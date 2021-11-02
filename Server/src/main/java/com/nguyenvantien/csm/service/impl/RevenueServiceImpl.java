package com.nguyenvantien.csm.service.impl;

import java.util.List;

import com.nguyenvantien.csm.dao.RevenueDao;
import com.nguyenvantien.csm.dao.impl.ReventueDaoImpl;
import com.nguyenvantien.csm.model.Revenue;
import com.nguyenvantien.csm.service.RevenueService;

public class RevenueServiceImpl implements RevenueService{
	private static RevenueDao revenueDao;
	static {
		revenueDao = new ReventueDaoImpl();
	}
	@Override
	public List<Revenue> getRevenue(String time) {
		return revenueDao.getRevenue(time);
	}
}
