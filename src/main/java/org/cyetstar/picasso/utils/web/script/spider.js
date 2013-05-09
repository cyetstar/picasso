function crawl(url) {
	log.info('start crawl website ' + url);
	var htmlContent;
	$.ajax({
		url : url,
		async : false,
		success : function(data) {
			htmlContent = $(data).find("#version_primary").html();
			log.info('crawl sucessfully');
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			log.error(textStatus || errorThrown);
		}
	})
	return htmlContent;
}
