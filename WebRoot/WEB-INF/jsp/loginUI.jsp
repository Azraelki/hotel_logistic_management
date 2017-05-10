<%@page import="cn.azrael.main.core.constant.Constant"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("ctx", path);
%>
<!DOCTYPE HTML>
<html>
  <head>
  	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>登陆界面</title>
    <jsp:include page="/common/header.jsp"></jsp:include>
    <script src="${basePath }js/md5.js"></script>
    <link rel="stylesheet" href="${ctx }/css/login.css">
  </head>
  
  <body>
    <div class="container" style="margin-top: 5%;">
	    <div class="row">
	        <div class="col-md-offset-3 col-md-6">
	            <form action="${pageContext.request.contextPath }/sys/login_login.action" method="post" id="login" class="form-horizontal">
	                <span class="heading">后勤管理系统</span>
	                <span id="validate" class="text-danger">
	                <c:if test="${loginResult != null }">${loginResult }</c:if>
	                </span>
	                <div class="form-group">
	                    <input id="account" type="text" class="form-control" name="user.employeeId.phoneNumber" value="${user.employeeId.phoneNumber }" placeholder="请输入用户名">
	                </div>
	                <div class="form-group help">
	                    <input id="password" type="password" class="form-control" name="user.password" placeholder="密　码">
	                </div>
	                <div class="form-group">
	                    <div class="main-checkbox">
	                        <input type="checkbox" value="remember" id="remember" name="rememberMe"/>
	                        <label for="remember"></label>
	                    </div>
	                    <span class="text">Remember me</span>
	                    <button id="submit" type="submit" class="btn btn-default">登录</button>
	                </div>
	            </form>
	        </div>
	    </div>
	</div>
	<script>
		$(function(){
			if(window!=top){
				top.location.href = location.href;
			}
			$("#login").submit(function(){
				var flag = validate($("#account"),textNotNull,$("#validate"),"账号或密码不能为空") && validate($("#password"),textNotNull,$("#validate"),"账号或密码不能为空");
				if(flag){
					$("#password").val($.md5($("#password").val()));
				}
				return flag;
			});
		});
	</script>
  </body>
</html>
