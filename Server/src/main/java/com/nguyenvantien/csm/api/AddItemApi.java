package com.nguyenvantien.csm.api;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nguyenvantien.csm.service.ItemService;
import com.nguyenvantien.csm.service.impl.ItemServiceImpl;

@WebServlet(urlPatterns = {"/add-item"})
public class AddItemApi extends HttpServlet{
	private static ItemService itemService;
	static {
		itemService = new ItemServiceImpl();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		Double price = Double.valueOf(req.getParameter("price"));
		String unit = req.getParameter("unit");
		String category = req.getParameter("category");
		System.out.println("add");
		boolean result = itemService.insertItem(name, price, unit, category);
		Gson gson = new Gson();
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		out.print(gson.toJson(result));
		out.flush();
	}
}
