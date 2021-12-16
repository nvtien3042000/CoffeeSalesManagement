package com.nguyenvantien.csm.service;

import java.util.List;

import com.nguyenvantien.csm.model.Revenue;

public interface RevenueService {
	List<Revenue> getRevenue(String time);
}
