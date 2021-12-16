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
import com.nguyenvantien.csm.service.CategoryService;
import com.nguyenvantien.csm.service.impl.CategoryServiceImpl;
import com.nguyenvantien.csm.utils.JsonUtils;

@WebServlet(urlPatterns = {"/category"})
public class CategoryApi extends HttpServlet{
	private static CategoryService categoryService;
	static {
		categoryService = new CategoryServiceImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<String> result = categoryService.getAllCategory();
		JsonUtils.tranObjectToJson(resp, result);
	}
}
