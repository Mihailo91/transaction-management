package com.demo.service;

import java.util.List;

import com.demo.dao.TransactionDAO;
import com.demo.model.TransactionItem;

public class TransactionService {

    private TransactionDAO transactionDAO = new TransactionDAO();

    public List<TransactionItem> getAllTransactions() throws ClassNotFoundException {
        return transactionDAO.getAllTransactions();
    }
}