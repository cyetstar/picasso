package org.cyetstar.picasso.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cyetstar.picasso.domain.JsonResult;
import org.cyetstar.picasso.entity.Book;
import org.cyetstar.picasso.entity.Chapter;
import org.cyetstar.picasso.entity.Token;
import org.cyetstar.picasso.entity.Verse;
import org.cyetstar.picasso.service.BibleService;
import org.cyetstar.picasso.service.TokenService;
import org.cyetstar.picasso.web.servlet.EasyCookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/bible")
public class BibleController {

	public final static String BIBLE_LAST_READ = "bible_last_read";

	public final static String RECOMMEND_READ = "jhn.1";

	public final static String BOOK_CHAPTER_SEPARATOR = ".";

	@Autowired
	TokenService tokenService;

	@Autowired
	BibleService bibleService;

	@RequestMapping(method = RequestMethod.GET)
	public String index(@CookieValue(value = BIBLE_LAST_READ, defaultValue = RECOMMEND_READ) String lastRead,
			HttpServletRequest request, HttpServletResponse response, Model model) {
		String[] lastReads = lastRead.split("\\.");
		if (lastReads.length != 2) {
			throw new IllegalArgumentException();
		}
		Book book = bibleService.findBookWithDetail(lastReads[0]);
		Chapter chapter = bibleService.findChaptersByNumAndBookId(lastReads[1], lastReads[0]);
		saveLastRead(request, response, chapter);
		model.addAttribute("book", book);
		model.addAttribute("chapter", chapter);
		return "bible/index";
	}

	@RequestMapping(value = "token-content/{tokenId}", method = RequestMethod.GET)
	public String tokenContent(@PathVariable Long tokenId, Model model) {
		Token token = tokenService.findTokenWithDetail(tokenId);
		model.addAttribute(token);
		return "bible/token-content";
	}

	@RequestMapping(value = "chapter-content/{chapterId}", method = RequestMethod.GET)
	public String chapterContent(@PathVariable Long chapterId, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		Chapter chapter = bibleService.findChapterWithDetail(chapterId);
		saveLastRead(request, response, chapter);
		model.addAttribute("chapter", chapter);
		return "bible/chapter-content";
	}

	@RequestMapping(value = "chapters", method = RequestMethod.GET)
	public String chapters(@CookieValue(value = "BIBLE_LAST_READ", required = false) String lastRead,
			@RequestParam String bookId, Model model) {
		List<Chapter> chapters = bibleService.findChaptersByBookId(bookId);
		model.addAttribute("chapters", chapters);
		return "bible/chapters";
	}

	@RequestMapping(value = "chapters/{chapterId}", method = RequestMethod.GET)
	public String chapter(@PathVariable Long chapterId, Model model) {
		Chapter chapter = bibleService.findChapterWithDetail(chapterId);
		model.addAttribute("chapter", chapter);
		return "bible/bible-content";
	}

	@RequestMapping(value = "verse/save", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult<Verse> verseSave(@RequestParam String usfm, @RequestParam String vcontent) {
		JsonResult<Verse> result = new JsonResult<Verse>();
		try {
			Verse verse = bibleService.verseSave(usfm, vcontent);
			if (verse == null) {
				throw new RuntimeException("verse is null");
			}
			result.setSuccess(true);
			result.setData(verse);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.setMessage(e.getMessage());
		}
		return result;
	}

	private void saveLastRead(HttpServletRequest request, HttpServletResponse response, Chapter chapter) {
		String lastRead = chapter != null ? chapter.getBook().getId() + BOOK_CHAPTER_SEPARATOR + chapter.getNum()
				: RECOMMEND_READ;
		EasyCookie cookie = new EasyCookie(BIBLE_LAST_READ, lastRead, EasyCookie.ONE_YEAR);
		cookie.saveTo(request, response);
	}
}
