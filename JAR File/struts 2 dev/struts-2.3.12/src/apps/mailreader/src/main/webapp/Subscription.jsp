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
package com.opensymphony.xwork2;

import com.opensymphony.xwork2.inject.Container;
import com.opensymphony.xwork2.inject.Inject;
import com.opensymphony.xwork2.util.ValueStack;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;


/**
 * Provides a default implementation for the most common actions.
 * See the documentation for all the interfaces this class implements for more detailed information.
 */
public class ActionSupport implements Action, Validateable, ValidationAware, TextProvider, LocaleProvider, Serializable {

    protected static Logger LOG = LoggerFactory.getLogger(ActionSupport.class);

    private final ValidationAwareSupport validationAware = new ValidationAwareSupport();

    private transient TextProvider textProvider;
    private Container container;

    public void setActionErrors(Collection<String> errorMessages) {
        validationAware.setActionErrors(errorMessages);
    }

    public Collection<String> getActionErrors() {
        return validationAware.getActionErrors();
    }

    public void setActionMessages(Co