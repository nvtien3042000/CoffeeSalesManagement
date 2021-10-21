package com.nguyenvantien.csm.app;

import com.nguyenvantien.csm.api.UserApi;
import com.nguyenvantien.csm.service.UserService;
import com.nguyenvantien.csm.service.impl.UserServiceImpl;

public class App {
	private static UserService userService;
	static {
		userService = new UserServiceImpl();
	}
	public static void main(String[] args) {
//		System.out.println();
		System.out.println(userService.login("tien", "123").size());;
	}
}
