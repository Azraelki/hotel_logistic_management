<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
  <head>
    <title>user</title>
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
		              <span class="glyphicon glyphicon-align-justify"></span>&nbsp;员&nbsp;工<span class="caret"></span>
		            </a>
		          </h4>
		        </div>
		        <div id="collapseOne" class="panel-collapse collapse in">
		          <div class="panel-body">
		            <ul class="nav nav-pills nav-stacked">
		              <li><a title="user_info" href="${path }/user/employee_info.action">员工信息</a></li>
		              <li><a title="user_add" href="${path }/user/employee_add.action">员工录入</a></li>
		            </ul>
		          </div>
		        </div>
		      </div>
		      <div class="panel panel-warning">
		        <div class="panel-heading">
		          <h4 class="panel-title">
		            <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">
		              <span class="glyphicon glyphicon-align-justify"></span>&nbsp;职&nbsp;务<span class="caret"></span>
		            </a>
		          </h4>
		        </div>
		        <div id="collapseTwo" class="panel-collapse collapse">
		          <div class="panel-body">
		            <ul class="nav nav-pills nav-stacked">
		              <li><a title="job_info" href="${path }/user/job_info.action">职务信息</a></li>
		              <%--<li><a title="job_add" href="${path }/user/job_add.action">职务录入</a></li>--%>
		            </ul>
		          </div>
		        </div>
		      </div>
		      <div class="panel panel-warning">
		        <div class="panel-heading">
		          <h4 class="panel-title">
		            <a data-toggle="collapse" data-parent="#accordion" href="#collapseThree">
		               <span class="glyphicon glyphicon-align-justify"></span>&nbsp;工&nbsp;作&nbsp;状&nbsp;况<span class="caret"></span>
		            </a>
		          </h4>
		        </div>
		        <div id="collapseThree" class="panel-collapse collapse">
		          <div class="panel-body">
		            <ul class="nav nav-pills nav-stacked">
		              <li><a title="work_info" href="${path }/user/work_info.action">员工做房信息</a></li>
		              <li><a title="work_add" href="${path }/user/work_add.action">做房信息录入</a></li>
		              <li><a title="cleanplan_info" href="${path }/user/cleanplan_info.action">计划卫生安排</a></li>
		              <li><a title="cleanplan_add" href="${path }/user/cleanplan_add.action">计划卫生录入</a></li>
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
