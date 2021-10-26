package com.nguyenvantien.csm.service.impl;

import java.util.Map;

import com.nguyenvantien.csm.dao.UserDao;
import com.nguyenvantien.csm.dao.impl.UserDaoImpl;
import com.nguyenvantien.csm.service.UserService;

public class UserServiceImpl implements UserService {
	private static UserDao userDao;
	static {
		userDao = new UserDaoImpl();
	}
	@Override
	public Map<String, String> login(String userName, String password) {
		return userDao.login(userName, password);
	}
}
