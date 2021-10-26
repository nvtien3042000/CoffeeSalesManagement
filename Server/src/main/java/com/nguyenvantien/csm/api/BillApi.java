package com.nguyenvantien.csm.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.google.gson.Gson;
import com.nguyenvantien.csm.model.BillDetail;
import com.nguyenvantien.csm.service.BillService;
import com.nguyenvantien.csm.service.impl.BillServiceImpl;

@WebServlet(urlPatterns = {"/add-bill"})
public class BillApi extends HttpServlet{
	private static BillService billService;
	static {
		billService = new BillServiceImpl();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer discount = Integer.parseInt(req.getParameter("discount"));
		Double total = Double.parseDouble(req.getParameter("total"));
		String date = req.getParameter("date");
		String itemsList = req.getParameter("itemsList");
		boolean result = billService.insertBill(discount, total, date);
		Gson gson = new Gson();
		JSONArray array = new JSONArray(itemsList);
		List<BillDetail> lists = new ArrayList<>();
        for (int i = 0; i < array.length(); i++) {
        	lists.add(gson.fromJson(array.get(i).toString(), BillDetail.class));
        }
        lists.forEach(System.out::println);
        result = billService.insertBillDetail(lists);
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		out.print(gson.toJson(result));
		out.flush();
	}
}
