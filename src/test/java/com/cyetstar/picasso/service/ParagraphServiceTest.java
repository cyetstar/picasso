package com.cyetstar.picasso.service;

import static org.junit.Assert.*;

import org.cyetstar.picasso.entity.Chapter;
import org.cyetstar.picasso.entity.Paragraph;
import org.cyetstar.picasso.service.ParagraphService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;


@ActiveProfiles("test")
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class ParagraphServiceTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private ParagraphService paragraphService;

	@Test
	public void save() {
		Paragraph paragraph = new Paragraph();
		Chapter chapter = new Chapter(1L);
		chapter.setContainJoinVerse(false);
		paragraph.setChapter(chapter);
		paragraph.setTitle("123");
		paragraph.setVerseNoFrom("5");
		paragraph.setVerseNoTo("12");
		paragraph.setType("p");
		paragraphService.saveParagraph(paragraph);
		assertNotNull(paragraph.getId());
	}

	@Test
	public void delete() {
		paragraphService.deleteParagraph(1L);
	}

}
