turn("getExtension", "xml");
        mockHandlerXml.matchAndReturn("getContentType", "application/xml");
        mockHandlerXml.matchAndReturn("toString", "xml");
        Mock mockHandlerJson = new Mock(ContentTypeHandler.class);
        mockHandlerJson.matchAndReturn("getExtension", "json");
        mockHandlerJson.matchAndReturn("getContentType", "application/javascript");
        mockHandlerJson.matchAndReturn("toString", "json");
        Mock mockHandlerXmlOverride = new Mock(ContentTypeHandler.class);
        mockHandlerXmlOverride.matchAndReturn("getExtension", "xml");
        mockHandlerXmlOverride.matchAndReturn("toString", "xmlOverride");
        mockHandlerXmlOverride.matchAndReturn("getContentType", "application/xml");

        Mock mockContainer = new Mock(Container.class);
        mockContainer.matchAndReturn("getInstance", C.args(C.eq(ContentTypeHandler.class), C.eq("xmlOverride")), mockHandlerXmlOverride.proxy());
        mockContainer.matchAndReturn("getInstance", C.args(C.eq(ContentTypeHandler.class), C.eq("xml")), mockHandlerXml.proxy());
        mockContainer.matchAndReturn("getInstance", C.args(C.eq(ContentTypeHandler.class), C.eq("json")), mockHandlerJson.proxy());
        mockContainer.expectAndReturn("getInstanceNames", C.args(C.eq(ContentTypeHandler.class)), new HashSet(Arrays.asList("xml", "