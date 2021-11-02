package com.nguyenvantien.csm.dao;

import java.util.List;

import com.nguyenvantien.csm.model.Item;
import com.nguyenvantien.csm.model.ItemCategoryDto;

public interface ItemDao {
	List<Item> getAllItem();
	List<ItemCategoryDto> getAllItemAndCategory(String name);
	List<Item> getItemsByCategory(String category);
	List<Item> getItemsByName(String name);
	boolean insertItem(String name, Double price, String unit, String category);
	boolean updateItem(Integer id, String name, Double price, String unit, String category);
	boolean deleteItem(Integer id);
}
