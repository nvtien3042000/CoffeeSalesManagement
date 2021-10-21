package com.nguyenvantien.csm.service.impl;

import java.util.List;

import com.nguyenvantien.csm.dao.CategoryDao;
import com.nguyenvantien.csm.impl.CategoryDaoImpl;
import com.nguyenvantien.csm.service.CategoryService;

public class CategoryServiceImpl implements CategoryService{
	private static CategoryDao categoryDao;
	static {
		categoryDao = new CategoryDaoImpl();
	}
	@Override
	public List<String> getAllCategory() {
		return categoryDao.getAllCategory();
	}
}
