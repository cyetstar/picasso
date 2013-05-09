package com.cyetstar.picasso.repository.mybatis;

import org.cyetstar.picasso.repository.mybatis.VerseTokenMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

@ActiveProfiles(profiles = "test")
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class VerseTokenMapperTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private VerseTokenMapper verseTokenMapper;

	@Test
	public void save() {
		verseTokenMapper.insert(3L, 1L);
	}

	@Test
	public void delete() {
		verseTokenMapper.delete(2L, 1L);
	}
}
