package org.cyetstar.picasso.service;

import java.util.List;

import org.apache.commons.lang3.Validate;
import org.cyetstar.picasso.entity.Chapter;
import org.cyetstar.picasso.entity.Paragraph;
import org.cyetstar.picasso.entity.Verse;
import org.cyetstar.picasso.repository.mybatis.ChapterMapper;
import org.cyetstar.picasso.repository.mybatis.ParagraphMapper;
import org.cyetstar.picasso.repository.mybatis.VerseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;


@Component
public class ParagraphService {

	@Autowired
	ParagraphMapper paragraphMapper;

	@Autowired
	VerseMapper verseMapper;

	@Autowired
	ChapterMapper chapterMapper;

	@Autowired
	VerseService verseService;

	public List<Paragraph> findParagraphByChapter(Long chapterId) {
		return paragraphMapper.findWithDetailByChapterId(chapterId);
	}

	public Paragraph findParagraph(Long id) {
		return paragraphMapper.findWithDetail(id);
	}

	@Transactional
	public Paragraph saveParagraph(Paragraph paragraph) {
		Chapter chapter = paragraph.getChapter();
		Validate.notNull(chapter);
		if (chapter.isContainJoinVerse() == null) {
			chapter = chapterMapper.findOne(chapter.getId());
		}
		List<Verse> verses = verseService.findVersesStepByStep(paragraph.getVerseNoFrom(), paragraph.getVerseNoTo(),
				chapter);
		if (paragraph.getId() == null) {
			paragraphMapper.insert(paragraph);
		} else {
			paragraphMapper.update(paragraph);
		}
		for (Verse verse : verses) {
			verse.setParagraph(paragraph);
			verseMapper.update(verse);
		}
		return paragraph;
	}

	@Transactional
	public void saveParagraphBatch(String[] verseNoFroms, String[] verseNoTos, String type, Long chapterId) {
		Chapter chapter = chapterMapper.findOne(chapterId);
		Validate.isTrue(verseNoFroms.length == verseNoTos.length);
		for (int i = 0; i < verseNoFroms.length; i++) {
			if (StringUtils.hasText(verseNoFroms[i]) && StringUtils.hasText(verseNoTos[i])) {
				Paragraph paragraph = new Paragraph();
				paragraph.setChapter(chapter);
				paragraph.setVerseNoFrom(verseNoFroms[i]);
				paragraph.setVerseNoTo(verseNoTos[i]);
				paragraph.setType(type);
				saveParagraph(paragraph);
			}
		}
	}

	public void deleteParagraph(Long id) {
		Paragraph paragraph = paragraphMapper.findWithDetail(id);
		paragraphMapper.delete(id);
		for (Verse verse : paragraph.getVerses()) {
			verse.setParagraph(null);
			verseMapper.update(verse);
		}
	}
}
