lt;interceptor-ref name="params"/&gt;
 *     &lt;interceptor-ref name="validation"/&gt;
 *     &lt;interceptor-ref name="workflow"&gt;
 *        &lt;param name="inputResultName"&gt;error&lt;/param&gt;
 *         &lt;param name="excludeMethods"&gt;*&lt;/param&gt;
 *         &lt;param name="includeMethods"&gt;myWorkflowMethod&lt;/param&gt;
 *     &lt;/interceptor-ref&gt;
 *     &lt;result name="success"&gt;good_result.ftl&lt;/result&gt;
 * &lt;/action&gt;
 * <p/>
 * <!-- END SNIPPET: example -->
 * </pre>
 *
 * @author Jason Carreira
 * @author Rainer Hermanns
 * @author <a href='mailto:the_mindstorm[at]evolva[dot]ro'>Alexandru Popescu</a>
 * @author Philip Luppens
 * @author tm_jee
 */
public class DefaultWorkflowInterceptor extends MethodFilterInterceptor {

    private static final long serialVersionUID = 7563014655616490865L;

    private static final Logger LOG = LoggerFactory.getLogger(DefaultWorkflowInterceptor.class);

    private static final Class[] EMPTY_CLASS_ARRA