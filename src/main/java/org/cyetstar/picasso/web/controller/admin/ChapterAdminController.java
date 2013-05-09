package org.cyetstar.picasso.web.controller.admin;

import java.util.List;

import org.cyetstar.picasso.domain.JsonResult;
import org.cyetstar.picasso.entity.Chapter;
import org.cyetstar.picasso.repository.mybatis.ChapterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/admin/chapter")
public class ChapterAdminController {

	@Autowired
	private ChapterMapper chapterMapper;

	@RequestMapping("/list")
	@ResponseBody
	public JsonResult<List<Chapter>> list(@RequestParam String bookId) {
		JsonResult<List<Chapter>> result = new JsonResult<List<Chapter>>();
		try {
			List<Chapter> chapters = chapterMapper.findChaptersByBookId(bookId);
			result.setSuccess(true);
			result.setData(chapters);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.setMessage(e.getMessage());
		}
		return result;
	}

}
