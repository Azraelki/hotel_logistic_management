<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML>
<html>
  <head>
    
    <title>food_add</title>
    <jsp:include page="/common/header.jsp"></jsp:include>
    <link rel="stylesheet" href="${path }/css/childframe.css">

  </head>
  
  <body>
    <div class="well bs-component">
    	<form id="userForm" action="${path }/food/food_add.action" class="form-horizontal" method="post" enctype="multipart/form-data">
    		<fieldset>
    			<div class="from-group row">
    				<label for="foName" class="col-xs-2 control-label">菜品&nbsp;名称</label>
    				<div class="col-xs-4">
    					<input type="text" id="foName" name="food.name" value="${food.name }" class="form-control" placeholder="请输入菜名">
    				</div>
    				<span class="col-xs-6"></span>
    			</div>
    			<div class="from-group row">
    				<label class="col-xs-2 control-label">菜品&nbsp;分类</label>
    				<div class="col-xs-4">
    					<select name="food.type" class="form-control">
    						<option value="${0 }">请选择类型</option>
			  	  			<c:forEach var="foodType" items="${foodTypeList }">
			  	  				<option value="${foodType.code }">${foodType.name}</option>
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
    						<option value="${true }" selected="selected">可用</option>
    						<option value="${false }">不可用</option>
    					</select>
    				</div>
    				<span class="col-xs-6"></span>
    			</div>
    			<div class="from-group row">
    				<div class="col-xs-9 pull-right">
    					<input type="reset" class="btn btn-default" value="重  置">
    					<input id="submit" type="submit" class="btn btn-default" value="保  存">
    					<span id="message" class="text-success">${message }</span>
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
