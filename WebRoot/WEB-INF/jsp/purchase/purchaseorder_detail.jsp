<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>设施采购清单</title>
    <jsp:include page="/common/header.jsp"></jsp:include>
    <link rel="stylesheet" href="${path }/css/childframe.css">
  </head>
  	
  <body>
  	<form id="list_info" class="form-horizontal" action="" title="${path }/purchase/purchaseinfo_info.action" method="post" enctype="multipart/form-data">
  	  <div class="row">
  	  	<div class="col-xs-12">
  	  		<div class="row from-group">
  	  			<%-- <input type="hidden" id="pageNo" name="pageNo" value="${pageNo }"> --%>
  				<input type="hidden" id="poId" name="purchaseOrder.id" value="${purchaseOrder.id }">
  				<input type="hidden" id="eId" name="purchaseOrder.employeeId.id" value="${purchaseOrder.employeeId.id }">
  				<label for="eName" class="control-label col-xs-1">负责人</label>
  				<div class="col-xs-3">
  					<input class="form-control" type="text" id="eName" name="purchaseOrder.employeeId.name" value="${purchaseOrder.employeeId.name }" readonly="readonly">
  				</div>
  				<label for="date" class="control-label col-xs-1">日&nbsp;期</label>
  	  			<div class="col-xs-3">
  	  				<input  class="form-control" type="date" id="date" name="temDate" readonly="readonly">
  	  				<input class="form-control" type="hidden" value="${purchaseOrder.date }" name="purchaseOrder.date" id="poDate">
  	  			</div>
  	  			<div class="col-xs-2">
  	  				<button id="export" class="btn btn-default">导出申购单</button>
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
	      <th>名称</th>
	      <th>单价</th>
	      <th>数量</th>
	      <th>总价</th>
	      <th>操作</th>
	    </tr>
	  </thead>
	  <tbody>
	  	<c:forEach var="item" items="${pageResult.items }" varStatus="status">
		    <tr>
      		  <td>${status.index+1 }</td>
		      <td>${item.facilitieId.name }</td>
		      <td>${item.price }</td>
		      <td>${item.purchaseNum }</td>
		      <td>${item.total }</td>
		      <td>
		      	<a href="editUI" title="${item.id }" class="btn btn-default" style="padding-top: 1px;padding-bottom: 1px;">编辑</a>
		      	<a href="delete" title="${item.id }" class="btn btn-default" style="padding-top: 1px;padding-bottom: 1px;">删除</a>
		      </td>
		    </tr>
	    </c:forEach>
	  </tbody>
	</table>
	</form>
	<div align="center" id="pagination" title="${pageResult.totalPageCount }" >
		<input type="hidden" value="${path }/">
		<s:if test="pageResult.totalCount > 0">
			<ul class="pagination pagination-sm"  style="margin-top: 0;">
				<c:choose>
	 				<c:when test="${pageNo <= 1 }">
	 					<li class="disabled"><a title="${pageNo-1 }">&laquo;</a></li>
	 				</c:when>
	 				<c:otherwise><li><a title="${pageNo-1 }">&laquo;</a></li></c:otherwise>
	 			</c:choose>
			 	<c:if test="${pageNo-3 >= 1 }">
			 		<li><a title="${pageNo-3 }">${pageNo-3 }</a></li>
			 	</c:if>
			 	<c:if test="${pageNo-2 >= 1 }">
			 		<li><a title="${pageNo-2 }">${pageNo-2 }</a></li>
			 	</c:if>
			 	<c:if test="${pageNo-1 >= 1 }">
			 		<li><a title="${pageNo-1 }">${pageNo-1 }</a></li>
			 	</c:if>
				 <c:forEach var="num2" begin="${pageNo }" end="${pageNo+4 }">
			 		<c:if test="${num2 <= pageResult.totalPageCount }">
			 			<c:if test=""></c:if>
			 			<c:choose>
			 				<c:when test="${num2 == pageNo }">
			 					<li class="active"><a title="${num2 }">${num2 }</a></li>
			 				</c:when>
			 				<c:otherwise><li><a title="${num2 }">${num2 }</a></li></c:otherwise>
			 			</c:choose>
				 	</c:if>
				 </c:forEach>
				 <c:choose>
	 				<c:when test="${pageNo >= pageResult.totalPageCount }">
	 					<li class="disabled"><a title="${pageNo+1 }">&raquo;</a></li>
	 				</c:when>
	 				<c:otherwise> <li><a title="${pageNo+1 }">&raquo;</a></li></c:otherwise>
	 			</c:choose>
			 </ul> 
		 </s:if>
		 <s:else>暂无数据!</s:else>
	</div>
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
			deleteAndEditInfo("purchaseInfo");
			spanDateTransplate();
			changeTogether("date", "poDate");
			if($("#poDate").val()>0){
				$("#date").val(translateRealToDate($("#poDate").val()));
			}
			$("#back").click(function(e){
				e.preventDefault();
				var url = $("#list_info").attr("title");
				$("#list_info").attr({
					"action": url.replace("purchaseinfo_info","purchaseorder_info")+"?pageNo=1"
				});
				//alert($("#list_info").attr("action"));
				$("#list_info").submit();
			});
			//特殊分页
			$("#pagination a").click(function(){
				var goalNum = $(this).attr("title");
				var maxNum = $("#pagination").attr("title");
				if(goalNum >= 1 && goalNum <= maxNum){
					var url = $("#list_info").attr("title");
					var data = {"pageNo":goalNum,"pageSize":7};
					url = url+"?pageNo="+goalNum+"&pageSize="+7;
					$("#list_info").attr("action",url.replace("purchaseinfo_info","purchaseorder_detail"));
					$("#list_info").submit();
				}
			});
			$("#export").click(function(e){
				e.preventDefault();
				window.open("${path}/purchase/purchaseorder_exportExcel.action?purchaseOrder.id="+$("#poId").val());
			});
		});
	</script>
  </body>
</html>