<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML>
<html>
  <head>
    
    <title>facilitie_edit</title>
    <jsp:include page="/common/header.jsp"></jsp:include>
    <link rel="stylesheet" href="${path }/css/childframe.css">

  </head>
  
  <body>
    <div class="well bs-component">
    	<form id="editForm" action="${path }/facilitie/facilitie_edit.action" class="form-horizontal" method="post" enctype="multipart/form-data">
    		<fieldset>
    			<div class="from-group row">
    				<label for="fName" class="col-xs-2 control-label">设施&nbsp;名称</label>
    				<div class="col-xs-4">
    					<input type="hidden" name="pageNo" value="${pageNo }">
    					<input type="hidden" name="facilitie.id" value="${facilitie.id }">
    					<input type="text" id="fName" name="facilitie.name" value="${facilitie.name }" class="form-control">
    				</div>
    				<span class="col-xs-6"></span>
    			</div>
    			<div class="from-group row">
    				<label for="fType" class="col-xs-2 control-label">设施&nbsp;类型</label>
    				<div class="col-xs-4">
    					<select id="fType"  name="facilitie.type" class="form-control">
			  	  			<c:choose>
			  	  				<c:when test="${facilitie.type == 1 }"><option value="${1 }" selected="selected">布草</option>></c:when>
			  	  				<c:otherwise><option value="${1 }">布草</option></c:otherwise>
			  	  			</c:choose>
			  	  			<c:choose>
			  	  				<c:when test="${facilitie.type == 2 }"><option value="${2 }"  selected="selected">其他</option>></c:when>
			  	  				<c:otherwise><option value="${2 }">其他</option></c:otherwise>
			  	  			</c:choose>
			  	  		</select>
    				</div>
    				<span class="col-xs-6"></span>
    			</div>
    			<div class="from-group row">
    				<label for="fnNum" class="col-xs-2 control-label">正常&nbsp;数量</label>
    				<div class="col-xs-4">
    					<input id="fnNum" type="number" name="facilitie.normalNum" value="${facilitie.normalNum}" class="form-control" placeholder="请输入设施数量" min="0">
    				</div>
    				<span class="col-xs-6"></span>
    			</div>
    			<div class="from-group row">
    				<label for="fbNum" class="col-xs-2 control-label">损坏&nbsp;数量</label>
    				<div class="col-xs-4">
    					<input id="fbNum" type="number" name="facilitie.badNum" value="${facilitie.badNum}" class="form-control" placeholder="请输入设施数量" min="0">
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
    	});
    </script>
  </body>
</html>
