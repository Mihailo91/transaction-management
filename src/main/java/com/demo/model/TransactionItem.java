package com.demo.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class TransactionItem {
    private Integer id;
    private String cardHolder;
    private String cardNumber;
    private BigDecimal amount;
    private Timestamp timeOfTransaction;
    private boolean suspiciousActivity;
	
    public TransactionItem() {
		super();
	}
    
	public TransactionItem(Integer id, String cardHolder, String cardNumber, BigDecimal amount,
			Timestamp timeOfTransaction, boolean suspiciousActivity) {
		super();
		this.id = id;
		this.cardHolder = cardHolder;
		this.cardNumber = cardNumber;
		this.amount = amount;
		this.timeOfTransaction = timeOfTransaction;
		this.suspiciousActivity = suspiciousActivity;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCardHolder() {
		return cardHolder;
	}
	public void setCardHolder(String cardHolder) {
		this.cardHolder = cardHolder;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public Timestamp getTimeOfTransaction() {
		return timeOfTransaction;
	}
	public void setTimeOfTransaction(Timestamp timeOfTransaction) {
		this.timeOfTransaction = timeOfTransaction;
	}
	public boolean isSuspiciousActivity() {
		return suspiciousActivity;
	}
	public void setSuspiciousActivity(boolean suspiciousActivity) {
		this.suspiciousActivity = suspiciousActivity;
	}    
}
