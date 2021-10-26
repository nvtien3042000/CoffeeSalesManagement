package com.nguyenvantien.csm.app;

import java.text.SimpleDateFormat;
import java.util.Date;

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
//		System.out.println(userService.login("tien", "123").size());;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		String date = dateFormat.format(new Date());
		System.out.println("aa"+date);
	}
}
