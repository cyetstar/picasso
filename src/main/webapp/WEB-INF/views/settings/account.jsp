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
		$("#account-form").validate();
	});
</script>
</head>

<body>
  <div class="container">
    <div class="row">
      <div class="span9">
        <form id="account-form" action="${ctx}/settings/account" method="post" class="form-horizontal">
          <input type="hidden" name="id" value="${user.id}" />
          <fieldset>
            <legend>
              <small>个性化域名</small>
            </legend>
            <c:if test="${success}">
              <div class="alert alert-block">
                <button type="button" class="close" data-dismiss="alert">&times;</button>
                <strong>操作成功！</strong>你的设置已保存。
              </div>
            </c:if>
            <div class="control-group">
              <label for="screenName" class="control-label">用户名:</label>
              <div class="controls">
                <input type="text" id="screenName" name="screenName" value="${user.screenName}" class="input-large required" />
                <p class="help-block">http://cyetstar.com/xxxx</p>
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
          <li id="account" class="active"><a href="${ctx}/settings/account">个性域名</a></li>
          <li id="passord"><a href="${ctx}/settings/password">密码</a></li>
        </ul>
      </div>
    </div>
  </div>
</body>
</html>
