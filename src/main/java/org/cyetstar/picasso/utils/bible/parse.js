function parse(html) {
	log.info('开始解析....');
	var $ch = $(html).find('.chapter');
}

function parseParagraph($ch) {
	var kv = {};
	var i = 0;
	var vs = new Array[];
	$ch.find('.verse').each(function() {
		if(kv[$(this).attr('data-usfm')]==undefined){
			vs = new Array[], i = 0;
			vs[i] = $(this).html();
		}else{
			i++;
			vs = kv[$(this).attr('data-usfm')];
			vs[i] = $(this).html();
		}
		kv[$(this).attr('data-usfm')] = vs;
	})
	return kv;
}
