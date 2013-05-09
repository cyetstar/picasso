package org.cyetstar.picasso.utils.web.script.old;

import org.apache.commons.lang3.Validate;
import org.mozilla.javascript.NativeObject;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;
import org.mozilla.javascript.Undefined;


@Deprecated
public class JQueryer extends JQueryScripter {

	Scriptable jQueryObj;

	public JQueryer(String selector) {
		this(selector, null);
	}

	public JQueryer(Scriptable jQueryObj) {
		this.jQueryObj = jQueryObj;
	}

	public JQueryer(String selector, String content) {
		Validate.notNull(selector);
		jQueryObj = context.newObject(scope, "jQuery", new String[] { selector, content });
		//jQueryObj = JQueryScriptObjcetFactory.getJQueryScriptObjcet(selector, content);
	}

	public String attr(String key) {
		Object object = ScriptableObject.callMethod(jQueryObj, "attr", new Object[] { key });
		if (object instanceof Undefined) {
			return null;
		}
		return (String) object;
	}

	public void attr(String key, String value) {
		ScriptableObject.callMethod(jQueryObj, "attr", new Object[] { key, value });
	}

	public String text() {
		Object object = ScriptableObject.callMethod(jQueryObj, "text", new Object[] {});
		if (object instanceof Undefined) {
			return null;
		}
		return (String) object;
	}

	public void text(String text) {
		ScriptableObject.callMethod(jQueryObj, "text", new Object[] { text });
	}

	public String val() {
		Object object = ScriptableObject.callMethod(jQueryObj, "val", new Object[] {});
		if (object instanceof Undefined) {
			return null;
		}
		return (String) object;
	}

	public void val(String val) {
		ScriptableObject.callMethod(jQueryObj, "val", new Object[] { val });
	}

	public String html() {
		Object object = ScriptableObject.callMethod(jQueryObj, "html", new Object[] {});
		if (object instanceof Undefined) {
			return null;
		}
		return (String) object;
	}

	public JQueryer first() {
		Object object = ScriptableObject.callMethod(jQueryObj, "first", new Object[] {});
		if (object instanceof Undefined) {
			return null;
		}
		return new JQueryer((NativeObject) object);
	}

	public JQueryer find(String expr) {
		Object object = ScriptableObject.callMethod(jQueryObj, "find", new Object[] { expr });
		if (object instanceof Undefined) {
			return null;
		}
		return new JQueryer((NativeObject) object);
	}

	public JQueryer append(JQueryer jq) {
		Object object = (NativeObject) ScriptableObject.callMethod(jQueryObj, "append", new Object[] { jq.jQueryObj });
		if (object instanceof Undefined) {
			return null;
		}
		return this;
	}

	public JQueryer append(String content) {
		Object object = (NativeObject) ScriptableObject.callMethod(jQueryObj, "append", new Object[] { content });
		if (object instanceof Undefined) {
			return null;
		}
		return this;
	}

	public boolean is(String expr) {
		Object object = ScriptableObject.callMethod(jQueryObj, "is", new Object[] { expr });
		if (object instanceof Undefined) {
			return false;
		}
		return ((Boolean) object).booleanValue();
	}

	public int size() {
		Object object = ScriptableObject.callMethod(jQueryObj, "size", new Object[] {});
		if (object instanceof Undefined) {
			return 0;
		}
		return ((Double) object).intValue();
	}

	public JQueryer get(int index) {
		Object object = ScriptableObject.callMethod(jQueryObj, "get", new Object[] { index });
		if (object instanceof Undefined) {
			return null;
		}
		return new JQueryer((NativeObject) object);
	}

	public JQueryer children() {
		Object object = ScriptableObject.callMethod(jQueryObj, "children", new Object[] {});
		if (object instanceof Undefined) {
			return null;
		}
		return new JQueryer((NativeObject) object);
	}
}
