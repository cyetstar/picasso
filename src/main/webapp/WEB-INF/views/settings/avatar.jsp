<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
<title>上传头像</title>
<link href="${ctx}/static/jquery-jcrop/jquery.Jcrop.min.css" type="text/css" rel="stylesheet" />
<script src="${ctx}/static/jquery-jcrop/jquery.Jcrop.js" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#origin').Jcrop({
			onChange : showPreview,
			onSelect : showPreview,
			aspectRatio : 1
		});
		
		$(":file").on("change", function(){
			var name = $(this).val();
			name = name.substring(name.lastIndexOf("\\")+1, name.length);
			$("#file-name-to-upload").text(name);
		})
	});
	function showPreview(coords) {
		if (parseInt(coords.w) > 0) {
			var widgetSize = this.getWidgetSize();
			var rx = 130 / coords.w;
			var ry = 130 / coords.h;
			$('#preview').css({
				maxWidth: "inherit",
				width : Math.round(widgetSize[0] * rx) + 'px',
				height : Math.round(widgetSize[1] * ry) + 'px',
				marginLeft : '-' + Math.round(rx * coords.x) + 'px',
				marginTop : '-' + Math.round(ry * coords.y) + 'px'
			});
			$("input[name='x']").val(coords.x);
			$("input[name='y']").val(coords.y);
			$("input[name='x2']").val(coords.x2);
			$("input[name='y2']").val(coords.y2);
			$("input[name='w']").val(coords.w);
			$("input[name='h']").val(coords.h);
		}
	}
</script>
<style type="text/css">
</style>
</head>

<body>
  <div class="container">
    <div class="row">
      <div class="span9">
        <form id="upload-form" action="${ctx}/settings/avatar/upload" enctype="multipart/form-data" method="post"  class="form-horizontal">
        <fieldset>
          <legend>
            <small>头像</small>
          </legend>
          <c:if test="${success}">
            <div class="alert alert-block">
              <button type="button" class="close" data-dismiss="alert">&times;</button>
              <strong>操作成功！</strong>你的设置已保存。
            </div>
          </c:if>
            <div class="control-group">
              <span class="control-label">1. 选择喜欢的照片</span>
              <div class="controls">
                <div class="btn btn-success input-file-container">
                  <span>添加照片</span>
                  <input type="file" name="file" class="input-file" /> 
                </div>
                <span id="file-name-to-upload"></span>
                <div id="upload-btn-container">
                  <input type="submit" value="上传照片" class="btn" />
                </div>
                <div class="help-block">你可以上传JPG、JPEG、GIF、PNG或BMP文件。</div>
              </div>
            </div>
            </fieldset>
          </form>
         
          <form id="crop-form" action="${ctx}/settings/avatar" method="post" class="form-horizontal">
            <input type="hidden" name="x" /> <input type="hidden" name="y" />
            <input type="hidden" name="x2" /> <input type="hidden" name="y2" />
            <input type="hidden" name="w" /> <input type="hidden" name="h" />
            <div class="control-group">
              <span class="control-label">2. 编辑上传的照片</span>
              <div class="controls">
                <div id="avatar-crop-area">
                <div id="avatar-origin">
                  <c:choose>
                    <c:when test="${!empty avatar}">
                      <img id="origin" src="${ctx}/static/avatar/origin/${avatar}" />
                    </c:when>
                    <c:otherwise>
                      <img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAASwAAAEsCAYAAAB5fY51AAAElElEQVR42u3bvWoqQRiA4dz/pfgHCmKjhYWVlY2VrYgi3sKGDXwymbjqnqPuxjzFU2SZ4LBkXnYm68fpdCoAfoMPNwEQLADBAgQLQLAABAsQLADBAhAsQLAABAtAsADBAhAsAMECBAtAsAAECxAsAMECECxAsAAEC0CwAMECECwAwQIEC0CwAMFyEwDBAhAsQLAABAtAsADBAhAsAMECBAtAsAAECxAsAMECECxAsAAEC0CwAMECECwAwQIEC0CwAAQLECwAwQIQLECwAAQLECw3ARAsAMECBAtAsAAECxAsAMECECxAsAAEC0CwAMECECwAwQIEC0CwAAQLECwAwQIQLECwAAQLQLAAwQIQLADBAgQLQLAAwXIjAMECECxAsAAEC0CwAMECECwAwQIEC0CwAAQLECwAwQIQLECwAAQLQLAAwQIQLADBAgQLQLAABAsQLADBAhAsQLAABAsQLADBAhAsQLAABAtAsADBAhAsAMECBAtAsAAECxAsAMECECxAsAAEC0CwAMECECwAwQIEC0CwuM/hcCj6/X7R6XS+dLvdYrvdVo7fbDZFr9c7j1+v1w8Z+67zRbB4YKwGg8F5wUcMqiKwWq2+FvJyufy2wOPnfx37rvNFsHig2Wz2Y6HnCzd/spnP59+uLxaLH8GoM/ad54tg8WRVTxbl4r20TYrx6WKvM/avzRfB4oGm02kxGo2K/X5/vnY8HovxeHzxaSOeTuJ36oz9i/NFsHiAWLiXnjSuLdx8wdcZW8YmDrjTA/T0+mQyac18/Z0IFi0QW6KQb4Fia3RtUUc46oxNz6DSazGuaivW5HwRLFoijUcagWcHID43nqbKIN1zbtTUfBEsWnbonm6DXhGA2AYOh8PKbWCb5otg0aKD93SRvuJM6H/i0MR8ESxadqaVnyk9879u6RvsdQPRxHwRLFoUrHwBP/O9pohG+XlxLlUnEq+eL4JFy15vyBfptbfB88VeZ2y8wZ5ei3H3hKKJ+SJYNPil53wrVXXoHU8/+SsJ176bd2tsef6Uf146txjflvkiWDT8omjq1tNE+irBrfG3xl56QfTSvMrt4W63a3y+CBaAYAEIFiBYAIIFIFiAYAEIFiBYAIIFIFiAYAEIFoBgAYIFIFgAggUIFoBgAQgWIFgAggUgWIBgAQgWgGABggUgWACCBQgWgGABCBYgWACCBSBYgGABCBYgWACCBSBYgGABCBaAYAGCBSBYAIIFCBaAYAEIFiBYAIIFIFiAYAEIFoBgAYIFIFgAggUIFoBgAQgWIFgAggUgWIBgAQgWIFgAggUgWIBgAQgWgGABggUgWACCBQgWgGABCBYgWACCBSBYgGABCBaAYAGCBSBYAIIFCBaAYAEIFiBYAIIFIFiAYAEIFiBYAIIFIFiAYAEIFoBgAYIFIFgAggUIFoBgAQgWIFgAggUgWIBgAQgWgGABggUgWACCBQgWgGABCBYgWACCBQiWmwAIFoBgAYIFIFgAggUIFoBgAQgWIFgAggUgWIBgAQgWgGABggUgWACCBQgWgGABCBYgWACCBSBYgGABPNsnGpPk69IhOnwAAAAASUVORK5CYII=" />
                    </c:otherwise>
                  </c:choose>
                </div>
                <div id="avatar-preview">
                  <c:choose>
                    <c:when test="${!empty avatar && success != true}">
                      <img id="preview" src="${ctx}/static/avatar/origin/${avatar}" />
                    </c:when>
                    <c:when test="${success == true}">
                      <img id="origin" src="${ctx}/static/avatar/large/${avatar}" />
                    </c:when>
                    <c:otherwise>
                      <img  src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAIIAAACCCAYAAACKAxD9AAACgUlEQVR42u3aPW7qQBSA0ex/KfxJICEaKCioqGioaClAiC04cqRBk4nHDijRJPYpviLIwfOuj21M3tv9fq+kN0MQCAJBIAgEgSAQBIJAEAgCQSAIBIEgEASCQBAIAkEgCASBIBAEgkAQCAJBIAgEgSAQBIJAEAgCQSAIBIEgEASCQBAIAkEgCASBIBAEgkAQCAJBIBiEQFBhCLvdrhqNRtVqtcpuc71eq+l0+rFd3Xg8rs7nc3b70+lUTSaTx/bH43Gw6/3zENJ/fG6w9VBns9ljkGHIueEeDoeP99vv95/2E34eynr/3RUhDCI32M1m82WA6fDSM3G73X45i7vOyr6utzcQ2s7OdLDhsp1eWsP26cCHsN5eQ1iv19Visagul8vjtdvtVi2Xy8YzKZx56e8MYb29hBCG13QWtQ0vHXp9YMK9Pv4wF7+eW0+J9YLQcBkNpZfNcDltG2x8QMJ+49fCdm2X5FLrBSGzfTrcVwab7rs+eF335ZLrBSHz4Su+dL462HA7mM/n31pD6fWC0PABLB7Uq/fcZ4deer0gZO7B6f392U/h8beA3xl86fWC0DDYdIjPPpeHg1G/R1hH1/BLrheEzGNZOqi2b+qaBl5/Cxi/Frb7iaeG31jvIP7o1HXZTi+pXc/56WNi+q1efc9O3yPeX+67/lLr7S2E9C90oXgA8Qe5uK4zJX5ka3tSiM/spn3FB7vkev1/BIEgEASCQBAIAkEgCASBIBAEgkAQCAJBIAgEgSAQBIJAEAgCQSAIBIEgEASCQBAIEggCQSAIBIEgEASCQBAIAkEgCASBIBAEgkAQCAJBIAgEgSAQBIJAEAgCQSAIBIEgEASC/nDvJCbtpAW3qxAAAAAASUVORK5CYII=" />
                    </c:otherwise>
                  </c:choose>
                </div>
                </div>
                <div class="help-block" style="clear:both;margin-top:15px;">随意拖拽或缩放大图中的虚线方格，预览的小图即为保存后的小头像图标。</div>
              </div>
            </div>
            <div class="form-actions background-none">
              <input id="submit_btn" class="btn btn-primary" type="submit" value="保存头像" />
            </div>
          </form>
        
      </div>
      <div class="span3">
        <ul class="nav nav-pills nav-stacked aside-block">
          <li id="profile"><a href="${ctx}/settings/profile">个人资料</a></li>
          <li id="avatar" class="active"><a href="${ctx}/settings/avatar">头像</a></li>
          <li id="account"><a href="${ctx}/settings/account">个性域名</a></li>
          <li id="passord"><a href="${ctx}/settings/password">密码</a></li>
        </ul>
      </div>
    </div>
  </div>
</body>
</html>
