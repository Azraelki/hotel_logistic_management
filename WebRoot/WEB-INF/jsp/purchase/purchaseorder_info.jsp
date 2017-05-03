<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>采购信息</title>
    <jsp:include page="/common/header.jsp"></jsp:include>
    <link rel="stylesheet" href="${path }/css/childframe.css">
  </head>
  	
  <body>
  	<form id="list_info" action="" title="${path }/purchase/purchaseorder_info.action" method="post" enctype="multipart/form-data">
  	  <div class="row">
  	  	<div class="col-xs-2">
  	  		<a id="deleteAll" href="deleteSelected" class="btn btn-default btn-block">删&nbsp;除</a>
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
	      <th>负责人</th>
	      <th>状态</th>
	      <th>日期</th>
	      <th>操作</th>
	    </tr>
	  </thead>
	  <tbody>
	  	<c:forEach var="item" items="${pageResult.items }" varStatus="status">
		    <tr>
      		  <td><input name="selectedRow" type="checkbox" value="${item.id }"></td>
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
		      	<a href="detail" title="${item.id }" class="btn btn-default" style="padding-top: 1px;padding-bottom: 1px;">详情</a>
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
			deleteAndEditInfo("purchaseOrder");
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
