package org.cyetstar.picasso.utils.web.script;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public abstract class AbstractScriptFactory implements ScriptFactory {

	Context context;

	Scriptable scope;

	public AbstractScriptFactory() {
		initContext();
	}

	private void initContext() {
		context = Context.enter();
		context.setOptimizationLevel(-1);
		context.setLanguageVersion(Context.VERSION_1_5);
		scope = context.initStandardObjects();
	}

	public Context getContext() {
		return context;
	}

	public Scriptable getScope() {
		return scope;
	}

	public void loadScriptFile(File... files) throws IOException {
		for (File file : files) {
			context.evaluateReader(scope, new FileReader(file), file.getName(), 1, null);
		}
	}

}
