package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
}
