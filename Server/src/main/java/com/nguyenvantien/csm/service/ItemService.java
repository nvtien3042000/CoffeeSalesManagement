package com.nguyenvantien.csm.service;

import java.util.List;

import com.nguyenvantien.csm.model.Item;

public interface ItemService {
	List<Item> getAllItem();
	List<Item> getItemsByCategory(String category);
	List<Item> getItemsByName(String name);
}
