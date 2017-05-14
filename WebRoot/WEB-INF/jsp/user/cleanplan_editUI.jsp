<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML>
<html>
  <head>
    
    <title>cleanplan_edit</title>
    <jsp:include page="/common/header.jsp"></jsp:include>
    <link rel="stylesheet" href="${path }/css/childframe.css">

  </head>
  
  <body>
    <div class="well bs-component">
    	<form id="editForm" action="${path }/user/cleanplan_edit.action" class="form-horizontal" method="post" enctype="multipart/form-data">
    		<fieldset>
    			<div class="from-group row">
    				<label for="eName" class="col-xs-2 control-label">姓&nbsp;名</label>
    				<div class="col-xs-4">
    					<input type="hidden" name="pageNo" value="${pageNo }">
    					<input type="hidden" name="cleanPlan.id" value="${cleanPlan.id }">
    					<input type="hidden" name="cleanPlan.employeeId.id" value="${cleanPlan.employeeId.id }">
    					<input type="text" id="eName"  value="${cleanPlan.employeeId.name }" class="form-control" readonly="readonly">
    				</div>
    				<span class="col-xs-6"></span>
    			</div>
    			<div class="from-group row">
    				<label for="cpContent" class="col-xs-2 control-label">计划&nbsp;内容</label>
    				<div class="col-xs-4">
    					<input type="text" name="cleanPlan.content" value="${cleanPlan.content}" id="cpContent" class="form-control" placeholder="请输入计划卫生内容">
    				</div>
    				<span class="col-xs-6"></span>
    			</div>
    			<div class="from-group row">
    				<label for="dateAt" class="col-xs-2 control-label">开始时间</label>
    				<div class="col-xs-4">
    					<input type="date" id="temDate1" name="temDate" class="form-control" >
    					<input type="hidden" name="cleanPlan.begin" value="${cleanPlan.begin }" id="dateAt1">
    				</div>
    				<span class="col-xs-6"></span>
    			</div>
    			<div class="from-group row">
    				<label for="dateAt" class="col-xs-2 control-label">截止时间</label>
    				<div class="col-xs-4">
    					<input type="date" id="temDate2" name="temDate" class="form-control" >
    					<input type="hidden" name="cleanPlan.end" value="${cleanPlan.end }" id="dateAt2">
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
    		changeTogether("temDate1", "dateAt1");
    		$("#temDate1").val(translateRealToDate($("#dateAt1").val()));
    		changeTogether("temDate2", "dateAt2");
    		$("#temDate2").val(translateRealToDate($("#dateAt2").val()));
    		$("#editForm").submit(function(){
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
