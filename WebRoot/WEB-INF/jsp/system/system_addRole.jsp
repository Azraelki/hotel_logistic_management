<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
  <head>
    
    <title>role_add</title>
    <jsp:include page="/common/header.jsp"></jsp:include>
    <link rel="stylesheet" href="${path }/css/childframe.css">

  </head>
  
  <body>
    <div class="well bs-component">
    	<form id="addForm" action="${path }/system/system_addRole.action" class="form-horizontal" method="post" enctype="multipart/form-data">
    		<fieldset>
    			<div class="from-group row">
    				<label for="jName" class="col-xs-2 control-label">职&nbsp;位</label>
    				<div class="col-xs-4">
    					<select id="jName" name="job.id" class="form-control">
	    					<c:forEach var="job" items="${jobList }">
	    						<option value="${job.id }">${job.name }</option>
	    					</c:forEach>
    					</select>
    				</div>
    				<span id="jNameMessage" class="col-xs-6"></span>
    			</div>
    			<div class="from-group row">
    				<label for="privilege" class="col-xs-2 control-label">职位&nbsp;描述</label>
    				<div class="col-xs-8">
    					<div class="checkbox">
				          <label>
				            <input type="checkbox" name="privileges" value="yhgl"> ${roleMap['yhgl'] }
				          </label>
				          <label>
				            <input type="checkbox" name="privileges" value="bcgl"> ${roleMap['bcgl'] }
				          </label>
				          <label>
				            <input type="checkbox" name="privileges" value="cggl"> ${roleMap['cggl'] }
				          </label>
				          <label>
				            <input type="checkbox" name="privileges" value="sswh"> ${roleMap['sswh'] }
				          </label>
				          <label>
				            <input type="checkbox" name="privileges" value="xtwh"> ${roleMap['xtwh'] }
				          </label>
				        </div>
    				</div>
    				<span class="col-xs-2"></span>
    			</div>
    			<div class="from-group row">
    				<div class="col-xs-9 pull-right">
    					<input type="button" class="btn btn-default" onclick="javaScript:history.go(-1)" value="取  消">
    					<input id="submit" type="submit" class="btn btn-default" value="录入权限">
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
    		/* $("#addForm").submit(function(){
    			return validate($("#jName"), textNotNull, $("#jNameMessage"), "职务不能为空");
    		}); */
    	});
    </script>
  </body>
</html>
