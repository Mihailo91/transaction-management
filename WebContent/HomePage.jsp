<%@ page language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>

<tiles:insert page="/WEB-INF/layout/layout.jsp" flush="true">
	<tiles:put name="title" type="string" value="Welcome Page" />
	<tiles:put name="header" value="/WEB-INF/jsp/header.jsp" />
	<tiles:put name="body" value="/transaction.jsp" />
	<tiles:put name="footer" value="/WEB-INF/jsp/footer.jsp" />
</tiles:insert>