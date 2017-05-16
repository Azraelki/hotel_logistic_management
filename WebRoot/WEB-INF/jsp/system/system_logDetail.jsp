<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE HTML>
<html>
  <head>
    
    <title>system_logDetail</title>
    <jsp:include page="/common/header.jsp"></jsp:include>
    <link rel="stylesheet" href="${path }/css/childframe.css">

  </head>
  
  <body>
    <div class="well bs-component">
    	<form id="detailForm" action="${path }/system/system_logDetail.action" class="form-horizontal" method="post" enctype="multipart/form-data">
    		<fieldset>
    			<div class="from-group row">
    				<label for=user class="col-xs-2 control-label">用&nbsp;户</label>
    				<div class="col-xs-6">
    					<input  id="user" type="text" class="form-control"  value="${systemLog.user }" readonly="readonly">
    				</div>
    				<span  class="col-xs-4"></span>
    			</div>
    			<div class="from-group row">
    				<label for="level" class="col-xs-2 control-label">级&nbsp;别</label>
    				<div class="col-xs-6">
    					<c:choose>
    						<c:when test="${systemLog.flag == 1 }">
    							<input  id="level" type="text" class="form-control"  value="info" readonly="readonly">
    						</c:when>
    						<c:when test="${systemLog.flag == 0 }">
    							<input  id="level" type="text" class="form-control"  value="error" readonly="readonly">
    						</c:when>
    					</c:choose>
    					
    				</div>
    				<span  class="col-xs-4"></span>
    			</div>
    			<div class="from-group row">
    				<label for="className" class="col-xs-2 control-label">类&nbsp;名</label>
    				<div class="col-xs-8">
    					<input  id="className" type="text" class="form-control"  value="${systemLog.className }" readonly="readonly">
    				</div>
    				<span  class="col-xs-2"></span>
    			</div>
    			<div class="from-group row">
    				<label for="methodName" class="col-xs-2 control-label">方&nbsp;法&nbsp;名</label>
    				<div class="col-xs-8">
    					<input  id="methodName" type="text" class="form-control"  value="${systemLog.methodName }" readonly="readonly">
    				</div>
    				<span  class="col-xs-2"></span>
    			</div>
    			<div class="from-group row">
    				<label for="desc" class="col-xs-2 control-label">业务&nbsp;描述</label>
    				<div class="col-xs-8">
    					<input  id="desc" type="text" class="form-control"  value="${systemLog.desc }" readonly="readonly">
    				</div>
    				<span  class="col-xs-2"></span>
    			</div>
    			<div class="from-group row">
    				<label for="date" class="col-xs-2 control-label">时&nbsp;间</label>
    				<div class="col-xs-8">
    					<input  id="date" type="text" class="form-control"  value="${logTime }" readonly="readonly">
    				</div>
    				<span  class="col-xs-2"></span>
    			</div>
    			<div class="from-group row">
    				<label for="error" class="col-xs-2 control-label">异常&nbsp;描述</label>
    				<div class="col-xs-8">
    					<input  id="error" type="text" class="form-control"  value="${systemLog.error }" readonly="readonly">
    				</div>
    				<span  class="col-xs-2"></span>
    			</div>
    			<div class="from-group row">
    				<div class="col-xs-9 pull-right">
    					<input type="button" class="btn btn-default" onclick="javaScript:history.go(-1)" value="返  回">
    				</div>
    			</div>
    		</fieldset>
    	</form>
    </div>
    <script>
    	$(function(){
    	});
    </script>
  </body>
</html>
