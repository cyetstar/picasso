<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
<title>资料修改</title>

<script>
	$(document).ready(function() {
		//聚焦第一个输入框
		$("#name").focus();
		//为inputForm注册validate函数
		$("#password-form").validate();
	});
</script>
</head>

<body>
  <div class="container">
    <div class="row">
      <div class="span9">
        <form id="password-form" action="${ctx}/settings/password" method="post" class="form-horizontal">
          <fieldset>
            <legend>
              <small>密码</small>
            </legend>
            <c:if test="${success}">
              <div class="alert alert-block">
                <button type="button" class="close" data-dismiss="alert">&times;</button>
                <strong>操作成功！</strong>你的设置已保存。
              </div>
            </c:if>
            <div class="control-group">
              <label for="oldPassword" class="control-label">当前密码:</label>
              <div class="controls">
                <input type="password" id="oldPassword" name="oldPassword" class="input-large" />
              </div>
            </div>
            <div class="control-group">
              <label for="plainPassword" class="control-label">密码:</label>
              <div class="controls">
                <input type="password" id="plainPassword" name="plainPassword" class="input-large" />
              </div>
            </div>
            <div class="control-group">
              <label for="confirmPassword" class="control-label">确认密码:</label>
              <div class="controls">
                <input type="password" id="confirmPassword" name="confirmPassword" class="input-large" equalTo="#plainPassword" />
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
          <li id="profile"><a href="${ctx}/settings/profile">个人资料</a></li>
          <li id="avatar"><a href="${ctx}/settings/avatar">头像</a></li>
          <li id="account"><a href="${ctx}/settings/account">个性域名</a></li>
          <li id="passord" class="active"><a href="${ctx}/settings/password">密码</a></li>
        </ul>
      </div>
    </div>
  </div>
</body>
</html>
