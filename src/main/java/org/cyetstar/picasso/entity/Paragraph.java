package org.cyetstar.picasso.entity;

import java.util.List;

/**
 * 段落，每区段有N个段落
 * 
 * @author cyetstar
 * 
 */
public class Paragraph extends IdEntity {

	private String title;

	private String subtitle;

	private String sectionTitle;

	private String relatedTitle;

	private String dialogTitle;

	private String epilog;

	private String type;

	private Chapter chapter;

	private List<Verse> verses;

	private String verseNoFrom;

	private String verseNoTo;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public String getSectionTitle() {
		return sectionTitle;
	}

	public void setSectionTitle(String sectionTitle) {
		this.sectionTitle = sectionTitle;
	}

	public String getRelatedTitle() {
		return relatedTitle;
	}

	public void setRelatedTitle(String relatedTitle) {
		this.relatedTitle = relatedTitle;
	}

	public String getDialogTitle() {
		return dialogTitle;
	}

	public void setDialogTitle(String dialogTitle) {
		this.dialogTitle = dialogTitle;
	}

	public String getEpilog() {
		return epilog;
	}

	public void setEpilog(String epilog) {
		this.epilog = epilog;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Chapter getChapter() {
		return chapter;
	}

	public void setChapter(Chapter chapter) {
		this.chapter = chapter;
	}

	public List<Verse> getVerses() {
		return verses;
	}

	public void setVerses(List<Verse> verses) {
		this.verses = verses;
	}

	public String getVerseNoFrom() {
		if (verseNoFrom == null && verses != null && !verses.isEmpty()) {
			verseNoFrom = verses.get(0).getNum();
		}
		return verseNoFrom;
	}

	public void setVerseNoFrom(String verseNoFrom) {
		this.verseNoFrom = verseNoFrom;
	}

	public String getVerseNoTo() {
		if (verseNoTo == null && verses != null && !verses.isEmpty()) {
			Verse end = verses.get(verses.size() - 1);
			if (end.getNum3() != null) {
				verseNoTo = end.getNum3();
			} else if (end.getNum2() != null) {
				verseNoTo = end.getNum2();
			} else {
				verseNoTo = end.getNum();
			}
		}
		return verseNoTo;
	}

	public void setVerseNoTo(String verseNoTo) {
		this.verseNoTo = verseNoTo;
	}

	public void addVerse(Verse verse) {
		this.verses.add(verse);
	}

}
