package com.nguyenvantien.csm.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nguyenvantien.csm.model.Revenue;
import com.nguyenvantien.csm.service.RevenueService;
import com.nguyenvantien.csm.service.impl.RevenueServiceImpl;
import com.nguyenvantien.csm.utils.JsonUtils;

@WebServlet(urlPatterns = {"/revenue"})
public class RevenueApi extends HttpServlet{
	private static RevenueService revenueService;
	static {
		revenueService = new RevenueServiceImpl();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String time = "";
		if(req.getParameter("time") != null) {
			if(req.getParameter("time").equals("date")) {
				time = "DATE(date)";
			} else if(req.getParameter("time").equals("month")) {
				time = "concat(Year(date), '-', MONTH(date))";
			} else {
				time = "YEAR(date)";
			}
		} else {
			time = "DATE(date)";
		}
		List<Revenue> result = revenueService.getRevenue(time);
		
		JsonUtils.tranObjectToJson(resp, result);
		
	}
}
