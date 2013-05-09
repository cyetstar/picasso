<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
<title>登录</title>

<script type="text/javascript">
	$(document).ready(function() {
		$("#login-form").validate();
	});
</script>
<style type="text/css">
body {
  
}
</style>
</head>

<body>
  <div class="container">
    <form id="login-form" class="window-form" action="${ctx}/login" method="post">
      <h4>登录<small>如果忘记用户名，请<a href="#">点击取回</a>。</small></h4>
      <c:if test="${!empty requestScope.shiroLoginFailure}">
        <div class="alert alert-error">
          <button class="close" data-dismiss="alert">×</button>
          <span>登录失败，请重试。</span>
        </div>
      </c:if>
      <label for="username" class="control-label">帐号:</label> 
      <input type="text" id="username" name="username" value="${username}" class="input-block-level required" placeholder="邮箱地址" /> 
      <label for="password"  class="control-label">密码:</label> 
      <input type="password" name="password" class="input-block-level required">
      <label class="checkbox" for="rememberMe"><input type="checkbox" name="rememberMe" value="true">下次自动登录</label>
      <button class="btn btn-success" type="submit">登录</button>
    </form>
  </div>
</body>
</html>