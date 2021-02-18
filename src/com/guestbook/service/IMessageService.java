package com.guestbook.service;

import java.util.List;

import com.guestbook.entity.Message;

public interface IMessageService {

	List<Message> getAll();

	void add(int userId, String title, String content);

	void edit(String id, String title, String content);

	List<Message> getAllByTitle(String aaa);

	
	

}
