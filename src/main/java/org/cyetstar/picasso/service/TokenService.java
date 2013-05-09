package org.cyetstar.picasso.service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.cyetstar.picasso.entity.Book;
import org.cyetstar.picasso.entity.Chapter;
import org.cyetstar.picasso.entity.Token;
import org.cyetstar.picasso.entity.Verse;
import org.cyetstar.picasso.repository.mybatis.BookMapper;
import org.cyetstar.picasso.repository.mybatis.ChapterMapper;
import org.cyetstar.picasso.repository.mybatis.TokenMapper;
import org.cyetstar.picasso.repository.mybatis.VerseMapper;
import org.cyetstar.picasso.repository.mybatis.VerseTokenMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;

@Component
@Transactional(readOnly = true)
public class TokenService {

	private final static Pattern pattern = Pattern.compile("([\\u4e00-\\u9fa5]+)\\s*(\\d+)(?::(\\d+)(?:\\-(\\d+))?)?");

	@Autowired
	BookMapper bookMapper;

	@Autowired
	ChapterMapper chapterMapper;

	@Autowired
	VerseMapper verseMapper;

	@Autowired
	TokenMapper tokenMapper;

	@Autowired
	VerseTokenMapper verseTokenMapper;

	public Token findTokenWithDetail(Long id) {
		return tokenMapper.findWithDetail(id);
	}

	@Transactional
	public Token saveTokenFormString(String tokenString) {
		tokenString = pretreatTokenString(tokenString);
		Token exsitToken = tokenMapper.findByName(tokenString);
		if (exsitToken != null) {
			return exsitToken;
		}
		Token newToken = analyzeTokenString(tokenString);
		if (newToken == null) {
			return null;
		}
		exsitToken = tokenMapper.findByName(newToken.getName());
		if (exsitToken != null) {
			return exsitToken;
		}
		tokenMapper.insert(newToken);
		for (Verse verse : newToken.getVerses()) {
			verseTokenMapper.insert(verse.getId(), newToken.getId());
		}
		return newToken;
	}

	private String pretreatTokenString(String tokenString) {
		return tokenString.trim().replace("：", ":").replace("——", "-").replace("１", "1").replace("２", "2")
				.replace("３", "3").replace("４", "4").replace("５", "5").replace("６", "6").replace("７", "7")
				.replace("８", "8").replace("９", "9").replace("０", "0");
	}

	private Token analyzeTokenString(String tokenString) {
		Token token = new Token();
		String titleOrAbbr = null;
		String chapterNo = null;
		String verseNoFrom = null;
		String verseNoTo = null;
		Matcher matcher = pattern.matcher(tokenString);
		while (matcher.find()) {
			titleOrAbbr = matcher.group(1);
			chapterNo = matcher.group(2);
			verseNoFrom = matcher.group(3);
			verseNoTo = matcher.group(4);
		}
		Book book = bookMapper.findByTitleOrAbbr(titleOrAbbr, titleOrAbbr);
		if (book == null) {
			return null;
		}
		Chapter chapter = chapterMapper.findByNumAndBookId(chapterNo, book.getId());
		if (chapter == null) {
			return null;
		}
		List<Verse> verses = findVersesStepByStep(verseNoFrom, verseNoTo, chapter);
		if (verses == null) {
			return null;
		}
		String tokenName = generateTokenName(book, chapter, verses);
		token.setBook(book);
		token.setChapter(chapter);
		token.setVerses(verses);
		token.setName(tokenName);
		return token;
	}

	private List<Verse> findVersesStepByStep(String verseNoFrom, String verseNoTo, Chapter chapter) {
		List<Verse> verses = Lists.newArrayList();
		if (verseNoFrom != null && verseNoTo != null) {
			int begin = Integer.parseInt(verseNoFrom);
			int end = Integer.parseInt(verseNoTo);
			for (int i = begin; i <= end; i++) {
				Verse verse = verseMapper.findByNumAndChapterId(String.valueOf(i), chapter.getId());
				if (verse == null) {
					return null;
				} else {
					verses.add(verse);
				}
			}
		} else if (verseNoFrom != null) {
			Verse verse = verseMapper.findByNumAndChapterId(verseNoFrom, chapter.getId());
			if (verse == null) {
				return null;
			} else {
				verses.add(verse);
			}

		} else {
			verses = verseMapper.findByChapterId(chapter.getId());
			verseNoFrom = verses.get(0).getNum();
			verseNoTo = verses.get(verses.size()).getNum();
		}
		return verses;
	}

	private String generateTokenName(Book book, Chapter chapter, List<Verse> verses) {
		String verseBound = verses.size() == 1 ? verses.get(0).getNum() : verses.get(0).getNum() + Verse.SEPARATOR
				+ verses.get(verses.size() - 1).getNum();
		return String.format("%s %s:%s", book.getAbbr(), chapter.getNum(), verseBound);
	}

}
