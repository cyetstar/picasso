package org.cyetstar.picasso.utils.web.script;

import java.io.File;
import java.io.IOException;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public interface ScriptFactory {

	public Scriptable getScope();

	public Context getContext();

	public void loadScriptFile(File... files) throws IOException;

}
