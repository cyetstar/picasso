<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<div id="header" class="navbar navbar-inverse navbar-static-top">
  <div class="navbar-inner ">
    <ul class="nav pull-right">
      <shiro:guest>
        <li><a href="${ctx}/login">登录</a></li>
        <li><a href="${ctx}/signup">注册</a></li>
      </shiro:guest>
      <shiro:user>
        <shiro:hasRole name="admin">
          <li><a href="${ctx}/">首页</a></li>
          <li><a href="${ctx}/admin/">管理员</a></li>
        </shiro:hasRole>
        <li class="divider"></li>
        <li><a href="${ctx}/settings/profile"><shiro:principal property="name"/></a></li>
        <li><a href="${ctx}/logout">退出</a></li>
      </shiro:user>
    </ul>
  </div>
</div>