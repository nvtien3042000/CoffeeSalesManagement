package com.nguyenvantien.csm.service.impl;

import java.util.List;

import com.nguyenvantien.csm.dao.BillDao;
import com.nguyenvantien.csm.dao.impl.BillDaoImpl;
import com.nguyenvantien.csm.model.BillDetail;
import com.nguyenvantien.csm.service.BillService;

public class BillServiceImpl implements BillService{
	private static BillDao billDao;
	static {
		billDao = new BillDaoImpl();
	}
	@Override
	public boolean insertBill(Integer discount, Double total, String date) {
		return billDao.insertBill(discount, total, date);
	}
	@Override
	public boolean insertBillDetail(List<BillDetail> lists) {
		return billDao.insertBillDetail(lists);
	}
}
