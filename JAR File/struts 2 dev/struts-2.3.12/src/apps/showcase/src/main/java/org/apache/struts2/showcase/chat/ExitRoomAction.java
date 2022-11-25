tEquals("/animals", mapping.getNamespace());
        assertEquals("dog", mapping.getName());
        assertEquals("fido", ((String[])mapping.getParams().get("id"))[0]);
        assertEquals("show", mapping.getMethod());
    }

    public void testShouldBlockDynamicMethodInvocationAnsUseDestroy() throws Exception {
        req.setRequestURI("/myapp/animals/dog/fido!destroy");
        req.setServletPath("/animals/dog/fido!destroy");
        req.setMethod("DELETE");

        mapper.setAllowDynamicMethodCalls("false");
        ActionMapping mapping = mapper.getMapping(req, configManager);

        assertEquals("/animals", mapping.getNamespace());
        assertEquals("dog", mapping.getName());
        assertEquals("fido", ((String[])mapping.getParams().get("id"))[0]);
        assertEquals("destroy", mapping.getMethod());
    }

    public void testShouldBlockDynamicMethodInvocationAndUseUpdate() throws Exception {
        req.setRequestURI("/myapp/animals/dog/fido!update");
        req.setServletPath("/animals/dog/fido!update");
        req.setMethod("PUT");

        mapper.setAllowDynamicMethodCalls("false");
        ActionMapping mapping = mapper.getMapping(req, configManager);

        assertEquals("/animals", mapping.getNamespace());
        assertEquals("dog", mapping.getName());
        assertEquals("fido", ((String[])mapping.getParams().get("id"))[0]);
        assertEquals("update", mapping.getMethod());
    }
    
    private void tryUri(String uri, String expectedNamespace, String expectedName) {
        ActionMapping mapping = new ActionMapping();
        mapper.setAllowDynamicMethodCalls(allowDynamicMethodInvocation);
        mapper.parseNameAndNamespace(uri, mapping, configManager);
        assertEquals(expectedName, mapping.get