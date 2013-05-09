<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<%
	java.util.Map<String, String> bookMap = org.cyetstar.picasso.utils.DictData.bookMap();
  request.setAttribute("bookDict", bookMap);
%>
<html>
<head>
<title>圣经段落管理</title>
<script type="text/javascript">
	$(function() {
		$('#bible').addClass('active').siblings().removeClass('active');
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
		$('.btn-add, .btn-batch-add').on('click', function(){
			var url = '${ctx}/admin/paragraph/add';
			if($(this).is('.btn-batch-add')){
				url += 'Batch';
			}
			window.location.href = url + '?bookId=' + $('[name="bookId"]').val() + '&chapterId=' + $('[name="chapterId"]').val();
		})
		$('.btn-edit').on('click', function(){
			window.location.href = '${ctx}/admin/paragraph/edit?id=' + $('.selected :hidden').val();
		})
		$('tbody td').on('click', function(){
			$('tbody tr').removeClass('selected');
			$(this).parent().addClass('selected');
		})
	})
	
</script>
</head>
<body>
  <fieldset>
    <legend>
      <small>圣经段落管理</small>
    </legend>
    <form action="${ctx}/admin/paragraph/list" method="post" class="form-horizontal">
      <select name="bookId" style="width: 100px;">
        <option value="">选择书卷</option>
        <c:forEach items="${bookDict}" var="item">
          <option value="${item.key}">${item.value}</option>
        </c:forEach>
      </select> <select name="chapterId" style="width: 100px;">
        <option value="">选择章节</option>
      </select>
      <button class="btn">查询</button>
    </form>
    <div>章节段落概况：</div>
    <table class="table">
      <thead>
        <tr>
          <th>#</th>
          <th>主标题</th>
          <th>次标题</th>
          <th>段落标题</th>
          <th>参考标题</th>
          <th>对话标题</th>
          <th>段类型</th>
          <th>经节范围</th>
        </tr>
      </thead>
      <tbody>
        <c:if test="${paragraphs == null}">
          <tr>
            <td colspan="8"></td>
          </tr>
        </c:if>
        <c:if test="${paragraphs != null && empty paragraphs}">
          <tr>
            <td colspan="8">查无此物！</td>
          </tr>
        </c:if>
        <c:if test="${!empty paragraphs}">
          <c:forEach items="${paragraphs}" var="paragraph" varStatus="st">
            <tr>
              <td>${st.index + 1}<input type="hidden" name="id" value="${paragraph.id}"></td>
              <td>${paragraph.title}</td>
              <td>${paragraph.subtitle}</td>
              <td>${paragraph.sectionTitle}</td>
              <td>${paragraph.relatedTitle}</td>
              <td>${paragraph.dialogTitle}</td>
              <td>${paragraph.type}</td>
              <td>${paragraph.verseNoFrom} - ${paragraph.verseNoTo}</td>
            </tr>
          </c:forEach>
        </c:if>
      </tbody>
    </table>
    <btn class="btn-add btn">创建</btn>
    <btn class="btn-batch-add btn">批建</btn>
    <btn class="btn-edit btn">编辑</btn>
    <btn class="btn-delete btn">删除</btn>
    <btn class="btn-preview btn">预览</btn>
  </fieldset>
</body>
</html>