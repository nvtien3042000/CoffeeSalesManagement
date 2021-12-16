package com.nguyenvantien.csm.model;

public class BillDetail {
	private Integer idItem;
	private Integer quantity;

	public BillDetail() {
	}

	public BillDetail(Integer idItem, Integer quantity) {
		super();
		this.idItem = idItem;
		this.quantity = quantity;
	}

	public Integer getidItem() {
		return idItem;
	}

	public void setidItem(Integer idItem) {
		this.idItem = idItem;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "BillDetail [idItem=" + idItem + ", quantity=" + quantity + "]";
	}
	
}
