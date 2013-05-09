package org.cyetstar.picasso.utils.web.script;

import java.io.IOException;

import org.cyetstar.picasso.utils.web.Spider;
import org.mozilla.javascript.ScriptableObject;


//@Component
public class JQuerySpider extends JQueryScript implements Spider {

	private static final String SPIDER_JS = "spider.js";

	@Override
	protected void init() {
		super.init();
		try {
			loadScriptFile(SPIDER_JS);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String crawl(String url) {
		return (String) ScriptableObject.callMethod(scope, "crawl", new Object[] { url });
	}

	public static void main(String[] args) throws Exception {

		Spider spider = new JQuerySpider();
		// https://www.youversion.com/zh-CN/bible/48/isa.1
		String content = spider.crawl("http://www.baidu.com");
		System.out.println(content);
		content = spider.crawl("http://www.google.cn");
		System.out.println(content);
	}
}
