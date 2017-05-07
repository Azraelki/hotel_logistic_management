<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML>
<html>
  <head>
    
    <title>facilitieFix_add</title>
    <jsp:include page="/common/header.jsp"></jsp:include>
    <link rel="stylesheet" href="${path }/css/childframe.css">

  </head>
  
  <body>
    <div class="well bs-component">
    	<form id="editForm" action="${path }/facilitie/facilitiefix_add.action" class="form-horizontal" method="post" enctype="multipart/form-data">
    		<fieldset>
    			<div class="from-group row">
    				<label for="fName" class="col-xs-2 control-label">设施&nbsp;名称</label>
    				<div class="col-xs-4">
    					<select name="facilitie.id" class="form-control">
			  	  			<option value="${0 }">请选择</option>
			  	  			<c:forEach var="item" items="${facilitieList }" >
		  	  					<option value="${item.id }">${item.name}</option>
			  	  			</c:forEach>
			  	  		</select>
    				</div>
    				<span class="col-xs-6"></span>
    			</div>
    			<div class="from-group row">
    				<label for="dateAt" class="col-xs-2 control-label">报修日期</label>
    				<div class="col-xs-4">
    					<input type="date" id="temDate" name="temDate" class="form-control">
    					<input type="hidden" name="facilitieFix.dateBegin"  id="dateAt">
    				</div>
    				<span class="col-xs-6"></span>
    			</div>
    			<div class="from-group row">
    				<label for="ffContent" class="col-xs-2 control-label">备注</label>
    				<div class="col-xs-6">
    					<textarea rows="4" cols="6" name="facilitieFix.contnet" class="form-control" placeholder="请输入详细的报修信息(100字以内)"></textarea>
    				</div>
    				<span class="col-xs-4"></span>
    			</div>
    			<div class="from-group row">
    				<div class="col-xs-9 pull-right">
    					<input type="reset" class="btn btn-default"  value="重  置">
    					<input id="submit" type="submit" class="btn btn-default" value="保  存">
    					<span class="text-success">${message }</span>
    				</div>
    			</div>
    		</fieldset>
    	</form>
    </div>
    <script>
    	$(function(){
    		changeTogether("temDate", "dateAt");
    	});
    </script>
  </body>
</html>
