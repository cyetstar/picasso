package org.cyetstar.picasso.entity;

import java.util.List;

/**
 * 参考标签
 * 
 * @author cyetstar
 * 
 */
public class Token extends IdEntity {

	private String name;

	private Book book;

	private Chapter chapter;

	private List<Verse> verses;

	private List<Post> posts;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
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

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public String getFullName() {
		return this.name.replace(book.getAbbr(), book.getTitle());
	}

}
