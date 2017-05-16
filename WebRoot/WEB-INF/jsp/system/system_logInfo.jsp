<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>system_logInfo</title>
    <jsp:include page="/common/header.jsp"></jsp:include>
    <link rel="stylesheet" href="${path }/css/childframe.css">
  </head>
  	
  <body>
  	<form id="list_info" action="" title="${path }/system/system_logInfo.action" method="post" enctype="multipart/form-data">
  	  <div class="row">
  	  	<div class="col-xs-3">
  	  		<select name="systemLog.flag" class="form-control">
  	  			<option value="${-1 }">请选择</option>
  	  			<c:choose>
  	  				<c:when test="${systemLog.flag == 1 }">
  	  					<option value="${1 }" selected="selected">正常日志</option>
  	  				</c:when>
  	  				<c:otherwise>
  	  					<option value="${1 }">正常日志</option>
  	  				</c:otherwise>
  	  			</c:choose>
  	  			<c:choose>
  	  				<c:when test="${systemLog.flag == 0 }">
  	  					<option value="${0 }" selected="selected">异常日志</option>
  	  				</c:when>
  	  				<c:otherwise>
  	  					<option value="${0 }">异常日志</option>
  	  				</c:otherwise>
  	  			</c:choose>
  	  		</select>
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
  	  		<a id="serach" href="logInfo" class="btn btn-default btn-block">搜&nbsp;索</a>
  	  	</div>
  	  </div>
    <table class="table table-striped table-hover ">
	  <thead>
	    <tr>
	      <th>用户</th>
	      <th>日志级别</th>
	      <th>方法描述</th>
	      <th>异常类型</th>
	      <th>操作</th>
	    </tr>
	  </thead>
	  <tbody>
	  	<c:forEach var="item" items="${pageResult.items }" varStatus="status">
		    <tr>
		      <td>${item.user }</td>
		      <td>
		      	<c:choose>
		      		<c:when test="${item.flag == 1 }">info</c:when>
		      		<c:otherwise>error</c:otherwise>
		      	</c:choose>
		      </td>
		      <td>${item.desc }</td>
		      <td>${item.error }</td>
		      <td>
		      	<a href="logDetail" title="${item.id }" class="btn btn-default" style="padding-top: 1px;padding-bottom: 1px;">详情</a>
		      </td>
		    </tr>
	    </c:forEach>
	  </tbody>
	</table>
	</form>
	<jsp:include page="/common/pageNavigator.jsp"></jsp:include>
	<script>
		$(function(){
			allCheck();
			deleteAndEditInfo("systemLog");
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
