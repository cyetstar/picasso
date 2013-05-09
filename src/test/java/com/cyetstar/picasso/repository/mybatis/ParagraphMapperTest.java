package com.cyetstar.picasso.repository.mybatis;

import static org.junit.Assert.*;

import java.util.List;

import org.cyetstar.picasso.entity.Chapter;
import org.cyetstar.picasso.entity.Paragraph;
import org.cyetstar.picasso.repository.mybatis.ParagraphMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;


@ActiveProfiles(profiles = "test")
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class ParagraphMapperTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private ParagraphMapper paragraphMapper;

	@Test
	public void find() {
		Paragraph paragraph = paragraphMapper.findWithDetail(1L);
		assertNotNull(paragraph);

		List<Paragraph> paragraphs = paragraphMapper.findWithDetailByChapterId(1L);
		assertEquals(5, paragraphs.size());
	}

	@Test
	public void save() {
		Paragraph paragraph = new Paragraph();
		paragraph.setChapter(new Chapter(1L));
		paragraph.setSectionTitle("12345");
		paragraph.setTitle("1234");
		paragraph.setSubtitle("123");
		paragraph.setRelatedTitle("12");
		paragraph.setDialogTitle("1");
		paragraph.setType("p");
		paragraphMapper.insert(paragraph);
		assertNotNull(paragraph.getId());

		paragraph.setEpilog("e");
		paragraphMapper.update(paragraph);
		assertNotNull(paragraph.getEpilog());
	}

	@Test
	public void delete() {
		paragraphMapper.delete(1L);
	}
}
