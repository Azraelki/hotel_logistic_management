<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
  <head>
    <title>linen</title>
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
		              <span class="glyphicon glyphicon-align-justify"></span>&nbsp;采购&nbsp;处理<span class="caret"></span>
		            </a>
		          </h4>
		        </div>
		        <div id="collapseOne" class="panel-collapse collapse in">
		          <div class="panel-body">
		            <ul class="nav nav-pills nav-stacked">
		              <li><a title="linen_fInfo" href="${path }/linen/linen_fInfo.action">采购单处理</a></li>
		            </ul>
		          </div>
		        </div>
		      </div>
		      <div class="panel panel-warning">
		        <div class="panel-heading">
		          <h4 class="panel-title">
		            <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">
		              <span class="glyphicon glyphicon-align-justify"></span>&nbsp;物品&nbsp;采购<span class="caret"></span>
		            </a>
		          </h4>
		        </div>
		        <div id="collapseTwo" class="panel-collapse collapse">
		          <div class="panel-body">
		            <ul class="nav nav-pills nav-stacked">
		              <li><a title="purchaseorder_info" href="${path }/purchase/purchaseorder_info.action">采购信息查询</a></li>
		              <li><a title="purchaseorder_add" href="${path }/purchase/purchaseorder_add.action">采购信息录入</a></li>
		            </ul>
		          </div>
		        </div>
		      </div>
		      <div class="panel panel-warning">
		        <div class="panel-heading">
		          <h4 class="panel-title">
		            <a data-toggle="collapse" data-parent="#accordion" href="#collapseThree">
		               <span class="glyphicon glyphicon-align-justify"></span>&nbsp;设施&nbsp;消耗&nbsp;<span class="caret"></span>
		            </a>
		          </h4>
		        </div>
		        <div id="collapseThree" class="panel-collapse collapse">
		          <div class="panel-body">
		            <ul class="nav nav-pills nav-stacked">
		              <li><a title="facilitieuse_info" href="${path }/purchase/facilitieuse_info.action">消耗信息查询</a></li>
		              <li><a title="facilitieuse_add" href="${path }/purchase/facilitieuse_add.action">消耗信息录入</a></li>
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
