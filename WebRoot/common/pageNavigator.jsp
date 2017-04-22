<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div align="center" id="pagination" title="${pageResult.totalPageCount }" >
	<input type="hidden" value="${path }/">
	<s:if test="pageResult.totalCount > 0">
		<ul class="pagination pagination-sm"  style="margin-top: 0;">
			<c:choose>
 				<c:when test="${pageNo <= 1 }">
 					<li class="disabled"><a title="${pageNo-1 }">&laquo;</a></li>
 				</c:when>
 				<c:otherwise><li><a title="${pageNo-1 }">&laquo;</a></li></c:otherwise>
 			</c:choose>
		 	<c:if test="${pageNo-3 >= 1 }">
		 		<li><a title="${pageNo-3 }">${pageNo-3 }</a></li>
		 	</c:if>
		 	<c:if test="${pageNo-2 >= 1 }">
		 		<li><a title="${pageNo-2 }">${pageNo-2 }</a></li>
		 	</c:if>
		 	<c:if test="${pageNo-1 >= 1 }">
		 		<li><a title="${pageNo-1 }">${pageNo-1 }</a></li>
		 	</c:if>
			 <c:forEach var="num2" begin="${pageNo }" end="${pageNo+4 }">
		 		<c:if test="${num2 <= pageResult.totalPageCount }">
		 			<c:if test=""></c:if>
		 			<c:choose>
		 				<c:when test="${num2 == pageNo }">
		 					<li class="active"><a title="${num2 }">${num2 }</a></li>
		 				</c:when>
		 				<c:otherwise><li><a title="${num2 }">${num2 }</a></li></c:otherwise>
		 			</c:choose>
			 	</c:if>
			 </c:forEach>
			 <c:choose>
 				<c:when test="${pageNo >= pageResult.totalPageCount }">
 					<li class="disabled"><a title="${pageNo+1 }">&raquo;</a></li>
 				</c:when>
 				<c:otherwise> <li><a title="${pageNo+1 }">&raquo;</a></li></c:otherwise>
 			</c:choose>
		 </ul> 
	 </s:if>
	 <s:else>暂无数据!</s:else>
</div>
<script>
	$(function(){
		$("#pagination a").click(function(){
			var goalNum = $(this).attr("title");
			var maxNum = $("#pagination").attr("title");
			if(goalNum >= 1 && goalNum <= maxNum){
				var url = $("#list_info").attr("title");
				var data = {"pageNo":goalNum,"pageSize":7};
				url = url+"?pageNo="+goalNum+"&pageSize="+7;
				$("#list_info").attr("action",url);
				$("#list_info").submit();
			}
		});
	});
</script>