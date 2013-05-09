package org.cyetstar.picasso.web.controller.settings;

import org.apache.shiro.SecurityUtils;
import org.cyetstar.picasso.entity.Profile;
import org.cyetstar.picasso.entity.User;
import org.cyetstar.picasso.service.UserService;
import org.cyetstar.picasso.service.ShiroDbRealm.ShiroUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * 用户修改自己资料的Controller.
 * 
 */
@Controller
@RequestMapping("/settings")
public class ProfileController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "profile", method = RequestMethod.GET)
	public String profile(Model model) {
		Profile profile = userService.findProfileByUserId(User.getCurrentUserId());
		model.addAttribute("profile", profile);
		return "settings/profile";
	}

	@RequestMapping(value = "profile", method = RequestMethod.POST)
	public String profile(@ModelAttribute("profile") Profile profile, Model model) {
		userService.saveProfile(profile);
		updateCurrentName(profile.getUser().getName());
		model.addAttribute("success", true);
		return "settings/profile";
	}

	@ModelAttribute
	public void getProfile(@RequestParam(value = "id", required = false) Long id, Model model) {
		if (id != null) {
			model.addAttribute("profile", userService.findProfile(id));
		}
	}

	private void updateCurrentName(String name) {
		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		user.name = name;
	}
}
