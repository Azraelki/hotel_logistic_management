<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>菜单信息录入</title>
    <jsp:include page="/common/header.jsp"></jsp:include>
    <link rel="stylesheet" href="${path }/css/childframe.css">
  </head>
  	
  <body>
  	<form id="list_info" class="form-horizontal" action="" title="${path }/food/foodshow_info.action" method="post" enctype="multipart/form-data">
		<div class="row from-group">
			<label for="date" class="control-label col-xs-1">日&nbsp;期</label>
			<div class="col-xs-3">
				<input  class="form-control" type="date" id="date" name="temDate" >
				<input class="form-control" type="hidden" name="nowDate" id="nowDate">
			</div>
			<div class="col-xs-2">
				<a  class="btn btn-default"  id="submit" >提交菜单</a>
			</div>
			<span id="validate" class="col-xs-2">${message }</span>
		</div>
	<div style="height: 400px;overflow-y: auto;">
	    <table class="table table-striped table-hover ">
		  <thead>
		    <tr class="row">
		      <th class="col-xs-6">菜品名称</th>
		      <th class="col-xs-6">操作</th>
		    </tr>
		  </thead>
		  <tbody id="dataTarget">
		  	<tr class="row">
		  		<td class="col-xs-3">
		  			<input id="foodName" type="text" name="temName" class="form-control input-sm">
		  			<input type="hidden" name="foodShows[0].foodId.id">
		  		</td>
		  		<td class="col-xs-3">
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
			//创建一个输入框提示div并设置样式
			var $div = $("<div title='content' class='form-control'></div>");
			$div.css({
				"height":"100px",
				"overflow-y":"auto",
				"position":"absolute"
			});
			//添加菜品输入框的keyup事件，异步向后台请求数据
			$("#dataTarget input[type='text']").keyup(function(e){
				e.preventDefault();
				//将提示div宽度设置等宽并添加到当前input的后面
				$div.width($(this).width());
				$(this).after($div);
				//获取url并构造数据
				var url = $("#list_info").attr("title").replace("_info","_foodJson");
				data = {"food.name":$(this).val()};
				$.post(url,data,function(backData){
					//将之前加入的span去除掉
					$("span",$div).remove();
					//获取返回的数据长度
					var num = backData.length;
					//迭代数据，创建span并放置到提示div中
					for(i = 0;i < num;i++){
						var $span = $("<span>hello</span>");
						$span.css("display","block");
						$span.val(backData[i].id);
						$span.text(backData[i].name);
						$div.append($span);
					}
					//当span划过时改变显示效果
					$("span",$div).hover(function(e){
						e.preventDefault();
						$("span",$div).removeClass("bg-primary");
						$(this).addClass("bg-primary");
					});
					//当span点击时将数据设置到input中，并将数据id插入到hidden中，最后将提示div除去
					$("span",$div).click(function(e){
						e.preventDefault();
						$("input[type='text']",$(this).parent().parent()).val($(this).text());
						$("input[type='hidden']",$(this).parent().parent()).val($(this).val());
						$div.remove();
						
					});
				});
			});
			function createEmptyRow(){
				//获得空白行
				var $originRow = $("#dataTarget tr:last").clone(true);
				$("input",$originRow).val(null);
				//修改input和select的name属性的对象数组下标
				$("input",$originRow).each(function(){
					$(this).attr("name",$(this).attr("name").replace(/\d/,myFlag));
				});
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
					if($("input:first",$tr).prop("readonly")){
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
				//判断所在行都非空
				var tem = true;
				tem = tem && textNotNull($("#foodName").val());
				//若有为空项则禁止确认
				if(!tem){
					alert("有空值,请核查各项值！");
					return;
				}
				//若是已经确认过的则不操作
				if($(this).hasClass("disabled")){
					return;
				}
				var value = $("input[type='text']",$(this).parent().parent()).val();
				//当使用从前输入的值时不会设置food的id值这时候将名称添加到id上到后台检测查询
				if($("input[type='hidden']",$(this).parent().parent()).val().length < 10)
					$("input[type='hidden']",$(this).parent().parent()).val(value);
				$div.remove();
				createEmptyRow();
				//将当前点击的行按钮设置为不可用
				$(this).addClass("disabled");
				//设置当前行不可编辑
				var $currentTr = $(this).parent().parent();
				$("input",$currentTr).prop("readonly",true);
			});
			$();
			$("#submit").click(function(e){
				e.preventDefault();
				//判断负责人和日期是否为空
				var tem = true;
				$("input",$(this).parent().parent()).each(function(){
					tem = tem && validate($(this), textNotNull, $("#validate"), "日期为空!");
				});
				if(tem){
					//判断是否有确认过的数据
					tem = tem && $("#dataTarget tr:first a[title='confirm']").hasClass("disabled");
					$("#validate").html("");
					if(!tem){
						$("#validate").html("没有菜品数据！");
						return;
					}
				}else{
					return;
				}
				//将无用空白行去除
				$("#dataTarget tr:last").remove();
				$("#list_info").attr({
					"action": $("#list_info").attr("title").replace("_info","_add")
				});
				$("#list_info").submit();
			});
			changeTogether("date", "nowDate");
			if($("#nowDate").val()>0){
				$("#date").val(translateRealToDate($("#nowDate").val()));
			}
		});
	</script>
  </body>
</html>