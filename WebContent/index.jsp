<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<html:html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.11/css/jquery.dataTables.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.11/js/jquery.dataTables.min.js"></script>
    
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        .button-container {
            display: inline-block;
            margin: 20px;
        }
        .button {
            display: inline-block;
            padding: 10px 20px;
            font-size: 16px;
            font-family: Arial, sans-serif;
            color: white;
            background-color: #005293; /* Button color */
            text-decoration: none; /* Remove underline from link */
            border-radius: 5px; /* Rounded corners */
            border: none; /* Remove default border */
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2); /* Shadow for 3D effect */
            transition: background-color 0.3s ease, transform 0.3s ease; /* Smooth transitions */
        }
        .button:hover {
            background-color: #003c6c; /* Darker shade on hover */
            transform: translateY(-2px); /* Slight lift on hover */
        }
        .button:active {
            transform: translateY(0); /* Return to original position on click */
        }
    </style>
</head>

<body style="background-color:#EDEDED; text-align: center">
	<h3>Practice project</h3>
	<div class="button-container">
		<div>
			<html:link page="/HomePage.jsp">
				<h3 class="button">Apache Tiles</h3>
			</html:link>
		</div>

		<div>
			<html:link page="/transactionDetails.jsp">
				<h3 class="button">Apache Tiles Example + JQuery Data Table</h3>
			</html:link>
		</div>

	</div>


	<br>
	<!-- 
	<html:link action="/transaction">Apache Tiles Example + JQuery Data Table</html:link>	
	 -->

</body>
</html:html>