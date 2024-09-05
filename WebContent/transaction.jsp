<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="b" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="l" %>

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