<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
  <head>
  	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>登陆界面</title>
    <link rel="stylesheet" href="${basePath }css/login.css">
    <jsp:include page="/common/header.jsp"></jsp:include>
  </head>
  
  <body>
    <div class="container" style="margin-top: 5%;">
	    <div class="row">
	        <div class="col-md-offset-3 col-md-6">
	            <form action="${pageContext.request.contextPath }/login.action" method="post" id="login" class="form-horizontal">
	                <span class="heading">后勤管理系统</span>
	                <c:if test="${message != null }">
	                	<span>${message }</span>
	                </c:if>
	                <div class="form-group">
	                    <input type="text" class="form-control" name="username" placeholder="请输入用户名">
	                </div>
	                <div class="form-group help">
	                    <input type="password" class="form-control" name="password" placeholder="密　码">
	                </div>
	                <div class="form-group">
	                    <div class="main-checkbox">
	                        <input type="checkbox" value="None" id="remember" name="check"/>
	                        <label for="remember"></label>
	                    </div>
	                    <span class="text">Remember me</span>
	                    <button type="submit" class="btn btn-default">登录</button>
	                </div>
	            </form>
	        </div>
	    </div>
	</div>
  </body>
</html>
