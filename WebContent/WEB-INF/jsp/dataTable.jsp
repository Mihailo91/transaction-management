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
            $('#myTable').dataTable();
        });
    </script>      
</body>
