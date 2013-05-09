<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<%
	java.util.Map<String, String> bookMap = org.cyetstar.picasso.utils.DictData.bookMap();
    java.util.Map<String, String> paragraphTypeMap = org.cyetstar.picasso.utils.DictData.paragraphTypeMap();
	request.setAttribute("bookDict", bookMap);
	request.setAttribute("paragraphTypeDict", paragraphTypeMap);
%>
<html>
<head>
<title>圣经段落管理</title>
<script type="text/javascript">
$(function() {
	  $('[name="chapter.book.id"]').on('change', function(){
	  	$('[name="chapter.id"] option:first').nextAll().remove();
	  	if($(this).val()!=''){
	  		$.ajax({url:'${ctx}/admin/chapter/list?bookId='+$(this).val(), dataType:'json', success:function(data){
	  			$.each(data.data, function(i, item){
	  				var option = $('<option value="' + item.id + '">' + item.num + '</option>')
	  				if(item.id == ('${param.chapterId}'||'${paragraph.chapter.id}')){
	  					option.attr('selected', 'selected');
	  				}
	  				$('[name="chapter.id"]').append(option);
	  			})
	  		}})
	  	}
	  })
	  $('[name="chapter.book.id"]').val('${param.bookId}'||'${paragraph.chapter.book.id}').trigger('change');
});
</script>
</head>
<body>
  <fieldset>
    <legend>
      <small>圣经段落管理</small>
    </legend>
    <form action="${ctx}/admin/paragraph/${action}" method="post" class="form-horizontal">
      <input type="hidden" name="id" value="${paragraph.id}"/>
      <div class="control-group">
        <label class="control-label">圣经章节 </label>
        <div class="controls">
          <select name="chapter.book.id" style="width: 105px;">
            <option value="">选择书卷</option>
            <c:forEach items="${bookDict}" var="item">
              <option value="${item.key}">${item.value}</option>
            </c:forEach>
          </select> 
          <select name="chapter.id" style="margin-left:7px; width: 105px;">
            <option value="">选择章节</option>
          </select>
        </div>
      </div>
      <div class="control-group">
        <label class="control-label">段类型 </label>
        <div class="controls">
          <select name="type">
            <option value="">选择段类型</option>
            <c:forEach items="${paragraphTypeDict}" var="item">
              <option <c:if test="${paragraph.type == item.key}">selected="selected"</c:if> value="${item.key}">${item.value}</option>
            </c:forEach>
          </select> 
        </div>
      </div>
      <div class="control-group">
        <label class="control-label">经节起止</label>
        <div class="controls">
          <input type="text" name="verseNoFrom" value="${paragraph.verseNoFrom}" style="width: 91px;"/>
          <span> - </span>
          <input type="text" name="verseNoTo" value="${paragraph.verseNoTo}" style="width: 91px;"/>
        </div>
      </div>
      <div class="control-group">
        <label class="control-label">主标题 </label>
        <div class="controls">
          <input type="text" name="title" value="${paragraph.title}" />
        </div>
      </div>
      <div class="control-group">
        <label class="control-label">次标题 </label>
        <div class="controls">
          <input type="text" name="subtitle" value="${paragraph.subtitle}" />
        </div>
      </div>
      <div class="control-group">
        <label class="control-label">段落标题 </label>
        <div class="controls">
          <input type="text" name="sectionTitle" value="${paragraph.sectionTitle}" />
        </div>
      </div>
      <div class="control-group">
        <label class="control-label">参考标题 </label>
        <div class="controls">
          <input type="text" name="relatedTitle" value="${paragraph.relatedTitle}" />
        </div>
      </div>
      <div class="control-group">
        <label class="control-label">对话标题 </label>
        <div class="controls">
          <input type="text" name="dialogTitle" value="${paragraph.dialogTitle}" />
        </div>
      </div>
      <div class="form-actions">
        <button class="btn-success btn">保存</button>
        <button class="btn">返回</button>
      </div>
    </form>
  </fieldset>
</body>
</html>