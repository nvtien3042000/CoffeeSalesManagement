package com.nguyenvantien.csm.dao;

import java.util.List;

import com.nguyenvantien.csm.model.Item;

public interface ItemDao {
	List<Item> getAllItem();
	List<Item> getItemsByCategory(String category);
	List<Item> getItemsByName(String name);
	boolean insertItem(String name, Double price, String unit, Integer category);
}
