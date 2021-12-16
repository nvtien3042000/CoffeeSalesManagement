package com.nguyenvantien.csm.dao;

import java.util.List;

import com.nguyenvantien.csm.model.BillDetail;

public interface BillDao {
	boolean insertBill(Integer discount, Double total, String date);
	boolean insertBillDetail(List<BillDetail> lists);
}
