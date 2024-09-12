package com.demo.dao;

import java.sql.*;
import java.util.*;

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

    public List<TransactionItem> getAllTransactionsPaginated(int start, int length, String searchValue, String orderColumn, String orderDir) throws ClassNotFoundException {
        List<TransactionItem> transactions = new ArrayList<>();
        Class.forName("org.postgresql.Driver");

        Map<Integer, String> columns = new HashMap<>();
        columns.put(0, "id");
        columns.put(1, "card_holder");
        columns.put(2, "card_number");
        columns.put(3, "amount");
        columns.put(4, "time_of_transaction");
        columns.put(5, "suspicious_activity");
        String orderColumnName = columns.getOrDefault(Integer.parseInt(orderColumn), "id");
        String allowedOrderDir = "ASC".equalsIgnoreCase(orderDir) || "DESC".equalsIgnoreCase(orderDir) ? orderDir : "ASC";

        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            StringBuilder baseQuery = new StringBuilder("SELECT * FROM transaction");

            if (searchValue != null && !searchValue.isEmpty()) {
                baseQuery.append(" WHERE card_holder ILIKE ? OR card_number ILIKE ? OR amount::text ILIKE ? OR time_of_transaction::text ILIKE ? OR suspicious_activity::text ILIKE ?");
            }
            baseQuery.append(" ORDER BY ").append(orderColumnName).append(" ").append(allowedOrderDir);
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
