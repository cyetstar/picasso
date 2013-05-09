<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
<title>首页</title>
<script type="text/javascript">
  $(function() {
    $("#friends .aside-content").load("${ctx}/followership/following-aside?userId=${user.id}");
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
    $('.remark-follow').on('click',function(){
    	$('#remark-follow-modal').find('.modal-body p').text('loading...').end().modal('show');
    	$('#remark-follow-modal').load('followership/remark?leaderId=${user.id}');
    })
  })
</script>
</head>
<body>
  <div class="container">
    <div class="row">
      <div class="span9">
          <div id="user-home-header" class="overhead">
          <dl class="user-intro">
            <dt>
              <a href="${ctx}/${user.screenNameOrId}/profile"><img alt="头像" src="${ctx}/${user.largeAvatar}" class="avatar-large img-polaroid" /></a>
            </dt>
            <dd>
              <ul class="intro-info">
                <li class="heading">
                  <a href="${ctx}/${user.screenNameOrId}" class="title">${user.name}</a>
                  <c:if test="${!myself}">
                  <span class="remark-follow muted">${followership.remark}<c:if test="${!empty followership.followershipCollections}"> - </c:if>
                  <c:forEach items="${followership.followershipCollections}" var="collection">
                   ${collection.name}  
                  </c:forEach>
                  <i class="opacity-50 icon-wrench"></i>
                  </span>
                  </c:if>
                </li>
                <li>
                  <p>${user.profile.aboutMe}</p>
                </li>
              </ul>
              <c:if test="${!myself}">
              <a class="btn btn-success pull-right" data-leader-id="${user.id}"><c:if test="${!empty followership}">取消</c:if>关注</a>
              </c:if>
            </dd>
          </dl>
        </div>
          <div id="posts">
            <%@ include file="list.jsp"%>
          </div>
      </div>
      <div class="span3">
       <div id="friends" class="aside-block">
       <h3 class="aside-heading">
       <c:if test="${!myself}">${user.name}的关注</c:if>
       <c:if test="${myself}">我的关注</c:if>
       </h3>
       <div class="aside-content">
       </div>
      </div>
      </div>
    </div>
  </div>
  <div id="remark-follow-modal" class="modal hide fade custom" tabindex="-1" role="dialog"
    aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-header">
      <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
      <h5 class="heading">设置备注名、分组</h5>
    </div>
    <div class="modal-body">
      <p>loading...</p>
    </div>
    <div class="modal-footer">
    </div>
  </div>
</body>
</html>