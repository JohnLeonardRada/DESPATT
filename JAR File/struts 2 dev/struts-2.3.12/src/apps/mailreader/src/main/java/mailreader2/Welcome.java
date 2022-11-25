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

import com.opensymphony.xwork2.util.ValueStack;

import java.util.List;
import java.util.ResourceBundle;


/**
 * Provides access to {@link ResourceBundle}s and their underlying text messages.
 * Implementing classes can delegate {@link TextProviderSupport}. Messages will be
 * searched in multiple resource bundles, startinag with the one associated with
 * this particular class (action in most cases), continuing to try the message
 * bundle associated with each superclass as well. It will stop once a bundle is
 * found that contains the given text. This gives a cascading style that allow
 * global texts to be defined for an application base class.
 * <p/>
 * You can override {@link LocaleProvider#getLocale()} to change the behaviour of how
 * to choose locale for the bundles that are returned. Typically you would
 * use the {@link LocaleProvider} interface to get the users con