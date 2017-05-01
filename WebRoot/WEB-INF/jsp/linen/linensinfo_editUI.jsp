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
    	<form id="userForm" action="${path }/linen/linensinfo_edit.action" class="form-horizontal" method="post" enctype="multipart/form-data">
    		<fieldset>
    			<div class="from-group row">
    				<label for="fName" class="col-xs-2 control-label">布草&nbsp;种类</label>
    				<div class="col-xs-4">
    					<input type="hidden" name="pageNo" value="${pageNo }">
    					<input type="hidden" name="linensInfo.id" value="${linensInfo.id }">
    					<input type="hidden" name="linensInfo.linenId.id" value="${linensInfo.linenId.id }">
    					<%-- <input type="hidden" name="linensInfo.facilitieId.id" value="${linensInfo.facilitieId.id }"> --%>
    					<select name="linensInfo.facilitieId.id" class="form-control">
    						<c:forEach var="item" items="${facilitieList}">
    							<c:choose>
	    							<c:when test="${item.id == linensInfo.facilitieId.id }">
	    								<option value="${item.id }" selected="selected">${item.name }</option>
	    							</c:when>
	    							<c:otherwise>
	    								<option value="${item.id }">${item.name }</option>
	    							</c:otherwise>
	    						</c:choose>
    						</c:forEach>
    					</select>
    					<%-- <input type="text" id="fName" name="linensInfo.facilitieId.name" value="${linensInfo.facilitieId.name }" class="form-control" placeholder="请输入布草名称"> --%>
    				</div>
    				<span class="col-xs-6"></span>
    			</div>
    			<div class="from-group row">
    				<label for="lrecNum" class="col-xs-2 control-label">收回&nbsp;数量</label>
    				<div class="col-xs-4">
    					<input type="number" name="linensInfo.recNum" value="${linensInfo.recNum }" id="lrecNum" class="form-control" placeholder="请输入收回数量" min="0">
    				</div>
    				<span class="col-xs-6"></span>
    			</div>
    			<div class="from-group row">
    				<label for="lsenNum" class="col-xs-2 control-label">送洗&nbsp;数量</label>
    				<div class="col-xs-4">
    					<input type="number" name="linensInfo.senNum" value="${linensInfo.senNum }" id="lsenNum" class="form-control" placeholder="请输入送洗数量" min="0">
    				</div>
    				<span class="col-xs-6"></span>
    			</div>
    			<div class="from-group row">
    				<label for="lbackWashNum" class="col-xs-2 control-label">回洗&nbsp;数量</label>
    				<div class="col-xs-4">
    					<input type="number" name="linensInfo.backWashNum" value="${linensInfo.backWashNum }" id="lbackWashNum" class="form-control" placeholder="请输入回洗数量" min="0">
    				</div>
    				<span class="col-xs-6"></span>
    			</div>
    			<div class="from-group row">
    				<label for="loweNum" class="col-xs-2 control-label">欠收&nbsp;数量</label>
    				<div class="col-xs-4">
    					<input type="number" name="linensInfo.oweNum" value="${linensInfo.oweNum }" id="loweNum" class="form-control" placeholder="请输入欠收数量" min="0">
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
