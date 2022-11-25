inerProviders.add(new XWorkConfigurationProvider());
                containerProviders.add(new XmlConfigurationProvider("xwork.xml", false));
            }

            return containerProviders;
        } finally {
            providerLock.unlock();
        }
    }

    /**
     * Set the list of configuration providers
     *
     * @param containerProviders list of {@link ConfigurationProvider} to be set
     */
    public void setContainerProviders(List<ContainerProvider> containerProviders) {
        providerLock.lock();
        try {
            this.containerProviders = new CopyOnWriteArrayList<ContainerProvider>(containerProviders);
            providersChanged = true;
        } finally {
            providerLock.unlock();
        }
    }

    /**
     * adds a configuration provider to the List of ConfigurationProviders.  a given ConfigurationProvider may be added
     * more than once
     *
     * @param provider the ConfigurationProvider to register
     */
    public void addContainerProvider(ContainerProvider provider) {
        if (!containerProviders.contains(provider)) {
            containerProviders.add(provider);
            providersChanged = true;
        }
    }

    public void clearContainerProviders() {
        for (ContainerProvider containerProvider : containerProviders) {
            clearContainerProvider(containerProvider);
        }
        containerProviders.clear();
        providersChanged = true;
    }

    private void clearContainerProvider(ContainerProvider containerProvider) {
        try {
            containerProvider.destroy();
        } catch (Exception e) {
            if (LOG.isWarnEnabled()) {
                LOG.warn("Error while destroying co