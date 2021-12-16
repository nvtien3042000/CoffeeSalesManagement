package com.nguyenvantien.csm.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpSession;

import com.nguyenvantien.csm.model.User;
import com.nguyenvantien.csm.service.UserService;
import com.nguyenvantien.csm.service.impl.UserServiceImpl;

@WebFilter(urlPatterns = { "/item", "/item-category", "/category", "/add-item", "/add-user", "/add-bill",
		"/delete-item", "/delete-user", "/revenue", "/users", "/update-item", "/update-user" })
public class Security implements Filter {

	private static UserService userService;
	static {
		userService = new UserServiceImpl();
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("1");
		HttpSession session = Session.session;
		List<User> uses = userService.getUsers("");
		Map<String, String> maps = new HashMap<>();
		
		for (User user : uses) {
			maps.put(user.getUserName(), user.getRole());
		}
		List<String> keys = new ArrayList<>(maps.keySet());

		System.out.println(session);
		if (session != null) {

			for(int i = 0; i< keys.size(); i++) {
				String name = (String) session.getAttribute(keys.get(i));
				System.out.println("name" + name);
				
				if (name != null) {
					System.out.println("Let");
					
					try {
						chain.doFilter(request, response);
						break;
					} catch (IOException e) {
						e.printStackTrace();
					} catch (ServletException e) {
						e.printStackTrace();
					}
				}
			}
			
		}

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

}
