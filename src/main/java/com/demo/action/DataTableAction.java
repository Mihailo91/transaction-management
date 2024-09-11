package com.demo.action;

import com.demo.model.TransactionItem;
import com.demo.service.TransactionService;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class DataTableAction extends Action {
	private int draw;
	private TransactionService transactionService = new TransactionService();

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		List<TransactionItem> dataList = new ArrayList<>();

		try {
			dataList.addAll(transactionService.getAllTransactions());
		} catch (Exception e) {
			e.printStackTrace();
		}

		JSONObject json = new JSONObject();
		json.put("draw", draw);
		json.put("recordsTotal", dataList.size());
		json.put("data", new JSONArray(dataList));

		response.setContentType("application/json");
		response.getWriter().write(json.toString());

		return null; // No forwarding, as this is a JSON response
	}
}