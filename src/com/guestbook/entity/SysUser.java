package com.guestbook.entity;

import java.io.Serializable;

/**
 * 
 * @author Administrator
 *
 * entity 或者说 Model 有2种
 * 1）DB Model :与数据库的字段一一对应
 * 2）View Model ：与界面的内容对应
 *
 *
 */

public class SysUser implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//DB model内容
	private int id;
	private String loginName;
	private String nickName;
	private String pwd;
	private String status;
	private int roleId;
	private String img;
	
	//view Model内容：页面需要什么就定义什么
	private String statusCn;
	private String roleName;
	
	
	
	public SysUser() {
		super();
	}

	public SysUser(String loginName, String nickName, String pwd, String status, int roleId, String img) {
		super();
		this.loginName = loginName;
		this.nickName = nickName;
		this.pwd = pwd;
		this.status = status;
		this.roleId = roleId;
		this.img = img;
	}

	public SysUser(int id, String loginName, String nickName, String pwd, String status, int roleId, String img) {
		super();
		this.id = id;
		this.loginName = loginName;
		this.nickName = nickName;
		this.pwd = pwd;
		this.status = status;
		this.roleId = roleId;
		this.img = img;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getStatusCn() {
		return statusCn;
	}

	public void setStatusCn(String statusCn) {
		this.statusCn = statusCn;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "SysUser [id=" + id + ", loginName=" + loginName + ", nickName=" + nickName + ", pwd=" + pwd
				+ ", status=" + status + ", roleId=" + roleId + ", img=" + img + "]";
	}
	
}
