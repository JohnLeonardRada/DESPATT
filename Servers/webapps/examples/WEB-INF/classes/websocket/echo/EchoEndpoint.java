/component/visit/VisitContext.html" title="class in javax.faces.component.visit">VisitContext</A>&nbsp;context,
                         <A HREF="../../../javax/faces/component/visit/VisitCallback.html" title="interface in javax.faces.component.visit">VisitCallback</A>&nbsp;callback)</PRE>
<DL>
<DD><B>Description copied from class: <CODE><A HREF="../../../javax/faces/component/UIComponent.html#visitTree(javax.faces.component.visit.VisitContext, javax.faces.component.visit.VisitCallback)">UIComponent</A></CODE></B></DD>
<DD><p class="changed_added_2_0">Perform a tree visit starting at
 this node in the tree.</p>

 <div class="changed_added_2_0">

 <p>UIComponent.visitTree() implementations do not invoke the
 <CODE>VisitCallback</CODE> directly, but instead call <CODE>VisitContext#invokeVisitCallback</CODE> to invoke the callback.  This
 allows <code>VisitContext</code> implementations to provide optimized
 tree traversals, for example by only calling the <code>VisitCallback</code> for a subset of components.</p>

 <p>UIComponent.visitTree() implementations must call
 UIComponent.pushComponentToEL() before performing the
 visit and UIComponent.popComponentFromEL() after the
 visit.</p>
<P>
<DD><DL>
<DT><B>Overrides:</B><DD><CODE><A HREF="../../../javax/faces/component/UIComponent.html#visitTree(javax.faces.component.visit.VisitContext, javax.faces.component.visit.VisitCallback)">visitTree</A></CODE> in class <CODE><A HREF="../../../javax/faces/component/UIComponent.html" title="class in javax.faces.component">UIComponent</A></CODE></DL>
</DD>
<DD><DL>
<DT><B>Parameters:</B><DD><CODE>context</CODE> - the <code>VisitContext</code> for this visit<DD><CODE>callback</CODE> - the <code>VisitCallback</code> instance
 whose <code>visit</code> method will be called
 for each node visited.
<DT><B>Returns:</B><DD>component implementations may return <code>true</code> 
   to indicate that the tree visit is complete (eg. all components
   that need to be visited have been visited).  This results in
   the tree visit being short-circuited such that no more components
