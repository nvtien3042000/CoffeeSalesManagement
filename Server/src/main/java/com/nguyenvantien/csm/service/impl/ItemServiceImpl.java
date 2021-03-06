package com.nguyenvantien.csm.service.impl;

import java.util.List;

import com.nguyenvantien.csm.dao.ItemDao;
import com.nguyenvantien.csm.dao.impl.ItemDaoImpl;
import com.nguyenvantien.csm.model.Item;
import com.nguyenvantien.csm.model.ItemCategoryDto;
import com.nguyenvantien.csm.service.ItemService;

public class ItemServiceImpl implements ItemService{
	private static ItemDao itemDao;
	static {
		itemDao = new ItemDaoImpl();
	}
	@Override
	public List<Item> getAllItem() {
		return itemDao.getAllItem();
	}
	@Override
	public List<ItemCategoryDto> getAllItemAndCategory(String name) {
		return itemDao.getAllItemAndCategory(name);
	}
	@Override
	public List<Item> getItemsByCategory(String category) {
		return itemDao.getItemsByCategory(category);
	}
	@Override
	public List<Item> getItemsByName(String name) {
		return itemDao.getItemsByName(name);
	}
	@Override
	public boolean insertItem(String name, Double price, String unit, String category) {
		return itemDao.insertItem(name, price, unit, category);
	}
	@Override
	public boolean updateItem(Integer id, String name, Double price, String unit, String category) {
		return itemDao.updateItem(id, name, price, unit, category);
	}
	@Override
	public boolean deleteItem(Integer id) {
		return itemDao.deleteItem(id);
	}
}
