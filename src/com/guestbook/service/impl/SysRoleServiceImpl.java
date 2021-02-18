package com.guestbook.service.impl;

import java.util.List;

import com.guestbook.dao.ISysRoleDao;
import com.guestbook.dao.impl.SysRoleDaoImpl;
import com.guestbook.entity.SysRole;
import com.guestbook.service.ISysRoleService;

public class SysRoleServiceImpl implements ISysRoleService {
	
	private ISysRoleDao roleDao = new SysRoleDaoImpl();

	@Override
	public List<SysRole> getAll() {
		return this.roleDao.getAll();
	}

	@Override
	public int add(String roleName, String description) {
		SysRole sysRole = new SysRole(roleName, description);
		return this.roleDao.insert(sysRole);
	}

	@Override
	public SysRole getSysRoleByRoleName(String roleName) {
		return this.roleDao.getSysRoleByRoleName(roleName);
	}

	@Override
	public int delete(String id) {
		return this.roleDao.del(Integer.valueOf(id));
	}

	@Override
	public SysRole get(String id) {
		return this.roleDao.get(Integer.valueOf(id));
	}

	@Override
	public int edit(String id, String roleName, String description) {
		SysRole role = new SysRole(Integer.valueOf(id), roleName, description);
		return this.roleDao.edit(role);
	}

	@Override
	public List<SysRole> getAll(int pageNo, int pageSize) {
		return this.roleDao.getAll(pageNo, pageSize);
	}

	@Override
	public int countAll() {
		return this.roleDao.countAll();
	}


}
