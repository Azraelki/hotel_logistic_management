<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
  <head>
    
    <title>user_add</title>
    <jsp:include page="/common/header.jsp"></jsp:include>
    <link rel="stylesheet" href="${path }/css/childframe.css">

  </head>
  
  <body>
    <div class="well bs-component">
    	<form id="userForm" action="${path }/user/employee_add.action" class="form-horizontal" method="post" enctype="multipart/form-data">
    		<fieldset>
    			<div class="from-group row">
    				<label for="eName" class="col-xs-2 control-label">姓&nbsp;名</label>
    				<div class="col-xs-4">
    					<input type="text" id="eName" name="employee.name" class="form-control" placeholder="请输入员工姓名">
    				</div>
    				<span class="col-xs-6"></span>
    			</div>
    			<div class="from-group row">
    				<label class="col-xs-2 control-label">性&nbsp;别</label>
    				<div class="col-xs-10">
    					<div class="radio">
    						<label>
    							<input type="radio" name="employee.gender" value="false" checked="checked">
    							男
    						</label>
    						&nbsp;
    						<label>
    							<input type="radio" name="employee.gender" value="true">
    							女
    						</label>
    					</div>
    				</div>
    			</div>
    			<div class="from-group row">
    				<label for="eAge" class="col-xs-2 control-label">年&nbsp;龄</label>
    				<div class="col-xs-4">
    					<input type="number" name="employee.age" id="eAge" class="form-control" placeholder="请输入你的年龄" min="1" max="100">
    				</div>
    				<span class="col-xs-6"></span>
    			</div>
    			<div class="from-group row">
    				<label for="jName" class="col-xs-2 control-label">职&nbsp;务</label>
    				<div class="col-xs-4">
    					<select id="jName" name="employee.jobId.id" class="form-control" >
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
    					<input type="text" name="employee.phoneNumber" id="ePhone" class="form-control" placeholder="请输入你的手机号" maxlength="11">
    				</div>
    				<span class="col-xs-6"></span>
    			</div>
    			<div class="from-group row">
    				<label for="eArrivedAt" class="col-xs-2 control-label">入职日期</label>
    				<div class="col-xs-4">
    					<input type="date"  id="temDate" name="temDate" class="form-control">
    					<input type="hidden" name="employee.arrivedAt" id="eArrivedAt">
    				</div>
    				<span class="col-xs-6"></span>
    			</div>
    			<div class="from-group row">
    				<div class="col-xs-9 pull-right">
    					<input type="reset" class="btn btn-default" value="重    置">
    					<input id="submit" type="submit" class="btn btn-default" value="添加员工">
    					<span id="message" class="text-success">${message }</span>
    				</div>
    			</div>
    		</fieldset>
    	</form>
    </div>
    <script>
    	$(function(){
    		/*$("#temDate").change(function(){
    			var date = translateDateToReal($(this).val());
    			$("#eArrivedAt").val(date);
    		});
    		$("#eArrivedAt").change(function(){
    			var date = translateRealToDate($(this).val());
    			$("#temDate").val(date);
    		});*/
    		changeTogether("temDate", "eArrivedAt");
    		$("input").click(function(e){
    			$("#message").text("");
    		});
    	});
    </script>
  </body>
</html>
