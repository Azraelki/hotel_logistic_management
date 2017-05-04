<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>采购状态处理</title>
    <jsp:include page="/common/header.jsp"></jsp:include>
    <link rel="stylesheet" href="${path }/css/childframe.css">
  </head>
  	
  <body>
  	<form id="list_info" action="" title="${path }/purchase/purchaseorder_info.action" method="post" enctype="multipart/form-data">
    <table class="table table-striped table-hover ">
	  <thead>
	    <tr>
	      <th>负责人</th>
	      <th>状态</th>
	      <th>提交日期</th>
	      <th>操作</th>
	    </tr>
	  </thead>
	  <tbody>
	  	<c:forEach var="item" items="${pageResult.items }" varStatus="status">
		    <tr>
		      <td>${item.employeeId.name }</td>
		       <td>
		       		<c:choose>
			       		<c:when test="${item.status == 1 }">已处理</c:when>
			       		<c:otherwise>未处理</c:otherwise>
			       	</c:choose>
		       </td>
		      <td><span title="date">
		      <input type="hidden" value="${item.date }">
		      </span></td>
		      <td>
		      	<a href="editUI" title="${item.id }" class="btn btn-default" style="padding-top: 1px;padding-bottom: 1px;">编辑</a>
		      </td>
		    </tr>
	    </c:forEach>
	  </tbody>
	</table>
	</form>
	<jsp:include page="/common/pageNavigator.jsp"></jsp:include>
	<script>
		$(function(){
			deleteAndEditInfo("purchaseOrder");
			spanDateTransplate();
		});
	</script>
  </body>
</html>
