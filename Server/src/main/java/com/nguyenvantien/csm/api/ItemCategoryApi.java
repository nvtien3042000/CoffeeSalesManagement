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

import com.google.gson.Gson;
import com.nguyenvantien.csm.model.Item;
import com.nguyenvantien.csm.model.ItemCategoryDto;
import com.nguyenvantien.csm.service.ItemService;
import com.nguyenvantien.csm.service.impl.ItemServiceImpl;

@WebServlet(urlPatterns = {"/item-category"})
public class ItemCategoryApi extends HttpServlet{
	private static ItemService itemService;
	static {
		itemService = new ItemServiceImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<ItemCategoryDto> result = new ArrayList<>();
		System.out.println("ok");
		String name = "";
		if(req.getParameter("name") != null) {
			name = req.getParameter("name");
		}
		result = itemService.getAllItemAndCategory(name);
		
		Gson gson = new Gson();
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		out.print(gson.toJson(result));
		out.flush();
	}
}
