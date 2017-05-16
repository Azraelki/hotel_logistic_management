<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
  <head>
    <title>system</title>
    <jsp:include page="/common/header.jsp"></jsp:include>
    <link rel="stylesheet" href="${path }/css/childframe.css">
  	<script>
  		$(function(){
  			clickPageView("panel-body a");
  		});
  	</script>
  </head>
  <body>
    <div class="row">
    	<!-- left -->
    	<div class="col-md-3">
    		<div class="panel-group" id="accordion">
		      <div class="panel panel-warning">
		        <div class="panel-heading">
		          <h4 class="panel-title">
		            <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
		              <span class="glyphicon glyphicon-align-justify"></span>&nbsp;系统&nbsp;维护<span class="caret"></span>
		            </a>
		          </h4>
		        </div>
		        <div id="collapseOne" class="panel-collapse collapse in">
		          <div class="panel-body">
		            <ul class="nav nav-pills nav-stacked">
		              <li><a title="job_info" href="${path }/user/job_info.action">职务增添</a></li>
		              <li><a title="system_roleInfo" href="${path }/system/system_roleInfo.action">权限分配</a></li>
		           	  <li><a title="system_logInfo" href="${path }/system/system_logInfo.action">日志查询</a></li>
		            </ul>
		          </div>
		        </div>
		      </div>
		    </div>
    	</div>
    	<!-- /left -->
    	<!-- right -->
    	<div class="col-md-9">
    		<ul id="myTab" class="nav nav-tabs">
		  		<li class="active">
		  			<a href="#home" data-toggle="tab"">
		  				欢迎使用
		  			</a>
		  		</li>
		  	</ul>
		  	<div id="myTabContent" class="tab-content">
		  		<div class="tab-panel fade in active" id="home">
		  			welcome!
		  		</div>
		  	</div>
    	</div>
    	<!-- /right -->
    </div>
  </body>
</html>
