package com.nguyenvantien.csm.service;

import java.util.List;

import com.nguyenvantien.csm.model.BillDetail;

public interface BillService {
	boolean insertBill(Integer discount, Double total, String date);
	boolean insertBillDetail(List<BillDetail> lists);
}
