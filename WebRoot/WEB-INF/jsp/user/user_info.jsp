<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
  <head>
    <title>用户信息</title>
    <jsp:include page="/common/header.jsp"></jsp:include>
    <link rel="stylesheet" href="${path }/css/childframe.css">
  </head>
  	
  <body>
  	<div class="form-group">
	  <input class="form-control input-sm" type="text" id="inputSmall">
	</div>
    <table id="list_info" class="table table-striped table-hover " title="${path }/user/employee_info.action">
	  <thead>
	    <tr>
	      <th><input id="checkbox" type="checkbox"></th>
	      <th>姓名</th>
	      <th>性别</th>
	      <th>年龄</th>
	      <th>职务</th>
	      <th>电话</th>
	      <th>任职日期</th>
	      <th>操作</th>
	    </tr>
	  </thead>
	  <tbody>
	  	<c:forEach var="employee" items="${pageResult.items }" varStatus="status">
		    <tr>
		      <td><input name="selectedRow" type="checkbox" value="${employee.id }"></td>
		      <td>${employee.name }</td>
		      <td>${employee.gender }</td>
		      <td>${employee.age }</td>
		      <td>${employee.jobId.name }</td>
		      <td>${employee.phoneNumber }</td>
		      <td>${employee.arrivedAt }</td>
		      <td>
		      	<a class="btn btn-default" style="padding-top: 1px;padding-bottom: 1px;">编辑</a>
		      	<a class="btn btn-default" style="padding-top: 1px;padding-bottom: 1px;">删除</a>
		      </td>
		    </tr>
	    </c:forEach>
	  </tbody>
	</table>
	<jsp:include page="/common/pageNavigator.jsp"></jsp:include>
	<script>
		$(function(){
			allCheck();
		});
	</script>
  </body>
</html>
