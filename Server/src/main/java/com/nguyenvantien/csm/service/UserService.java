package com.nguyenvantien.csm.service;

import java.util.List;
import java.util.Map;

import com.nguyenvantien.csm.model.User;

public interface UserService {
	Map<String, String> login(String userName, String password);
	List<User> getUsers(String name);
	boolean insertUser(String userName, String password, String fullName, String phoneNumber, String address, String role);
	boolean updateUser(Integer id, String userName, String password, String fullName, String phoneNumber, String address, String role);
	boolean deleteUser(Integer id);
}
