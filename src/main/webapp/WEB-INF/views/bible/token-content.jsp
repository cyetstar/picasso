<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div class="modal-header">
  <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
  <h5>${token.fullName}</h5>
</div>
<div id="bible-content" class="modal-body">
  <c:forEach items="${token.verses}" var="verse">
    <div class="v">
      <span class="l">${verse.num}</span> <span class="c">${verse.text}</span>
    </div>
  </c:forEach>
  <div class="read-more text-center">
    <button class="btn" data-chapter-id="${token.chapter.id}" data-chapter-num="${token.chapter.num}" data-book-title="${token.book.title}">阅读整章圣经</button>
  </div>
</div>
<div class="modal-footer"></div>
<script type="text/javascript">
<!--
	$('.read-more .btn').on('click',function() {
		$('#token-modal .modal-header h5').text($(this).attr('data-book-title') + ' ' + $(this).attr('data-chapter-num'))
		$('#bible-content').load('bible/chapter-content/'+ $(this).attr('data-chapter-id'));
	})
//-->
</script>