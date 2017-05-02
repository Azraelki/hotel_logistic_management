<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>布草洗涤录入</title>
    <jsp:include page="/common/header.jsp"></jsp:include>
    <link rel="stylesheet" href="${path }/css/childframe.css">
  </head>
  	
  <body>
  	<form id="list_info" class="form-horizontal" action="" title="${path }/linen/linen_info.action" method="post" enctype="multipart/form-data">
		<div class="row from-group">
			<label for="eName" class="control-label col-xs-1">负责人</label>
			<div class="col-xs-3">
				<input class="form-control" type="text" id="eName" name="linen.employeeId.name" placeholder="请输入负责人姓名">
			</div>
			<label for="date" class="control-label col-xs-1">日&nbsp;期</label>
			<div class="col-xs-3">
				<input  class="form-control" type="date" id="date" name="temDate" >
				<input class="form-control" type="hidden" name="linen.date" id="lDate">
			</div>
			<div class="col-xs-2">
				<a  class="btn btn-default"  id="submit" >提交洗涤单</a>
			</div>
			<span class="col-xs-2">${message }</span>
		</div>
	<div style="height: 400px;overflow-y: auto;">
	    <table class="table table-striped table-hover ">
		  <thead>
		    <tr class="row">
		      <th class="col-xs-2">布草名称</th>
		      <th class="col-xs-2">收回数量</th>
		      <th class="col-xs-2">送出数量</th>
		      <th class="col-xs-2">回洗数量</th>
		      <th class="col-xs-2">欠收数量</th>
		      <th class="col-xs-2">操作</th>
		    </tr>
		  </thead>
		  <tbody id="dataTarget">
		  	<tr class="row">
		  		<td class="col-xs-2">
		  			<select name="linensInfo[0].facilitieId.id" class="form-control input-sm">
						<option value="${0 }">请选择</option>
						<c:forEach var="item" items="${facilitieList}">
							<option value="${item.id }">${item.name }</option>
						</c:forEach>
					</select>
		  		</td>
		  		<td class="col-xs-2"><input type="number" name="linensInfo[0].recNum" class="form-control input-sm"></td>
		  		<td class="col-xs-2"><input type="number" name="linensInfo[0].senNum" class="form-control input-sm"></td>
		  		<td class="col-xs-2"><input type="number" name="linensInfo[0].backWashNum" class="form-control input-sm"></td>
		  		<td class="col-xs-2"><input type="number" name="linensInfo[0].oweNum" class="form-control input-sm"></td>
		  		<td class="col-xs-2">
		  			<a title="delete" class="btn btn-default" style="padding-top: 1px;padding-bottom: 1px;">删除</a> 
		  			<a title="confirm" class="btn btn-default" style="padding-top: 1px;padding-bottom: 1px;">确认</a> 
		  		</td>
		  	</tr>
		  </tbody>
		</table>
	</div>
	</form>
	<script>
		$(function(){
			function createEmptyRow(){
				//获得空白行
				var $originRow = $("#dataTarget tr:last").clone(true);
				$("input",$originRow).val(null);
				//修改input和select的name属性的对象数组下标
				$("input",$originRow).each(function(){
					$(this).attr("name",$(this).attr("name").replace(/\d/,myFlag));
				});
				$("select",$originRow).attr("name",$("select",$originRow).attr("name").replace(/\d/,myFlag));
				//自增长值
				myFlag++;
				//将空白行追加到tbody的内部
				$("#dataTarget").append($originRow);
			}
			// 删除要删除的条目 
			$("a[title='delete']").click(function(e){
				e.preventDefault();
				//判断是否为确认过的信息
				if($("input:first",$(this).parent().parent()).prop("readonly")){
					$(this).parent().parent().remove();
					var $tr = $("#dataTarget tr:last");
					if($("select:first",$tr).prop("disabled")){
						$("select",$tr).prop("disabled",false);
						$("input",$tr).prop("readonly",false);
						$("a",$tr).removeClass("disabled");
					}
				}else{
					alert("只能删除已确认过的信息！");
					return;
				}
			});
			//为对象数组的下标维护一个增长的值
			var myFlag = 1;
			//确认信息
			$("a[title='confirm']").click(function(e){
				e.preventDefault();
				//若是已经确认过的则不操作
				if($(this).hasClass("disabled")){
					return;
				}
				if($("#dataTarget tr").size()<7)
					createEmptyRow();
				//将当前点击的行按钮设置为不可用
				$(this).addClass("disabled");
				//设置当前行不可编辑
				$("input",$(this).parent().parent()).prop("readonly",true);
				$("select",$(this).parent().parent()).prop("disabled",true);
				//将空白行追加到tbody的内部
			});
			$("#submit").click(function(e){
				e.preventDefault();
				//将无用空白行去除
				$("#dataTarget tr:last").remove();
				$("#list_info").attr({
					"action": $("#list_info").attr("title").replace("_info","_add")
				});
				//提交时修改select的状态，否则数据不会提交
				$("#dataTarget select").removeAttr("disabled");
				$("#list_info").submit();
			});
			changeTogether("date", "lDate");
			if($("#lDate").val()>0){
				$("#date").val(translateRealToDate($("#lDate").val()));
			}
		});
	</script>
  </body>
</html>