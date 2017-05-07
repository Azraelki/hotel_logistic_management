<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>设施维护查询</title>
    <jsp:include page="/common/header.jsp"></jsp:include>
    <link rel="stylesheet" href="${path }/css/childframe.css">
  </head>
  	
  <body>
  	<form id="list_info" action="" title="${path }/facilitie/facilitiefix_info.action" method="post" enctype="multipart/form-data">
  	  <div class="row">
  	  	<div class="col-xs-2">
  	  		<a id="deleteAll" href="deleteSelected" class="btn btn-default btn-block">删&nbsp;除</a>
  	  	</div>
  	  	<div class="col-xs-3">
  	  		<input name="facilitie.name" value="${facilitie.name }" class="form-control" type="text" id="serachContent" placeholder="请输入查询设施名称">
  	  	</div>
  	  	<div class="col-xs-3">
  	  		<select name="facilitieFix.status" class="form-control">
  	  			<option value="${0 }">请选择</option>
  	  			<c:choose>
  	  				<c:when test="${facilitieFix.status == 1 }"><option value="${1 }" selected="selected">未处理</option>></c:when>
  	  				<c:otherwise><option value="${1 }">未处理</option></c:otherwise>
  	  			</c:choose>
  	  			<c:choose>
  	  				<c:when test="${facilitieFix.status == 2 }"><option value="${2 }"  selected="selected">正在处理</option>></c:when>
  	  				<c:otherwise><option value="${2 }">正在处理</option></c:otherwise>
  	  			</c:choose>
  	  			<c:choose>
  	  				<c:when test="${facilitieFix.status == 3 }"><option value="${3 }"  selected="selected">已处理</option>></c:when>
  	  				<c:otherwise><option value="${3 }">已处理</option></c:otherwise>
  	  			</c:choose>
  	  		</select>
  	  	</div>
  	  	<div class="col-xs-2">
  	  		<a id="serach"  href="info" class="btn btn-default btn-block">搜&nbsp;索</a>
  	  	</div>
  	  </div>
    <table class="table table-striped table-hover ">
	  <thead>
	    <tr>
	      <th><input id="checkbox" type="checkbox"></th>
	      <th>列数</th>
	      <th>设施名称</th>
	      <th>状态</th>
	      <th>报修日期</th>
	      <th>修复日期</th>
	      <th>修理人员</th>
	      <th>操作</th>
	    </tr>
	  </thead>
	  <tbody>
	  	<c:forEach var="item" items="${pageResult.items }" varStatus="status">
		    <tr>
		      <td><input name="selectedRow" type="checkbox" value="${item.id }"></td>
      		  <td>${(pageNo-1)*7+1+status.index }</td>
		      <td>${item.facilitieId.name }</td>
		      <td>
		      	<c:choose>
		      		<c:when test="${item.status == 1 }">未处理 </c:when>
		      		<c:when test="${item.status == 2 }">正在处理.. </c:when>
		      		<c:when test="${item.status == 3 }">已处理 </c:when>
		      	</c:choose>
		      </td>
		      <td><span title="date">
		      <input type="hidden" value="${item.dateBegin }">
		      </span></td>
		      <td><span title="date">
		      <input type="hidden" value="${item.dateEnd }">
		      </span></td>
		      <td>${item.employeeId.name }</td>
		      <td>
		      	<a href="editUI" title="${item.id }" class="btn btn-default" style="padding-top: 1px;padding-bottom: 1px;">详情</a>
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
			deleteAndEditInfo("facilitieFix");
			spanDateTransplate();
		});
	</script>
  </body>
</html>
