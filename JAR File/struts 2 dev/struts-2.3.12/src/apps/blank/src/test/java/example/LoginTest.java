oviders) {
            if (provider.needsReload()) {
                if (LOG.isInfoEnabled()) {
                    LOG.info("Detected container provider [#0] needs to be reloaded. Reloading all providers.", provider.toString());
                }
                return true;
            }
        }
        return false;
    }

    private void reloadProviders(List<ContainerProvider> providers) {
        for (ContainerProvider containerProvider : containerProviders) {
            try {
                containerProvider.destroy();
            } catch (Exception e) {
                if (LOG.isWarnEnabled()) {
                    LOG.warn("error while destroying configuration provider [#0]", e, containerProvider.toString());
                }
            }
        }
        packageProviders = this.configuration.reloadContainer(providers);
    }

    public synchronized void reload() {
        packageProviders = getConfiguration().reloadContainer(getContainerProviders());
    }

}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       