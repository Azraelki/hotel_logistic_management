<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
  <head>
    
    <title>work_add</title>
    <jsp:include page="/common/header.jsp"></jsp:include>
    <link rel="stylesheet" href="${path }/css/childframe.css">

  </head>
  
  <body>
    <div class="well bs-component">
    	<form id="addForm" action="${path }/user/work_add.action" class="form-horizontal" method="post" enctype="multipart/form-data">
    		<fieldset>
    			<div class="from-group row">
    				<label for="eName" class="col-xs-2 control-label">姓&nbsp;名</label>
    				<div class="col-xs-4">
    					<input type="text" id="eName" name="employeeWork.employeeId.name" class="form-control" placeholder="请输入员工姓名">
    				</div>
    				<span class="col-xs-6"></span>
    			</div>
    			<div class="from-group row">
    				<label for="lNum" class="col-xs-2 control-label">退房&nbsp;打扫</label>
    				<div class="col-xs-4">
    					<input type="number" name="employeeWork.leaveNum" id="lNum" class="form-control" placeholder="请输入退房打扫数" min="0" max="100">
    				</div>
    				<span class="col-xs-6"></span>
    			</div>
    			<div class="from-group row">
    				<label for="cNum" class="col-xs-2 control-label">续房&nbsp;打扫</label>
    				<div class="col-xs-4">
    					<input type="number" name="employeeWork.cleanNum" id="cNum" class="form-control" placeholder="请输入续房打扫数" min="0" max="100">
    				</div>
    				<span class="col-xs-6"></span>
    			</div>
    			<div class="from-group row">
    				<label for="dateAt" class="col-xs-2 control-label">日期</label>
    				<div class="col-xs-4">
    					<input type="date"  id="temDate" name="temDate" class="form-control">
    					<input type="hidden" name="employeeWork.date" id="dateAt">
    				</div>
    				<span class="col-xs-6"></span>
    			</div>
    			<div class="from-group row">
    				<div class="col-xs-9 pull-right">
    					<input type="reset" class="btn btn-default" value="重    置">
    					<input id="submit" type="submit" class="btn btn-default" value="添加记录">
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
    			$("#dateAt").val(date);
    		});
    		$("#dateAt").change(function(){
    			var date = translateRealToDate($(this).val());
    			$("#temDate").val(date);
    		});*/
    		changeTogether("temDate", "dateAt");
    		$("input").click(function(e){
    			$("#message").text("");
    		});
    	});
    </script>
  </body>
</html>
