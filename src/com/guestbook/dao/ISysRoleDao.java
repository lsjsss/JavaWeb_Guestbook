package com.guestbook.dao;

import java.util.List;

import com.guestbook.entity.SysRole;

public interface ISysRoleDao {

	/**
	 * 用于新增记录，无返回值
	 * @param sysRole
	 * @return
	 */
	void add(SysRole sysRole);
	
	/**
	 * 删除记录，无返回值
	 * @param valueOf
	 * @return
	 */
	void delete(int id);
	
	void update(SysRole sysRole);
	
	SysRole get(int id);
	
	List<SysRole> getAll();

	/**
	 * 用于新增记录，返回新增记录的id值
	 * @param sysRole
	 * @return
	 */
	int insert(SysRole sysRole);

	/**
	 * 根据角色名称查询角色对象
	 * @param roleName
	 * @return
	 */
	SysRole getSysRoleByRoleName(String roleName);

	/**
	 * 删除记录，返回受影响的行数
	 * @param valueOf
	 * @return
	 */
	int del(Integer id);

	int edit(SysRole role);

	List<SysRole> getAll(int pageNo, int pageSize);

	int countAll();
}
