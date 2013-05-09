<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
<title>首页</title>
<script type="text/javascript">
	$(function() {
		$("#home").addClass("active").siblings().removeClass("active");
		$("#posts-list").load("${ctx}/posts/following-list");
		$("#friends .aside-content").load("${ctx}/followership/following-aside");
		$('a[data-collection-id]').on('click', function(){
			$('.collection-dropdown > .dropdown-toggle').text($(this).text()).append('<b class="caret"></b>');
			$("#posts-list").load("${ctx}/posts/following-list?collectionId=" + $(this).attr('data-collection-id'));
		});
		$('.open-dropdown .dropdown-menu > li > a').on('click', function(){
			$(':hidden[name="open"]').val($(this).attr('data-open'));
			$('.open-dropdown .btn:first-child').text($(this).text());
		});
	});
</script>
</head>
<body>
  <div class="container">
    <div class="row">
      <div class="span9">
        <div id="user-index-header" class="overhead">
          <dl class="avatar-large pull-left">
            <dt>
              <a href="${ctx}/<shiro:principal property="screenName" />"><img alt="头像" src="${ctx}/static/avatar/large/<shiro:principal property="avatar"/>" class="img-polaroid" /></a>
            </dt>
            <dd>
              <a href="${ctx}/<shiro:principal property="screenName" />"><shiro:principal property="name" /></a>
            </dd>
          </dl>
          <form id="post-form" action="${ctx}/posts/create" method="post" onsubmit="return false;">
            <input type="hidden" name="open" value="true" />
            <input type="text" name="title" class="input-xlarge" placeholder="分享主题" /> 
            <input type="text" name="tokenString" class="input-xlarge" placeholder="引用圣经经文，如：约 4:11" />
            <textarea rows="3" name="content" style="width:480px" placeholder="分享正文"></textarea>
            <div class="open-dropdown btn-group">
              <button class="btn">公开</button>
              <button class="btn dropdown-toggle" data-toggle="dropdown">
                <span class="caret"></span>
              </button>
              <ul class="dropdown-menu">
                <li><a href="javascript:void()" data-open="true">公开</a></li>
                <li><a href="javascript:void()" data-open="false">保密</a></li>
              </ul>
            </div>
            <button name="publish" class="pull-right btn btn-success" onclick="this.form.submit();">发布</button>
          </form>
        </div>
        <div id="posts">
          <c:if test="${!empty followershipCollections}">
            <div class="collection-dropdown dropdown pull-right">
            <a class="dropdown-toggle" data-toggle="dropdown" href="#">全部<b class="caret"></b></a>
              <ul class="dropdown-menu ">
                <li class="disabled"><a href="#">选择分组查看</a></li>
                <li class="divider"></li>
                <li><a href="javascript:void();" data-collection-id="-1">全部</a></li>
                <c:forEach items="${followershipCollections}" var="collection">
                  <li><a href="javascript:void();" data-collection-id="${collection.id}">${collection.name}</a></li>
                </c:forEach>
              </ul>
             </div>
          </c:if>
           <div id="posts-list"></div>
         </div>
      </div>
      <div class="span3">
        <div id="friends" class="aside-block">
         <h3 class="aside-heading">我的关注</h3>
         <div class="aside-content">
         </div>
        </div>
      </div>
    </div>
  </div>
</body>
</html>