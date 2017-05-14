<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>roleInfo</title>
    <jsp:include page="/common/header.jsp"></jsp:include>
    <link rel="stylesheet" href="${path }/css/childframe.css">
  </head>
  	
  <body>
  	<form id="list_info" action="" title="${path }/system/system_roleInfo.action" method="post" enctype="multipart/form-data">
    <table class="table table-striped table-hover ">
	  <thead>
	    <tr>
	      <th>职务</th>
	      <th>权限范围</th>
	      <th>操作</th>
	    </tr>
	  </thead>
	  <tbody>
	  	<c:forEach var="item" items="${pageResult.items }" varStatus="status">
		    <tr>
		      <td>${item.name }</td>
		      <td>
		      	<c:forEach var="role" items="${roleList }">
		      		<c:choose>
			      		<c:when test="${role.type == item.id }">${roleMap[role.privilege]}&nbsp;</c:when>
			      	</c:choose>
		      	</c:forEach>
		      </td>
		      <td>
		      	<a href="roleEditUI" title="${item.id }" class="btn btn-default" style="padding-top: 1px;padding-bottom: 1px;">编辑</a>
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
			deleteAndEditInfo("job");
		});
	</script>
  </body>
</html>
