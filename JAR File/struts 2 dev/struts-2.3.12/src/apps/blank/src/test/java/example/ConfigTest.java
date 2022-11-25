e of the method to execute
     */
    public String getMethodName() {
        return methodName;
    }

    /**
     * @return Returns the packageName.
     */
    public String getPackageName() {
        return packageName;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public Map<String, ResultConfig> getResults() {
        return results;
    }

    public boolean isAllowedMethod(String method) {
        if (allowedMethods.size() == 1 && WILDCARD.equals(allowedMethods.iterator().next())) {
            return true;
        } else {
            return method.equals(methodName != null ? methodName : DEFAULT_METHOD) || allowedMethods.contains(method);
        }
    }

    @Override public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof ActionConfig)) {
            return false;
        }

        final ActionConfig actionConfig = (ActionConfig) o;

        if ((className != null) ? (!className.equals(actionConfig.className)) : (actionConfig.className != null)) {
            return false;
        }

        if ((name != null) ? (!name.equals(actionConfig.name)) : (actionConfig.name != null)) {
            return false;
        }

        if ((interceptors != null) ? (!interceptors.equals(actionConfig.interceptors)) : (actionConfig.interceptors != null))
        {
            return false;
        }

        if ((methodName != null) ? (!methodName.equals(actionConfig.methodName)) : (actionConfig.methodName != null)) {
            return false;
        }

        if ((params != null) ? (!params.equals(actionConfig.params)) : (actionConfig.params != null)) {
            return false;
        }

        if ((results != null) ? (!results.equals(actionConfig.results)) : (actionConfig.results != null)) {
            return false;
        }

        if ((allowedMethods != null) ? (!allowedMethods.equals(actionConfig.allowedMethods)) : (actionConfig.allowedMethods != null)) {
            return false;
        }

        return true;
    }

    @Override public int hashCode() {
        int result;
        result = (interceptors != null ? interceptors.hashCode() : 0);
        result = 31 * result + (params != null ? params.hashCode() : 0);
        result = 31 * result + (results != null ? results.hashCode() : 0);
        result = 31 * result + (exceptionMappings != null ? exceptionMappings.hashCode() : 0);
        result = 31 * result + (className != null ? className.hashCode() : 0);
        result = 31 * result + (methodName != null ? methodName.hashCode() : 0);
        result = 31 * result + (packageName != null ? packageName.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (allowedMethods != null ? allowedMethods.hashCode() : 0);
        return result;
    }

    @Override public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{ActionConfig ");
        sb.append(name).append(" (");
        sb.append(className);
        if (methodName != null) {
            sb.append(".").append(methodName).append("()");
        }
        sb.append(")");
        sb.append(" - ").append(location);
        sb.append("}");
        return sb.toString();
    }

    /**
     * The builder for this object.  An instance of this object is the only way to construct a new instance.  The
     * purpose is to enforce the immutability of the object.  The methods are structured in a way to support chaining.
     * After setting any values you need, call the {@link #build()} method to create the object.
     */
    public static class Builder implements InterceptorListHolder{

        protected ActionConfig target;
        private bo