<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
  <head>
    
    <title>linen_invalid</title>
    <jsp:include page="/common/header.jsp"></jsp:include>
    <link rel="stylesheet" href="${path }/css/childframe.css">

  </head>
  
  <body>
    <div class="well bs-component">
    	<form id="addForm" action="${path }/linen/linen_invalid.action" class="form-horizontal" method="post" enctype="multipart/form-data">
    		<fieldset>
    			<div class="from-group row">
    				<label for="fName" class="col-xs-2 control-label">布草&nbsp;种类</label>
    				<div class="col-xs-4">
    					<select name="facilitie.id" id="fName" class="form-control">
							<option value="${0 }">请选择</option>
							<c:forEach var="item" items="${facilitieList}">
								<option value="${item.id }">${item.name }</option>
							</c:forEach>
						</select>
    				</div>
    				<span id="fNameValidate" class="col-xs-6"></span>
    			</div>
    			<div class="from-group row">
    				<label for="fBadNum" class="col-xs-2 control-label">损坏&nbsp;数量</label>
    				<div class="col-xs-4">
    					<input type="number" name="facilitie.badNum" id="fBadNum" class="form-control" placeholder="请输入布草损坏数量" min="1" max="100">
    				</div>
    				<span id="fBadNumValidate" class="col-xs-6"></span>
    			</div>
    			<div class="from-group row">
    				<div class="col-xs-9 pull-right">
    					<input type="reset" class="btn btn-default" value="重    置">
    					<input id="submit" type="submit" class="btn btn-default" value="提    交">
    					<span id="message" class="text-success">${message }</span>
    				</div>
    			</div>
    		</fieldset>
    	</form>
    </div>
    <script>
    	$(function(){
    		$("input").click(function(e){
    			$("#message").text("");
    		});
    		$("#addForm").submit(function(){
    			return validate($("#fName"), notZero, $("#fNameValidate"), "设施选项不能为空！") && validate($("#fBadNum"), textNotNull, $("#fBadNumValidate"), "损坏数目不能为空！");
    		});
    	});
    </script>
  </body>
</html>
