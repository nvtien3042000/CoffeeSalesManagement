package com.nguyenvantien.csm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.nguyenvantien.csm.dao.ItemDao;
import com.nguyenvantien.csm.jdbc.DBConnection;
import com.nguyenvantien.csm.model.Item;
import com.nguyenvantien.csm.utils.SqlUtils;

public class ItemDaoImpl implements ItemDao {
	private static Connection conn;
	private static Statement st;
	private static PreparedStatement preStatement;
	private static ResultSet rs;

	static {
		conn = DBConnection.getConnection();
	}

	@Override
	public List<Item> getAllItem() {
		List<Item> result = new ArrayList<>();
		String sql = "SELECT id, name, price, unit FROM item ORDER BY name;";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				result.add(transformer());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, preStatement);
		}
		return result;
	}

	@Override
	public List<Item> getItemsByCategory(String category) {
		List<Item> result = new ArrayList<>();
		String sql = "SELECT I.id, I.name, price, unit FROM item I\r\n" + "JOIN category C\r\n"
				+ "ON C.id = I.categoryId\r\n" + "WHERE C.name LIKE '%" + category + "%' ORDER BY name;";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				result.add(transformer());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, preStatement);
		}
		return result;
	}

	@Override
	public List<Item> getItemsByName(String name) {
		List<Item> result = new ArrayList<>();
		String sql = "SELECT * FROM item WHERE name LIKE '%" + name + "%' ORDER BY name;";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				result.add(transformer());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, st);
		}
		return result;
	}

	@Override
	public boolean insertItem(String name, Double price, String unit, Integer category) {
		String sql = "INSERT INTO `manager`.`item` (`name`, `price`, `unit`, `categoryId`) VALUES (?, ?, ?, ?);";
		boolean result = false;
		try {
			preStatement = conn.prepareStatement(sql);
			preStatement.setString(1, name);
			preStatement.setDouble(2, price);
			preStatement.setString(3, unit);
			preStatement.setInt(4, category);
			preStatement.execute();
			result = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} finally {
			SqlUtils.close(rs, preStatement);
		}
		return result;
	}

	private Item transformer() throws SQLException {
		Item item = new Item();
		item.setId(rs.getInt("id"));
		item.setName(rs.getString("name"));
		item.setPrice(rs.getDouble("price"));
		item.setUnit(rs.getString("unit"));
		return item;
	}
}
