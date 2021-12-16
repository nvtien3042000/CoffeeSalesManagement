package com.nguyenvantien.csm.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.nguyenvantien.csm.filter.Session;
import com.nguyenvantien.csm.service.UserService;
import com.nguyenvantien.csm.service.impl.UserServiceImpl;
import com.nguyenvantien.csm.utils.JsonUtils;

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
		System.out.println(req.getRequestURI());
		System.out.println(req.getRequestURL());
		Map<String, String> result = userService.login(userName, password);
		System.out.println(userName + " - " + password);
		
		if(result.size() > 0) {
			HttpSession session = Session.session;
			if(session == null) {
				session = req.getSession();
			}
			session.setAttribute(userName, userName);
			Session.session = session;
			System.out.println(result.size()+"======="+session.getAttribute("name"));
		}
		
		JsonUtils.tranObjectToJson(resp, result);
		
	}
	
}
