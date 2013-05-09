package org.cyetstar.picasso.utils;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.cyetstar.picasso.entity.Book;
import org.cyetstar.picasso.repository.mybatis.BookMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;


public class DictData {

	static Logger log = LoggerFactory.getLogger(DictData.class);

	static String BOOK = "book";

	static String PARAGRAPH_TYPE = "paragraphType";

	static Map<String, Map<String, String>> dataMap = new HashMap<String, Map<String, String>>();

	@Autowired
	BookMapper bookMapper;

	public void init() {
		load();
	}

	public void load() {
		log.debug("loading dictionary data from database.");
		loadBook();
		loadParagraphType();
	}

	public void reload() {
		log.debug("reloading dictionary data from database.");
	}

	public static Map<String, String> bookMap() {
		return dataMap.get(BOOK);
	}

	public static Map<String, String> paragraphTypeMap() {
		return dataMap.get(PARAGRAPH_TYPE);
	}

	private void loadBook() {
		log.debug("loading BOOK from database.");
		Order order = new Order(Direction.ASC, "seq");
		List<Book> books = bookMapper.findAll(order);
		Map<String, String> bookMap = new LinkedHashMap<String, String>();
		for (Book book : books) {
			bookMap.put(book.getId(), book.getTitle());
		}
		dataMap.put(BOOK, bookMap);
	}

	private void loadParagraphType() {
		log.debug("loading PARAGRAPH TYPE from database.");
		Map<String, String> typeMap = new LinkedHashMap<String, String>();
		typeMap.put("p", "P");
		typeMap.put("q", "Q");
		dataMap.put(PARAGRAPH_TYPE, typeMap);
	}

}
