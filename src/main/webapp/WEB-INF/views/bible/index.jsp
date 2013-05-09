<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
<title>圣经</title>
<script type="text/javascript">
	function parseAllChapter(start, num) {
		stop = false;
		for ( var i = start; i <= num; i++) {
			$.ajax({
				url : '${ctx}/bible/chapters/' + i,
				async : false,
				success : function(data) {
					var $ch = $(data).find('div.chapter');
					stop = !parseChapter($ch);
				}
			});
			console.log("chapter " + i + " parsed success! need stop: " + stop);
			if (stop) {
				return;
			}
		}
	}

	function parseChapter($ch) {
		var success = true;
		$ch.find('span.verse').each(function() {
			var usfm = $(this).attr('data-usfm');
			var vcontent = $(this).html();
			$.ajax({
				url : '${ctx}/bible/verse/save',
				type : 'post',
				async : false,
				data : {
					usfm : usfm,
					vcontent : vcontent
				},
				success : function(data) {
					success = data.success;
					if(!success){
						console.log(data);
					}
				}
			})
			return success;
		});
		return success;
	}

	$(function() {
		$('#bible').addClass('active').siblings().removeClass('active');
		$('[data-book-id]').on(
				'click.data-book',
				function() {
					$('#book-list li').removeClass('active');
					$(this).parent('li').addClass('active');
					$('#chapter-list').load(
							'${ctx}/bible/chapters?bookId='
									+ $(this).attr('data-book-id'));
				})
		$('[data-chapter-id]').on(
				'click.data-chapter-id',
				function() {
					$('#chapter-list li').removeClass('active');
					$(this).parent('li').addClass('active');
					$('[data-toggle="dropdown"] span').text(
							$('#book-list li.active').attr('data-book-title')
									+ ' '
									+ $('#chapter-list li.active').attr(
											'data-chapter-num'));
					$('#bible-content').load(
							'${ctx}/bible/chapter-content/'
									+ $(this).attr('data-chapter-id'));
					$(this).dropdown('toggle');
				});
		$('[data-book-id="${book.id}"]').parent('li').addClass('active');
		$('[data-chapter-id="${chapter.id}"]').parent('li').addClass('active');
	})

	function dropmenuOpen(part) {
		$('#book-list').scrollTop(part == 1 ? 0 : 200);
	}
</script>
</head>
<body>
  <div class="container">
    <div class="row">
      <div class="span9">
        <div id="read-header">
          <div id="bible-selector" class="btn-group">
            <a class="btn btn-mini btn-success dropdown-toggle" data-toggle="dropdown" data-dropmenu-open="dropmenuOpen(${book.part})" href="#"><span>${book.title} ${chapter.num}</span><b class="caret"></b></a>
            <div class="dropdown-menu self span9">
              <div id="book-menu">
                <h5>书卷</h5>
                <div id="book-list">
                  <ul class="nav nav-pills">
                    <li data-book-title="创世记"><a data-book-id="gen" href="javascript:void(0)">创世记</a></li>
                    <li data-book-title="出埃及记"><a data-book-id="exo" href="javascript:void(0)">出埃及记</a></li>
                    <li data-book-title="利未记"><a data-book-id="lev" href="javascript:void(0)">利未记</a></li>
                    <li data-book-title="民数记"><a data-book-id="num" href="javascript:void(0)">民数记</a></li>
                    <li data-book-title="申命记"><a data-book-id="deu" href="javascript:void(0)">申命记</a></li>
                    <li data-book-title="约书亚记"><a data-book-id="jos" href="javascript:void(0)">约书亚记</a></li>
                    <li data-book-title="士师记"><a data-book-id="jdg" href="javascript:void(0)">士师记</a></li>
                    <li data-book-title="路得记"><a data-book-id="rut" href="javascript:void(0)">路得记</a></li>
                    <li data-book-title="撒母耳记上"><a data-book-id="1sa" href="javascript:void(0)">撒母耳记上</a></li>
                    <li data-book-title="撒母耳记下"><a data-book-id="2sa" href="javascript:void(0)">撒母耳记下</a></li>
                    <li data-book-title="列王纪上"><a data-book-id="1ki" href="javascript:void(0)">列王纪上</a></li>
                    <li data-book-title="列王纪下"><a data-book-id="2ki" href="javascript:void(0)">列王纪下</a></li>
                    <li data-book-title="历代志上"><a data-book-id="1ch" href="javascript:void(0)">历代志上</a></li>
                    <li data-book-title="历代志下"><a data-book-id="2ch" href="javascript:void(0)">历代志下</a></li>
                    <li data-book-title="以斯拉记"><a data-book-id="ezr" href="javascript:void(0)">以斯拉记</a></li>
                    <li data-book-title="尼希米记"><a data-book-id="neh" href="javascript:void(0)">尼希米记</a></li>
                    <li data-book-title="以斯帖记"><a data-book-id="est" href="javascript:void(0)">以斯帖记</a></li>
                    <li data-book-title="约伯记"><a data-book-id="job" href="javascript:void(0)">约伯记</a></li>
                    <li data-book-title="诗篇"><a data-book-id="psa" href="javascript:void(0)">诗篇</a></li>
                    <li data-book-title="箴言"><a data-book-id="pro" href="javascript:void(0)">箴言</a></li>
                    <li data-book-title="传道书"><a data-book-id="ecc" href="javascript:void(0)">传道书</a></li>
                    <li data-book-title="雅歌"><a data-book-id="sng" href="javascript:void(0)">雅歌</a></li>
                    <li data-book-title="以赛亚书"><a data-book-id="isa" href="javascript:void(0)">以赛亚书</a></li>
                    <li data-book-title="耶利米书"><a data-book-id="jer" href="javascript:void(0)">耶利米书</a></li>
                    <li data-book-title="耶利米哀歌"><a data-book-id="lam" href="javascript:void(0)">耶利米哀歌</a></li>
                    <li data-book-title="以西结书"><a data-book-id="ezk" href="javascript:void(0)">以西结书</a></li>
                    <li data-book-title="但以理书"><a data-book-id="dan" href="javascript:void(0)">但以理书</a></li>
                    <li data-book-title="何西阿书"><a data-book-id="hos" href="javascript:void(0)">何西阿书</a></li>
                    <li data-book-title="约珥书"><a data-book-id="jol" href="javascript:void(0)">约珥书</a></li>
                    <li data-book-title="阿摩司书"><a data-book-id="amo" href="javascript:void(0)">阿摩司书</a></li>
                    <li data-book-title="俄巴底亚书"><a data-book-id="oba" href="javascript:void(0)">俄巴底亚书</a></li>
                    <li data-book-title="约拿书"><a data-book-id="jon" href="javascript:void(0)">约拿书</a></li>
                    <li data-book-title="弥迦书"><a data-book-id="mic" href="javascript:void(0)">弥迦书</a></li>
                    <li data-book-title="那鸿书"><a data-book-id="nam" href="javascript:void(0)">那鸿书</a></li>
                    <li data-book-title="哈巴谷书"><a data-book-id="hab" href="javascript:void(0)">哈巴谷书</a></li>
                    <li data-book-title="西番雅书"><a data-book-id="zep" href="javascript:void(0)">西番雅书</a></li>
                    <li data-book-title="哈该书"><a data-book-id="hag" href="javascript:void(0)">哈该书</a></li>
                    <li data-book-title="撒迦利亚书"><a data-book-id="zec" href="javascript:void(0)">撒迦利亚书</a></li>
                    <li data-book-title="玛拉基书"><a data-book-id="mal" href="javascript:void(0)">玛拉基书</a></li>
                  </ul>
                  <ul class="nav nav-pills">
                    <li data-book-title="马太福音"><a data-book-id="mat" href="javascript:void(0)">马太福音</a></li>
                    <li data-book-title="马可福音"><a data-book-id="mrk" href="javascript:void(0)">马可福音</a></li>
                    <li data-book-title="路加福音"><a data-book-id="luk" href="javascript:void(0)">路加福音</a></li>
                    <li data-book-title="约翰福音"><a data-book-id="jhn" href="javascript:void(0)">约翰福音</a></li>
                    <li data-book-title="使徒行传"><a data-book-id="act" href="javascript:void(0)">使徒行传</a></li>
                    <li data-book-title="罗马书"><a data-book-id="rom" href="javascript:void(0)">罗马书</a></li>
                    <li data-book-title="哥林多前书"><a data-book-id="1co" href="javascript:void(0)">哥林多前书</a></li>
                    <li data-book-title="哥林多后书"><a data-book-id="2co" href="javascript:void(0)">哥林多后书</a></li>
                    <li data-book-title="加拉太书"><a data-book-id="gal" href="javascript:void(0)">加拉太书</a></li>
                    <li data-book-title="以弗所书"><a data-book-id="eph" href="javascript:void(0)">以弗所书</a></li>
                    <li data-book-title="腓立比书"><a data-book-id="php" href="javascript:void(0)">腓立比书</a></li>
                    <li data-book-title="歌罗西书"><a data-book-id="col" href="javascript:void(0)">歌罗西书</a></li>
                    <li data-book-title="帖撒罗尼迦前书"><a data-book-id="1th" href="javascript:void(0)">帖撒罗尼迦前书</a></li>
                    <li data-book-title="帖撒罗尼迦后书"><a data-book-id="2th" href="javascript:void(0)">帖撒罗尼迦后书</a></li>
                    <li data-book-title="提摩太前书"><a data-book-id="1ti" href="javascript:void(0)">提摩太前书</a></li>
                    <li data-book-title="提摩太后书"><a data-book-id="2ti" href="javascript:void(0)">提摩太后书</a></li>
                    <li data-book-title="提多书"><a data-book-id="tit" href="javascript:void(0)">提多书</a></li>
                    <li data-book-title="腓利门书"><a data-book-id="phm" href="javascript:void(0)">腓利门书</a></li>
                    <li data-book-title="希伯来书"><a data-book-id="heb" href="javascript:void(0)">希伯来书</a></li>
                    <li data-book-title="雅各书"><a data-book-id="jas" href="javascript:void(0)">雅各书</a></li>
                    <li data-book-title="彼得前书"><a data-book-id="1pe" href="javascript:void(0)">彼得前书</a></li>
                    <li data-book-title="彼得后书"><a data-book-id="2pe" href="javascript:void(0)">彼得后书</a></li>
                    <li data-book-title="约翰一书"><a data-book-id="1jn" href="javascript:void(0)">约翰一书</a></li>
                    <li data-book-title="约翰二书"><a data-book-id="2jn" href="javascript:void(0)">约翰二书</a></li>
                    <li data-book-title="约翰三书"><a data-book-id="3jn" href="javascript:void(0)">约翰三书</a></li>
                    <li data-book-title="犹大书"><a data-book-id="jud" href="javascript:void(0)">犹大书</a></li>
                    <li data-book-title="启示录"><a data-book-id="rev" href="javascript:void(0)">启示录</a></li>
                  </ul>
                </div>
                <hr />
                <h5>章节</h5>
                <div id="chapter-list">
                  <c:if test="${!empty book.chapters}">
                    <ul class="nav nav-pills">
                      <c:forEach items="${book.chapters}" var="ch">
                        <li data-chapter-num="${ch.num}"><a href="javascript:void(0)" data-chapter-id="${ch.id}">${ch.num}</a></li>
                      </c:forEach>
                    </ul>
                  </c:if>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div id="bible-content">
          <%@ include file="chapter-content.jsp"%>
        </div>
      </div>
      <div class="span3">
        <%@ include file="bible-aside.jsp"%>
      </div>
    </div>
  </div>
</body>
</html>