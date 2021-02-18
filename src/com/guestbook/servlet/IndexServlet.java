package com.guestbook.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.guestbook.entity.Message;
import com.guestbook.service.IMessageService;
import com.guestbook.service.impl.MessageServiceImpl;

@WebServlet("/index.do")
public class IndexServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private IMessageService messageService = new MessageServiceImpl();

	public IndexServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//处理乱码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");		
		
		List<Message> messageList = this.messageService.getAll();
		request.setAttribute("messageList", messageList);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
