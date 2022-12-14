ors list.
     * <p/>
     * Will clear the list that contains action errors.
     */
    public synchronized void clearActionErrors() {
        internalGetActionErrors().clear();
    }

    /**
     * Clears messages list.
     * <p/>
     * Will clear the list that contains action messages.
     */
    public synchronized void clearMessages() {
        internalGetActionMessages().clear();
    }

    /**
     * Clears all error list/maps.
     * <p/>
     * Will clear the map and list that contain
     * field errors and action errors.
     */
    public synchronized void clearErrors() {
        internalGetFieldErrors().clear();
        internalGetActionErrors().clear();
    }

    /**
     * Clears all error and messages list/maps.
     * <p/>
     * Will clear the maps/lists that contain
     * field errors, action errors and action messages.
     */
    public synchronized void clearErrorsAndMessages() {
        internalGetFieldErrors().clear();
        internalGetActionErrors().clear();
        internalGetActionMessages().clear();
    }
}
                       