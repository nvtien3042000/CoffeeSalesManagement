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
import com.nguyenvantien.csm.utils.JsonUtils;

@WebServlet(urlPatterns = {"/update-item"})
public class UpdateItemApi extends HttpServlet{
	private static ItemService itemService;
	static {
		itemService = new ItemServiceImpl();
	}
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(req.getParameter("id"));
		Integer id = Integer.valueOf(req.getParameter("id"));
		String name = req.getParameter("name");
		System.out.println(name);
		Double price = Double.valueOf(req.getParameter("price"));
		String unit = req.getParameter("unit");
		String category = req.getParameter("category");
		boolean result = itemService.updateItem(id, name, price, unit, category);
		JsonUtils.tranObjectToJson(resp, result);
	}
	
	
	
}
