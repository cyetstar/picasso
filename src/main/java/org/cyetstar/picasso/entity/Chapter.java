package org.cyetstar.picasso.entity;

import java.util.List;

/**
 * 章
 * 
 * @author cyetstar
 * 
 */
public class Chapter extends IdEntity {

	private String num;

	private Boolean containJoinVerse;

	private Book book;

	private List<Paragraph> paragraphs;

	private List<Verse> verses;

	private List<Token> tokens;

	private String text;

	public Chapter() {

	}

	public Chapter(Long id) {
		this.id = id;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public Boolean isContainJoinVerse() {
		return containJoinVerse;
	}

	public void setContainJoinVerse(Boolean containJoinVerse) {
		this.containJoinVerse = containJoinVerse;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public List<Paragraph> getParagraphs() {
		return paragraphs;
	}

	public void setParagraphs(List<Paragraph> paragraphs) {
		this.paragraphs = paragraphs;
	}

	public List<Verse> getVerses() {
		return verses;
	}

	public void setVerses(List<Verse> verses) {
		this.verses = verses;
	}

	public List<Token> getTokens() {
		return tokens;
	}

	public void setTokens(List<Token> tokens) {
		this.tokens = tokens;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
