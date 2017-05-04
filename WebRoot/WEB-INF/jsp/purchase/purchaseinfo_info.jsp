<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>采购物品查询</title>
    <jsp:include page="/common/header.jsp"></jsp:include>
    <link rel="stylesheet" href="${path }/css/childframe.css">
  </head>
  	
  <body>
  	<form id="list_info" action="" title="${path }/purchase/purchaseinfo_info.action" method="post" enctype="multipart/form-data">
  	  <div class="row">
  	  	<div class="col-xs-3">
  	  		<select name="facilitie.id" class="form-control">
  	  			<option value="${0 }">请选择</option>
  	  			<c:forEach var="item" items="${facilitieList }" >
  	  				<c:choose>
  	  					<c:when test="${item.id == facilitie.id }"><option value="${item.id }" selected="selected">${item.name}</option></c:when>
  	  					<c:otherwise><option value="${item.id }">${item.name}</option></c:otherwise>
  	  				</c:choose>
  	  			</c:forEach>
  	  		</select>
  	  	</div>
  	  	<div class="col-xs-2">
  	  		<a id="serach" href="info" title="" class="btn btn-default btn-block">搜&nbsp;索</a>
  	  	</div>
  	  </div>
    <table class="table table-striped table-hover ">
	  <thead>
	    <tr>
	      <th>列数</th>
	      <th>设施名称</th>
	      <th>单价</th>
	      <th>数量</th>
	      <th>总价</th>
	    </tr>
	  </thead>
	  <tbody>
	  	<c:forEach var="item" items="${pageResult.items }" varStatus="status">
		    <tr>
      		  <td>${(pageNo-1)*7+1+status.index }</td>
		      <td>${item.facilitieId.name }</td>
		      <td>${item.price }</td>
		      <td>${item.purchaseNum }</td>
		      <td>${item.total }</td>
		    </tr>
	    </c:forEach>
	  </tbody>
	</table>
	</form>
	<jsp:include page="/common/pageNavigator.jsp"></jsp:include>
	<script>
		$(function(){
			deleteAndEditInfo("purchaseInfo")
		});
	</script>
  </body>
</html>
