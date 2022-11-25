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
package com.opensymphony.xwork2.config.entities;

import com.opensymphony.xwork2.util.location.Located;
import com.opensymphony.xwork2.util.location.Location;

import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Configuration for Interceptors.
 * <p/>
 * In the xml configuration file this is defined as the <code>interceptors</code> tag.
 *
 * @author Mike
 */
public class InterceptorConfig extends Located implements Serializable {

    protected Map<String,String> params;
    protected String className;
    protected String name;

    protected InterceptorConfig(String name, String className) {
        this.params = new LinkedHashMap<String,String>();
        this.name = name;
        this.className = className;
    }

    protected InterceptorConfig(InterceptorConfig orig) {
        this.name = orig.name;
        this.className = orig.className;
        this.params = new LinkedHashMap<String,String>(orig.params);
    }

    public String getClass