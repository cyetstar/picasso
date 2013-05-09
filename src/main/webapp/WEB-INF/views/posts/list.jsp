<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<c:forEach items="${posts.content}" var="post">
  <%@ include file="list-item.jsp"%>
</c:forEach>
<ul class="pager">
  <c:if test="${!posts.firstPage}">
  <li class="previous"><a href="" data-page="${page-1}">上一页</a></li>
  </c:if>
  <c:if test="${!posts.lastPage}">
  <li class="next"><a href="#" data-page="${page+1}">下一页</a></li>
  </c:if>
</ul>
<script type="text/javascript">
<!--
$('.pager > li > a').on('click', function(){
	$('#posts').load($(this).attr('href'));
	return false;
})
//-->
</script>