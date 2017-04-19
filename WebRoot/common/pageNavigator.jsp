<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div align="center" id="pagination" title="${pageResult.totalPageCount }" >
	<input type="hidden" value="${path }/">
	<s:if test="pageResult.totalCount > 0">
		<ul class="pagination pagination-sm"  style="margin-top: 0;">
			 <li class="disabled"><a title="${pageResult.pageNo-1 }">&laquo;</a></li>
			 <c:forEach var="num" begin="0" end="5">
			 	<c:if test="${pageResult.pageNo+num <= pageResult.totalPageCount }">
			 		<li><a title="${num+1 }">${num+1 }</a></li>
			 	</c:if>
			 </c:forEach>
			 <li><a title="${pageResult.pageNo+1 }">&raquo;</a></li>
		 </ul> 
	 </s:if>
	 <s:else>暂无数据!</s:else>
</div>
<script>
	$(function(){
		$("#pagination a").click(function(){
			var goalNum = $(this).attr("title");
			var maxNum = $("#pagination").attr("title");
			if(goalNum <= 0){
				$("#pagination a:first").parent().addClass("disabled");
			}else if(goalNum > maxNum){
				$("#pagination a:last").parent().addClass("disabled");
			}else{
				$("#pagination li").removeClass("disabled");
				$(this).parent().addClass("disabled");
				var url = $("#list_info").attr("title");
				var data = {"pageNo":goalNum,"pageSize":7};
				$.post(url,data);
			}
		});
	});
</script>