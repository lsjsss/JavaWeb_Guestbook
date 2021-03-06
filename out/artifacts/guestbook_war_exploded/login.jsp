<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>网络留言本-登录</title>

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
    <%@ include file="pages/layout/head.jsp" %>
    <!-- 页面导航结束 -->
    
    <!-- 页面主体部分开始 -->
    <div class="row" style="width:100%">
    	<div class="col-md-4"></div>
	    <div class="bs-docs-section col-md-4"> 
	    	<form method="post" action="${ctx}/user.do?type=login">
			  <div class="form-group">
			    <label for="loginName">用户账号</label>
			    <input type="text" class="form-control" value="admin" name="loginName" id="loginName" placeholder="账号">
			  </div>
			  <div class="form-group">
			    <label for="password">密码</label>
			    <input type="password" class="form-control" value="123456" name="password" id="password" placeholder="密码">
			  </div>			  
			  <button type="submit" class="btn btn-default">登录</button>
			</form>	    	
		</div>
		<div class="col-md-4"></div>
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
    <%@ include file="pages/layout/foot.jsp" %>
    <!-- 页脚部分结束 -->

    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="${ctx}/bootstrap/js/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="${ctx}/bootstrap/js/bootstrap.min.js"></script>
    <script src="${ctx}/bootstrap/js/docs.min.js"></script>
  </body>
</html>















