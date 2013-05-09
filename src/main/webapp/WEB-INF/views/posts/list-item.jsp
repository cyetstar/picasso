<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div class="post row-fluid">
  <div class="span2">
    <dl class="avatar-middle">
      <dt>
        <a href="${ctx}/${post.user.screenNameOrId}"><img alt="头像" src="${ctx}/${post.user.smallAvatar}" /></a>
      </dt>
      <dd>
        <a href="${ctx}/${post.user.screenNameOrId}">${post.user.name}</a>
      </dd>
    </dl>
  </div>
  <div class="post-content span10">
    <span>${post.title}</span>
    <c:if test="${!empty post.tokens}">
      <div class="tokens">
        <c:forEach items="${post.tokens}" var="token">
          <span class="label label-success" data-token-id="${token.id}">${token.name}</span>
        </c:forEach>
      </div>
    </c:if>
    <p>${post.content}</p>
    <span class="muted"><tag:datetime value="${post.createdAt}"/></span>
  </div>
</div>
<div id="token-modal" class="modal hide fade custom" tabindex="-1" role="dialog">
  <div class="modal-header"></div>
  <div class="modal-body">
    <p>loading...</p>
  </div>
  <div class="modal-footer"></div>
</div>
<script type="text/javascript">
<!--
$('[data-token-id]').on('click',function(){
	$('#token-modal').find('.modal-body p').text('loading...').end().modal('show');
	$('#token-modal').load('bible/token-content/' + $(this).attr('data-token-id'));
})
//-->
</script>