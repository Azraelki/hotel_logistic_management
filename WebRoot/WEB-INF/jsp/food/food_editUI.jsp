<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML>
<html>
  <head>
    
    <title>food_edit</title>
    <jsp:include page="/common/header.jsp"></jsp:include>
    <link rel="stylesheet" href="${path }/css/childframe.css">

  </head>
  
  <body>
    <div class="well bs-component">
    	<form id="userForm" action="${path }/food/food_edit.action" class="form-horizontal" method="post" enctype="multipart/form-data">
    		<fieldset>
    			<div class="from-group row">
    				<label for="foName" class="col-xs-2 control-label">菜品&nbsp;名称</label>
    				<div class="col-xs-4">
    					<input type="hidden" name="pageNo" value="${pageNo }">
    					<input type="hidden" name="food.id" value="${food.id }">
    					<input type="text" id="foName" name="food.name" value="${food.name }" class="form-control" placeholder="请输入菜名">
    				</div>
    				<span class="col-xs-6"></span>
    			</div>
    			<div class="from-group row">
    				<label class="col-xs-2 control-label">菜品&nbsp;分类</label>
    				<div class="col-xs-4">
    					<select name="food.type" class="form-control">
			  	  			<c:forEach var="foodType" items="${foodTypeList }">
			  	  				<c:choose>
				  	  				<c:when test="${food.type == foodType.code }"><option value="${foodType.code }" selected="selected">${foodType.name}</option></c:when>
				  	  				<c:otherwise><option value="${foodType.code }">${foodType.name}</option></c:otherwise>
			  	  				</c:choose>
			  	  			</c:forEach>
			  	  		</select>
    				</div>
    			</div>
    			<div class="from-group row">
    				<label for="foStyle" class="col-xs-2 control-label">菜&nbsp;系</label>
    				<div class="col-xs-4">
    					<input type="text" name="food.style" value="${food.style }" id="foStyle" class="form-control" placeholder="请输入所属菜系">
    				</div>
    				<span class="col-xs-6"></span>
    			</div>
    			<div class="from-group row">
    				<label for="foPrice" class="col-xs-2 control-label">价&nbsp;格</label>
    				<div class="col-xs-4">
    					<input type="number" name="food.price" value="${food.price }" id="foPrice" class="form-control" placeholder="请输入价格" min="0">
    				</div>
    				<span class="col-xs-6"></span>
    			</div>
    			<div class="from-group row">
    				<label for="fo_status" class="col-xs-2 control-label">菜品状态</label>
    				<div class="col-xs-4">
    					<select name="food.status" class="form-control" id="fo_status">
    						<c:choose>
    							<c:when test="${food.status }"><option value="${true }" selected="selected">可用</option></c:when>
    							<c:otherwise><option value="${false }" selected="selected">不可用</option></c:otherwise>
    						</c:choose>
    						<c:choose>
    							<c:when test="${food.status }"><option value="${false }">不可用</option></c:when>
    							<c:otherwise><option value="${true }">可用</option></c:otherwise>
    						</c:choose>
    					</select>
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
