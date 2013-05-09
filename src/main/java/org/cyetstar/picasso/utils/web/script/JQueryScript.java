package org.cyetstar.picasso.utils.web.script;

import java.io.File;
import java.io.IOException;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class JQueryScript {

	protected static Scriptable scope;

	protected static Context context;

	protected ScriptFactory factory = new JQueryScriptFactory();

	public JQueryScript() {
		if (scope == null || context == null) {
			scope = factory.getScope();
			context = factory.getContext();
			init();
		}
	}

	protected void init() {
	}

	protected void loadScriptFile(String... fileNames) throws IOException {
		for (String fileName : fileNames) {
			factory.loadScriptFile(new File(getCurrentClasspath() + File.separator + fileName));
		}
	}

	protected String getCurrentClasspath() {
		return this.getClass().getResource(".").getPath();
	}

}
