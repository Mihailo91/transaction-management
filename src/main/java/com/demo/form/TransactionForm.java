package com.demo.form;

import java.util.List;

import org.apache.struts.action.ActionForm;

import com.demo.model.TransactionItem;

public class TransactionForm extends ActionForm{
	
	private List<TransactionItem> transactionItems;

	public List<TransactionItem> getTransactionItems() {
		return transactionItems;
	}

	public void setTransactionItems(List<TransactionItem> transactionItems) {
		this.transactionItems = transactionItems;
	}
	
	

}
