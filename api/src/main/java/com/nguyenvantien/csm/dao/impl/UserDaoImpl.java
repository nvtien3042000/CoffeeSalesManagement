package com.nguyenvantien.csm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.nguyenvantien.csm.dao.UserDao;
import com.nguyenvantien.csm.jdbc.DBConnection;
import com.nguyenvantien.csm.model.User;
import com.nguyenvantien.csm.utils.SqlUtils;


public class UserDaoImpl implements UserDao{
	
	private static Connection conn;
	private static Statement st;
	private static PreparedStatement ps;
	private static ResultSet rs;

	static {
		conn = DBConnection.getConnection();
	}
	
	@Override
	public Map<String, String> login(String userName, String password) {
		Map<String, String> result = new HashMap<>();
		String sql = "SELECT id, userName, role FROM account\r\n"
				+ "WHERE userName = '" + userName + "' AND password = '" + password + "'";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				result.put("id", rs.getString("id"));
				result.put("userName", rs.getString("userName"));
				result.put("role", rs.getString("role"));
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
	public List<User> getUsers(String name) {
		String sql = "SELECT id, userName, password, fullName,\r\n"
				+ "phoneNumber, address, role FROM account \r\n"
				+ "WHERE fullName LIKE '%" + name + "%';";
		List<User> result = new ArrayList<User>();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				result.add(transformer());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public boolean insertUser(String userName, String password, String fullName, String phoneNumber, String address,
			String role) {
		String sql = " INSERT INTO `manager`.`account` (\r\n"
				+ " `userName`, `password`, `fullName`,\r\n"
				+ " `phoneNumber`, `address`, `role`)\r\n"
				+ " VALUES (?, ?, ?, ?, ?, ?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, password);
			ps.setString(3, fullName);
			ps.setString(4, phoneNumber);
			ps.setString(5, address);
			ps.setString(6, role);
			ps.execute();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			SqlUtils.close(ps, st);
		}
		return false;
	}
	
	@Override
	public boolean updateUser(Integer id, String userName, String password, String fullName, String phoneNumber,
			String address, String role) {
		String sql = "UPDATE `manager`.`account` SET `userName` = ?,\r\n"
				+ " `password` = ?, `fullName` = ?,\r\n"
				+ " `phoneNumber` = ?, `address` = ?,\r\n"
				+ " `role` = ? WHERE (`id` = ?);";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, password);
			ps.setString(3, fullName);
			ps.setString(4, phoneNumber);
			ps.setString(5, address);
			ps.setString(6, role);
			ps.setInt(7, id);
			ps.execute();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			SqlUtils.close(ps, st);
		}
		return false;
	}
	
	@Override
	public boolean deleteUser(Integer id) {
		String sql = "DELETE FROM `manager`.`account` WHERE (`id` = ?);\r\n";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			SqlUtils.close(ps, st);
		}
		return false;
	}
	
	private User transformer() throws SQLException {
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setUserName(rs.getString("userName"));
		user.setPassword(rs.getString("password"));
		user.setFullName(rs.getString("fullName"));
		user.setPhoneNumber(rs.getString("phoneNumber"));
		user.setAddress(rs.getString("address"));
		user.setRole(rs.getString("role"));
		return user;
	}
}
