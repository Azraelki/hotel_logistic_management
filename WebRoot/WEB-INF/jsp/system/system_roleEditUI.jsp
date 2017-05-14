<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE HTML>
<html>
  <head>
    
    <title>role_add</title>
    <jsp:include page="/common/header.jsp"></jsp:include>
    <link rel="stylesheet" href="${path }/css/childframe.css">

  </head>
  
  <body>
    <div class="well bs-component">
    	<form id="editForm" action="${path }/system/system_editRole.action" class="form-horizontal" method="post" enctype="multipart/form-data">
    		<fieldset>
    			<div class="from-group row">
    				<label for="jName" class="col-xs-2 control-label">职&nbsp;位</label>
    				<div class="col-xs-4">
    					<input id="jName" class="form-control" name="tem" value="${job.name }" readonly="readonly">
    					<input type="hidden" name="job.id" value="${job.id }">
    				</div>
    				<span id="jNameMessage" class="col-xs-6"></span>
    			</div>
    			<div class="from-group row">
    				<label for="privilege" class="col-xs-2 control-label">职位&nbsp;描述</label>
    				<div class="col-xs-8">
    					<div class="checkbox">
				          <label>
			          		<c:choose>
				          		<c:when test="${fn:contains(privilegeStr,'yhgl') }"><input type="checkbox" name="privileges" value="yhgl" checked="checked">${roleMap['yhgl'] }</c:when>
				          		<c:otherwise><input type="checkbox" name="privileges" value="yhgl">${roleMap['yhgl'] }</c:otherwise>
				          	</c:choose>
				          </label>
				          <label>
							<c:choose>
				          		<c:when test="${fn:contains(privilegeStr,'bcgl') }"><input type="checkbox" name="privileges" value="bcgl" checked="checked">${roleMap['bcgl'] }</c:when>
				          		<c:otherwise><input type="checkbox" name="privileges" value="bcgl">${roleMap['bcgl'] }</c:otherwise>
				          	</c:choose>
				          </label>
				          <label>
				            <c:choose>
				          		<c:when test="${fn:contains(privilegeStr,'cggl') }"><input type="checkbox" name="privileges" value="cggl" checked="checked">${roleMap['cggl'] }</c:when>
				          		<c:otherwise><input type="checkbox" name="privileges" value="cggl">${roleMap['cggl'] }</c:otherwise>
				          	</c:choose>
				          </label>
				          <label>
				            <c:choose>
				          		<c:when test="${fn:contains(privilegeStr,'sswh') }"><input type="checkbox" name="privileges" value="sswh" checked="checked">${roleMap['sswh'] }</c:when>
				          		<c:otherwise><input type="checkbox" name="privileges" value="sswh">${roleMap['sswh'] }</c:otherwise>
				          	</c:choose>
				          </label>
				          <label>
				            <c:choose>
				          		<c:when test="${fn:contains(privilegeStr,'xtwh') }"><input type="checkbox" name="privileges" value="xtwh" checked="checked">${roleMap['xtwh'] }</c:when>
				          		<c:otherwise><input type="checkbox" name="privileges" value="xtwh">${roleMap['xtwh'] }</c:otherwise>
				          	</c:choose>
				          </label>
				        </div>
    				</div>
    				<span class="col-xs-2"></span>
    			</div>
    			<div class="from-group row">
    				<div class="col-xs-9 pull-right">
    					<input type="button" class="btn btn-default" onclick="javaScript:history.go(-1)" value="取  消">
    					<input id="submit" type="submit" class="btn btn-default" value="确认修改">
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
