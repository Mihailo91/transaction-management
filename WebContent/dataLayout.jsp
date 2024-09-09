<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title><tiles:getAsString name="title" ignore="true" /></title>
</head>
<body style="margin: 1rem; width: 100%">
	<div>
		<tiles:insert attribute="header" />
	</div>

	<div>
		<tiles:insert attribute="body" />
	</div>
	
	<div class="footer">
		<tiles:insert attribute="footer" />
	</div>
</body>
</html>
