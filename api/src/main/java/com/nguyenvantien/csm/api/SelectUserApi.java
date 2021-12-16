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
import com.nguyenvantien.csm.model.User;
import com.nguyenvantien.csm.service.UserService;
import com.nguyenvantien.csm.service.impl.UserServiceImpl;
import com.nguyenvantien.csm.utils.JsonUtils;

@WebServlet(urlPatterns = {"/users"})
public class SelectUserApi extends HttpServlet{
	private static UserService userService;
	static {
		userService = new UserServiceImpl();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = "";
		if(req.getParameter("name") != null) {
			name = req.getParameter("name");
		}
		List<User> result = userService.getUsers(name);

		JsonUtils.tranObjectToJson(resp, result);
	}
}
