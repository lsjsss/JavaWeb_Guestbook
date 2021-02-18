package com.guestbook.service;

import java.util.List;

import com.guestbook.entity.SysRole;

public interface ISysRoleService {

	List<SysRole> getAll();
	
	List<SysRole> getAll(int pageNo, int pageSize);

	int add(String roleName, String description);

	SysRole getSysRoleByRoleName(String roleName);

	int delete(String id);

	SysRole get(String id);

	int edit(String id, String roleName, String description);

	int countAll();

	

}
