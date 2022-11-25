/*
 * Copyright 2002-2006,2009 The Apache Software Foundation.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.opensymphony.xwork2.config;

import com.opensymphony.xwork2.XWorkConstants;
import com.opensymphony.xwork2.config.impl.DefaultConfiguration;
import com.opensymphony.xwork2.config.providers.XWorkConfigurationProvider;
import com.opensymphony.xwork2.config.providers.XmlConfigurationProvider;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * ConfigurationManager - central for XWork Configuration management, including
 * its ConfigurationProvider.
 *
 * @author Jason Carreira
 * @author tm_jee
 * @version $Date: 2013-01-20 20:44:55 +0100 (Sun, 20 Jan 2013) $ $Id: ConfigurationManager.java 1435931 2013-01-20 19:44:55Z lukaszlenart $
 */
public class ConfigurationManager {

    protected static final Logger LOG = LoggerFactory.getLogger(ConfigurationManager.class);
    protected Configuration configuration;
    protected Lock providerLock = new ReentrantLock();
    private List<ContainerProvider> containerProviders = new CopyOnWriteArrayList<ContainerProvider>();
    private List<PackageProvider> packageProviders = new CopyOnWriteArrayList<PackageProvider>();
    protected String defaultFrameworkBeanName;
    private boolean providersChanged = false;
    private boolean reloadConfigs = true; // for the first time

    public ConfigurationManager() {
        this("xwork");
    }
    
    public ConfigurationManager(String name) {
        this.defaultFrameworkBeanName = name;
    }

    /**
     * Get the current XWork configuration object.  By default an instance of DefaultConfiguration will be returned
     *
     * @see com.opensymphony.xwork2.config.impl.DefaultConfiguration
     */
    public synchronized Configuration getConfiguration() {
        if (configuration == null) {
            setConfiguration(createConfiguration(defaultFrameworkBeanName));
            try {
                configuration.reloadContainer(getContainerProviders());
            } catch (ConfigurationException e) {
                setConfiguration(null);
                throw new ConfigurationException("Unable to load configuration.", e);
            }
        } else {
            conditionalReload();
        }

        return configuration;
    }

    protected Configuration createConfiguration(String beanName) {
        return new DefaultConfiguration(beanName);
    }

    public synchronized void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    /**
     * Get the current list of ConfigurationProviders. If no custom ConfigurationProviders have been added, this method
     * will return a list containing only the default ConfigurationProvider, XMLConfigurationProvider.  if a custom
     * ConfigurationProvider has been added, then the XmlConfigurationProvider must be added by hand.
     * </p>
     * <p/>
     * TODO: the lazy instantiation of XmlConfigurationProvider 