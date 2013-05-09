package org.cyetstar.picasso.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.Validate;
import org.cyetstar.picasso.entity.Chapter;
import org.cyetstar.picasso.entity.Verse;
import org.cyetstar.picasso.repository.mybatis.VerseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
@Transactional(readOnly = true)
public class VerseService {

	@Autowired
	VerseMapper verseMapper;

	public List<Verse> findVersesStepByStep(String verseNoFrom, String verseNoTo, Chapter chapter) {
		Validate.notNull(verseNoFrom);
		Validate.notNull(verseNoTo);
		Validate.notNull(chapter);
		int begin = Integer.parseInt(verseNoFrom);
		int end = Integer.parseInt(verseNoTo);
		Map<Long, Verse> versesMap = new HashMap<Long, Verse>();
		for (int i = begin; i <= end; i++) {
			Verse verse = null;
			if (chapter.isContainJoinVerse()) {
				verse = verseMapper.findByNumsAndChapterId(String.valueOf(i), chapter.getId());
			} else {
				verse = verseMapper.findByNumAndChapterId(String.valueOf(i), chapter.getId());
			}
			if (verse == null) {
				return null;
			} else {
				versesMap.put(verse.getId(), verse);
			}
		}
		return new ArrayList<Verse>(versesMap.values());
	}

}
