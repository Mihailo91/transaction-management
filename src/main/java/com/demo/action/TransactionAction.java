package com.demo.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.demo.form.TransactionForm;
import com.demo.model.TransactionItem;
import com.demo.service.TransactionService;

public class TransactionAction extends Action {

	private TransactionService transactionService = new TransactionService();

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		ActionForward fw = mapping.findForward("failure");

		TransactionForm tF = (TransactionForm) form;

		try {
			List<TransactionItem> transactions = transactionService.getAllTransactions();
			tF.setTransactionItems(transactions);
			fw = mapping.findForward("success");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return fw;
	}

}
