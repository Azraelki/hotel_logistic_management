<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
  <head>
  	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>酒店后勤管理系统</title>
    <jsp:include page="${basePath }common/header.jsp"></jsp:include>
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
      	  	<li><a id="a" href="#">用户管理</a></li>
      	  	<li><a href="#">布草管理</a></li>
      	  	<li><a href="#">采购管理</a></li>
      	  	<li><a href="#">餐饮管理</a></li>
      	  	<li><a href="#">设施管理</a></li>
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
    <div class="container">
	  <iframe id="content" scrolling="no" src="${basePath }test_user.jsp" frameborder="0"></iframe>
    </div>
    <!-- /content -->
  </body>
</html>
