package com.nguyenvantien.csm.service.impl;

import java.util.List;
import java.util.Map;

import com.nguyenvantien.csm.dao.UserDao;
import com.nguyenvantien.csm.dao.impl.UserDaoImpl;
import com.nguyenvantien.csm.model.User;
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
	@Override
	public List<User> getUsers(String name) {
		return userDao.getUsers(name);
	}
	@Override
	public boolean insertUser(String userName, String password, String fullName, String phoneNumber, String address,
			String role) {
		return userDao.insertUser(userName, password, fullName, phoneNumber, address, role);
	}
	@Override
	public boolean updateUser(Integer id, String userName, String password, String fullName, String phoneNumber,
			String address, String role) {
		return userDao.updateUser(id, userName, password, fullName, phoneNumber, address, role);
	}
	@Override
	public boolean deleteUser(Integer id) {
		return userDao.deleteUser(id);
	}
}
