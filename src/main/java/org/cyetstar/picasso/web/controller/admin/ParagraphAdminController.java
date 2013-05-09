package org.cyetstar.picasso.web.controller.admin;

import java.util.List;

import org.cyetstar.picasso.entity.Paragraph;
import org.cyetstar.picasso.service.ParagraphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/admin/paragraph")
public class ParagraphAdminController {

	@Autowired
	private ParagraphService paragraphService;

	@RequestMapping
	public String index(Model model) {
		return "admin/paragraphList";
	}

	@RequestMapping("/list")
	public String list(@RequestParam(required = false) Long chapterId, Model model) {
		List<Paragraph> paragraphs = paragraphService.findParagraphByChapter(chapterId);
		model.addAttribute("paragraphs", paragraphs);
		return "admin/paragraphList";
	}

	@RequestMapping("/add")
	public String add(Model model) {
		model.addAttribute("action", "create");
		return "admin/paragraphForm";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(Paragraph paragraph, RedirectAttributes redirectAttributes) {
		paragraphService.saveParagraph(paragraph);
		redirectAttributes.addFlashAttribute("message", "创建段落成功");
		return "admin/paragraphForm";
	}

	@RequestMapping("/edit")
	public String edit(@RequestParam Long id, Model model) {
		Paragraph paragraph = paragraphService.findParagraph(id);
		model.addAttribute("paragraph", paragraph);
		model.addAttribute("action", "update");
		return "admin/paragraphForm";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(Paragraph paragraph, RedirectAttributes redirectAttributes) {
		paragraphService.saveParagraph(paragraph);
		redirectAttributes.addFlashAttribute("message", "更新段落成功");
		return "admin/paragraphForm";
	}

	@RequestMapping("/addBatch")
	public String addBatch(Model model) {
		model.addAttribute("action", "createBatch");
		return "admin/paragraphBatchForm";
	}

	@RequestMapping(value = "/createBatch", method = RequestMethod.POST)
	public String create(@RequestParam Long chapterId, @RequestParam("verseNoFrom") String[] verseNoFroms,
			@RequestParam("verseNoTo") String[] verseNoTos, @RequestParam String type,
			RedirectAttributes redirectAttributes) {
		paragraphService.saveParagraphBatch(verseNoFroms, verseNoTos, type, chapterId);
		redirectAttributes.addFlashAttribute("message", "创建段落成功");
		return "admin/paragraphForm";
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam Long id, RedirectAttributes redirectAttributes) {
		paragraphService.deleteParagraph(id);
		redirectAttributes.addFlashAttribute("message", "删除段落成功");
		return "redicrect:admin/paragraph/list";
	}

	@RequestMapping("/preview")
	public String preview(@RequestParam Long id, Model model) {
		return "admin/paragraphList";
	}

}
