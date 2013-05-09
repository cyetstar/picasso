package com.cyetstar.picasso.repository.mybatis;

import static org.junit.Assert.*;

import org.cyetstar.picasso.entity.Book;
import org.cyetstar.picasso.entity.Chapter;
import org.cyetstar.picasso.entity.Token;
import org.cyetstar.picasso.repository.mybatis.TokenMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;


@ActiveProfiles(profiles = "test")
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class TokenMapperTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private TokenMapper tokenMapper;

	@Test
	public void find() {
		Token token = tokenMapper.findByName("约 1:1-2");
		assertNotNull(token);

		token = tokenMapper.findWithDetail(token.getId());
		assertEquals(2, token.getVerses().size());
	}

	@Test
	public void save() {
		Token token = new Token();
		token.setName("约 1:5");
		token.setBook(new Book("jhn"));
		token.setChapter(new Chapter(1L));
		tokenMapper.insert(token);
		assertNotNull(token.getId());
	}
}
