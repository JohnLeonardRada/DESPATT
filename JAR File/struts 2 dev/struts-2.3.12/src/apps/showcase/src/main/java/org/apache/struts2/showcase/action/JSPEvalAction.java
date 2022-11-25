/*
 * $Id: ClassReloadingXMLWebApplicationContext.java 1292705 2012-02-23 08:40:53Z lukaszlenart $
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.struts2.spring;

import com.opensymphony.xwork2.util.classloader.FileResourceStore;
import com.opensymphony.xwork2.util.classloader.JarResourceStore;
import com.opensymphony.xwork2.util.classloader.ReloadingClassLoader;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import org.apache.commons.jci.monitor.FilesystemAlterationListener;
import org.apache.commons.jci.monitor.FilesystemAlterationMonitor;
import org.apache.commons.jci.monitor.FilesystemAlterationObserver;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.dispatcher.Dispatcher;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.BeansException;

import javax.servlet.ServletContext;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.regex.Pattern;

/**
 * This class can be used instead of XmlWebApplicationContext, and it will watch jar files and direct