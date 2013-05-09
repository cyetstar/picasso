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
var i = 1;
$(function() {
	  $('[name="bookId"]').on('change', function(){
	  	$('[name="chapterId"] option:first-child').nextAll().remove();
	  	if($(this).val()!=''){
	  		$.ajax({url:'${ctx}/admin/chapter/list?bookId='+$(this).val(), dataType:'json', success:function(data){
	  			$.each(data.data, function(i, item){
	  				var option = $('<option value="' + item.id + '">' + item.num + '</option>')
	  				if(item.id == '${param.chapterId}'){
	  					option.attr('selected', 'selected');
	  				}
	  				$('[name="chapterId"]').append(option);
	  			})
	  		}})
	  	}
	  })
	  $('[name="bookId"]').val('${param.bookId}').trigger('change');
	  $('.btn-more').on('click', function(){
		  var bound = $('.verse-bound:first').clone();
		  bound.find('span.help-inline').remove();
		  bound.find(':input').val('');
		  bound.find('label span').text("#" + ++i);
		  $('.form-actions').before(bound);
		  return false;
	  })
});
</script>
</head>
<body>
  <fieldset>
    <legend>
      <small>圣经段落管理</small>
    </legend>
    <form action="${ctx}/admin/paragraph/${action}" method="post" onsubmit="return false;" class="form-horizontal">
      <div class="control-group">
        <label class="control-label">圣经章节 </label>
        <div class="controls">
          <select name="bookId" style="width: 105px;">
            <option value="">选择书卷</option>
            <c:forEach items="${bookDict}" var="item">
              <option value="${item.key}">${item.value}</option>
            </c:forEach>
          </select> 
          <select name="chapterId" style="margin-left:7px; width: 105px;">
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
              <option value="${item.key}">${item.value}</option>
            </c:forEach>
          </select> 
        </div>
      </div>
      <div class="verse-bound control-group">
        <label class="control-label">经节起止 <span>#1</span></label>
        <div class="controls">
          <input type="text" name="verseNoFrom" value="${verseNoFrom}" style="width: 91px;"/>
          <span> - </span>
          <input type="text" name="verseNoTo" value="${verseNoTo}" style="width: 91px;"/>
          <span class="help-inline"><a href="javascript:void()" class="btn-more btn-link btn">添加更多“经节起止”</a></span>
        </div>
      </div>
      <div class="form-actions">
        <button class="btn-success btn" onclick="this.form.submit()">保存</button>
        <button class="btn">返回</button>
      </div>
    </form>
  </fieldset>
</body>
</html>