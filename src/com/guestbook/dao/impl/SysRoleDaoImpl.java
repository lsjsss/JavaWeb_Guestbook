package com.guestbook.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.guestbook.dao.ISysRoleDao;
import com.guestbook.entity.SysRole;
import com.guestbook.utils.DBTools;

public class SysRoleDaoImpl extends BaseDaoImpl<SysRole> implements ISysRoleDao {

	private Connection conn = DBTools.getConnection();

	@Override
	public void add(SysRole sysRole) {
		String sql = "insert into sys_role(roleName,description)values(?,?)";
		Object[] params = new Object[] {sysRole.getRoleName(),sysRole.getDescription()};
		try {
			super.update(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		String sql = "delete from sys_role where id=?";
		Object[] params = new Object[] {id};
		try {
			super.update(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(SysRole sysRole) {
		String sql = "update sys_role set roleName=?,description=? where id=?";
		Object[] params = new Object[] {sysRole.getRoleName(),sysRole.getDescription(),sysRole.getId()};
		try {
			super.update(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public SysRole get(int id) {
		SysRole role = null;
		String sql = "select * from sys_role where id=?";
		Object[] params = new Object[] {id};
		try {
			role = super.get(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return role;
	}

	@Override
	public List<SysRole> getAll() {
		List<SysRole> list = null;
		String sql = "select * from sys_role";
		Object[] params = new Object[] {};
		try {
			list = super.getForList(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static void main(String[] args) {
		SysRoleDaoImpl dao = new SysRoleDaoImpl();
		SysRole role = dao.get(1);
		System.out.println(role);
	}

	
	/**
	 * Connection
	 * Statement PreparedStatement
	 * ResultSet
	 */
	@Override
	public int insert(SysRole sysRole) {
		int id = -1;
		String sql = "insert into sys_role(roleName,description)values(?,?)";
		Object[] params = new Object[] {sysRole.getRoleName(),sysRole.getDescription()};
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
	public SysRole getSysRoleByRoleName(String roleName) {
		SysRole role = null;
		String sql = "select * from sys_role where roleName=?";
		Object[] params = new Object[] {roleName};
		try {
			role = super.get(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return role;
	}

	@Override
	public int del(Integer id) {
		int ret = -1;
		String sql = "delete from sys_role where id=?";
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
	public int edit(SysRole sysRole) {
		int ret = -1;
		String sql = "update sys_role set roleName=?,description=? where id=?";
		Object[] params = new Object[] {sysRole.getRoleName(),sysRole.getDescription(),sysRole.getId()};
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
	public List<SysRole> getAll(int pageNo, int pageSize) {
		List<SysRole> list = null;
		String sql = "select * from sys_role limit ?,?";
		Object[] params = new Object[] {(pageNo-1)*pageSize,pageSize};
		try {
			list = super.getForList(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int countAll() {
		int num=0;
		String sql = "select count(*) from sys_role";
		Object[] params = new Object[] {};
		try {
			Number number = super.getForValue(conn, sql, params);
			num = number.intValue();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}
	
}
