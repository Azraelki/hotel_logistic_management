<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>菜品信息</title>
    <jsp:include page="/common/header.jsp"></jsp:include>
    <link rel="stylesheet" href="${path }/css/childframe.css">
  </head>
  	
  <body>
  	<form id="list_info" action="" title="${path }/food/food_info.action" method="post" enctype="multipart/form-data">
  	  <div class="row">
  	  	<div class="col-xs-2">
  	  		<a id="deleteAll" href="deleteSelected" class="btn btn-default btn-block">删&nbsp;除</a>
  	  	</div>
  	  	<div class="col-xs-3">
  	  		<input name="food.name" value="${food.name }" class="form-control" type="text" id="serachContent" placeholder="请输入查询菜品的名称">
  	  	</div>
  	  	<div class="col-xs-3">
  	  		<select name="food.type" class="form-control">
  	  			<option value="${0 }">请选择类型</option>
  	  			<c:forEach var="foodType" items="${foodTypeList }">
  	  				<c:choose>
	  	  				<c:when test="${food.type == foodType.code }"><option value="${foodType.code }" selected="selected">${foodType.name}</option></c:when>
	  	  				<c:otherwise><option value="${foodType.code }">${foodType.name}</option></c:otherwise>
  	  				</c:choose>
  	  			</c:forEach>
  	  		</select>
  	  	</div>
  	  	<div class="col-xs-2">
  	  		<a id="serach" href="info" class="btn btn-default btn-block">搜&nbsp;索</a>
  	  	</div>
  	  </div>
    <table class="table table-striped table-hover ">
	  <thead>
	    <tr>
	      <th><input id="checkbox" type="checkbox"></th>
	      <th>名称</th>
	      <th>类型</th>
	      <th>菜系</th>
	      <th>状态</th>
	      <th>价格</th>
	      <th>操作</th>
	    </tr>
	  </thead>
	  <tbody>
	  	<c:forEach var="item" items="${pageResult.items }" varStatus="status">
		    <tr>
      		  <td><input name="selectedRow" type="checkbox" value="${item.id }"></td>
		      <td>${item.name }</td>
		      <td>
		      	<c:forEach var="foodType" items="${foodTypeList }">
		      		<c:choose>
		      		<c:when test="${item.type == foodType.code }">
		      		${foodType.name }
		      		</c:when>
		      	</c:choose>
		      	</c:forEach>
		      </td>
		      <td>${item.style }</td>
		      <td>
		      	<c:choose>
		      		<c:when test="${item.status }">
		      			可用
		      		</c:when>
		      		<c:otherwise>不可用</c:otherwise>
		      	</c:choose>
		      </td>
		      <td>${item.price }</td>
		      <td>
		      	<a href="editUI" title="${item.id }" class="btn btn-default" style="padding-top: 1px;padding-bottom: 1px;">编辑</a>
		      	<a href="delete" title="${item.id }" class="btn btn-default" style="padding-top: 1px;padding-bottom: 1px;">删除</a>
		      </td>
		    </tr>
	    </c:forEach>
	  </tbody>
	</table>
	</form>
	<jsp:include page="/common/pageNavigator.jsp"></jsp:include>
	<div id="deleteDialog" class="modal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title" id="dialogTitle">
						操作提示
					</h4>
				</div>
				<div class="modal-body">
					你希望执行删除操作吗？
				</div>
				<div class="modal-footer">
					<button name="confirm" type="button" class="btn btn-default">取消
					</button>
					<button id="confirm" name="confirm" type="button" class="btn btn-primary">
						确认删除
					</button>
				</div>
			</div><!-- /.modal-content -->
		</div><!-- /.modal -->
</div>
	<script>
		$(function(){
			allCheck();
			deleteAndEditInfo("food");
		});
	</script>
  </body>
</html>
