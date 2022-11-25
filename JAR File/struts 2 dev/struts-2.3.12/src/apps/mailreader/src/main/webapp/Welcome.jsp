    if (actionName != null ? !actionName.equals(that.actionName) : that.actionName != null) return false;
        if (methodName != null ? !methodName.equals(that.methodName) : that.methodName != null) return false;
        if (namespace != null ? !namespace.equals(that.namespace) : that.namespace != null) return false;

        return true;
    }

    @Override public int hashCode() {
        int result;
        result = (actionName != null ? actionName.hashCode() : 0);
        result = 31 * result + (namespace != null ? namespace.hashCode() : 0);
        result = 31 * result + (methodName != null ? methodName.hashCode() : 0);
        return result;
    }

    private boolean isInChainHistory(String namespace, String actionName, String methodName) {
        LinkedList<? extends String> chainHistory = ActionChainResult.getChainHistory();

        if (chainHistory == null) {
            return false;
        } else {
            //  Actions to skip
            Set<String> skipActionsList = new HashSet<String>();
            if (skipActions != null && skipActions.length() > 0) {
                ValueStack stack = ActionContext.getContext().getValueStack();
                String finalSkipActions = TextParseUtil.translateVariables(this.skipActions, stack);
                skipActionsList.addAll(TextParseUtil.commaDelimitedStringToSet(finalSkipActions));
            }
            if (!skipActionsList.contains(actionName)) {
                //  Get if key is in the chain history
                return chainHistory.contains(makeKey(namespace, actionN