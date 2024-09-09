<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="b" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="l" %>

<head>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            background-color: #fff;
        }
        th, td {
            padding: 12px;
            text-align: left;
        }
        th {
            background-color: #EDEDED;
            font-size: 16px;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        tr:hover {
            background-color: #ddd;
        }
        td {
            border-bottom: 1px solid #ddd;
        }

    </style>
</head>

<table>
	<tr>
		<th>id</th>
		<th>cardHolder</th>
		<th>cardNumber</th>
		<th>amount</th>
		<th>timeOfTransaction</th>
		<th>suspiciousActivity</th>
	</tr>
	<l:iterate id="transaction" name="transactionForm"
		property="transactionItems">
		<tr>
			<td><b:write name="transaction" property="id"/> </td>
			<td><b:write name="transaction" property="cardHolder"/> </td>
			<td><b:write name="transaction" property="cardNumber"/> </td>
			<td><b:write name="transaction" property="amount"/> </td>
			<td><b:write name="transaction" property="timeOfTransaction"/> </td>
			<td><b:write name="transaction" property="suspiciousActivity"/> </td>
		</tr>
	</l:iterate>
</table>