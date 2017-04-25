<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>work_info</title>
    <jsp:include page="/common/header.jsp"></jsp:include>
    <link rel="stylesheet" href="${path }/css/childframe.css">
  </head>
  	
  <body>
  	<form id="list_info" action="" title="${path }/user/work_info.action" method="post" enctype="multipart/form-data">
  	  <div class="row">
  	  	<div class="col-xs-2">
  	  		<a id="deleteAll" href="deleteSelected" class="btn btn-default btn-block">删&nbsp;除</a>
  	  	</div>
  	  	<div class="col-xs-3">
  	  		<input name="employee.name" value="${employee.name }" class="form-control" type="text" id="serachContent" placeholder="请输入查询员工的姓名">
  	  	</div>
  	  	<div class="col-xs-5">
  	  		<div class="row">
  	  			<div class="col-xs-6">
  	  				<input  class="form-control" type="date" id="begin" name="temDate">
  	  				<input class="form-control" type="hidden" value="${beginDate }" name="beginDate" id="beginDate">
  	  			</div>
  	  			<div class="col-xs-6">
  	  				<input  class="form-control" type="date" id="end" name="temDate">
  	  				<input class="form-control" type="hidden" value="${endDate }" name="endDate" id="endDate">
  	  			</div>
  	  		</div>
  	  	</div>
  	  	<div class="col-xs-2">
  	  		<a id="serach" href="info" class="btn btn-default btn-block">搜&nbsp;索</a>
  	  	</div>
  	  </div>
    <table class="table table-striped table-hover ">
	  <thead>
	    <tr>
	      <th><input id="checkbox" type="checkbox"></th>
	      <th>姓名</th>
	      <th>退房打扫</th>
	      <th>续房打扫</th>
	      <th>日期</th>
	      <th>操作</th>
	    </tr>
	  </thead>
	  <tbody>
	  	<c:forEach var="item" items="${pageResult.items }" varStatus="status">
		    <tr>
      		  <td><input name="selectedRow" type="checkbox" value="${item.id }"></td>
		      <td>${item.employeeId.name }</td>
		      <td>${item.leaveNum }</td>
		      <td>${item.cleanNum }</td>
		      <td><span title="date">
		      <input type="hidden" value="${item.date }">
		      </span></td>
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
			deleteAndEditInfo("employeeWork");
			spanDateTransplate();
			changeTogether("begin", "beginDate");
			changeTogether("end", "endDate");
			if($("#beginDate").val()>0){
				$("#begin").val(translateRealToDate($("#beginDate").val()));
			}
			if($("#endDate").val()>0)
				$("#end").val(translateRealToDate($("#endDate").val()));
		});
	</script>
  </body>
</html>
