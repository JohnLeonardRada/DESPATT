 String> parameters = config.getParams();

        if (LOG.isDebugEnabled()) {
            LOG.debug("Setting static parameters " + parameters);
        }

        // for actions marked as Parameterizable, pass the static parameters directly
        if (action instanceof Parameterizable) {
            ((Parameterizable) action).setParams(parameters);
        }

        if (parameters != null) {
            ActionContext ac = ActionContext.getContext();
            Map<String, Object> contextMap = ac.getContextMap();
            try {
                ReflectionContextState.setCreatingNullObjects(contextMap, true);
                ReflectionContextState.setReportingConversionErrors(contextMap, true);
                final ValueStack stack = ac.getValueStack();

                ValueStack newStack = valueStackFactory.createValueStack(stack);
                boolean clearableStack = newStack instanceof ClearableValueStack;
                if (clearableStack) {
                    //if the stack's context can be cleared, do that to prevent OGNL
                    //from having access to objects in the stack, see XW-641
                    ((ClearableValueStack)newStack).clearContextValues();
                    Map<String, Object> context = newStack.getContext();
                    ReflectionContextState.setCreatingNullObjects(context, true);
                    ReflectionContextState.setDenyMethodExecution(context, true);
                    ReflectionContextState.setReportingConversionErrors(context, true);

                    //keep locale from original context
                    context.put(ActionContext.LOCALE, stack.getContext().get(ActionContext.LOCALE));
                }

                for (Map.Entry<String, String> entry : parameters.entrySet()) {
                    Object val = entry.getValue();
                    if (parse && val instanceof String) {
                        val = TextParseUtil.translateVariables(val.toString(), stack);
                    }
                    try {
                        newStack.setValue(entry.getKey(), val);
                    } catch (RuntimeException e) {
                        if (devMode) {
                            String developerNotification = LocalizedTextUtil.findText(ParametersInterceptor.class, "devmode.notification", ActionContext.getContext().getLocale(), "Developer Notification:\n{0}", new Object[]{
                                    "Unexpected Exception caught setting '" + entry.getKey() + "' on '" + action.getClass() + ": " + e.getMessage()
                            });
                            LOG.error(developerNotification);
                            if (action instanceof ValidationAware) {
                                ((ValidationAware) action).addActionMessage(developerNotification);
                            }
                        }
                    }
                }

                 if (clearableStack && (stack.getContext() != null) && (newStack.getContext() != null))
                    stack.getContext().put(ActionContext.CONVERSION_ERRORS, newStack.getContext().get(ActionContext.CONVERSION_ERRORS));

                if (merge)
                    addParametersToContext(ac, parameters);
            } finally {
                ReflectionContextState.setCreatingNullObjects(contextMap, false);
                ReflectionContextState.setReportingConversionErrors(contextMap, false);
            }
        }
        return invocation.invoke();
    }


    /**
     * @param ac The action context
     * @return the parameters from the action mapping in the context.  If none found, returns
     *         an empty map.
     */
    protected Map<String, String> retrieveParameters(ActionContext ac) {
        ActionConfig config = ac.getActionInvocation().getProxy().getConfig();
        if (config != null) {
            return config.getParams();
        } else {
            return Collections.emptyMap();
        }
    }

    /**
     * Adds the parameters into context's ParameterMap.
     * As default, static parameters will not overwrite existing paramaters from other sources.
     * If you want the static parameters as successor over already existing parameters, set overwrite to <tt>true</tt>.
     *
     * @param ac        The action context
     * @param newParams The parameter map to apply
     */
    protected void addParametersToContext(ActionContext ac, Map<String, ?> newParams) {
        Map<String, Object> previousParams = ac.getParameters();

        Map<String, Object> combinedParams;
        if ( overwrite ) {
            if (previousParams != null) {
                combinedParams = new TreeMap<String, Object>(previousParams);
            } else {
                combinedParams = new TreeMap<String, Object>();
            }
            if ( newParams != null) {
                combinedParams.putAll(newParams);
            }
        } else {
            if (newParams != null) {
                combinedParams = new TreeMap<String, Object>(ne