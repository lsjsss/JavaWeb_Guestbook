package com.guestbook.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.guestbook.entity.SysRole;
import com.guestbook.service.ISysRoleService;
import com.guestbook.service.impl.SysRoleServiceImpl;
import com.guestbook.utils.Pager;

@WebServlet("/role.do")
public class SysRoleServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private ISysRoleService roleService = new SysRoleServiceImpl();

	public SysRoleServlet() {
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
		String roleName = request.getParameter("roleName");
		String description = request.getParameter("description");
		int pageNo = Integer.valueOf(request.getParameter("pageNo"));
		int pageSize = Integer.valueOf(request.getParameter("pageSize"));
		
		if(type.equals("getAll")) {
			getAll(pageNo,pageSize,request, response);			
		}else if(type.equals("add")) {
			add(request, response, roleName, description);
		}else if(type.equals("delete")) {
			delete(request, response, id);
		}else if(type.equals("get")) {
			SysRole role = this.roleService.get(id);
			request.setAttribute("role", role);
			//跳转
			request.getRequestDispatcher("/pages/role/editrole.jsp").forward(request, response);
		}else {
			int ret = this.roleService.edit(id,roleName,description);
			if(ret == 1) {
				request.setAttribute("msg", "编辑成功！");
			}else {
				request.setAttribute("msg", "编辑失败！");
			}
			//跳转
			request.getRequestDispatcher("/pages/role/roleresult.jsp").forward(request, response);
		}
		
	}

	private void delete(HttpServletRequest request, HttpServletResponse response, String id)
			throws ServletException, IOException {
		int ret = this.roleService.delete(id);
		if(ret == 1) {
			request.setAttribute("msg", "删除成功！");
		}else {
			request.setAttribute("msg", "删除失败！");
		}
		//跳转
		request.getRequestDispatcher("/pages/role/roleresult.jsp").forward(request, response);
	}

	private void add(HttpServletRequest request, HttpServletResponse response, String roleName, String description)
			throws ServletException, IOException {
		//添加角色
		SysRole role = this.roleService.getSysRoleByRoleName(roleName);
		if(role == null) {
			int newId = this.roleService.add(roleName, description);
			if(newId>0) {
				request.setAttribute("msg", "添加成功！");
			}else {
				request.setAttribute("msg", "添加失败！");				
			}
		}else {
			request.setAttribute("msg", "添加失败，角色已经存在！");		
		}			
		//跳转
		request.getRequestDispatcher("/pages/role/roleresult.jsp").forward(request, response);
	}

	private void getAll(int pageNo, int pageSize,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取所有角色		
		List<SysRole> roleList = this.roleService.getAll(pageNo, pageSize);
		int totalRecords = this.roleService.countAll();
		int totalPage =(totalRecords - 1) / pageSize + 1;
		
		int a=pageNo;
		if(pageNo==totalPage) {
			a=totalPage;
		}
		if(pageNo<1) {
			a=1;
		}
		
		
		Pager pager = new Pager();
		pager.setPageNo(a);
		pager.setPageSize(pageSize);
		pager.setTotalRecords(totalRecords);
		pager.setTotalPage(totalPage);
		pager.setList(roleList);
		
		//List<SysRole> roleList = this.roleService.getAll();
		//将数据放到请求域中
		request.setAttribute("pager", pager);
		//跳转
		request.getRequestDispatcher("/pages/role/roles.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
