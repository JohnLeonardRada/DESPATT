/../org/hibernate/dialect/function/AnsiTrimEmulationFunction.html" title="class in org.hibernate.dialect.function">AnsiTrimEmulationFunction</A></B></CODE>

<BR>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;A <A HREF="../../../../../org/hibernate/dialect/function/SQLFunction.html" title="interface in org.hibernate.dialect.function"><CODE>SQLFunction</CODE></A> implementation that emulates the ANSI SQL trim function
 on dialects which do not support the full definition.</TD>
</TR>
<TR BGCOLOR="white" CLASS="TableRowColor">
<TD ALIGN="right" VALIGN="top" WIDTH="1%"><FONT SIZE="-1">
<CODE>&nbsp;class</CODE></FONT></TD>
<TD><CODE><B><A HREF="../../../../../org/hibernate/dialect/function/AnsiTrimFunction.html" title="class in org.hibernate.dialect.function">AnsiTrimFunction</A></B></CODE>

<BR>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Defines support for rendering according to ANSI SQL <tt>TRIM</tt> function specification.</TD>
</TR>
<TR BGCOLOR="white" CLASS="TableRowColor">
<TD ALIGN="right" VALIGN="top" WIDTH="1%"><FONT SIZE="-1">
<CODE>&nbsp;class</CODE></FONT></TD>
<TD><CODE><B><A HREF="../../../../../org/hibernate/dialect/function/AvgWithArgumentCastFunction.html" title="class in org.hibernate.dialect.function">AvgWithArgumentCastFunction</A></B></CODE>

<BR>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Some databases strictly return the type of the of the aggregation value for <tt>AVG</tt> which is
 problematic in the case of averaging integers because the decimals will be dropped.</TD>
</TR>
<TR BGCOLOR="white" CLASS="TableRowColor">
<TD ALIGN="right" VALIGN="top" WIDTH="1%"><FONT SIZE="-1">
<CODE>&nbsp;class</CODE></FONT></TD>
<TD><CODE><B><A HREF="../../../../../org/hibernate/dialect/function/CastFunction.html" title="class in org.hibernate.dialect.function">CastFunction</A></B></CODE>

<BR>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ANSI-SQL style <tt>cast(foo as type)</tt> where the type is
 a Hibernate type</TD>
</TR>
<TR BGCOLOR="white" CLASS="TableRowColor">
<TD ALIGN="right" VALIGN="top" WIDTH="1%"><FONT SIZE="-1">
<CODE>&nbsp;class</CODE></FONT></TD>
<TD><CODE><B><A HREF="../../../../../org/hibernate/dialect/function/CharIndexFunction.html" title="class in org.hibernate.dialect.function">CharIndexFunction</A></B></CODE>

<BR>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Emulation of <tt>locate()</tt> on Sybase</TD>
</TR>
<TR BGCOLOR="white" CLASS="TableRowColor">
<TD ALIGN="right" VALIGN="top" WIDTH="1%"><FONT SIZE="-1">
<CODE>&nbsp;class</CODE></FONT></TD>
<TD><CODE><B><A HREF="../../../../../org/hibernate/dialect/function/ClassicAvgFunction.html" title="class in org.hibernate.dialect.function">ClassicAvgFunction</A></B></CODE>

<BR>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Classic AVG sqlfunction that return types as it was done in Hibernate 3.1</TD>
</TR>
<TR BGCOLOR="white" CLASS="TableRowColor">
<TD ALIGN="right" VALIGN="top" WIDTH="1%"><FONT SIZE="-1">
<CODE>&nbsp;class</CODE></FONT></TD>
<TD><CODE><B><A HREF="../../../../../org/hibernate/dialect/function/ClassicCountFunction.html" title="class in org.hibernate.dialect.function">ClassicCountFunction</A></B></CODE>

<BR>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Classic COUNT sqlfunction that return types as it was done in Hibernate 3.1</TD>
</TR>
<TR BGCOLOR="white" CLASS="TableRowColor">
<TD ALIGN="right" VALIGN="top" WIDTH="1%"><FONT SIZE="-1">
<CODE>&nbsp;class</CODE></FONT></TD>
<TD><CODE><B><A HREF="../../../../../org/hibernate/dialect/function/ClassicSumFunction.html" title="class in org.hibernate.dialect.function">ClassicSumFunction</A></B></CODE>

<BR>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&