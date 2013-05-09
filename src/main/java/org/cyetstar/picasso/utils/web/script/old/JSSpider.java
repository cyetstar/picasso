package org.cyetstar.picasso.utils.web.script.old;

import java.io.File;

import org.cyetstar.picasso.utils.web.Spider;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.ScriptableObject;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;


@Deprecated
@Component
public class JSSpider extends JQueryScripter implements Spider {

	private static final String SPIDER_JS = "spider.js";

	@Override
	protected void init() {
		super.init();
		try {
			loadJs(new File[] { new File(getCurrentPath() + File.separator + SPIDER_JS) });
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String crawl(String url) {
		return (String) ScriptableObject.callMethod(scope, "crawl", new Object[] { url });
	}

	public static void main(String[] args) throws Exception {

		Spider spider = new JSSpider();
		// https://www.youversion.com/zh-CN/bible/48/isa.1
		String content = spider.crawl("http://www.baidu.com");
		System.out.println(content);
		content = spider.crawl("http://www.google.cn");
		System.out.println(content);
	}

	protected void loadLogger(Logger log) {
		ScriptableObject.putProperty(scope, "log", Context.javaToJS(log, scope));
	}

}
