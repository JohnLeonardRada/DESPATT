 at init() time
        synchronized (this) {
            if (!initialized) {
                initResources(ServletActionContext.getServletContext());
                initialized = true;
            }
        }
        Object action = invocation.getAction();

        
        if ((action instanceof ScopedModelDriven) &&
            (!(action instanceof Struts1Action) || ((Struts1Action)action).isValidate())) {
            ScopedModelDriven modelDriven = (ScopedModelDriven) action;
            Object model = modelDriven.getModel();
            if (model != null) {
                HttpServletRequest req = ServletActionContext.getRequest();
                Struts1Factory strutsFactory = new Struts1Factory(configuration);
                ActionMapping mapping = strutsFactory.createActionMapping(invocation.getProxy().getConfig());
                ModuleConfig moduleConfig = strutsFactory.createModuleConfig(invocation.getProxy().getConfig().getPackageName());
                req.setAttribute(Globals.MODULE_KEY, moduleConfig);
                req.setAttribute(Globals.MESSAGES_KEY, new WrapperMessageResources((TextProvider)invocation.getAction()));
                
                mapping.setAttribute(modelDriven.getScopeKey());
                
                ActionForm form = (ActionForm) model;
                form.setServlet(new ActionServlet(){
                    public ServletContext getServletContext() {
                        return ServletActionContext.getServletContext();
                    }
                });
                ActionErrors errors = form.validate(mapping, req);
                strutsFactory.conve