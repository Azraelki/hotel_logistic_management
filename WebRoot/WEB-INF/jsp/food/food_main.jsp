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
		              <span class="glyphicon glyphicon-align-justify"></span>&nbsp;菜品&nbsp;信息<span class="caret"></span>
		            </a>
		          </h4>
		        </div>
		        <div id="collapseOne" class="panel-collapse collapse in">
		          <div class="panel-body">
		            <ul class="nav nav-pills nav-stacked">
		              <li><a title="food_info" href="${path }/food/food_info.action">菜品信息查询</a></li>
		              <li><a title="food_add" href="${path }/food/food_add.action">菜品信息录入</a></li>
		            </ul>
		          </div>
		        </div>
		      </div>
		      <div class="panel panel-warning">
		        <div class="panel-heading">
		          <h4 class="panel-title">
		            <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">
		              <span class="glyphicon glyphicon-align-justify"></span>&nbsp;菜单&nbsp;信息<span class="caret"></span>
		            </a>
		          </h4>
		        </div>
		        <div id="collapseTwo" class="panel-collapse collapse">
		          <div class="panel-body">
		            <ul class="nav nav-pills nav-stacked">
		              <li><a title="foodShow_info" href="${path }/food/foodshow_info.action">菜单信息查询</a></li>
		              <li><a title="foodShow_add" href="${path }/food/foodshow_add.action">菜单信息录入</a></li>
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
