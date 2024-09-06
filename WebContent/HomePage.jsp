<%@ page language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>

<tiles:insert page="/layout.jsp" flush="true">
	<tiles:put name="title" type="string" value="Welcome Page" />
	<tiles:put name="header" value="/header.jsp" />
	<tiles:put name="body" value="/body.jsp" />
	<tiles:put name="footer" value="/footer.jsp" />
</tiles:insert>