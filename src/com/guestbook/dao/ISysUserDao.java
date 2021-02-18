package com.guestbook.dao;

import java.util.List;

import com.guestbook.entity.SysUser;

public interface ISysUserDao {

	SysUser login(String loginName, String password);

	List<SysUser> getAll();

	int insert(String loginName, String nickName, String password, String status, int roleId);

	boolean isExits(String loginName);

	int delete(Integer id);

	SysUser get(Integer valueOf);

	int update(String id, String loginName, String nickName, String status, Integer valueOf);
	
}
