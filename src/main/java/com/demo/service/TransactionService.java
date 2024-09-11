package com.demo.service;

import java.util.List;

import com.demo.dao.TransactionDAO;
import com.demo.model.TransactionItem;

public class TransactionService {

    private final TransactionDAO transactionDAO = new TransactionDAO();

    public List<TransactionItem> getAllTransactions() throws ClassNotFoundException {
        return transactionDAO.getAllTransactions();
    }

    public int getTransactionCount() throws ClassNotFoundException {
        return transactionDAO.getTransactionCount();
    }

    public List<TransactionItem> getTransactionsPaginated(int start,
                                                          int length,
                                                          String searchValue,
                                                          String orderColumn,
                                                          String orderDir) throws ClassNotFoundException {
        return transactionDAO.getAllTransactionsPaginated(start, length, searchValue, orderColumn, orderDir);
    }
}