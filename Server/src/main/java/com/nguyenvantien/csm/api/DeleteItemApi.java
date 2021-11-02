package com.nguyenvantien.csm.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nguyenvantien.csm.service.ItemService;
import com.nguyenvantien.csm.service.impl.ItemServiceImpl;

@WebServlet(urlPatterns = {"/delete-item"})
public class DeleteItemApi extends HttpServlet{
	private static ItemService itemService;
	static {
		itemService = new ItemServiceImpl();
	}
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getReader().lines().collect(Collectors.joining()).split("=")[1];
		System.out.println(id);
		boolean result = itemService.deleteItem(Integer.parseInt(id));
		Gson gson = new Gson();
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		out.print(gson.toJson(result));
		out.flush();
	}
}
