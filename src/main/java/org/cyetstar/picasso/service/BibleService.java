package org.cyetstar.picasso.service;

import java.util.List;

import org.cyetstar.picasso.entity.Book;
import org.cyetstar.picasso.entity.Chapter;
import org.cyetstar.picasso.entity.Verse;
import org.cyetstar.picasso.repository.mybatis.BookMapper;
import org.cyetstar.picasso.repository.mybatis.ChapterMapper;
import org.cyetstar.picasso.repository.mybatis.VerseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;


@Component
@Transactional(readOnly = true)
public class BibleService {

	@Autowired
	BookMapper bookMapper;

	@Autowired
	ChapterMapper chapterMapper;

	@Autowired
	VerseMapper verseMapper;

	public Book findBookWithDetail(String id) {
		return bookMapper.findWithDetail(id);
	}

	public Chapter findChapterWithDetail(Long id) {
		return chapterMapper.findWithDetail(id);
	}

	public List<Chapter> findChaptersByBookId(String bookId) {
		return chapterMapper.findChaptersByBookId(bookId);
	}

	public Chapter findChaptersByNumAndBookId(String num, String bookId) {
		return chapterMapper.findWithDetailByNumAndBookId(num, bookId);
	}

	@Transactional
	public Verse verseSave(String usfm, String vcontent) {
		String[] usfmArray = usfm.split("\\+");
		Verse verse = null;
		for (String key : usfmArray) {
			String[] keyArray = key.split("\\.");
			if (keyArray.length != 3) {
				throw new IllegalArgumentException("usfm不合法");
			}
			String bookId = keyArray[0].toLowerCase();
			String chapterNum = keyArray[1];
			String verseNum = keyArray[2];
			verse = verseSave(bookId, chapterNum, verseNum, vcontent, verse);
		}
		return verse;
	}

	private Verse verseSave(String bookId, String chapterNum, String verseNum, String vcontent, Verse verse) {
		Book book = new Book(bookId);
		Chapter chapter = chapterMapper.findByNumAndBookId(chapterNum, bookId);
		if (verse == null) {
			verse = verseMapper.findByNumsAndChapterId(verseNum, chapter.getId());
		}
		if (verse == null) {
			verse = new Verse();
			verse.setBook(book);
			verse.setChapter(chapter);
			verse.setNum(verseNum);
			verse.setText(vcontent);
			verseMapper.insert(verse);
		} else {
			if (!verseNum.equals(verse.getNum()) && !verseNum.equals(verse.getNum2())
					&& !verseNum.equals(verse.getNum3())) {
				if (verse.getNum2() == null) {
					verse.setNum2(verseNum);
				} else if (verse.getNum3() == null) {
					verse.setNum3(verseNum);
				} else {
					throw new RuntimeException("num超出结构设计范围");
				}
			} else {
				String dealText = dealText(vcontent);
				if (verse.getText2() == null) {
					if (!verse.getText().equals(dealText)) {
						verse.setText2(dealText);
					}
				} else if (verse.getText3() == null) {
					if (!verse.getText2().equals(dealText)) {
						verse.setText3(dealText);
					}
				} else if (verse.getText4() == null) {
					if (!verse.getText3().equals(dealText)) {
						verse.setText4(dealText);
					}
				} else if (verse.getText5() == null) {
					if (!verse.getText4().equals(dealText)) {
						verse.setText5(dealText);
					}
				} else if (verse.getText6() == null) {
					if (!verse.getText5().equals(dealText)) {
						verse.setText6(dealText);
					}
				} else if (verse.getText7() == null) {
					if (!verse.getText6().equals(dealText)) {
						verse.setText7(dealText);
					}
				} else if (verse.getText8() == null) {
					if (!verse.getText7().equals(dealText)) {
						verse.setText8(dealText);
					}
				} else if (verse.getText9() == null) {
					if (!verse.getText8().equals(dealText)) {
						verse.setText9(dealText);
					}
				} else if (verse.getText10() == null) {
					if (!verse.getText9().equals(dealText)) {
						verse.setText10(dealText);
					}
				} else if (verse.getText11() == null) {
					if (!verse.getText10().equals(dealText)) {
						verse.setText11(dealText);
					}
				} else if (verse.getText12() == null) {
					if (!verse.getText11().equals(dealText)) {
						verse.setText12(dealText);
					}
				} else if (verse.getText13() == null) {
					if (!verse.getText12().equals(dealText)) {
						verse.setText13(dealText);
					}
				} else if (verse.getText14() == null) {
					if (!verse.getText13().equals(dealText)) {
						verse.setText14(dealText);
					}
				} else if (verse.getText15() == null) {
					if (!verse.getText14().equals(dealText)) {
						verse.setText15(dealText);
					}
				} else {
					throw new RuntimeException("text超出结构设计范围");
				}
			}
			verseMapper.update(verse);
		}
		return verse;
	}

	private String dealText(String text) {
		if (StringUtils.hasText(text.replace("<span class=\"content\">", "").replace("</span>", ""))) {
			return text;
		} else {
			return null;
		}
	}
}
