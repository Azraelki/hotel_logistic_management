<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML>
<html>
  <head>
    
    <title>facilitieFix_edit</title>
    <jsp:include page="/common/header.jsp"></jsp:include>
    <link rel="stylesheet" href="${path }/css/childframe.css">

  </head>
  
  <body>
    <div class="well bs-component">
    	<form id="editForm" action="${path }/facilitie/facilitiefix_edit.action" class="form-horizontal" method="post" enctype="multipart/form-data">
    		<fieldset>
    			<div class="from-group row">
    				<label for="fName" class="col-xs-2 control-label">设施&nbsp;名称</label>
    				<div class="col-xs-4">
    					<input type="hidden" name="pageNo" value="${pageNo }">
    					<input type="hidden" name="facilitieFix.id" value="${facilitieFix.id }">
    					<input type="hidden" name="facilitieFix.facilitieId.id" value="${facilitieFix.facilitieId.id }">
    					<input type="text" id="fName" name="facilitieFix.facilitieId.name" value="${facilitieFix.facilitieId.name }" class="form-control" readonly="readonly">
    				</div>
    				<span class="col-xs-6"></span>
    			</div>
    			<div class="from-group row">
    				<label for="ffStatus" class="col-xs-2 control-label">状&nbsp;态</label>
    				<div class="col-xs-4">
    					<select id="ffStatus"  name="facilitieFix.status" class="form-control">
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
    				<span class="col-xs-6"></span>
    			</div>
    			<div class="from-group row">
    				<label for="dateAt" class="col-xs-2 control-label">报修日期</label>
    				<div class="col-xs-4">
    					<input type="date" id="temDate" name="temDate" class="form-control" readonly="readonly">
    					<input type="hidden" name="facilitieFix.dateBegin" value="${facilitieFix.dateBegin }" id="dateAt">
    				</div>
    				<span class="col-xs-6"></span>
    			</div>
    			<div class="from-group row">
    				<label for="eName" class="col-xs-2 control-label">维修&nbsp;人员</label>
    				<div class="col-xs-4">
    					<c:choose>
    						<c:when test="${facilitieFix.employeeId.id != null }">
    							<input type="hidden" name="facilitieFix.employeeId.id" value="${facilitieFix.employeeId.id}" class="form-control" readonly="readonly">
    							<input type="text" id="eName" name="temName" value="${facilitieFix.employeeId.name }" class="form-control" readonly="readonly">
    						</c:when>
    						<c:otherwise><input id="eName" type="text" name="employee.name" value="${employee.name}" class="form-control" placeholder="请输入维修人员姓名"></c:otherwise>
    					</c:choose>
    				</div>
    				<span class="col-xs-6"></span>
    			</div>
    			<div class="from-group row">
    				<label for="ffContent" class="col-xs-2 control-label">备注</label>
    				<div class="col-xs-6">
    					<textarea rows="4" cols="6" name="facilitieFix.contnet"  class="form-control" placeholder="请输入详细的报修信息(100字以内)" readonly="readonly">${facilitieFix.contnet }</textarea>
    				</div>
    				<span class="col-xs-4"></span>
    			</div>
    			<div class="from-group row">
    				<div class="col-xs-9 pull-right">
    					<input type="button" class="btn btn-default" onclick="javascript:history.go(-1)" value="取  消">
    					<input id="submit" type="submit" class="btn btn-default" value="保  存">
    				</div>
    			</div>
    		</fieldset>
    	</form>
    </div>
    <script>
    	$(function(){
    		changeTogether("temDate", "dateAt");
    		$("#temDate").val(translateRealToDate($("#dateAt").val()));
    	});
    </script>
  </body>
</html>
