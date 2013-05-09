package org.cyetstar.picasso.utils.web.script;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.ScriptableObject;
import org.slf4j.Logger;

public abstract class LoggerScriptFactory extends AbstractScriptFactory {

	protected void loadLogger(Logger log) {
		ScriptableObject.putProperty(scope, "log", Context.javaToJS(log, scope));
	}

}
