package com.guestbook.dao;

import java.util.Date;
import java.util.List;

import com.guestbook.entity.Message;

public interface IMessageDao {

	List<Message> getAll();

	void add(int userId, String title, String content, Date date, String canComment);

	void edit(String id, String title, String content);

	List<Message> getAllByTitle(String aaa);
	
}
