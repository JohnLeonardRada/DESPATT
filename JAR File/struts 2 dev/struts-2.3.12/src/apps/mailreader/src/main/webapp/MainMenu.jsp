tProvider}s and return the first valid message for this
     * <code>key</code>.
     *
     * @param key
     * @param args
     * @return
     * @see {@link com.opensymphony.xwork2.TextProvider#getText(String, String[])}
     */
    public String getText(String key, String[] args) {
        return getText(key, key, args);
    }


    /**
     * It will consult each {@link TextProvider}s and return the first valid message for this
     * <code>key</code>, before returining <code>defaultValue</code>
     *
     * @param key
     * @param defaultValue
     * @param args
     * @return
     * @see {@link com.opensymphony.xwork2.TextProvider#getText#getText(String, String, java.util.List)}
     */
    public String getText(String key, String defaultValue, List<?> args) {
        //