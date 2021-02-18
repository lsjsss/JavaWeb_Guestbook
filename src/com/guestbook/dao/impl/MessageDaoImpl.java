package com.guestbook.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.guestbook.dao.IMessageDao;
import com.guestbook.entity.Message;
import com.guestbook.utils.DBTools;

public class MessageDaoImpl extends BaseDaoImpl<Message> implements IMessageDao {

	private Connection conn = DBTools.getConnection();

	@Override
	public List<Message> getAll() {
		List<Message> list = null;
		String sql = "select * from message";
		Object[] params = new Object[] {};
		try {
			list = super.getForList(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void add(int userId, String title, String content, Date createDate, String canComment) {
		int ret = -1;
		String sql = "insert into message(userId,title,content,createDate,canComment)values(?,?,?,?,?)";
		Object[] params = new Object[] {userId,title,content,createDate,canComment};
		try {
			super.update(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void edit(String id, String title, String content) {
		int ret = -1;
		String sql = "update message set title=?,content=? where id=?";
		Object[] params = new Object[] {title,content,id};
		try {
			super.update(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Message> getAllByTitle(String aaa) {
		List<Message> list = null;
		String sql = "select * from message where title like ?";
		Object[] params = new Object[] {"%"+aaa+"%"};
		try {
			list = super.getForList(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
