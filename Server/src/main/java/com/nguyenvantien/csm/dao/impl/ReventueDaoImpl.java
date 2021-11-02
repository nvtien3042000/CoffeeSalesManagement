package com.nguyenvantien.csm.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.nguyenvantien.csm.dao.RevenueDao;
import com.nguyenvantien.csm.jdbc.DBConnection;
import com.nguyenvantien.csm.model.Revenue;

public class ReventueDaoImpl implements RevenueDao{
	private static Connection conn;
	private static Statement st;
	private static ResultSet rs;

	static {
		conn = DBConnection.getConnection();
	}
	@Override
	public List<Revenue> getRevenue(String time) {
		String sql = "SELECT sum(total) total, " + time + " time FROM bill GROUP BY time ORDER BY time DESC;";
		List<Revenue> result = new ArrayList<>();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				result.add(transformer());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	private Revenue transformer() throws SQLException {
		Revenue revenue = new Revenue();
		revenue.setTotal(rs.getString("total"));
		revenue.setTime(rs.getString("time"));
		return revenue;
	}
}
