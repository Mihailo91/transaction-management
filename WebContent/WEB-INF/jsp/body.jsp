<%@ taglib uri="http://struts.apache.org/tags-html" prefix="h"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
</head>
<body style="width: 100%; height: 400px; background-color: F5EDED">

	<br>
	<h1>Transaction Details</h1>
	</br>
	<h:form action="/transaction">
		Load transactions <h:submit />
		<hr />
		<h:errors />
	</h:form>


</body>
</html>




