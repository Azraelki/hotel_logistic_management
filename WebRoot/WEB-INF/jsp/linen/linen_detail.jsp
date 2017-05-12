<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>布草洗涤详情</title>
    <jsp:include page="/common/header.jsp"></jsp:include>
    <link rel="stylesheet" href="${path }/css/childframe.css">
  </head>
  	
  <body>
  	<form id="list_info" class="form-horizontal" action="" title="${path }/linen/linensinfo_info.action" method="post" enctype="multipart/form-data">
  	  <div class="row">
  	  	<div class="col-xs-12">
  	  		<div class="row from-group">
  	  			<input type="hidden" id="pageNo" name="pageNo" value="${pageNo }">
  				<input type="hidden" id="lId" name="linen.id" value="${linen.id }">
  				<input type="hidden" id="eId" name="linen.employeeId.id" value="${linen.employeeId.id }">
  				<label for="eName" class="control-label col-xs-1">负责人</label>
  				<div class="col-xs-3">
  					<input class="form-control" type="text" id="eName" name="linen.employeeId.name" value="${linen.employeeId.name }" readonly="readonly">
  				</div>
  				<label for="date" class="control-label col-xs-1">日&nbsp;期</label>
  	  			<div class="col-xs-3">
  	  				<input  class="form-control" type="date" id="date" name="temDate" readonly="readonly">
  	  				<input class="form-control" type="hidden" value="${linen.date }" name="linen.date" id="lDate">
  	  			</div>
  	  			<div class="col-xs-2">
  	  				<button id="export" class="btn btn-default">导出洗涤单</button>
  	  			</div>
  	  			<div class="col-xs-2">
  	  				<button id="back" class="btn btn-default">返回</button>
  	  			</div>
  	  		</div>
  	  	</div>
  	  </div>
    <table class="table table-striped table-hover ">
	  <thead>
	    <tr>
	      <th>列数</th>
	      <th>布草名称</th>
	      <th>收回数量</th>
	      <th>送出数量</th>
	      <th>回洗数量</th>
	      <th>欠收数量</th>
	      <th>操作</th>
	    </tr>
	  </thead>
	  <tbody>
	  	<c:forEach var="item" items="${linen.linensInfos }" varStatus="status">
		    <tr>
      		  <td>${status.index+1 }</td>
		      <td>${item.facilitieId.name }</td>
		      <td>${item.recNum }</td>
		      <td>${item.senNum }</td>
		      <td>${item.backWashNum }</td>
		      <td>${item.oweNum }</td>
		      <td>
		      	<a href="editUI" title="${item.id }" class="btn btn-default" style="padding-top: 1px;padding-bottom: 1px;">编辑</a>
		      	<a href="delete" title="${item.id }" class="btn btn-default" style="padding-top: 1px;padding-bottom: 1px;">删除</a>
		      </td>
		    </tr>
	    </c:forEach>
	  </tbody>
	</table>
	</form>
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
			deleteAndEditInfo("linensInfo");
			spanDateTransplate();
			changeTogether("date", "lDate");
			if($("#lDate").val()>0){
				$("#date").val(translateRealToDate($("#lDate").val()));
			}
			$("#back").click(function(e){
				e.preventDefault();
				var url = $("#list_info").attr("title");
				$("#list_info").attr({
					"action": url.replace("linensinfo_info","linen_info")+"?pageNo="+$("#pageNo").val()
				});
				//alert($("#list_info").attr("action"));
				$("#list_info").submit();
			});
			$("#export").click(function(e){
				e.preventDefault();
				window.open("${path}/linen/linen_exportExcel.action?linen.id="+$("#lId").val());
			});
		});
	</script>
  </body>
</html>