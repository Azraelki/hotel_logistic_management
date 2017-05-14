//---------childframe--------------
//date型input与hidden型input的change联动
function changeTogether(dateInputId,hiddenInputId){
	$("#"+dateInputId).change(function(){
		var date = translateDateToReal($(this).val());
		//判断是否为NaN，date类型的input点击叉号会出现值为NaN，后台无法识别
		if(isNaN(date)){
			date = null;
		}
		$("#"+hiddenInputId).val(date);
	});
	$("#"+hiddenInputId).change(function(){
		var date = translateRealToDate($(this).val());
		$("#"+dateInputId).val(date);
	});
}
//对信息展示的时间戳加工
function spanDateTransplate(){
	$("span[title='date']").text(function(){
		var date = $(this).find("input:first").val();
		if(date > 0)
			return translateRealToDate(date);
	});
}
//操作信息
function deleteAndEditInfo(item){
	var url = $("#list_info").attr("title");
	$("a.btn").click(function(e){
		e.preventDefault();
		var id = $(this).attr("title");
		var href = $(this).attr("href");
		var myUrl = url.replace(/_[A-z]*info/i,"_"+href);
		var pageNo = $("#pagination li.active a:first").text();
		if($(this).attr("id") == "serach"){
			pageNo = 1;
		}
		if($(this).attr("href") == "delete"){
			showDeleteDialog();
			$("button[name='confirm']").click(function(){
				if($(this).attr("id") == "confirm"){
					if(pageNo.length <= 0)
						pageNo = 1;
					$("#list_info").attr({
						"action": myUrl+"?"+item+".id="+id+"&pageNo="+pageNo
					});
					$("#list_info").submit();
				}else{
					hideDeleteDialog();
				}
			});
		}else if($(this).attr("href") == "deleteSelected"){
			showDeleteDialog();
			$("button[name='confirm']").click(function(){
				if($(this).attr("id") == "confirm"){
					$("#list_info").attr({
						"action": myUrl+"?"+"&pageNo="+pageNo
					});
					$("#list_info").submit();
				}else{
					hideDeleteDialog();
				}
			});
		}else{
			myUrl = myUrl+"?"+item+".id="+id;
			if(pageNo.length <= 0)
				pageNo = 1;
			myUrl = myUrl + "&pageNo="+pageNo;
			$("#list_info").attr({
				"action": myUrl
			});
			$("#list_info").submit();
		}
//		$.post(myUrl,{"employee.id":id},function(result){
//			if(href != "editUI")
//				$("#list_info").submit();
//			else{
//				location.reload();
//			}
//		});
	});
}
//全选实现
function allCheck(){
	$("#checkbox").change(function(){
		var flag = $(this).attr("checked");
		if(flag == undefined){
			$(this).attr("checked","");
			$("input[name='selectedRow']").prop("checked",true);
		}else{
			$(this).removeAttr("checked");
			$("input[name='selectedRow']").prop("checked",false);
		}
	});
}
//------------------home---------------------
//home页面
//创建
//创建content
function createContent(){
	$("#navbar-main a[title='content']").click(function(e){
		e.preventDefault();
		$("#navbar-main a").parent().removeClass("active");
		$(this).parent().addClass("active");
		var href = $(this).attr("href");
		var title = $(this).attr("title");
		var $iframe = $("<iframe></iframe>");
		$iframe.attr({
			"id": title,
			"scrolling": "no",
			"frameborder": 0,
			"src": href
		});
		$("#contentDiv iframe").remove();
		$("#contentDiv").append($iframe);
	});
}
//function(id){
//	tarId = "#" + id;
//	$(tarId)
//}
//子页面显示
var cDoc = parent.$("iframe[id='content']").get(0).contentWindow;
//创建childframe主体
function createTabContent(href,addr){
	var $div = $("<div></div>");
	$div.addClass("tab-panel fade in active");
	$div.attr({
		"id": href
	});
	var $iframe = $("<iframe></iframe>");
	$iframe.attr({
		"id": href+"-frame",
		"frameborder": 0,
		"src": addr
	});
	$div.append($iframe);
	return $div;
}
//创建tab
function createTab(href,name){
	$("#myTab li").removeClass("active");
	$("#myTabContent div").removeClass("in active");
	$("#myTabContent div").addClass("notvisible");
	var $li = $("<li></li>");
	$li.addClass("active");
	var $a = $("<a></a>");
	$a.attr({
		"href": href,
		"data-toggle":"tab",
		"aria-expanded": "true"
	});
	$a.text(name);
	$a.click(function(e){
		e.preventDefault();
		$("#myTabContent div").addClass("notvisible");
		$(this).parent().removeClass("active");
		$("#myTabContent div").removeClass("in active");
		var id = $(this).attr("href");
		$(id).addClass("in");
	});
	var $span = $("<span></span>");
	$span.addClass("glyphicon glyphicon-remove");
	$span.click(function(){
		var id = $(this).parent().attr("href");
		var value = "a[href="+id+"]";
		$(value).parent().remove();
		$(id).remove();
		var nav = "a[title="+id.replace("#","")+"]"
		$(nav).parent().toggleClass("disabled");
		//将最近一个打开的tab和tabcontent设置active
		$("#myTab li:last").addClass("active");
		$("#myTabContent div:last").addClass("in active");
	});
	$a.append($span);
	$li.append($a);
	return $li
}
//创建right视图
function clickPageView(className){
	var classStr = "." + className;
	$(classStr).click(function(e){
		e.preventDefault();
		if($(this).parent().hasClass("disabled"))
			return;
		$(this).parent().toggleClass("disabled");
		var href = $(this).attr("title");
		var addr = $(this).attr("href");
		var name = $(this).text();
		var $li = createTab("#"+href,name);
		var $div = createTabContent(href,addr);
		$("#myTab").append($li);
		$("#myTabContent").append($div);
	});
}
//------------------util--------------
//date转换为时间戳
function translateDateToReal(date){
	return Date.parse(date.toString())/1000;
}
//时间戳转换date
function translateRealToDate(real){
	var date = new Date()
	date.setTime(real*1000);
	var year = ""+date.getFullYear();
	var month = ""+(date.getMonth()+1);
	if(month.length == 1){
		month = "0"+month;
	}
	var day = ""+date.getDate();
	if(day.length == 1){
		day = "0"+day;
	}
	var dateStr = year+"-"+month+"-"+day;
	return dateStr;
}
//delete确认提示
function showDeleteDialog(){
	$("#deleteDialog").css("display","block");
}
function hideDeleteDialog(){
	$("#deleteDialog").css("display","none");
}