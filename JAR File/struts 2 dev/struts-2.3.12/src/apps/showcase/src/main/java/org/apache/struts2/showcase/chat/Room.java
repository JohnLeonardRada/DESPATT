/*
 * $Id: RestActionMapperTest.java 1367870 2012-08-01 07:11:09Z lukaszlenart $
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

package org.apache.struts2.rest;

import com.opensymphony.xwork2.config.Configuration;
import com.opensymphony.xwork2.config.ConfigurationManager;
import com.opensymphony.xwork2.config.entities.PackageConfig;
import com.opensymphony.xwork2.config.impl.DefaultConfiguration;
import junit.framework.TestCase;
import org.apache.struts2.dispatcher.mapper.ActionMapping;
import org.springframework.mock.web.MockHttpServletRequest;

public class RestActionMapperTest extends TestCase {

    private RestActionMapper mapper;
    private ConfigurationManager configManager;
    private Configuration config;
    private MockHttpServletRequest req;
    private String allowDynamicMethodInvocation = "true";

    protected void setUp() throws Exception {
        super.setUp();
        req = new MockHttpServletRequest();
        req.setContextPath("/myapp");
        req.setMethod("GET");

        mapper = new RestActionMapper();

        config = new DefaultConfiguration();
        PackageConfig pkg = new PackageConfig.Builder("myns").namespace("/animals").build();
        PackageConfig pkg2 = new PackageConfig.Builder("my").namespace("/my").build();
        config.addPackageConfig("mvns", pkg);
        config.addPackageConfig("my", pkg2);
        configManager = new ConfigurationManager() {
            public Configuration getConfiguration() {
                return config;
            }
        };
    }

    public void testRootMapping() throws Exception {
        req.setRequestURI("/myapp/");
        req.setServletPath("/");

        ActionMapping mapping = mapper.getMapping(req, configManager);

        assertNull(mapping