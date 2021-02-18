package com.guestbook.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.guestbook.dao.ISysUserDao;
import com.guestbook.entity.SysUser;
import com.guestbook.utils.DBTools;

public class SysUserDaoImpl extends BaseDaoImpl<SysUser> implements ISysUserDao {

	private Connection conn = DBTools.getConnection();

	@Override
	public SysUser login(String loginName, String password) {
		SysUser user = null;
		String sql = "select * from sys_user where loginName=? and pwd=?";
		Object[] params = new Object[] {loginName, password};
		try {
			user = super.get(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public List<SysUser> getAll() {
		List<SysUser> list = null;
		String sql = "select * from sys_user";
		Object[] params = new Object[] {};
		try {
			list = super.getForList(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int insert(String loginName, String nickName, String password, String status, int roleId) {
		int id = -1;
		String sql = "insert into sys_user(loginName,nickName,pwd,status,roleId)values(?,?,?,?,?)";
		Object[] params = new Object[] {loginName,nickName,password,status,roleId};
		try {			
			PreparedStatement st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			//提供数据
            if (params != null && params.length > 0) {
                for (int i = 0; i < params.length; i++) {
                    st.setObject(i + 1, params[i]);
                }
            }
			st.executeUpdate();
			ResultSet rs = st.getGeneratedKeys();
            while(rs.next()){
                id = rs.getInt(1);
            } 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public boolean isExits(String loginName) {
		SysUser user = null;
		String sql = "select * from sys_user where loginName=?";
		Object[] params = new Object[] {loginName};
		try {
			user = super.get(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user==null?false:true;
	}

	@Override
	public int delete(Integer id) {
		int ret = -1;
		String sql = "delete from sys_user where id=?";
		Object[] params = new Object[] {id};
		try {			
			PreparedStatement st = conn.prepareStatement(sql);
			//提供数据
            if (params != null && params.length > 0) {
                for (int i = 0; i < params.length; i++) {
                    st.setObject(i + 1, params[i]);
                }
            }
			ret = st.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}

	@Override
	public SysUser get(Integer id) {
		SysUser user = null;
		String sql = "select * from sys_user where id=?";
		Object[] params = new Object[] {id};
		try {
			user = super.get(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public int update(String id, String loginName, String nickName, String status, Integer roleId) {
		int ret = -1;
		String sql = "update sys_user set loginName=?,nickName=?,status=?,roleId=? where id=?";
		Object[] params = new Object[] {loginName,nickName,status,roleId,id};
		try {			
			PreparedStatement st = conn.prepareStatement(sql);
			//提供数据
            if (params != null && params.length > 0) {
                for (int i = 0; i < params.length; i++) {
                    st.setObject(i + 1, params[i]);
                }
            }
			ret = st.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}

	
}
