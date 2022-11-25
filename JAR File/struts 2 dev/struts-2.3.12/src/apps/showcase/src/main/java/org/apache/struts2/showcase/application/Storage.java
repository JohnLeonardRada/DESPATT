e request, so let's create one using the current Dispatcher
            ValueStack vs = Dispatcher.getInstance().getContainer().getInstance(ValueStackFactory.class).createValueStack();
            vs.getContext().putAll(Dispatcher.getInstance().createContextMap(request, response, null, servletContext));
            ctx = new ActionContext(vs.getContext());
            if (ctx.getActionInvocation() == null) {
                // put in a dummy ActionSupport so basic functionality still works
                ActionSupport action = new ActionSupport();
                vs.push(action);
                ctx.setActionInvocation(new DummyActionInvocation(action));
            }
        }

        // delegate to the actual page decorator
        render(content, request, response, servletContext, ctx);

    }

    /**
     * Returns the locale used for the {@link freemarker.template.Configuration#getTemplate(String, java.util.Locale)} call. The base implementation
     * simply returns the locale setting of the action (assuming the action implements {@link LocaleProvider}) or, if
     * the action does not the configuration's locale is returned. Override this method to provide different behaviour,
     */
    protected Locale getLocale(ActionInvocation invocation, Configuration configuration) {
        if (invocation.getAction() instanceof LocaleProvider) {
            return ((LocaleProvider) invocation.getAction()).getLocale();
        } else {
            return configuration.getLocale();
        }
    }


    /**
     * Gets the L18N encoding of the system.  The default is UTF-8.
     */
    protected String getEncoding() {
        String encodin