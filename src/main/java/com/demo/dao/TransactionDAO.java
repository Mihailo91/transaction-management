package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.demo.model.TransactionItem;

public class TransactionDAO {

    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/task";
    private static final String JDBC_USER = "postgres";
    private static final String JDBC_PASSWORD = "twingo";

    public List<TransactionItem> getAllTransactions() throws ClassNotFoundException {
        List<TransactionItem> transactions = new ArrayList<>();
        Class.forName("org.postgresql.Driver");
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            String sql = "SELECT * FROM transaction";
            try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    TransactionItem transaction = new TransactionItem();
                    transaction.setId(resultSet.getInt("id"));
                    transaction.setCardHolder(resultSet.getString("card_holder"));
                    transaction.setCardNumber(resultSet.getString("card_number"));
                    transaction.setAmount(resultSet.getBigDecimal("amount"));
                    transaction.setTimeOfTransaction(resultSet.getTimestamp("time_of_transaction"));
                    transaction.setSuspiciousActivity(resultSet.getBoolean("suspicious_activity"));

                    transactions.add(transaction);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return transactions;
    }

    public int getTransactionCount() throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        int totalRecords = 0;
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement("SELECT COUNT(*) FROM transaction");
                 ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    totalRecords = resultSet.getInt(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return totalRecords;
    }

    //TODO: fix orderColumn, it only orders by id
    public List<TransactionItem> getAllTransactionsPaginated(int start, int length, String searchValue, String orderColumn, String orderDir) throws ClassNotFoundException {
        List<TransactionItem> transactions = new ArrayList<>();
        Class.forName("org.postgresql.Driver");

        // Define allowed columns and directions to avoid SQL injection
        String[] allowedColumns = {"id", "card_holder", "card_number", "amount", "time_of_transaction", "suspicious_activity"};
        List<String> allowedOrderColumns = Arrays.asList(allowedColumns);
        String sanitizedOrderColumn = allowedOrderColumns.contains(orderColumn) ? orderColumn : "id"; // Default to "id" if invalid
        String sanitizedOrderDir = "ASC".equalsIgnoreCase(orderDir) || "DESC".equalsIgnoreCase(orderDir) ? orderDir : "ASC"; // Default to "ASC"

        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            StringBuilder baseQuery = new StringBuilder("SELECT * FROM transaction");

            if (searchValue != null && !searchValue.isEmpty()) {
                baseQuery.append(" WHERE card_holder ILIKE ? OR card_number ILIKE ? OR amount::text ILIKE ? OR time_of_transaction::text ILIKE ? OR suspicious_activity::text ILIKE ?");
            }
            baseQuery.append(" ORDER BY ").append(sanitizedOrderColumn).append(" ").append(sanitizedOrderDir);
            baseQuery.append(" LIMIT ? OFFSET ?");

            try (PreparedStatement statement = connection.prepareStatement(baseQuery.toString())) {
                int paramIndex = 1;

                if (searchValue != null && !searchValue.isEmpty()) {
                    String filterValue = "%" + searchValue + "%";
                    for (int i = 0; i < 5; i++) {
                        statement.setString(paramIndex++, filterValue);
                    }
                }

                // Pagination parameters
                statement.setInt(paramIndex++, length);  // Limit
                statement.setInt(paramIndex, start);     // Offset

                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        TransactionItem transaction = new TransactionItem();
                        transaction.setId(resultSet.getInt("id"));
                        transaction.setCardHolder(resultSet.getString("card_holder"));
                        transaction.setCardNumber(resultSet.getString("card_number"));
                        transaction.setAmount(resultSet.getBigDecimal("amount"));
                        transaction.setTimeOfTransaction(resultSet.getTimestamp("time_of_transaction"));
                        transaction.setSuspiciousActivity(resultSet.getBoolean("suspicious_activity"));

                        transactions.add(transaction);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return transactions;

    }
}
