package org.cyetstar.picasso.web.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author cyetstar
 */
@Controller
public class AdminController {

	@RequestMapping("/admin")
	public String index(Model model) {
		return "admin/index";
	}

}
