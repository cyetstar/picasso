<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
<title>资料修改</title>

<script>
	$(document).ready(function() {
		//聚焦第一个输入框
		$("#name").focus();
		//为inputForm注册validate函数
		$("#profile-form").validate();
	});
</script>
</head>

<body>
  <div class="container">
    <div class="row">
      <div class="span9">
        <form id="profile-form" action="${ctx}/settings/profile" method="post" class="form-horizontal">
          <input type="hidden" name="id" value="${profile.id}" /> 
          <input type="hidden" name="user.id" value='<shiro:principal property="id"/>' />
          <fieldset>
            <legend>
              <small>个人资料</small>
            </legend>
            <c:if test="${success}">
              <div class="alert alert-block">
                <button type="button" class="close" data-dismiss="alert">&times;</button>
                <strong>操作成功！</strong>你的设置已保存。
              </div>
            </c:if>
            <div class="control-group">
              <label for="name" class="control-label">全名:</label>
              <div class="controls">
                <input type="text" id="name" name="user.name" value="<shiro:principal property="name" />" class="input-large required" />
                <p class="help-block">取个好名字让别人记得你?</p>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">性别:</label>
              <div class="controls">
                <c:choose>
                  <c:when test="${profile.gender eq '1'}">
                    <label class="radio inline"><input type="radio" name="gender" value="1" checked="checked">男</label>
                    <label class="radio inline"><input type="radio" name="gender" value="2">女</label>
                  </c:when>
                  <c:when test="${profile.gender eq '2'}">
                    <label class="radio inline"><input type="radio" name="gender" value="1">男</label>
                    <label class="radio inline"><input type="radio" name="gender" value="2" checked="checked">女</label>
                  </c:when>
                  <c:otherwise>
                    <label class="radio inline"><input type="radio" name="gender" value="1">男</label>
                    <label class="radio inline"><input type="radio" name="gender" value="2">女</label>
                  </c:otherwise>
                </c:choose>
              </div>
            </div>
            <div class="control-group">
              <label for="brithday" class="control-label">生日:</label>
              <div class="controls">
                <input type="text" id="brithday" name="brithday" class="input-large" value="${profile.brithday}" />
                <p class="help-block">生日格式 19990101</p>
              </div>
            </div>
            <div class="control-group">
              <label for="location" class="control-label">位置:</label>
              <div class="controls">
                <input type="text" id="location" name="location" class="input-large" value="${profile.location}" />
                <p class="help-block">你在什么地方?</p>
              </div>
            </div>
            <div class="control-group">
              <label for="confirmPassword" class="control-label">介绍:</label>
              <div class="controls">
                <textarea name="aboutMe" rows="3" class="input-large">${profile.aboutMe}</textarea>
                <p class="help-block">用一两句话描述你自己。</p>
              </div>
            </div>
            <div class="form-actions background-none">
              <input id="submit_btn" class="btn btn-primary" type="submit" value="保存更改" />
            </div>
          </fieldset>
        </form>
      </div>
      <div class="span3">
        <ul class="nav nav-pills nav-stacked aside-block">
          <li id="profile" class="active"><a href="${ctx}/settings/profile">个人资料</a></li>
          <li id="avatar"><a href="${ctx}/settings/avatar">头像</a></li>
          <li id="account"><a href="${ctx}/settings/account">个性域名</a></li>
          <li id="passord"><a href="${ctx}/settings/password">密码</a></li>
        </ul>
      </div>
    </div>
  </div>
</body>
</html>
