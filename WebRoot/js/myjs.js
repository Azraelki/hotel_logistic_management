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
		"scrolling": "no",
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