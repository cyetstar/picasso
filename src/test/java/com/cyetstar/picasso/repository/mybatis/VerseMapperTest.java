package com.cyetstar.picasso.repository.mybatis;

import static org.junit.Assert.*;

import java.util.List;

import org.cyetstar.picasso.entity.Verse;
import org.cyetstar.picasso.repository.mybatis.VerseMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;


@ActiveProfiles(profiles = "test")
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class VerseMapperTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private VerseMapper verseMapper;

	@Test
	public void find() {
		List<Verse> verses = verseMapper.findByChapterId(1L);
		assertEquals(51, verses.size());

		Verse verse = verseMapper.findByNumAndChapterId("3", 1L);
		assertEquals("3", verse.getNum());
	}

}
