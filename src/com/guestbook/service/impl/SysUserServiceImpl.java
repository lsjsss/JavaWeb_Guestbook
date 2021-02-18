package com.guestbook.service.impl;

import java.util.List;

import com.guestbook.constant.SysConstant;
import com.guestbook.dao.ISysRoleDao;
import com.guestbook.dao.ISysUserDao;
import com.guestbook.dao.impl.SysRoleDaoImpl;
import com.guestbook.dao.impl.SysUserDaoImpl;
import com.guestbook.entity.SysRole;
import com.guestbook.entity.SysUser;
import com.guestbook.service.ISysUserService;

public class SysUserServiceImpl implements ISysUserService {
	
	private ISysUserDao userDao = new SysUserDaoImpl();
	
	private ISysRoleDao roleDao = new SysRoleDaoImpl();

	@Override
	public SysUser login(String loginName, String password) {
		return userDao.login(loginName, password);
	}

	@Override
	public List<SysUser> getAll() {
		List<SysUser> list = this.userDao.getAll();
		
		for(SysUser user : list) {
			String statusCn = user.getStatus().equals("0")? SysConstant.STATUS_NORMAL:SysConstant.STATUS_FORBIDDEN;
			user.setStatusCn(statusCn);
			SysRole sysRole = this.roleDao.get(user.getRoleId());
			if (sysRole != null) {
				user.setRoleName(sysRole.getRoleName());
			}else {
				user.setRoleName("");
			}
		}
		
		return list;
	}

	@Override
	public int add(String loginName, String nickName, String password, String status, int roleId) {
		return this.userDao.insert(loginName,nickName,password,status,roleId);
	}

	@Override
	public boolean isExits(String loginName) {
		return this.userDao.isExits(loginName);
	}

	@Override
	public int delete(String id) {
		return this.userDao.delete(Integer.valueOf(id));
	}

	@Override
	public SysUser get(String id) {
		return this.userDao.get(Integer.valueOf(id));	
	}

	@Override
	public int edit(String id, String loginName, String nickName, String status, String roleId) {
		return this.userDao.update(id,loginName,nickName,status,Integer.valueOf(roleId));
	}

}
