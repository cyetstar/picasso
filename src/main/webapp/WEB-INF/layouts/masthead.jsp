<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<div id="masthead">
  <div class="container">
    <h3 id="heading" class="pull-left">静默时间</h3>
    <div id="main-nav">
      <ul class="nav nav-pills pull-left">
        <li id="home"><a href="${ctx}/">首页</a></li>
        <li id="bible"><a href="${ctx}/bible">圣经</a></li>
        <li id="family"><a href="${ctx}/family">弟兄姊妹</a></li>
      </ul>
      <form class="form-search pull-right">
        <div class="input-append">
          <input type="text" class="span2 search-query">
          <button type="submit" class="btn">查询</button>
        </div>
      </form>
    </div>
  </div>
</div>