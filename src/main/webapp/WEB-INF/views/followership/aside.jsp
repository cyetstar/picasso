<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<c:forEach items="${users.content}" var="user">
  <dl class="avatar-small">
    <dt>
      <a href="${ctx}/${user.screenNameOrId}"><img alt="" src="${ctx}/${user.miniAvatar}"></a>
    </dt>
    <dd>
      <a href="${ctx}/${user.screenNameOrId}">${user.name}</a>
    </dd>
  </dl>
</c:forEach>
