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
    <title>网络留言本-用户编辑</title>

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
	    	<form method="post" action="${ctx}/user.do?type=edit">
	    	  <input type="hidden" name="id" id="id" value="${user4Edit.id}">
			  <div class="form-group">
			    <label for="loginName">账号</label>
			    <input type="text" class="form-control" readonly="readonly" name="loginName" id="loginName" value="${user4Edit.loginName}" placeholder="">
			  </div>
			  <div class="form-group">
			    <label for="nickName">昵称</label>
			    <input type="text" class="form-control" name="nickName" id="nickName" value="${user4Edit.nickName }" placeholder="">
			  </div>
			  <div class="form-group">
			    <label for="status">状态</label>
			    <div class="radio">
			      <%-- <c:set var="bbb" value="${user4Edit.status eq '0'?'checked':''}"></c:set>
			      <c:set var="ccc" value="${user4Edit.status eq '1'?'checked':''}"></c:set> --%>
				  <label>
				    <input type="radio" name="status" value="0" ${user4Edit.status eq '0'?'checked':''}>
				    正常
				  </label>
				</div>
				<div class="radio">
				  <label>
				    <input type="radio" name="status" value="1" ${user4Edit.status eq '1'?'checked':''}>
				    禁言				  
				</div>
			  </div>
			  <div class="form-group">
			    <label for="roleId">角色</label>
			    <select class="form-control" name="roleId">
				  <c:forEach items="${roleList}" var="obj">
				  	<c:set var="aaa" value="${obj.id eq user4Edit.roleId?'selected':''}"></c:set>
				  	<option ${aaa} value="${obj.id}">${obj.roleName}</option>	
				  </c:forEach>			  
				</select>
			  </div>
			
			  <button type="submit" class="btn btn-default">修改</button>
			</form>	    	
		</div>
		<div class="col-md-2"></div>
	</div>	
    <!-- 页面主体部分结束 -->
    
    <!-- 页脚部分开始 -->
    <%@ include file="/pages/layout/foot.jsp" %>
    <!-- 页脚部分结束 -->

    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="${ctx}/bootstrap/js/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="${ctx}/bootstrap/js/bootstrap.min.js"></script>
    <script src="${ctx}/bootstrap/js/docs.min.js"></script>
  </body>
</html>















