package com.guestbook.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.guestbook.constant.SysConstant;
import com.guestbook.entity.Message;
import com.guestbook.entity.SysRole;
import com.guestbook.entity.SysUser;
import com.guestbook.service.IMessageService;
import com.guestbook.service.ISysRoleService;
import com.guestbook.service.ISysUserService;
import com.guestbook.service.impl.MessageServiceImpl;
import com.guestbook.service.impl.SysRoleServiceImpl;
import com.guestbook.service.impl.SysUserServiceImpl;

@WebServlet("/user.do")
public class SysUserServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private ISysUserService userService = new SysUserServiceImpl();
	private ISysRoleService roleService = new SysRoleServiceImpl();
	private IMessageService messageService = new MessageServiceImpl();
	

	public SysUserServlet() {
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
		String loginName = request.getParameter("loginName");
		String nickName = request.getParameter("nickName");
		String status = request.getParameter("status");
		String roleId = request.getParameter("roleId");
		String password = request.getParameter("password");
				
		if(type.equals("login")) {
			login(request, response, session, loginName, password);
		}else if(type.equals("logout")) {
			logout(request, response, session);
		}else if(type.equals("getAll")) {
			getAll(request, response);			
		}else if(type.equals("add")) {
			add(request, response, loginName, nickName);
		}else if(type.equals("delete")) {
			delete(request, response, id);
		}else if(type.equals("get")) {
			get(request, response, id);
		}else if(type.equals("edit")){
			int ret = this.userService.edit(id,loginName,nickName,status,roleId);
			if(ret == 1) {
				request.setAttribute("msg", "编辑成功！");
			}else {
				request.setAttribute("msg", "编辑失败！");
			}
			//跳转
			request.getRequestDispatcher("/pages/user/userresult.jsp").forward(request, response);
		}
	}

	private void get(HttpServletRequest request, HttpServletResponse response, String id)
			throws ServletException, IOException {
		//获取待编辑纪录,并存放到请求域中
		SysUser sysUser = this.userService.get(id);
		request.setAttribute("user4Edit", sysUser);
		//获取所有角色信息
		List<SysRole> roleList = this.roleService.getAll();
		request.setAttribute("roleList", roleList);
		request.getRequestDispatcher("/pages/user/edituser.jsp").forward(request, response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response, String id)
			throws ServletException, IOException {
		int ret = this.userService.delete(id);
		if(ret == 1) {
			request.setAttribute("msg", "删除成功！");
		}else {
			request.setAttribute("msg", "删除失败！");
		}
		//跳转
		request.getRequestDispatcher("/pages/user/userresult.jsp").forward(request, response);
	}

	private void add(HttpServletRequest request, HttpServletResponse response, String loginName, String nickName)
			throws ServletException, IOException {
		boolean flag = this.userService.isExits(loginName);
		if (!flag) {
			int newId = this.userService.add(loginName, nickName, SysConstant.DEFAULT_PASSWORD,
					SysConstant.DEFAULT_STATUS, SysConstant.DEFAULT_ROLE_ID);
			if (newId > 0) {
				request.setAttribute("msg", "添加用户成功！");
			} else {
				request.setAttribute("msg", "添加用户失败！");
			} 
		}else {
			request.setAttribute("msg", "添加用户失败,存在同名用户！");
		}
		//跳转
		request.getRequestDispatcher("/pages/user/userresult.jsp").forward(request, response);
	}

	private void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<SysUser> userList = this.userService.getAll();
		request.setAttribute("userList", userList);
		request.getRequestDispatcher("/pages/user/users.jsp").forward(request, response);
	}

	private void logout(HttpServletRequest request,HttpServletResponse response, HttpSession session) throws IOException {
		session.removeAttribute("loginUser");
		session.invalidate();
		response.sendRedirect(request.getContextPath()+"/index.do");
	}

	private void login(HttpServletRequest request,HttpServletResponse response, HttpSession session, String loginName, String password)
			throws IOException, ServletException {
		//登录处理
		SysUser loginUser = this.userService.login(loginName, password);
		if(loginUser != null) {
			System.out.println(loginUser.getLoginName());
			session.setAttribute("loginUser", loginUser);
			
			List<Message> messageList = this.messageService.getAll();
			request.setAttribute("messageList", messageList);
			request.getRequestDispatcher("/index.jsp").forward(request, response);	
		}else {
			response.sendRedirect("login.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
