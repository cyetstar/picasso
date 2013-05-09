package com.cyetstar.picasso.repository.mybatis;

import static org.junit.Assert.*;

import java.util.List;

import org.cyetstar.picasso.entity.Book;
import org.cyetstar.picasso.entity.Chapter;
import org.cyetstar.picasso.repository.mybatis.BookMapper;
import org.cyetstar.picasso.repository.mybatis.ChapterMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;


@ActiveProfiles(profiles = "test-bible")
@ContextConfiguration(locations = { "/applicationContext-bible.xml", "/applicationContext.xml" })
public class BibleTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private BookMapper bookMapper;

	@Autowired
	private ChapterMapper chapterMapper;

	@Test
	public void validate() {
		Book book = bookMapper.findByTitle("创世记");
		List<Chapter> chapters = chapterMapper.findChaptersByBookId(book.getId());
		assertEquals(50, chapters.size());

		book = bookMapper.findByTitle("出埃及记");
		chapters = chapterMapper.findChaptersByBookId(book.getId());
		assertEquals(40, chapters.size());

		book = bookMapper.findByTitle("利未记");
		chapters = chapterMapper.findChaptersByBookId(book.getId());
		assertEquals(27, chapters.size());

		book = bookMapper.findByTitle("民数记");
		chapters = chapterMapper.findChaptersByBookId(book.getId());
		assertEquals(36, chapters.size());

		book = bookMapper.findByTitle("申命记");
		chapters = chapterMapper.findChaptersByBookId(book.getId());
		assertEquals(34, chapters.size());

		book = bookMapper.findByTitle("约书亚记");
		chapters = chapterMapper.findChaptersByBookId(book.getId());
		assertEquals(24, chapters.size());

		book = bookMapper.findByTitle("士师记");
		chapters = chapterMapper.findChaptersByBookId(book.getId());
		assertEquals(21, chapters.size());

		book = bookMapper.findByTitle("路得记");
		chapters = chapterMapper.findChaptersByBookId(book.getId());
		assertEquals(4, chapters.size());

		book = bookMapper.findByTitle("撒母耳记上");
		chapters = chapterMapper.findChaptersByBookId(book.getId());
		assertEquals(31, chapters.size());

		book = bookMapper.findByTitle("撒母耳记下");
		chapters = chapterMapper.findChaptersByBookId(book.getId());
		assertEquals(24, chapters.size());

		book = bookMapper.findByTitle("列王纪上");
		chapters = chapterMapper.findChaptersByBookId(book.getId());
		assertEquals(22, chapters.size());

		book = bookMapper.findByTitle("列王纪下");
		chapters = chapterMapper.findChaptersByBookId(book.getId());
		assertEquals(25, chapters.size());

		book = bookMapper.findByTitle("历代志上");
		chapters = chapterMapper.findChaptersByBookId(book.getId());
		assertEquals(29, chapters.size());

		book = bookMapper.findByTitle("历代志下");
		chapters = chapterMapper.findChaptersByBookId(book.getId());
		assertEquals(36, chapters.size());

		book = bookMapper.findByTitle("以斯拉记");
		chapters = chapterMapper.findChaptersByBookId(book.getId());
		assertEquals(10, chapters.size());

		book = bookMapper.findByTitle("尼希米记");
		chapters = chapterMapper.findChaptersByBookId(book.getId());
		assertEquals(13, chapters.size());

		book = bookMapper.findByTitle("以斯帖记");
		chapters = chapterMapper.findChaptersByBookId(book.getId());
		assertEquals(10, chapters.size());

		book = bookMapper.findByTitle("约伯记");
		chapters = chapterMapper.findChaptersByBookId(book.getId());
		assertEquals(42, chapters.size());

		book = bookMapper.findByTitle("诗篇");
		chapters = chapterMapper.findChaptersByBookId(book.getId());
		assertEquals(150, chapters.size());

		book = bookMapper.findByTitle("箴言");
		chapters = chapterMapper.findChaptersByBookId(book.getId());
		assertEquals(31, chapters.size());

		book = bookMapper.findByTitle("传道书");
		chapters = chapterMapper.findChaptersByBookId(book.getId());
		assertEquals(12, chapters.size());

		book = bookMapper.findByTitle("雅歌");
		chapters = chapterMapper.findChaptersByBookId(book.getId());
		assertEquals(8, chapters.size());

		book = bookMapper.findByTitle("以赛亚书");
		chapters = chapterMapper.findChaptersByBookId(book.getId());
		assertEquals(66, chapters.size());

		book = bookMapper.findByTitle("耶利米书");
		chapters = chapterMapper.findChaptersByBookId(book.getId());
		assertEquals(52, chapters.size());

		book = bookMapper.findByTitle("耶利米哀歌");
		chapters = chapterMapper.findChaptersByBookId(book.getId());
		assertEquals(5, chapters.size());

		book = bookMapper.findByTitle("以西结书");
		chapters = chapterMapper.findChaptersByBookId(book.getId());
		assertEquals(48, chapters.size());

		book = bookMapper.findByTitle("但以理书");
		chapters = chapterMapper.findChaptersByBookId(book.getId());
		assertEquals(12, chapters.size());

		book = bookMapper.findByTitle("何西阿书");
		chapters = chapterMapper.findChaptersByBookId(book.getId());
		assertEquals(14, chapters.size());

		book = bookMapper.findByTitle("约珥书");
		chapters = chapterMapper.findChaptersByBookId(book.getId());
		assertEquals(3, chapters.size());

		book = bookMapper.findByTitle("阿摩司书");
		chapters = chapterMapper.findChaptersByBookId(book.getId());
		assertEquals(9, chapters.size());

		book = bookMapper.findByTitle("俄巴底亚书");
		chapters = chapterMapper.findChaptersByBookId(book.getId());
		assertEquals(1, chapters.size());

		book = bookMapper.findByTitle("约拿书");
		chapters = chapterMapper.findChaptersByBookId(book.getId());
		assertEquals(4, chapters.size());

		book = bookMapper.findByTitle("弥迦书");
		chapters = chapterMapper.findChaptersByBookId(book.getId());
		assertEquals(7, chapters.size());

		book = bookMapper.findByTitle("那鸿书");
		chapters = chapterMapper.findChaptersByBookId(book.getId());
		assertEquals(3, chapters.size());

		book = bookMapper.findByTitle("哈巴谷书");
		chapters = chapterMapper.findChaptersByBookId(book.getId());
		assertEquals(3, chapters.size());

		book = bookMapper.findByTitle("西番雅书");
		chapters = chapterMapper.findChaptersByBookId(book.getId());
		assertEquals(3, chapters.size());

		book = bookMapper.findByTitle("哈该书");
		chapters = chapterMapper.findChaptersByBookId(book.getId());
		assertEquals(2, chapters.size());

		book = bookMapper.findByTitle("撒迦利亚书");
		chapters = chapterMapper.findChaptersByBookId(book.getId());
		assertEquals(14, chapters.size());

		book = bookMapper.findByTitle("玛拉基书");
		chapters = chapterMapper.findChaptersByBookId(book.getId());
		assertEquals(4, chapters.size());

		book = bookMapper.findByTitle("马太福音");
		chapters = chapterMapper.findChaptersByBookId(book.getId());
		assertEquals(28, chapters.size());

		book = bookMapper.findByTitle("马可福音");
		chapters = chapterMapper.findChaptersByBookId(book.getId());
		assertEquals(16, chapters.size());

		book = bookMapper.findByTitle("路加福音");
		chapters = chapterMapper.findChaptersByBookId(book.getId());
		assertEquals(24, chapters.size());

		book = bookMapper.findByTitle("约翰福音");
		chapters = chapterMapper.findChaptersByBookId(book.getId());
		assertEquals(21, chapters.size());

		book = bookMapper.findByTitle("使徒行传");
		chapters = chapterMapper.findChaptersByBookId(book.getId());
		assertEquals(28, chapters.size());

		book = bookMapper.findByTitle("罗马书");
		chapters = chapterMapper.findChaptersByBookId(book.getId());
		assertEquals(16, chapters.size());

		book = bookMapper.findByTitle("哥林多前书");
		chapters = chapterMapper.findChaptersByBookId(book.getId());
		assertEquals(16, chapters.size());

		book = bookMapper.findByTitle("哥林多后书");
		chapters = chapterMapper.findChaptersByBookId(book.getId());
		assertEquals(13, chapters.size());

		book = bookMapper.findByTitle("加拉太书");
		chapters = chapterMapper.findChaptersByBookId(book.getId());
		assertEquals(6, chapters.size());

		book = bookMapper.findByTitle("以弗所书");
		chapters = chapterMapper.findChaptersByBookId(book.getId());
		assertEquals(6, chapters.size());

		book = bookMapper.findByTitle("腓立比书");
		chapters = chapterMapper.findChaptersByBookId(book.getId());
		assertEquals(4, chapters.size());

		book = bookMapper.findByTitle("歌罗西书");
		chapters = chapterMapper.findChaptersByBookId(book.getId());
		assertEquals(4, chapters.size());

		book = bookMapper.findByTitle("帖撒罗尼迦前书");
		chapters = chapterMapper.findChaptersByBookId(book.getId());
		assertEquals(5, chapters.size());

		book = bookMapper.findByTitle("帖撒罗尼迦后书");
		chapters = chapterMapper.findChaptersByBookId(book.getId());
		assertEquals(3, chapters.size());

		book = bookMapper.findByTitle("提摩太前书");
		chapters = chapterMapper.findChaptersByBookId(book.getId());
		assertEquals(6, chapters.size());

		book = bookMapper.findByTitle("提摩太后书");
		chapters = chapterMapper.findChaptersByBookId(book.getId());
		assertEquals(4, chapters.size());

		book = bookMapper.findByTitle("提多书");
		chapters = chapterMapper.findChaptersByBookId(book.getId());
		assertEquals(3, chapters.size());

		book = bookMapper.findByTitle("腓利门书");
		chapters = chapterMapper.findChaptersByBookId(book.getId());
		assertEquals(1, chapters.size());

		book = bookMapper.findByTitle("希伯来书");
		chapters = chapterMapper.findChaptersByBookId(book.getId());
		assertEquals(13, chapters.size());

		book = bookMapper.findByTitle("雅各书");
		chapters = chapterMapper.findChaptersByBookId(book.getId());
		assertEquals(5, chapters.size());

		book = bookMapper.findByTitle("彼得前书");
		chapters = chapterMapper.findChaptersByBookId(book.getId());
		assertEquals(5, chapters.size());

		book = bookMapper.findByTitle("彼得后书");
		chapters = chapterMapper.findChaptersByBookId(book.getId());
		assertEquals(3, chapters.size());

		book = bookMapper.findByTitle("约翰一书");
		chapters = chapterMapper.findChaptersByBookId(book.getId());
		assertEquals(5, chapters.size());

		book = bookMapper.findByTitle("约翰二书");
		chapters = chapterMapper.findChaptersByBookId(book.getId());
		assertEquals(1, chapters.size());

		book = bookMapper.findByTitle("约翰三书");
		chapters = chapterMapper.findChaptersByBookId(book.getId());
		assertEquals(1, chapters.size());

		book = bookMapper.findByTitle("犹大书");
		chapters = chapterMapper.findChaptersByBookId(book.getId());
		assertEquals(1, chapters.size());

		book = bookMapper.findByTitle("启示录");
		chapters = chapterMapper.findChaptersByBookId(book.getId());
		assertEquals(22, chapters.size());
	}

}
