package com.nguyenvantien.csm.model;

public class Revenue {
	private String total;
	private String time;
	public Revenue() {
		
	}
	public Revenue(String total, String time) {
		this.total = total;
		this.time = time;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "Revenue [total=" + total + ", time=" + time + "]";
	}
	
}
