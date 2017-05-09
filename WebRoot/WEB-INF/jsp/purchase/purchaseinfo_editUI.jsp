<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML>
<html>
  <head>
    
    <title>linensinfo_edit</title>
    <jsp:include page="/common/header.jsp"></jsp:include>
    <link rel="stylesheet" href="${path }/css/childframe.css">

  </head>
  
  <body>
    <div class="well bs-component">
    	<form id="editForm" action="${path }/purchase/purchaseinfo_edit.action" class="form-horizontal" method="post" enctype="multipart/form-data">
    		<fieldset>
    			<div class="from-group row">
    				<label for="fName" class="col-xs-2 control-label">设施&nbsp;种类</label>
    				<div class="col-xs-4">
    					<input type="hidden" name="pageNo" value="${pageNo }">
    					<input type="hidden" name="purchaseInfo.id" value="${purchaseInfo.id }">
    					<input type="hidden" name="purchaseInfo.purchaseOrderId.id" value="${purchaseInfo.purchaseOrderId.id }">
    					<select name="purchaseInfo.facilitieId.id" class="form-control">
    						<c:forEach var="item" items="${facilitieList}">
    							<c:choose>
	    							<c:when test="${item.id == purchaseInfo.facilitieId.id }">
	    								<option value="${item.id }" selected="selected">${item.name }</option>
	    							</c:when>
	    							<c:otherwise>
	    								<option value="${item.id }">${item.name }</option>
	    							</c:otherwise>
	    						</c:choose>
    						</c:forEach>
    					</select>
    				</div>
    				<span class="col-xs-6"></span>
    			</div>
    			<div class="from-group row">
    				<label for="piPrice" class="col-xs-2 control-label">单&nbsp;价</label>
    				<div class="col-xs-4">
    					<input type="number" name="purchaseInfo.price" value="${purchaseInfo.price }" id="piPrice" class="form-control" placeholder="请输入单价" min="0">
    				</div>
    				<span class="col-xs-6"></span>
    			</div>
    			<div class="from-group row">
    				<label for="piNum" class="col-xs-2 control-label">送洗&nbsp;数量</label>
    				<div class="col-xs-4">
    					<input type="number" name="purchaseInfo.purchaseNum" value="${purchaseInfo.purchaseNum }" id="piNum" class="form-control" placeholder="请输入数量" min="0">
    				</div>
    				<span class="col-xs-6"></span>
    			</div>
    			<div class="from-group row">
    				<label for="piTotal" class="col-xs-2 control-label">总&nbsp;价</label>
    				<div class="col-xs-4">
    					<input type="number" name="purchaseInfo.total" value="${purchaseInfo.total }" id="piTotal" class="form-control" readonly="readonly">
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
    		$("#piPrice").change(function(){
    			$("#piTotal").val($(this).val()*$("#piNum").val());
    		});
    		$("#piNum").change(function(){
    			$("#piTotal").val($(this).val()*$("#piPrice").val());
    		});
    		$("#editForm").submit(function(){
    			var flag = true;
    			$("form input").each(function(){
    				flag = flag && validate($(this), textNotNull, $("span",$(this).parent().parent()), "输入项不能为空")
    			});
    			return flag;
    		});
    	});
    </script>
  </body>
</html>
