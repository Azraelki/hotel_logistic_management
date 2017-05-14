<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
  <head>
    
    <title>cleanPlan_add</title>
    <jsp:include page="/common/header.jsp"></jsp:include>
    <link rel="stylesheet" href="${path }/css/childframe.css">

  </head>
  
  <body>
    <div class="well bs-component">
    	<form id="addForm" action="${path }/user/cleanplan_add.action" class="form-horizontal" method="post" enctype="multipart/form-data">
    		<fieldset>
    			<div class="from-group row">
    				<label for="eName" class="col-xs-2 control-label">负&nbsp;责&nbsp;人</label>
    				<div class="col-xs-4">
    					<input type="text" id="eName" name="cleanPlan.employeeId.name" class="form-control" placeholder="请输入员工姓名">
    				</div>
    				<span class="col-xs-6"></span>
    			</div>
    			<div class="from-group row">
    				<label for="cpContent" class="col-xs-2 control-label">退房&nbsp;打扫</label>
    				<div class="col-xs-4">
    					<input type="text" name="cleanPlan.content" id="cpContent" class="form-control" placeholder="请输入计划卫生内容">
    				</div>
    				<span class="col-xs-6"></span>
    			</div>
    			<div class="from-group row">
    				<label for="dateAt1" class="col-xs-2 control-label">日期</label>
    				<div class="col-xs-4">
    					<input type="date"  id="temDate1" name="temDate" class="form-control">
    					<input type="hidden" name="cleanPlan.begin" id="dateAt1">
    				</div>
    				<span class="col-xs-6"></span>
    			</div>
    			<div class="from-group row">
    				<label for="dateAt2" class="col-xs-2 control-label">日期</label>
    				<div class="col-xs-4">
    					<input type="date"  id="temDate2" name="temDate" class="form-control">
    					<input type="hidden" name="cleanPlan.end" id="dateAt2">
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
    		changeTogether("temDate1", "dateAt1");
    		changeTogether("temDate2", "dateAt2");
    		$("input").click(function(e){
    			$("#message").text("");
    		});
    		$("#addForm").submit(function(){
    			var flag = true;
    			$("form input").each(function(){
    				flag = flag && validate($(this), textNotNull, $("span",$(this).parent().parent()), "输入项不能为空")
    			});
    			return flag;
    		});
    	});
    </script>
  </body>
</html>
