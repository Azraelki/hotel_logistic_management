//验证框架
//为目标字段创建并添加提示信息
function createMessageLabel($targetEle,message){
	var $label = $("<label></label>");
	$label.text(message);
	$label.addClass("text-danger");
	$targetEle.html("");
	$targetEle.append($label);
}
//验证函数
/**
 * param:
 * 	$target 验证目标
 * 	validateFunc 验证函数
 *	$targetOutput 若果验证函数返回false输出目标,若为null则alert出信息
 * 	message 若果验证函数返回false输出的信息
 */
function validate($target,validateFunc,$targetOutput,message){
	var value = $target.val();
	if(!validateFunc(value)){
		if($targetOutput != null){
			createMessageLabel($targetOutput, message);
		}else{
			if(message!=null){
				alert(message);
			}
		}
		return false;
	}else{
		if($targetOutput!=null)
			$targetOutput.html("");
		return true;
	}
}
//非空验证
//value为验证的信息targetOutput为信息输出目标，message为显示的话语
function textNotNull(value){
	if(value == null)
		return false;
	value = value.trim();
	if(value.length <= 0){
		return false;
	}
	return true;
}
//验证非零
function notZero(value){
	if(value == null)
		return false;
	if(value!=0)
		return true;
	return false;
}
//数字字符串验证
function numAndCharValidate(value){
	if(value == null)
		return false;
	var reg = /[a-zA-Z0-9]+/;
	return reg.test(value);
}

