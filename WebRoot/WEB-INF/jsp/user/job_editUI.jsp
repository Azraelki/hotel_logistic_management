<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML>
<html>
  <head>
    
    <title>job_edit</title>
    <jsp:include page="/common/header.jsp"></jsp:include>
    <link rel="stylesheet" href="${path }/css/childframe.css">

  </head>
  
  <body>
    <div class="well bs-component">
    	<form id="editForm" action="${path }/user/job_edit.action" class="form-horizontal" method="post" enctype="multipart/form-data">
    		<fieldset>
    			<div class="from-group row">
    				<label for="jName" class="col-xs-2 control-label">职&nbsp;位</label>
    				<div class="col-xs-4">
    					<input type="hidden" name="pageNo" value="${pageNo }">
    					<input type="hidden" name="job.id" value="${job.id }">
    					<input type="text" id="jName" name="job.name" value="${job.name }" class="form-control" placeholder="请输入职位名称">
    				</div>
    				<span id="jNameMessage" class="col-xs-6"></span>
    			</div>
    			<div class="from-group row">
    				<label for="jTask" class="col-xs-2 control-label">职位&nbsp;描述</label>
    				<div class="col-xs-4">
    					<input type="text" id="jTask" name="job.task" value="${job.task }" class="form-control" placeholder="请输入职位对应的任务">
    				</div>
    				<span id="jTaskMessage" class="col-xs-6"></span>
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
    	$("#editForm").submit(function(){
			return validate($("#jName"), textNotNull, $("#jNameMessage"), "职务不能为空") && validate($("#jTask"), textNotNull, $("#jTaskMessage"), "职务描述不能为空");
		});
    });
    </script>
  </body>
</html>
