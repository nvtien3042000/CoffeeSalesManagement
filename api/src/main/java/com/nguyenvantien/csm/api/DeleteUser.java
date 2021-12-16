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
import com.nguyenvantien.csm.service.UserService;
import com.nguyenvantien.csm.service.impl.UserServiceImpl;
import com.nguyenvantien.csm.utils.JsonUtils;

@WebServlet(urlPatterns = {"/delete-user"})
public class DeleteUser extends HttpServlet{
	private static UserService userService;
	static {
		userService = new UserServiceImpl();
	}
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getReader().lines().collect(Collectors.joining()).split("=")[1];
		System.out.println("id : " + id);
		boolean result = userService.deleteUser(Integer.parseInt(id));
		JsonUtils.tranObjectToJson(resp, result);
	}
}
