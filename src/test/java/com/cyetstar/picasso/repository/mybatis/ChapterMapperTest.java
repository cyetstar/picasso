package com.cyetstar.picasso.repository.mybatis;

import static org.junit.Assert.*;

import java.util.List;

import org.cyetstar.picasso.entity.Chapter;
import org.cyetstar.picasso.entity.Paragraph;
import org.cyetstar.picasso.repository.mybatis.ChapterMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;


@ActiveProfiles(profiles = "test")
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class ChapterMapperTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private ChapterMapper chapterMapper;

	@Test
	public void find() {
		Chapter chapter = chapterMapper.findWithDetail(1L);
		assertEquals(5, chapter.getParagraphs().size());

		chapter = chapterMapper.findWithDetailByNumAndBookId("1", "jhn");
		assertEquals(5, chapter.getParagraphs().size());

		List<Paragraph> paragraphs = chapter.getParagraphs();
		for (Paragraph p : paragraphs) {
			assertTrue(!p.getVerses().isEmpty());
		}

		List<Chapter> chapters = chapterMapper.findAll();
		assertEquals("1", chapters.get(0).getNum());

		chapter = chapterMapper.findByNumAndBookId("2", "jhn");
		assertNotNull(chapter);

		chapters = chapterMapper.findChaptersByBookId("jhn");
		assertEquals(21, chapters.size());

	}
}
