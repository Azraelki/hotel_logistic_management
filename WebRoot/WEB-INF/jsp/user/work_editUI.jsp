<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML>
<html>
  <head>
    
    <title>work_edit</title>
    <jsp:include page="/common/header.jsp"></jsp:include>
    <link rel="stylesheet" href="${path }/css/childframe.css">

  </head>
  
  <body>
    <div class="well bs-component">
    	<form id="editForm" action="${path }/user/work_edit.action" class="form-horizontal" method="post" enctype="multipart/form-data">
    		<fieldset>
    			<div class="from-group row">
    				<label for="eName" class="col-xs-2 control-label">姓&nbsp;名</label>
    				<div class="col-xs-4">
    					<input type="hidden" name="pageNo" value="${pageNo }">
    					<input type="hidden" name="employeeWork.id" value="${employeeWork.id }">
    					<input type="hidden" name="employeeWork.employeeId.id" value="${employeeWork.employeeId.id }">
    					<input type="text" id="eName" name="employee.name" value="${employeeWork.employeeId.name }" class="form-control" readonly="readonly">
    				</div>
    				<span class="col-xs-6"></span>
    			</div>
    			<div class="from-group row">
    				<label for="ewLeaveNum" class="col-xs-2 control-label">年&nbsp;龄</label>
    				<div class="col-xs-4">
    					<input type="number" name="employeeWork.leaveNum" value="${employeeWork.leaveNum}" id="ewLeaveNum" class="form-control" placeholder="请输入退房打扫数" min="0" max="100">
    				</div>
    				<span class="col-xs-6"></span>
    			</div>
    			<div class="from-group row">
    				<label for="ewCleanNum" class="col-xs-2 control-label">年&nbsp;龄</label>
    				<div class="col-xs-4">
    					<input type="number" name="employeeWork.cleanNum" value="${employeeWork.cleanNum}" id="ewLeaveNum" class="form-control" placeholder="请输入退房打扫数" min="0" max="100">
    				</div>
    				<span class="col-xs-6"></span>
    			</div>
    			<div class="from-group row">
    				<label for="dateAt" class="col-xs-2 control-label">入职日期</label>
    				<div class="col-xs-4">
    					<input type="date" id="temDate" name="temDate" class="form-control" >
    					<input type="hidden" name="employeeWork.date" value="${employeeWork.date }" id="dateAt">
    				</div>
    				<span class="col-xs-6"></span>
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
    		$("#temDate").change(function(){
    			var date = translateDateToReal($(this).val());
    			$("#dateAt").val(date);
    		});
    		$("#dateAt").change(function(){
    			var date = translateRealToDate($(this).val());
    			$("#temDate").val(real);
    		});
    		$("#temDate").val(translateRealToDate($("#dateAt").val()));
    	});
    </script>
  </body>
</html>
