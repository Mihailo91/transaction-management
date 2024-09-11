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
import java.util.List;

public class DataTableAction extends Action {
	private final TransactionService transactionService = new TransactionService();

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
								 HttpServletResponse response) throws Exception {

		// Extracting parameters from the request
		int draw = Integer.parseInt(request.getParameter("draw"));
		int start = Integer.parseInt(request.getParameter("start"));
		int length = Integer.parseInt(request.getParameter("length"));
		String searchValue = request.getParameter("search[value]");
		String orderColumn = request.getParameter("order[0][column]");
		String orderDir = request.getParameter("order[0][dir]");

		// Fetching the total count of records
		int recordsTotal = transactionService.getTransactionCount();

		// Fetching the filtered and paginated data
		List<TransactionItem> dataList = transactionService.getTransactionsPaginated(start, length, searchValue, orderColumn, orderDir);

		// Creating the JSON response
		JSONObject json = new JSONObject();
		json.put("draw", draw);
		json.put("recordsTotal", recordsTotal);
		json.put("recordsFiltered", recordsTotal); // For simplicity, no actual filtering is done
		json.put("data", new JSONArray(dataList));

		// Sending the response back to DataTables
		response.setContentType("application/json");
		response.getWriter().write(json.toString());

		return null; // No forwarding, as this is a JSON response
	}
}
