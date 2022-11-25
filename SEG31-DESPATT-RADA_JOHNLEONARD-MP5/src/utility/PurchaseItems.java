 * </pre>
 * 
 * <p/>
 * This second example will also log the exceptions using our own category
 * <code>com.mycompany.app.unhandled<code> at WARN level. 
 * 
 * <pre>
 * <!-- START SNIPPET: example2 -->
 * &lt;xwork&gt;
 *   &lt;package name="something" extends="xwork-default"&gt;
 *      &lt;interceptors&gt;
 *          &lt;interceptor-stack name="exceptionmappingStack"&gt;
 *              &lt;interceptor-ref name="exception"&gt;
 *                  &lt;param name="logEnabled"&gt;true&lt;/param&gt;
 *                  &lt;param name="logCategory"&gt;com.mycompany.app.unhandled&lt;/param&gt;
 *                  &lt;param name="logLevel"&gt;WARN&lt;/param&gt;	        		
 *              &lt;/interceptor-ref&gt;	
 *              &lt;interceptor-ref name="i18n"/&gt;
 *              &lt;interceptor-ref name="staticParams"/&gt;
 *              &lt;interceptor-ref name="params"/&gt;
 *         