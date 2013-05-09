package org.cyetstar.picasso.utils.bible;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.cyetstar.picasso.utils.web.script.JQueryScript;
import org.mozilla.javascript.ScriptableObject;
import org.springframework.stereotype.Component;


@Component
public class YouversionBibleParser extends JQueryScript {

	private static final String PARSE_JS = "parse.js";

	@Override
	protected void init() {
		super.init();
		try {
			loadScriptFile(PARSE_JS);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String parse(String content) {
		return (String) ScriptableObject.callMethod(scope, "parse", new Object[] { content });
	}

	public static void main(String[] args) throws Exception {
		YouversionBibleParser parser = new YouversionBibleParser();

		StringBuffer content = new StringBuffer("");
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(new File(YouversionBibleParser.class
				.getResource("bible1.jsp").getFile())));
		byte[] buff = new byte[1024];
		while (in.read(buff) != -1) {
			content.append(new String(buff));
		}
		in.close();
		parser.parse(content.toString());
	}
}
