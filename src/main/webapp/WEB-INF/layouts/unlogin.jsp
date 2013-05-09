<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<title><sitemesh:title /></title>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<meta http-equiv="Cache-Control" content="no-store" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />

<link type="image/x-icon" href="${ctx}/static/images/favicon.ico" rel="shortcut icon">
<link href="${ctx}/static/bootstrap/2.3.1/css/bootstrap.css" type="text/css" rel="stylesheet" />
<link href="${ctx}/static/jquery-validation/1.10.0/validate.css" type="text/css" rel="stylesheet" />
<link href="${ctx}/static/styles/default.css" type="text/css" rel="stylesheet" />
<script src="${ctx}/static/jquery/jquery-1.8.3.js" type="text/javascript"></script>
<script src="${ctx}/static/jquery-validation/1.10.0/jquery.validate.min.js" type="text/javascript"></script>
<script src="${ctx}/static/jquery-validation/1.10.0/messages_bs_zh.js" type="text/javascript"></script>
<script src="${ctx}/static/javascript/jquery.form.js" type="text/javascript"></script>

<sitemesh:head />
</head>

<body>
  <%@ include file="/WEB-INF/layouts/header.jsp"%>
  <div id="masthead">
    <div class="container">
      <h3 id="heading" class="pull-left">静默时间</h3>
      <div id="main-nav">
        <blockquote>
          <p>耶稣说：“我是世界的光；跟从我的，就不在黑暗里走，必要得着生命的光。”</p>
          <small>约翰福音 8:12</small>
        </blockquote>
      </div>
    </div>
  </div>
  <sitemesh:body />
  <%@ include file="/WEB-INF/layouts/footer.jsp"%>
  <script src="${ctx}/static/bootstrap/2.3.1/js/bootstrap.js" type="text/javascript"></script>
</body>
</html>