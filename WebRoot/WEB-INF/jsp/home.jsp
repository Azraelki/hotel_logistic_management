<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    application.setAttribute("basePath",basePath);
    application.setAttribute("path", path);
%>
<!DOCTYPE html>
<html style="overflow-y: hidden;">
  <head>
  	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>酒店后勤管理系统</title>
    <jsp:include page="/common/header.jsp"></jsp:include>
    <link rel="stylesheet" href="${path }/css/home.css">
    <script>
    	$(function(){
    		createContent();
    	});
    </script>
  </head>
  
  <body style="padding:10px">
    <!-- nav-top -->
    <div id="head" class="navbar navbar-default">
      <div class="container">
      	<div class="navbar-header">
      	  <a href="#" class="navbar-brand"><span class="glyphicon glyphicon-home"></span>&nbsp;后勤管理系统</a>
      	  <button class="navbar-toggle" type="button" data-toggle="collapse" data-target="#navbar-main">
      	    <span class="icon-bar"></span>
      	    <span class="icon-bar"></span>
      	    <span class="icon-bar"></span>
      	  </button>
      	</div>
      	<div class="navbar-collapse collapse" id="navbar-main">
      	  <ul class="nav navbar-nav">
      	  	<li class="active"><a title="content" href="${path }/user/employee.action">用户管理</a></li>
      	  	<li><a title="content" href="${path }/linen/linen.action">布草管理</a></li>
      	  	<li><a title="content" href="${path }/purchase/purchaseorder.action">采购管理</a></li>
      	  	<li><a title="content" href="${path }/food/food.action">餐饮管理</a></li>
      	  	<li><a title="content" href="#">设施管理</a></li>
      	  </ul>
      	  <ul class="nav navbar-nav navbar-right">
		    <li class="dropdown">
		      <a href="#" class="dropdown-toggle" data-toggle="dropdown">
		      <span class="glyphicon glyphicon-user">&nbsp;</span>admin<span class="caret"></span>
		      </a>
		      <ul class="dropdown-menu" >
		        <li><a href="#">个人中心</a></li>
		        <li class="divider"></li>
		        <li><a href="#">登出</a></li>
		      </ul>
		    </li>
		  </ul>
      	</div>
      </div>
    </div>
    <!-- /nav-top -->
    <!-- content -->
    <div id="contentDiv" class="container">
	  <iframe id="content" scrolling="no" src="${path }/user/employee.action" frameborder="0"></iframe>
    </div>
    <!-- /content -->
  </body>
</html>