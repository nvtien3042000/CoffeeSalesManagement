package com.nguyenvantien.csm.service;

import java.util.Map;

public interface UserService {
	Map<String, String> login(String userName, String password);
}
