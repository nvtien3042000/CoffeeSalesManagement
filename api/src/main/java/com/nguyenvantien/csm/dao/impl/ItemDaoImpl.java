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
import com.nguyenvantien.csm.model.ItemCategoryDto;
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
	public List<ItemCategoryDto> getAllItemAndCategory(String name) {
		List<ItemCategoryDto> result = new ArrayList<>();
		String sql = "SELECT I.id, I.name, price, unit, C.name nameCategory FROM item I\r\n"
				+ "JOIN category C\r\n"
				+ "ON I.categoryId = C.id\r\n"
				+ "WHERE I.name LIKE '%" + name + "%'\r\n"
				+ "group by I.id";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				result.add(transformerItemCategory());
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
	public boolean insertItem(String name, Double price, String unit, String category) {
		String sql = "INSERT INTO `manager`.`item` (`name`, `price`, `unit`, `categoryId`) VALUES (?, ?, ?, "
				+ "(SELECT id FROM category WHERE name = ?));";
		boolean result = false;
		try {
			preStatement = conn.prepareStatement(sql);
			preStatement.setString(1, name);
			preStatement.setDouble(2, price);
			preStatement.setString(3, unit);
			preStatement.setString(4, category);
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
	
	@Override
	public boolean updateItem(Integer id, String name, Double price, String unit, String category) {
		String sql = "UPDATE `manager`.`item` SET `name` = '" + name + "',\r\n"
				+ " `price` = '" + price + "', `unit` = '" + unit + "',\r\n"
				+ " `categoryId` = (SELECT id FROM category WHERE name = '" + category + "')\r\n"
				+ " WHERE (`id` = '" + id + "');";
//		String sql = "UPDATE `manager`.`item` SET `name` = ?,\r\n"
//				+ " `price` = ?, `unit` = ?,\r\n"
//				+ " `categoryId` = (SELECT id FROM category WHERE name = ?)\r\n"
//				+ " WHERE (`id` = ?);";
		try {
			preStatement = conn.prepareStatement(sql);
//			preStatement.setString(1, name);
//			preStatement.setDouble(2, price);
//			preStatement.setString(3, unit);
//			preStatement.setString(4, category);
//			preStatement.setInt(5, id);
			System.out.println(sql);
			preStatement.execute();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			SqlUtils.close(rs, preStatement);
		}
		return false;
		
	}
	
	@Override
	public boolean deleteItem(Integer id) {
		String sql = "DELETE FROM `manager`.`item` WHERE (`id` = ?);\r\n";
		try {
			preStatement = conn.prepareStatement(sql);
			preStatement.setInt(1, id);
			preStatement.execute();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			SqlUtils.close(rs, preStatement);
		}
		return false;
	}

	private Item transformer() throws SQLException {
		Item item = new Item();
		item.setId(rs.getInt("id"));
		item.setName(rs.getString("name"));
		item.setPrice(rs.getDouble("price"));
		item.setUnit(rs.getString("unit"));
		return item;
	}
	
	private ItemCategoryDto transformerItemCategory() throws SQLException {
		ItemCategoryDto itemCategory = new ItemCategoryDto();
		itemCategory.setId(rs.getInt("id"));
		itemCategory.setName(rs.getString("name"));
		itemCategory.setPrice(rs.getDouble("price"));
		itemCategory.setUnit(rs.getString("unit"));
		itemCategory.setNameCategory(rs.getString("nameCategory"));
		return itemCategory;
	}
}
