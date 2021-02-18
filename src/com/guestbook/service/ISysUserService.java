package com.guestbook.service;

import java.util.List;

import com.guestbook.entity.SysUser;

public interface ISysUserService {

	SysUser login(String loginName, String password);

	List<SysUser> getAll();

	int add(String loginName, String nickName, String password, String status, int roleId);

	boolean isExits(String loginName);

	int delete(String id);

	SysUser get(String id);

	int edit(String id, String loginName, String nickName, String status, String roleId);

}
