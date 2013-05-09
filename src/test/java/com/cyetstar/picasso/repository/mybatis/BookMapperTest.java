package com.cyetstar.picasso.repository.mybatis;

import static org.junit.Assert.*;

import org.cyetstar.picasso.entity.Book;
import org.cyetstar.picasso.repository.mybatis.BookMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;


@ActiveProfiles(profiles = "test")
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class BookMapperTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private BookMapper bookMapper;

	@Test
	public void find() {

		Book book = bookMapper.findWithDetail("jhn");
		assertEquals(21, book.getChapters().size());

		book = bookMapper.findByAbbr("约");
		assertEquals("约翰福音", book.getTitle());

		book = bookMapper.findByTitle("约翰福音");
		assertEquals("约", book.getAbbr());

		book = bookMapper.findByTitleOrAbbr("约", "约");
		assertNotNull(book);
	}

}
