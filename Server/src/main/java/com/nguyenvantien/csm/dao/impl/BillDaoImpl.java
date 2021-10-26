package com.nguyenvantien.csm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.nguyenvantien.csm.dao.BillDao;
import com.nguyenvantien.csm.jdbc.DBConnection;
import com.nguyenvantien.csm.model.BillDetail;
import com.nguyenvantien.csm.utils.SqlUtils;

public class BillDaoImpl implements BillDao {
	private static Connection conn;
	private static Statement st;
	private static PreparedStatement ps;
	private static ResultSet rs;

	static {
		conn = DBConnection.getConnection();
	}

	@Override
	public boolean insertBill(Integer discount, Double total, String date) {
		boolean result = false;
		String sql = "INSERT INTO `manager`.`bill` (`discount`, `total`, `date`)\r\n" + " VALUES ( ?, ?, ?);\r\n";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, discount);
			ps.setDouble(2, total);
			ps.setString(3, date);
			ps.execute();
			result = true;
			System.out.println("bill");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, ps);
		}
		return result;
	}

	@Override
	public boolean insertBillDetail(List<BillDetail> lists) {
		String sql = "SELECT MAX(id) id FROM bill";
		Integer idBill = -1;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				idBill = rs.getInt("id");
			}
			System.out.println("maxId:" +idBill);
		} catch (SQLException e) {
			System.out.println("getMax:" + e.getMessage());
			return false;
		} finally {
			SqlUtils.close(rs, st);
		}
		
		for (int i = 0; i < lists.size(); i++) {
			String sqlInsert = "INSERT INTO `manager`.`billdetail` (`billId`, `itemId`, `quantity`)\r\n"
					+ "VALUES (?, ?, ?);";
			try {
				ps = conn.prepareStatement(sqlInsert);
				ps.setInt(1, idBill);
				ps.setInt(2, lists.get(i).getidItem());
				ps.setInt(3, lists.get(i).getQuantity());
				ps.execute();
				System.out.println("item: " + idBill + " - " +lists.get(i).getidItem());
			} catch (SQLException e) {
				System.out.println("inssert item:" + e.getMessage());
				return false;
			} finally {
				SqlUtils.close(rs, ps);
			}
		}
		
		return true;
	}
}
