package com.guestbook.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.guestbook.entity.Message;
import com.guestbook.entity.SysUser;
import com.guestbook.service.IMessageService;
import com.guestbook.service.impl.MessageServiceImpl;

@WebServlet("/message.do")
public class MessageServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private IMessageService messageService = new MessageServiceImpl();

	public MessageServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//处理乱码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		HttpSession session = request.getSession();
		
		//获取参数
		String type = request.getParameter("type");
		String id = request.getParameter("id");
		String title =request.getParameter("title");
		String aaa =request.getParameter("aaa");
		String content = request.getParameter("content");
		
		if(type.equals("getAll")) {
			List<Message> messageList = this.messageService.getAll();
			request.setAttribute("messageList", messageList);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}else if(type.equals("add")){
			if (id == null || id.length()==0) {
				SysUser loginUser = (SysUser) session.getAttribute("loginUser");
				this.messageService.add(loginUser.getId(), title, content);
				request.setAttribute("msg", "留言成功！");
			}else {
				this.messageService.edit(id,title,content);
				request.setAttribute("msg", "修改留言成功！");				
			}
			request.getRequestDispatcher("/index.do").forward(request, response);
		}else if(type.equals("query")) {
			if(aaa != null && aaa.length()>0) {
				List<Message> messageList = this.messageService.getAllByTitle(aaa);
				request.setAttribute("messageList", messageList);
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
		}else {
			List<Message> messageList = this.messageService.getAll();
			request.setAttribute("messageList", messageList);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
