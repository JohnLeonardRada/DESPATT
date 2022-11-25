ontext = (ApplicationContext) ActionContext.getContext().getApplication().get(
                    WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);

            if (applicationContext == null) {
                if (LOG.isWarnEnabled()) {
                    LOG.warn("ApplicationContext could not be found.  Action classes will not be autowired.");
                }
            } else {
                setApplicationContext(applicationContext);
                factory = new SpringObjectFactory();
                factory.setApplicationContext(getApplicationContext());
                if (autowireStrategy != null) {
                    factory.setAutowireStrategy(autowireStrategy.intValue());
                }
            }
            initialized = true;
        }

        if (factory != null) {
            Object bean = invocation.getAction();
            factory.autoWireBean(bean);
    
            ActionContext.getContext().put(APPLICATION_CONTEXT, context);
        }
        return invocation.invoke();
    }

    /**
     * @param applicationContext
     * @throws BeansException
     */
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    /**
     * @return context
     */
    protected ApplicationContext getApplicationContext() {
        return context;
    }

}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            /*
 * Copyright 2002-2006,2009 The Apache Software Foundation.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may 