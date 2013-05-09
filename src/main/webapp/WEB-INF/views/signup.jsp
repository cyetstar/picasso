<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
<title>注册</title>
<script type="text/javascript">
$(document).ready(function() {
	$("#signup-form").validate({
		rules: {
			loginName: {
				remote: "${ctx}/signup/checkLoginName"
			}
		},
		messages: {
			loginName: {
				remote: "帐号已存在"
			}
		}
	});
});
</script>
</head>

<body>
     <form id="signup-form" class="window-form" action="${ctx}/signup" method="post" >
      <h4>注册<small>已经有帐号，请<a href="${ctx}/login">点击登录</a>。</small></h4>
      <label for="loginName" class="control-label">帐号:</label>
      <input type="text" id="loginName" name="loginName" class="input-block-level required email" placeholder="请输入邮箱地址"/>
      <label for="name" class="control-label">用户名:</label>
      <input type="text" id="name" name="name" class="input-block-level required"/>
      <label for="plainPassword" class="control-label">密码:</label>
	  <input type="password" id="plainPassword" name="plainPassword" class="input-block-level required"/>
      <label for="confirmPassword" class="control-label">确认密码:</label>
      <input type="password" id="confirmPassword" name="confirmPassword" class="input-block-level required" equalTo="#plainPassword"/>
      <div>
      <button class="btn btn-success" type="submit">注册</button>&nbsp;
      <button class="btn" type="button" onclick="history.back()">返回</button>
      </div>
    </form>
</body>
</html>
