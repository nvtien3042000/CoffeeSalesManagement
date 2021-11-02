package com.nguyenvantien.csm.dao;

import java.util.List;

import com.nguyenvantien.csm.model.Revenue;

public interface RevenueDao {
	List<Revenue> getRevenue(String time);
}
