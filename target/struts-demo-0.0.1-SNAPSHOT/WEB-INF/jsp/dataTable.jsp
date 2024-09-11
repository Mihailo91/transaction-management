<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.11/css/jquery.dataTables.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://cdn.datatables.net/1.10.11/js/jquery.dataTables.min.js"></script>
<style>
td {
	text-align: center
}
</style>
</head>

<body>
	<table id="myTable" class="display">
		<thead>
			<tr>
				<th>id</th>
				<th>cardHolder</th>
				<th>cardNumber</th>
				<th>amount</th>
				<th>timeOfTransaction</th>
				<th>suspiciousActivity</th>
			</tr>
		</thead>
		<tbody>
			<!-- Data will be populated by DataTables -->
		</tbody>
	</table>

	<script>
		$(document).ready(function() {
			$('#myTable').dataTable({
				serverSide: true, <!-- this means the dataTable is handled by the action class (ajax call) so we must add logic for handling pagination -->
				ajax: "http://localhost:8080/struts-demo/dataTable.do",
				processing: true,
				paginationType: "full_numbers",
				pageLength: 15,
				lengthMenu: [10, 15, 25, 50, 100],
				ordering: true,
				searching: true,
				responsive: true,
				jQueryUI: true,
				columns: [
					{ data: "id" },
					{ data: "cardHolder" },
					{ data: "cardNumber" },
					{ data: "amount" },
					{ data: "timeOfTransaction" },
					{ data: "suspiciousActivity" }
				]
			});
		});
	</script>

</body>