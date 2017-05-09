<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML>
<html>
  <head>
    
    <title>facilitieUse_edit</title>
    <jsp:include page="/common/header.jsp"></jsp:include>
    <link rel="stylesheet" href="${path }/css/childframe.css">

  </head>
  
  <body>
    <div class="well bs-component">
    	<form id="editForm" action="${path }/purchase/facilitieuse_edit.action" class="form-horizontal" method="post" enctype="multipart/form-data">
    		<fieldset>
    			<div class="from-group row">
    				<label for="fName" class="col-xs-2 control-label">设施&nbsp;名称</label>
    				<div class="col-xs-4">
    					<input type="hidden" name="pageNo" value="${pageNo }">
    					<input type="hidden" name="facilitieUse.id" value="${facilitieUse.id }">
    					<select name="facilitieUse.facilitieId.id" class="form-control input-sm">
							<option value="${0 }">请选择</option>
							<c:forEach var="item" items="${facilitieList}">
								<c:choose>
									<c:when test="${item.id == facilitieUse.facilitieId.id }">
										<option value="${item.id }" selected="selected">${item.name }</option>
									</c:when>
									<c:otherwise><option value="${item.id }">${item.name }</option></c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
    				</div>
    				<span id="fNameValidate" class="col-xs-6"></span>
    			</div>
    			<div class="from-group row">
    				<label for="fuNum" class="col-xs-2 control-label">消耗&nbsp;数量</label>
    				<div class="col-xs-4">
    					<input type="number" name="facilitieUse.useNum" value="${facilitieUse.useNum}" class="form-control" placeholder="请输入消耗数量" min="0">
    				</div>
    				<span class="col-xs-6"></span>
    			</div>
    			<div class="from-group row">
    				<label for="dateAt" class="col-xs-2 control-label">日&nbsp;&nbsp;期</label>
    				<div class="col-xs-4">
    					<input type="date" id="temDate" name="temDate" class="form-control" >
    					<input type="hidden" name="facilitieUse.date" value="${facilitieUse.date }" id="dateAt">
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
    		changeTogether("temDate", "dateAt");
    		$("#temDate").val(translateRealToDate($("#dateAt").val()));
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
