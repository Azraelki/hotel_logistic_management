<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
  <head>
    
    <title>job_add</title>
    <jsp:include page="/common/header.jsp"></jsp:include>
    <link rel="stylesheet" href="${path }/css/childframe.css">

  </head>
  
  <body>
    <div class="well bs-component">
    	<form id="addForm" action="${path }/user/job_add.action" class="form-horizontal" method="post" enctype="multipart/form-data">
    		<fieldset>
    			<div class="from-group row">
    				<label for="jName" class="col-xs-2 control-label">职&nbsp;位</label>
    				<div class="col-xs-4">
    					<input type="text" id="jName" name="job.name" class="form-control" placeholder="请输入职位名称">
    				</div>
    				<span id="jNameMessage" class="col-xs-6"></span>
    			</div>
    			<div class="from-group row">
    				<div class="col-xs-9 pull-right">
    					<input type="reset" class="btn btn-default" value="重    置">
    					<input id="submit" type="submit" class="btn btn-default" value="添加职位">
    					<span id="message" class="text-success">${message }</span>
    				</div>
    			</div>
    		</fieldset>
    	</form>
    </div>
    <script>
    	$(function(){
    		$("input").click(function(e){
    			$("#message").text("");
    		});
    		$("#addForm").submit(function(){
    			return validate($("#jName"), textNotNull, $("#jNameMessage"), "职务不能为空");
    			return false;
    		});
    	});
    </script>
  </body>
</html>
