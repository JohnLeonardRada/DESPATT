/*
 * $Id: Main.java 1173233 2011-09-20 16:36:15Z mcucchiara $
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

import java.io.File;
import java.io.FilenameFilter;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <!-- START SNIPPET: javadoc -->
 *
 * Struts comes with various related tools included in the struts-core-VERSION.jar file. You can access these
 * tools by simply unpacking the Struts distribution and running <b>java -jar struts-core-VERSION.jar</b>.
 * Struts will automatically include all jars in the same directory as the struts-core-VERSION.jar file as well as all
 * jars in the <i>lib</i> directory. This means you can invoke these tools either from within the standard directory
 * structure found in the Struts distribu