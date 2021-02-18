package com.guestbook.service.impl;

import java.util.Date;
import java.util.List;

import com.guestbook.constant.SysConstant;
import com.guestbook.dao.IMessageDao;
import com.guestbook.dao.ISysUserDao;
import com.guestbook.dao.impl.MessageDaoImpl;
import com.guestbook.dao.impl.SysUserDaoImpl;
import com.guestbook.entity.Message;
import com.guestbook.entity.SysUser;
import com.guestbook.service.IMessageService;

public class MessageServiceImpl implements IMessageService {
	
	private IMessageDao messageDao = new MessageDaoImpl();
	private ISysUserDao userDao = new SysUserDaoImpl();

	@Override
	public List<Message> getAll() {
		List<Message> list = this.messageDao.getAll();
		//添加nickName信息
		for(Message message : list) {
			SysUser sysUser = this.userDao.get(message.getUserId());
			if(sysUser != null) {
				message.setNickName(sysUser.getNickName());
			}else {
				message.setNickName("");
			}			
		}
		return list;
	}

	@Override
	public void add(int userId, String title, String content) {
		this.messageDao.add(userId,title,content,new Date(), SysConstant.STATUS_NORMAL);
	}

	@Override
	public void edit(String id, String title, String content) {
		this.messageDao.edit(id,title,content);
	}

	@Override
	public List<Message> getAllByTitle(String aaa) {
		List<Message> list = this.messageDao.getAllByTitle(aaa);
		//添加nickName信息
		for(Message message : list) {
			SysUser sysUser = this.userDao.get(message.getUserId());
			if(sysUser != null) {
				message.setNickName(sysUser.getNickName());
			}else {
				message.setNickName("");
			}			
		}
		return list;
	}

	


}
