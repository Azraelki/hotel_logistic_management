<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML>
<html>
  <head>
    
    <title>facilitie_add</title>
    <jsp:include page="/common/header.jsp"></jsp:include>
    <link rel="stylesheet" href="${path }/css/childframe.css">

  </head>
  
  <body>
    <div class="well bs-component">
    	<form id="addForm" action="${path }/facilitie/facilitie_add.action" class="form-horizontal" method="post" enctype="multipart/form-data">
    		<fieldset>
    			<div class="from-group row">
    				<label for="fName" class="col-xs-2 control-label">物资&nbsp;名称</label>
    				<div class="col-xs-4">
    					<input type="text" id="fName" name="facilitie.name"  class="form-control">
    				</div>
    				<span class="col-xs-6"></span>
    			</div>
    			<div class="from-group row">
    				<label for="fType" class="col-xs-2 control-label">物资&nbsp;类型</label>
    				<div class="col-xs-4">
    					<select id="fType"  name="facilitie.type" class="form-control">
			  	  			<option value="${0 }">请选择</option>
			  	  			<option value="${1 }">布草类</option>
			  	  			<option value="${2 }">设施类</option>
			  	  			<option value="${3 }">消耗类</option>
			  	  		</select>
    				</div>
    				<span id="fTypeValidate" class="col-xs-6"></span>
    			</div>
    			<div class="from-group row">
    				<label for="fnNum" class="col-xs-2 control-label">正常&nbsp;数量</label>
    				<div class="col-xs-4">
    					<input id="fnNum" type="number" name="facilitie.normalNum"  class="form-control" placeholder="请输入设施数量" min="0">
    				</div>
    				<span class="col-xs-6"></span>
    			</div>
    			<div class="from-group row">
    				<label for="fbNum" class="col-xs-2 control-label">损坏&nbsp;数量</label>
    				<div class="col-xs-4">
    					<input id="fbNum" type="number" name="facilitie.badNum"  class="form-control" placeholder="请输入设施数量" min="0">
    				</div>
    				<span class="col-xs-6"></span>
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
    		$("#addForm").submit(function(){
    			var flag = true;
    			flag = flag && validate($("#fType"), notZero, $("#fTypeValidate"), "设施类型不能为空！");
    			$("form input").each(function(){
    				flag = flag && validate($(this), textNotNull, $("span",$(this).parent().parent()), "输入项不能为空")
    			});
    			return flag;
    		});
    	});
    </script>
  </body>
</html>
