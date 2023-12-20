package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.entity.User;

public class UserDAO {
	private Connection conn;
	public UserDAO(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public boolean addUser(User u) {
		boolean f = false;
		try {
			String sql = "insert into user(name, email, password, qualification, role) values(?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getName());
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getPassword());
			ps.setString(4, u.getQualification());
			ps.setString(5, "user");
			
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public User login(String em, String pwd) {
		User user = null;
		
		try {
			String sql = "select * from user where email=? and password = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, em);
			ps.setString(2, pwd);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				user = new User();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setPassword(rs.getString(4));
				user.setQualification(rs.getString(5));
				user.setRole(rs.getString(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public boolean updateUser (User u) {
		boolean f = false;
		try {
			String sql = "update user set name=?, qualification=?, email=?, password=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getName());
			ps.setString(2, u.getQualification());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getPassword());
			ps.setInt(5, u.getId());
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
}
