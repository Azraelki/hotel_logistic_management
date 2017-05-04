<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML>
<html>
  <head>
    
    <title>purchaseorder_edit</title>
    <jsp:include page="/common/header.jsp"></jsp:include>
    <link rel="stylesheet" href="${path }/css/childframe.css">

  </head>
  
  <body>
    <div class="well bs-component">
    	<form id="addForm" action="${path }/purchase/purchaseorder_edit.action" class="form-horizontal" method="post" enctype="multipart/form-data">
    		<fieldset>
    			<div class="from-group row">
    				<label for="eName" class="col-xs-2 control-label">负&nbsp;责&nbsp;人</label>
    				<div class="col-xs-4">
    					<input type="hidden" name="pageNo" value="${pageNo }">
    					<input type="hidden" name="purchaseOrder.id" value="${purchaseOrder.id }">
    					<input type="hidden" name="purchaseOrder.employeeId.id" value="${purchaseOrder.employeeId.id }">
    					<input type="text" name="purchaseOrder.employeeId.name" value="${purchaseOrder.employeeId.name }" id="eName" class="form-control" readonly="readonly">
    				</div>
    				<span class="col-xs-6"></span>
    			</div>
    			<div class="from-group row">
    				<label for="poStatus" class="col-xs-2 control-label">状&nbsp;态</label>
    				<div class="col-xs-4">
    					<select id="poStatus" name="purchaseOrder.status" class="form-control">
    						<c:choose>
    							<c:when test="${purchaseOrder.status == 1 }"><option value="${1 }" selected="selected">已处理</option></c:when>
    							<c:otherwise><option value="${0 }" selected="selected">未处理</option></c:otherwise>
    						</c:choose>
    						<c:choose>
    							<c:when test="${purchaseOrder.status == 1 }"><option value="${0 }">未处理</option></c:when>
    							<c:otherwise><option value="${1 }">已处理</option></c:otherwise>
    						</c:choose>
    					</select>
    				</div>
    				<span class="col-xs-6"></span>
    			</div>
    			<div class="from-group row">
    				<label for="date" class="col-xs-2 control-label">申请&nbsp;日期</label>
    				<div class="col-xs-4">
    					<input type="date" class="form-control" id="date" name="temDate" readonly="readonly">
    					<input type="hidden" name="purchaseOrder.date" value="${purchaseOrder.date }" id="poDate" class="form-control">
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
    		$("#date").val(translateRealToDate($("#poDate").val()));
    	});
    </script>
  </body>
</html>
