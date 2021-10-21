package com.nguyenvantien.csm.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nguyenvantien.csm.service.UserService;
import com.nguyenvantien.csm.service.impl.UserServiceImpl;

@WebServlet(urlPatterns = {"/login"})
public class UserApi extends HttpServlet{
	private static UserService userService;
	static {
		userService = new UserServiceImpl();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		
		Map<String, String> result = userService.login(userName, password);
		
		Gson gson = new Gson();
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		out.print(gson.toJson(result));
		out.flush();
	}
}
