<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div class="modal-header">
  <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
  <h5 class="heading">设置备注名、分组</h5>
</div>
<div class="modal-body">
  <form id="remark-followership-form" action="${ctx}/followership/remark" method="post" class="form-horizontal">
    <input type="hidden" name="id" value="${followership.id}"/>
    <div class="control-group">
      <label for="remark" class="control-label">备注名</label>
      <div class="controls">
        <input type="text" id="remark" name="remark" value="${followership.remark}" class="input-large" />
      </div>
    </div>
    <fieldset>
      <legend><small>选择分组</small></legend>
      <ul class="followership-collection">
        <c:forEach items="${followershipCollections}" var="followershipCollection">
        <li><label class="checkbox"> <input type="checkbox" name="collectionIds" 
        <c:forEach items="${followership.followershipCollections}" var="checkedCollection">
        <c:if test="${checkedCollection.id == followershipCollection.id}">
          checked="checked" 
        </c:if>
        </c:forEach>
        value="${followershipCollection.id}" />${followershipCollection.name}</label></li>
        </c:forEach>
      </ul>
    </fieldset>
  </form>
  <form id="new-collection-form" action="${ctx}/followership/collection/create" method="post" class="form-inline hide">
      <input type="text" name="name" placeholder="填写分组名称" />
      <button class="btn btn-success btn-small">保存</button> 
      <input type="reset" class="btn btn-link btn-small" value="取消" />
  </form>
  <div class="new-collection-btn">
    <button class="btn btn-small">新建分组</button>
  </div>
</div>
<div class="modal-footer">
  <button class="btn btn-primary">保存设置</button>
  <button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
</div>
<script type="text/javascript">
<!--
$('#remark-followership-form').ajaxForm({
	dataType: 'json',
	success: function(data){
		if(data.success){
			$('#remark-follow-modal').modal('hide');
		}
	}
});
$('#remark-follow-modal .btn-primary').on('click',function(){
	$('#remark-followership-form').submit();
})
$('#new-collection-form').ajaxForm({
	dataType: 'json',
	success: function(data){
		if(data.success){
			var checkbox = $('<input type="checkbox" name="followershipCollection"/>').val(data.data.id).attr('checked', true);
			var label = $('<label class="checkbox"/>').append(checkbox).append(data.data.name);
			var li = $('<li/>').append(label);
			$('ul.followership-collection').append(li);
		}
		$('#new-collection-form :reset').trigger('click');
	}
});
$('.new-collection-btn button').on('click', function(){
	$('.new-collection-btn').hide();
	$('#new-collection-form').show();
})
$('#new-collection-form :reset').on('click', function(){
	$('.new-collection-btn').show();
	$('#new-collection-form').hide();
})
//-->
</script>