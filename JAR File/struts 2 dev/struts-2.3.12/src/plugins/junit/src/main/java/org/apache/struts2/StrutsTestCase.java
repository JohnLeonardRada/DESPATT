/*
 * $Id: StrutsTestCase.java 1344572 2012-05-31 05:59:06Z lukaszlenart $
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

package org.apache.struts2;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.ActionProxyFactory;
import com.opensymphony.xwork2.XWorkTestCase;
import com.opensymphony.xwork2.config.Configuration;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import com.opensymphony.xwork2.util.logging.jdk.JdkLoggerFactory;
import org.apache.struts2.dispatcher.Dispatcher;
import org.apache.struts2.dispatcher.mapper.ActionMapper;
import org.apache.struts2.dispatcher.mapper.ActionMapping;
import org.apache.struts2.util.StrutsTestCaseHelper;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockPageContext;
import org.springframework.mock.web.MockServletContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/**
 * Base test case for JUnit testing Struts.
 */
public abstract class StrutsTestCase extends XWorkTestCase {
    protected MockHttpServletResponse response;
    protected MockHttpServletRequest request;
    protected MockPageContext pageContext;
    protected MockServletContext servletContext;
    protected Map<String, String> dispatcherInitParams;

    protected DefaultResourceLoader resourceLoader = new DefaultResourceLoader();

    static {
        ConsoleHandler handler = new ConsoleHandler();
        final SimpleDateFormat df = new SimpleDateFormat("mm:ss.SSS");
        Formatter formatter = new Formatter() {
            @Override
            public String format(LogRecord record) {
                StringBuilder sb = new StringBuilder();
                sb.append(record.getLevel());
                sb.append(':');
                for (int x = 9 - record.getLevel().toString().length(); x > 0; x--) {
                    sb.append(' ');
                }
                sb.append('[');
                sb.append(df.format(new Date(record.getMillis())));
                sb.append("] ");
                sb.append(formatMessage(record));
                sb.append('\n');
                return sb.toString();
            }
        };
        handler.setFormatter(formatter);
        Logger logger = Logger.getLogger("");
        if (logger.getHandlers().length > 0)
            logger.removeHandler(logger.getHandlers()[0]);
        logger.addHandler(handler);
        logger.setLevel(Level.WARNING);
        LoggerFactory.setLoggerFactory(new JdkLoggerFactory());
    }

    private static final com.opensymphony.xwork2.util.logging.Logger LOG = LoggerFactory.getLogger(StrutsTestCase.class);

    /**
     * gets an object from the stack after an action is executed
     */
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

package com.opensymphony.xwork2.ognl.accessor;

import com.opensymphony.xwork2.ObjectFactory;
import com.opensymphony.xwork2.conversion.ObjectTypeDeterminer;
import com.opensymphony.xwork2.conversion.impl.XWorkConverter;
import com.opensymphony.xwork2.inject.Inject;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import com.opensymphony.xwork2.util.reflection.ReflectionContextState;
import ognl.ObjectPropertyAccessor;
import ognl.OgnlException;
import ognl.OgnlRuntime;
import ognl.SetPropertyAccessor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Gabe
 */
public class XWorkCollectionPropertyAccessor extends SetPropertyAccessor {

    private static final Logger LOG = LoggerFactory.getLogger(XWorkCollectionPropertyAccessor.class);
    private static final String CONTEXT_COLLECTION_MAP = "xworkCollectionPropertyAccessorContextSetMap";

    public static final String KEY_PROPERTY_FOR_CREATION = "makeNew";

    //use a basic object Ognl property accessor here
    //to access properties of the objects in the Set
    //so that nothing is put in the context to screw things up
    private ObjectPropertyAccessor _accessor = new ObjectPropertyAccessor();
    
    private XWorkConverter xworkConverter;
    private ObjectFactory objectFactory;
    private ObjectTypeDeterminer objectTypeDeterminer;
    
    @Inject
    public void setXWorkConverter(XWorkConverter conv) {
        this.xworkConverter = conv;
    }
    
    @Inject
    public void setObjectFactory(ObjectFactory fac) {
        this.objectFactory = fac;
    }
    
    @Inject
    public void setObjectTypeDeterminer(ObjectTypeDeterminer ot) {
        this.objectTypeDeterminer = ot;
    }

    /**
     * Gets the property of a Collection by indexing the collection
     * based on a key property. For example, if the key property were
     * 'id', this method would convert the key Object to whatever
     * type the id property was, and then access the Set like it was
     * a Map returning a JavaBean with the value of id property matching
     * the input.
     *
     * @see ognl.PropertyAccessor#getProperty(java.util.Map, Object, Object)
     */
    @Override
    public Object getProperty(Map context, Object target, Object key)
            throws OgnlException {

        if (LOG.isDebugEnabled()) {
            LOG.debug("Entering getProperty()");
        }

        //check if it is a generic type property.
        //if so, return the value from the
        //superclass which will determine this.
        if (!ReflectionContextState.isGettingByKeyProperty(context)
                && !key.equals(KEY_PROPERTY_FOR_CREATION)) {
            return super.getProperty(context, target, key);
        }	else {
            //reset context property
            ReflectionContextState.setGettingByKeyProperty(context,false);
        }
        Collection c = (Collection) target;

        //get the bean that this collection is a property of
        Class lastBeanClass = ReflectionContextState.getLastBeanClassAccessed(context);

        //get the property name that this collection uses
        String lastPropertyClass = ReflectionContextState.getLastBeanPropertyAccessed(context);

        //if one or the other is null, assume that it isn't
        //set up correctly so just return whatever the
        //superclass would
        if (lastBeanClass == null || lastPropertyClass == null) {
            ReflectionContextState.updateCurrentPropertyPath(context, key);
            return super.getProperty(context, target, key);
        }
        
        
        //get the key property to index the
        //collection with from the ObjectTypeDeterminer
        String keyProperty = objectTypeDeterminer
                .getKeyProperty(lastBeanClass, lastPropertyClass);

        //get the collection class of the
        Class collClass = objectTypeDeterminer.getElementClass(lastBeanClass, lastPropertyClass, key);

        Class keyType = null;
        Class toGetTypeFrom = (collClass != null) ? collClass : c.iterator().next().getClass();
        try {
            keyType = OgnlRuntime.getPropertyDescriptor(toGetTypeFrom, keyProperty).getPropertyType();
        } catch (Exception exc) {
            throw new OgnlException("Error getting property descriptor: " + exc.getMessage());
        }


        if (ReflectionContextState.isCreatingNullObjects(context)) {
            Map collMap = getSetMap(context, c, keyProperty, collClass);
            if (key.toString().equals(KEY_PROPERTY_FOR_CREATION)) {
                //this should return the XWorkList
                //for this set that contains new entries
              