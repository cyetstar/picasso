<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
<title>兄弟姐妹</title>
<script type="text/javascript">
$(function() {
	$('#family').addClass('active').siblings().removeClass('active');
	$('[data-leader-id]').on('click', function(){
		var thisObj = $(this);
		var follow = thisObj.text() == '关注';
		var url = follow ? '${ctx}/followership/follow' : '${ctx}/followership/unfollow';
		$.post(url, {leaderId : $(this).attr('data-leader-id')}, function(data) {
			if (data.success) {
				follow ? thisObj.text('取消关注') : thisObj.text('关注');
			}
		});
	});
	$('.user-intro .btn').on('click',function() {
		var btn = $(this);
		$.post(btn.attr('href'), function(data) {
			if (data.success) {
				btn.text('取消关注').attr('href', btn.attr('href').replace('/follow','/unfollow'));
			}
		});
		return false;
	})
})
</script>
</head>
<body>
  <div class="container">
      <div id="user-list" class="span9">
        <c:forEach items="${users.content}" var="user">
          <dl class="user-intro">
            <dt>
              <a href="${ctx}/${user.screenNameOrId}"><img alt="头像" src="${ctx}/${user.smallAvatar}" class="avatar-middle" /></a>
            </dt>
            <dd>
              <a href="javascript:void()" class="btn btn-success btn-small" data-leader-id="${user.id}">关注</a>
              <ul class="intro-info">
                <li><a href="${ctx}/${user.screenNameOrId}" class="nickname">${user.name}</a></li>
              </ul>
            </dd>
          </dl>
        </c:forEach>
      </div>
      <div class="span3">
      </div>
  </div>
</body>
</html>