<%@ page language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>

<tiles:insert page="/dataLayout.jsp" flush="true">
	<tiles:put name="title" type="string" value="Transaction Page" />
	<tiles:put name="header" value="/WEB-INF/jsp/header.jsp" />
	<tiles:put name="body" value="/WEB-INF/jsp/body.jsp" />
	<tiles:put name="footer" value="/WEB-INF/jsp/footer.jsp" />
</tiles:insert>