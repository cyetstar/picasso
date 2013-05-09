<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<ul class="nav nav-pills">
<c:forEach items="${chapters}" var="chapter">
  <li data-chapter-num="${chapter.num}"><a href="javascript:void(0)" data-chapter-id="${chapter.id}">${chapter.num}</a></li>
</c:forEach>
</ul>

<script type="text/javascript">
<!--
$(function(){
	$('[data-chapter-id]').on('click.data-chapter-id', function(){
		$('#chapter-list li').removeClass('active');
		$(this).parent('li').addClass('active');
		$('[data-toggle="dropdown"] span').text($('#book-list li.active').attr('data-book-title') + ' ' + $('#chapter-list li.active').attr('data-chapter-num'));
		$('#bible-content').load('${ctx}/bible/chapter-content/'+$(this).attr('data-chapter-id'))
		$(this).dropdown('toggle')
	});
})
//-->
</script>