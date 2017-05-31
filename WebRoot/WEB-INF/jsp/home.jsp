<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    application.setAttribute("basePath",basePath);
    application.setAttribute("path", path);
%>
<!DOCTYPE html>
<html style="overflow-y: hidden;">
  <head>
  	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>酒店后勤管理系统</title>
    <jsp:include page="/common/header.jsp"></jsp:include>
    <script src="${path }/js/md5.js"></script>
    <link rel="stylesheet" href="${path }/css/home.css">
    <script>
    	$(function(){
    		createContent();
    		$("#updatepwd").click(function(e){
    			
    			$("#myModal input").val(null);
    			$("#myModal span").text("");
    		});
    		$("#confirm").click(function(e){
    			e.preventDefault();
    			var flag = true;
    			$("#myModal input").each(function(){
    				flag = flag && validate($(this), textNotNull, $("span",$(this).parent().parent()), "输入项不能为空");
    				if(flag){
    					flag = flag && validate($(this), numAndCharValidate, $("span",$(this).parent().parent()), "密码只能为数字和字母组合");
    				}
    			});
    			if(flag && $("#second").val() != $("#first").val()){
    				flag = false;
    				$("#secondConfirm").text("两次密码不同！");
    			}
    			if(!flag){
    				return;
    			}
    			var url = "<%=path%>"+"/sys/home_json.action";
    			var myData = {"old":$.md5($("#old").val()),"first":$.md5($("#first").val()),"second":$.md5($("#second").val())};
    			$.post(url,myData,function(data){
    				$("#myModal input").val(null);
    				$("#json").text(data);
    			});
    		});
    	});
    </script>
  </head>
  
  <body style="padding:10px">
    <!-- nav-top -->
    <div id="head" class="navbar navbar-default">
      <div class="container">
      	<div class="navbar-header">
      	  <a href="#" class="navbar-brand"><span class="glyphicon glyphicon-home"></span>&nbsp;后勤管理系统</a>
      	  <button class="navbar-toggle" type="button" data-toggle="collapse" data-target="#navbar-main">
      	    <span class="icon-bar"></span>
      	    <span class="icon-bar"></span>
      	    <span class="icon-bar"></span>
      	  </button>
      	</div>
      	<div class="navbar-collapse collapse" id="navbar-main">
      	  <ul class="nav navbar-nav">
      	  	<li class="active"><a title="content" href="${path }/user/employee.action">员工管理</a></li>
      	  	<li><a title="content" href="${path }/linen/linen.action">布草管理</a></li>
      	  	<li><a title="content" href="${path }/purchase/purchaseorder.action">申购管理</a></li>
      	  	<!--<li><a title="content" href="${path }/food/food.action">餐饮管理</a></li>-->
      	  	<li><a title="content" href="${path }/facilitie/facilitie.action">物资管理</a></li>
	      	<li><a title="content" href="${path }/system/system.action">系统维护</a></li>
      	  </ul>
      	  <ul class="nav navbar-nav navbar-right">
		    <li class="dropdown">
		      <a href="#" class="dropdown-toggle" data-toggle="dropdown">
		      <span class="glyphicon glyphicon-user">&nbsp;</span>${SYS_USER.employeeId.name}<span class="caret"></span>
		      </a>
		      <ul class="dropdown-menu" >
		      	<li><a id="updatepwd" href="#" data-toggle="modal" data-target="#myModal">修改密码</a></li>
		      	<li class="divider"></li>
		        <li><a href="${path }/sys/login_logout.action">登出</a></li>
		      </ul>
		    </li>
		  </ul>
      	</div>
      </div>
    </div>
    <!-- /nav-top -->
    <!-- content -->
    <div id="contentDiv" class="container">
	  <iframe id="content" scrolling="no" src="${path }/user/employee.action" frameborder="0"></iframe>
    </div>
    <!-- /content -->
    <!-- 模态框（Modal） -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
	            	 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	                <h4 class="modal-title text-center" id="myModalLabel">用户密码修改</h4>
	            </div>
	            <div class="modal-body form-horizontal">
	            	<div class="from-group row">
	    				<label for="old" class="col-xs-3 control-label">旧密码</label>
	    				<div class="col-xs-6">
	    					<input type="password" id="old" name="old" class="form-control" placeholder="请输入旧密码">
	    				</div>
	    				<span class="col-xs-3 text-danger"></span>
	    			</div>
	            	<div class="from-group row">
	    				<label for="first" class="col-xs-3 control-label">新密码</label>
	    				<div class="col-xs-6">
	    					<input type="password" id="first" name="first" class="form-control" placeholder="请输入新密码">
	    				</div>
	    				<span class=" col-xs-3 text-danger"></span>
	    			</div>
	    			<div class="from-group row">
	    				<label for="second" class="col-xs-3 control-label">确认新密码</label>
	    				<div class="col-xs-6">
	    					<input type="password" id="second" name="second"  class="form-control" placeholder="请再输入一次新密码">
	    				</div>
	    				<span id="secondConfirm" class="col-xs-3 text-danger"></span>
	    			</div>
	            </div>
	            <div class="modal-footer">
	            	<span id="json" class="text-info"></span>
	                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
	                <button type="button" id="confirm" class="btn btn-primary">确认修改</button>
	            </div>
	        </div><!-- /.modal-content -->
	    </div><!-- /.modal -->
	</div>
  </body>
</html>