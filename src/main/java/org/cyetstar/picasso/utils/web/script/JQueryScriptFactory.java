package org.cyetstar.picasso.utils.web.script;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JQueryScriptFactory extends LoggerScriptFactory {

	static Logger log = LoggerFactory.getLogger(JQueryScriptFactory.class);

	private static final String ENV_JS = "env.js";
	private static final String JQUERY_JS = "jquery.js";

	public JQueryScriptFactory() {
		try {
			loadLogger(log);
			loadJQueryScriptFile();
		} catch (Exception e) {
			log.error("jQuery环境建立失败", e);
			e.printStackTrace();
		}
	}

	private void loadJQueryScriptFile() throws Exception {
		String[] fileNames = { ENV_JS, JQUERY_JS };
		for (String fileName : fileNames) {
			loadScriptFile(new File(getCurrentClassPath() + File.separator + fileName));
		}
	}

	private String getCurrentClassPath() {
		return this.getClass().getResource(".").getPath();
	}

}
