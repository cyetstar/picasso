package org.cyetstar.picasso.utils.web.script.old;

import java.io.File;


@Deprecated
public class JQueryScripter extends Scripter {

	private static final String ENV_JS = "env.js";
	private static final String JQUERY_JS = "jquery.js";

	@Override
	protected void init() {
		try {
			super.init();
			loadJs(new File[] { new File(getCurrentPath() + File.separator + ENV_JS),
					new File(getCurrentPath() + File.separator + JQUERY_JS) });
			System.out.println("ddd");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getCurrentPath() {
		return getClass().getResource("").getPath();
	}

}
