package org.cyetstar.picasso.utils.web.script.old;

import java.io.File;
import java.io.FileReader;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Deprecated
public class Scripter {

	Logger log = LoggerFactory.getLogger(this.getClass());

	Context context;

	Scriptable scope;

	File[] files;

	public Scripter() {
		init();
	}

	protected void init() {
		context = Context.enter();
		scope = context.initStandardObjects();
		context.setOptimizationLevel(-1);
		context.setLanguageVersion(Context.VERSION_1_5);
		setupJsLogger();
	}

	protected void setupJsLogger() {
		ScriptableObject.putProperty(scope, "log", Context.javaToJS(log, scope));
	}

	public void loadJs(File file) throws Exception {
		context.evaluateReader(scope, new FileReader(file), file.getName(), 1, null);
	}

	public void loadJs(File... files) throws Exception {
		for (File file : files) {
			loadJs(file);
		}
	}

}
