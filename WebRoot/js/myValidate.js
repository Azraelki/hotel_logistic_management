//验证框架
//为目标字段创建并添加提示信息
function createMessageLabel(targetEle,message){
	var $label = $("<label></label>");
	$lable.text(message);
	$lable.addClass("text-danger");
	targetEle.parent().append($label);
}
//非空验证
function notNull(ele){
	var value = ele.replace(" ","");
	if(value.length<=0){
		createMessageLabel(ele, "输入项不能为空！");
	}
}
、、function 