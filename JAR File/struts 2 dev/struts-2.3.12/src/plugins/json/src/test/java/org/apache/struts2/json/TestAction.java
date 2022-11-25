bject name) throws OgnlException {
        CompoundRoot root = (CompoundRoot) target;
        OgnlContext ognlContext = (OgnlContext) context;

        if (name instanceof Integer) {
            Integer index = (Integer) name;

            return root.cutStack(index.intValue());
        } else if (name instanceof String) {
            if ("top".equals(name)) {
                if (root.size() > 0) {
                    return root.get(0);
                } else {
                    return null;
                }
            }

            for (Object o : root) {
                if (o == null) {
                    continue;
                }

                try {
                    if ((OgnlRuntime.hasGetProperty(ognlContext, o, name)) || ((o instanceof Map) && ((Map) o).containsKey(name))) {
                        return OgnlRuntime.getProperty(ognlContext, o, name);
                    }
                } catch (OgnlException e) {
                    if (e.getReason() != null) {
                        final String msg = "Caught an Ognl exception while getting property " + name;
                        throw new XWorkException(msg, e);
                    }
                } catch (IntrospectionException e) {
                    // this is OK if this happens, we'll just keep trying the next
                }
            }

            //property was not found
            if (context.containsKey(OgnlValueStack.THROW_EXCEPTION_ON_FAILURE))
                throw new NoSuchPropertyException(target, name);
            else
                return null;
        } else {
            return null;
        }
    }

    public Object callMethod(Map context, Object target, String name, Object[] objects) throws MethodFailedException {
        CompoundRoot root = (CompoundRoot) target;

        if ("describe".equals(name)) {
            Object v;
            if (objects != null && objects.length == 1) {
                v = objects[0];
            } else {
                v = root.get(0);
            }


            if (v instanceof Collection || v instanceof Map || v.getClass().isArray()) {
                return v.toString();
            }

            try {
                Map<String, PropertyDescriptor> descriptors = OgnlRuntime.getPropertyDescriptors(v.getClass());

                int maxSize = 0;
                for (String pdName : descriptors.keySet()) {
                    if (pdName.length() > maxSize) {
                        maxSize = pdName.length();
                    }
                }

                SortedSet<String> set = new TreeSet<String>();
                StringBuffer sb = new StringBuffer();
                for (PropertyDescriptor pd : descriptors.values()) {

                    sb.append(pd.getName()).append(": ");
                    int padding = maxSize - pd.getName().length();
                    for (int i = 0; i < padding; i++) {
                        sb.append(" ");
                    }
                    sb.append(pd.getPropertyType().getName());
                    set.add(sb.toString());

                    sb = new StringBuffer();
                }

                sb = new StringBuffer();
                for (Object aSet : set) {
                    String s = (String) aSet;
                    sb.append(s).append("\n");
                }

                return sb.toString();
            } catch (IntrospectionException e) {
                if (LOG.isDebugEnabled()) {
                    LOG.debug("Got exception in callMethod", e);
                }
            } catch (OgnlException e) {
                if (LOG.isDebugEnabled()) {
                    LOG.debug("Got exception in callMethod", e);
                }
            }

            return null;
        }

        for (Object o : root) {
            if (o == null) {
                continue;
            }

            Class clazz = o.getClass();
            Class[] argTypes = getArgTypes(objects);

            MethodCall mc = null;

            if (argTypes != null) {
                mc = new MethodCall(clazz, name, argTypes);
            }

            if ((argTypes == null) || !invalidMethods.containsKey(mc)) {
                try {
                    Object value = OgnlRuntime.callMethod((OgnlContext) context, o, name, name, objects);

                    if (value != null) {
                        return val