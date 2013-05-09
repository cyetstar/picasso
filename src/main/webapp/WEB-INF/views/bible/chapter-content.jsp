<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:forEach items="${chapter.paragraphs}" var="paragraph">
  <div class="${paragraph.type}">
    <c:if test="${!empty paragraph.title}">
      <h4>${paragraph.title}</h4>
    </c:if>
    <c:if test="${!empty paragraph.subtitle}">
      <div class="r">${paragraph.subtitle}</div>
    </c:if>
    <c:forEach items="${paragraph.verses}" var="verse">
      <div class="v">
        <span class="l">${verse.num}<c:if test="${!empty verse.num2}">,${verse.num2}</c:if></span> 
        <span class="c">${verse.text}</span>
      </div>
    </c:forEach>
  </div>
</c:forEach>
