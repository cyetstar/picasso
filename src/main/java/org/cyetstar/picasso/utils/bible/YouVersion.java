package org.cyetstar.picasso.utils.bible;

import org.cyetstar.picasso.entity.Chapter;
import org.cyetstar.picasso.repository.mybatis.ChapterMapper;
import org.cyetstar.picasso.utils.web.Spider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;


@Component
public class YouVersion {

	private final static String url = "https://www.youversion.com/zh-CN/bible/48/";

	@Autowired
	private Spider spider;

	//	@Autowired
	//	private YouversionBibleParser parser;

	@Autowired
	private ChapterMapper chapterMapper;

	private void saveChapter(Long chapterId, String chapterText) {
		//		chapterMapper.updateText(chapterId, chapterText);
	}

	private String getChapterText(String bookId, String chapterNum) {
		return spider.crawl(url + bookId + "." + chapterNum);
	}

	public void saveAllChapter() {
		Chapter chapter = chapterMapper.findByNumAndBookId("100", "psa");
		//		for (Chapter chapter : chapters) {
		//			if (chapter.getText() == null) {
		String text = getChapterText("psa", chapter.getNum());
		saveChapter(chapter.getId(), text);
		//			}
		//		}
	}

	//	public void saveParseChapter() {
	//		List<Chapter> chapters = chapterMapper.findAll();
	//		for (Chapter chapter : chapters) {
	//			if (chapter.getText() != null && chapter.getId() > 73) {
	//				saveChapter(chapter.getId(), parser.parse(chapter.getText()));
	//			}
	//		}
	//	}

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
		context.getEnvironment().setActiveProfiles("development");
		context.setConfigLocations(new String[] { "applicationContext.xml" });
		context.refresh();

		YouVersion yv = context.getBean(YouVersion.class);
		yv.saveAllChapter();
	}
}
