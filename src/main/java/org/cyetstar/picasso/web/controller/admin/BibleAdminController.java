package org.cyetstar.picasso.web.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/bible")
public class BibleAdminController {

	@RequestMapping
	public String index() {
		return "redirect:/admin/paragraph";
	}

}
