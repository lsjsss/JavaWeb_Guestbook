<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>网络留言本</title>
    <!-- Bootstrap -->
    <link href="${ctx}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${ctx}/bootstrap/css/docs.min.css" rel="stylesheet">

    <!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
    <!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
    <!--[if lt IE 9]>
      <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
      <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>    
    <!-- 页面导航开始 -->
    <%@ include file="/pages/layout/head.jsp" %>
    <!-- 页面导航结束 -->
    
    <!-- 页面主体部分开始 -->
    <div class="row" style="width:100%">
    	<div class="col-md-2"></div>
	    <div class="bs-docs-section col-md-8"> 
	    	<h3 style="text-align:center;">留言列表</h3>
		    <table class="table table-striped table-hover">
		      <thead>
		        <tr>
		          <th>编号</th>
		          <th>标题</th>		          
		          <th>日期</th>
		          <th>作者</th>
		          <th>操作</th>
		        </tr>
		      </thead>
		      <tbody>
		      	<c:forEach items="${messageList}" var="obj">
		      		<tr>
			          <th scope="row">${obj.id}</th>
			          <td>
			          	<a href="${ctx}/message.do?type=get&id=${obj.id}">${obj.title}</a>			          
			          </td>			          
			          <td>
			          	<fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss" value="${obj.createDate}"/>
			          </td>
			          <td>${obj.nickName}</td>
			          <td>			    
			         	 <c:if test="${obj.userId eq loginUser.id}">
			         	 	<a href="#" onclick="getInfo(${obj.id},'${obj.title}','${obj.content}');">编辑</a> 
			         	 </c:if>
			         	 <c:if test="${loginUser.roleId eq 1 || obj.userId eq loginUser.id}">
			         	 	<a href="${ctx}/message.do?type=delete&id=${obj.id}">删除</a>
			         	 </c:if>			         	
			          </td>
			        </tr>		
		      	</c:forEach>		                
		      </tbody>		      
		    </table>
		    <div style="margin-top:50px;">
		    	<!-- 
		    		提交动作先执行，还是onclick事件（检查动作）先执行
		    	 -->
		    	<form method="post" action="${ctx}/message.do?type=add">
		    		<input type="hidden" id="id" name="id" />
			    	<div class="form-group">
					   <label for="title">标题</label>
					   <input type="text" class="form-control"  name="title" id="title"/>
					</div>
					<div class="form-group">
					   <label for="content">内容</label>
					   <textarea name="content" id="content" class="form-control" rows="5"></textarea>
					</div>
				    <button type="submit" class="btn btn-info" onclick="return loginCheck();">我要留言</button>
				    ${msg}			
			    </form>
		    </div>
		</div>
		<div class="col-md-2"></div>
	</div>
	<nav aria-label="Page navigation" style="text-align:center;">
	  <ul class="pagination">
	    <li>
	      <a href="#" aria-label="Previous">
	        <span aria-hidden="true">&laquo;</span>
	      </a>
	    </li>
	    <li><a href="#">1</a></li>
	    <li><a href="#">2</a></li>
	    <li><a href="#">3</a></li>
	    <li><a href="#">4</a></li>
	    <li><a href="#">5</a></li>
	    <li>
	      <a href="#" aria-label="Next">
	        <span aria-hidden="true">&raquo;</span>
	      </a>
	    </li>
	  </ul>
	</nav>
    <!-- 页面主体部分结束 -->
    
    <!-- 页脚部分开始 -->
    <%@ include file="/pages/layout/foot.jsp" %>
    <!-- 页脚部分结束 -->

    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="${ctx}/bootstrap/js/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="${ctx}/bootstrap/js/bootstrap.min.js"></script>
    <script src="${ctx}/bootstrap/js/docs.min.js"></script>    
    <script type="text/javascript">
    	function loginCheck(){
    		//var title = document.getElementById('title').value;
    		
    		var name = $('#loginedUser').text();
    		if(name==null || name=="" || name.length==0){
    			alert("只有登录用户才能留言，请先登录或注册！");  
    			return false;
    		}
    		
    		var title = $('#title').val();
    		var content = $('#content').val();
    		if(title.length>=4 && content.length>=8){
    			return true;
    		}else{
    			alert("标题长度至少为4，内容长度至少为8，请修改！");
    			return false;
    		}
    	}
    	function getInfo(id,title,content){
    		$('#id').val(id);
    		$('#title').val(title);
    		$('#content').val(content);
    	}
    </script>
  </body>
</html>















