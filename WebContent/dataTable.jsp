<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.11/css/jquery.dataTables.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.11/js/jquery.dataTables.min.js"></script>
</head>

<body>
    <table id="myTable" class="display">
        <thead>
            <tr>
                <th>id</th>
                <th>cardHolder</th>
                <th>cardNumber</th>
            </tr>
        </thead>
        <tbody>
            <!-- Data will be populated by DataTables -->
        </tbody>
    </table>

<script>

        $(document).ready(function() {
            $('#myTable').dataTable({
                "bServerSide": true,
                "sAjaxSource": "http://localhost:8080/struts-demo/dataTable.do",
                "bProcessing": true,
                "sPaginationType": "full_numbers",
                "bJQueryUI": true
                "ajax": {
                    "url": "<s:url action='http://localhost:8080/struts-demo/dataTable.do'/>", // URL to the Struts action
                    "type": "GET",
                    "data": function (json) {
                        console.log('Data received from server:', json);
                        return json; // Return the data as-is or process it if needed
                    },
                    "error": function (xhr, error, thrown) {
                        console.error('Error fetching data:', thrown);
                    }
                },
                "columns": [
                    { "data": "id" },
                    { "data": "cardHolder" },
                    { "data": "cardNumber" }
                ]
            });
        });
    </script>      
</body>
