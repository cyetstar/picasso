package org.cyetstar.picasso.utils.bible;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.cyetstar.picasso.entity.Book;
import org.cyetstar.picasso.entity.Chapter;
import org.cyetstar.picasso.entity.Paragraph;
import org.cyetstar.picasso.entity.Verse;
import org.cyetstar.picasso.utils.web.script.old.JQueryer;


public class Fetcher {

	JQueryer jqr;

	public void parseChapter(String fileContent) {
		jqr = new JQueryer(fileContent);
		//JQueryer $ch = jqr.find(".chapter").get(0);
		//		JQueryer $p = $ch.find("div.p");
		//
		//		JQueryer $pt = $ch.find("div.s");
	}

	private void parseParagraph(Book buk, Chapter ch, JQueryer $p, JQueryer $pt) {
		if ($p == null) {
			return;
		}
		Paragraph p = new Paragraph();
		if ($pt != null) {
			//			p.setTitle($pt.find(".heading").text());
		}
		p.setType("p");
		p.setChapter(ch);
		// p.setEpilog(epilog);
		// p.setSubtitle(subtitle);
		//TODO save

		//		JQueryer[] $vs = $p.find(".verse");
		//		parseVerse(buk, ch, p, $vs);

	}

	private void parseVerse(Book buk, Chapter ch, Paragraph p, JQueryer[] $vs) {
		if ($vs == null) {
			return;
		}
		Verse v = new Verse();
		v.setBook(buk);
		v.setChapter(ch);
		v.setParagraph(p);
		for (JQueryer $v : $vs) {
			parseLabel(v, $v);
			String text = parseText($v.find(" > span"));
			if (v.getText() == null) {
				v.setText(text);
			} else if (v.getText2() == null) {
				v.setText2(text);
			} else if (v.getText3() == null) {
				v.setText3(text);
			} else if (v.getText4() == null) {
				v.setText4(text);
			} else if (v.getText5() == null) {
				v.setText5(text);
			} else {
				throw new RuntimeException("超出text边界");
			}
			v.setEpilog($v.find(".qs > .content").text());
		}

	}

	private String parseText(JQueryer $spans) {
		String txt = "";
		//		for (JQueryer $span : $spans) {
		//			if (!$span.is(".qs")) {
		//				txt += $span.text();
		//			}
		//		}
		return txt;
	}

	private void parseLabel(Verse v, JQueryer $v) {
		if (v.getNum() != null)
			return;
		String dataUsfm = $v.attr("data-usfm");
		String[] dataUsfmArr = dataUsfm.split("+");
		for (String data : dataUsfmArr) {
			String num = data.substring(data.lastIndexOf("."));
			if (v.getNum() == null) {
				v.setNum(num);
			} else if (v.getNum2() == null) {
				v.setNum2(num);
			} else if (v.getNum3() == null) {
				v.setNum3(num);
			} else {
				throw new RuntimeException("超出num边界");
			}
		}
	}

	public String readContent() {
		String fileContent = "";
		try {
			String path = Fetcher.class.getResource("./bible1.jsp").getPath();
			File file = new File(path);
			BufferedReader in = new BufferedReader(new FileReader(file));
			char[] buff = new char[1024];
			while (in.read(buff) != -1) {
				fileContent += new String(buff);
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileContent;
	}

	public static void main(String[] args) throws Exception {
		JQueryer j = new JQueryer(
				"<ul><a>11</a><a>22</a><li class='qs'><a>ddd</a></li><li class='qs'>vvvv</li><li class='qs'>sdf</li></ul>");
		JQueryer lis = j.children();
		System.out.println(lis.size());
		System.out.println(lis.text());
		System.out.println(lis.html());
		for (int i = 0; i < lis.size(); i++) {

			//System.out.println(lis.get(i).text());
		}

	}
}
