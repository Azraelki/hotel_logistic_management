<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>布草库存查询</title>
    <jsp:include page="/common/header.jsp"></jsp:include>
    <link rel="stylesheet" href="${path }/css/childframe.css">
  </head>
  	
  <body>
  	<form id="list_info" action="" title="${path }/linen/linen_fInfo.action" method="post" enctype="multipart/form-data">
  	  <div class="row">
  	  	<div class="col-xs-3">
  	  		<input name="facilitie.name" value="${facilitie.name }" class="form-control" type="text" id="serachContent" placeholder="请输入查询布草名称">
  	  	</div>
  	  	<div class="col-xs-2">
  	  		<a id="serach" href="fInfo" class="btn btn-default btn-block">搜&nbsp;索</a>
  	  	</div>
  	  </div>
    <table class="table table-striped table-hover ">
	  <thead>
	    <tr>
	      <th>列数</th>
	      <th>布草名称</th>
	      <th>正常数量</th>
	      <th>损坏数量</th>
	      <th>总数</th>
	    </tr>
	  </thead>
	  <tbody>
	  	<c:forEach var="item" items="${pageResult.items }" varStatus="status">
		    <tr>
      		  <td>${(pageNo-1)*7+1+status.index }</td>
		      <td>${item.name }</td>
		      <td>${item.normalNum }</td>
		      <td>${item.badNum }</td>
		      <td>${item.normalNum+item.badNum }</td>
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
			deleteAndEditInfo("facilitie");
		});
	</script>
  </body>
</html>
