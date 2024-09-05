<%@ taglib uri="http://struts.apache.org/tags-html" prefix="h" %>

<h:form action="/hello">
<h:text property="name"></h:text>
<h:submit/>
<hr/>
<h:errors/>
<tiles:getAsString name="transaction" ignore="true" />
</h:form>