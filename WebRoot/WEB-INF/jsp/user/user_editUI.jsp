<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML>
<html>
  <head>
    
    <title>user_add</title>
    <jsp:include page="/common/header.jsp"></jsp:include>
    <link rel="stylesheet" href="${path }/css/childframe.css">

  </head>
  
  <body>
    <div class="well bs-component">
    	<form id="userForm" action="${path }/user/employee_edit.action" class="form-horizontal" method="post" enctype="multipart/form-data">
    		<fieldset>
    			<div class="from-group row">
    				<label for="eName" class="col-xs-2 control-label">姓&nbsp;名</label>
    				<div class="col-xs-4">
    					<input type="hidden" name="pageNo" value="${pageNo }">
    					<input type="hidden" name="employee.id" value="${employee.id }">
    					<input type="text" id="eName" name="employee.name" value="${employee.name }" class="form-control" placeholder="请输入员工姓名">
    				</div>
    				<span class="col-xs-6"></span>
    			</div>
    			<div class="from-group row">
    				<label class="col-xs-2 control-label">性&nbsp;别</label>
    				<div class="col-xs-10">
    					<div class="radio">
    						<label>
    							<c:choose>
    								<c:when test="${!employee.gender }">
    									<input type="radio" name="employee.gender" value="false" checked="checked">
    								</c:when>
    								<c:otherwise><input type="radio" name="employee.gender" value="false"></c:otherwise>
    							</c:choose>
    							男
    						</label>
    						&nbsp;
    						<label>
    							<c:choose>
    								<c:when test="${employee.gender }">
    									<input type="radio" name="employee.gender" value="true" checked="checked">
    								</c:when>
    								<c:otherwise><input type="radio" name="employee.gender" value="true"></c:otherwise>
    							</c:choose>
    							女
    						</label>
    					</div>
    				</div>
    			</div>
    			<div class="from-group row">
    				<label for="eAge" class="col-xs-2 control-label">年&nbsp;龄</label>
    				<div class="col-xs-4">
    					<input type="number" name="employee.age" value="${employee.age }" id="eAge" class="form-control" placeholder="请输入你的年龄" min="1" max="100">
    				</div>
    				<span class="col-xs-6"></span>
    			</div>
    			<div class="from-group row">
    				<label for="jName" class="col-xs-2 control-label">职&nbsp;务</label>
    				<div class="col-xs-4">
    					<select id="jName" name="employee.jobId.id"  class="form-control" >
    						<option value="0">请选择</option>
    						<option	value="1">店长</option>
    						<option	value="2">经理</option>
    						<option	value="3">保洁员</option>
    					</select>
    				</div>
    				<span class="col-xs-6"></span>
    			</div>
    			<div class="from-group row">
    				<label for="ePhone" class="col-xs-2 control-label">手机号码</label>
    				<div class="col-xs-4">
    					<input type="text" name="employee.phoneNumber" value="${employee.phoneNumber }" id="ePhone" class="form-control" placeholder="请输入你的手机号" maxlength="11">
    				</div>
    				<span class="col-xs-6"></span>
    			</div>
    			<div class="from-group row">
    				<label for="eArrivedAt" class="col-xs-2 control-label">入职日期</label>
    				<div class="col-xs-4">
    					<input type="date" id="temDate" name="temDate" class="form-control" >
    					<input type="hidden" name="employee.arrivedAt" value="${employee.arrivedAt }" id="eArrivedAt">
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
    			$("#eArrivedAt").val(date);
    		});
    		$("#eArrivedAt").change(function(){
    			var date = translateRealToDate($(this).val());
    			$("#temDate").val(real);
    		});
    		$("#temDate").val(translateRealToDate($("#eArrivedAt").val()));
    	});
    </script>
  </body>
</html>
