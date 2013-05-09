package org.cyetstar.picasso.web.controller.settings;

import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
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
public class AccountController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "account", method = RequestMethod.GET)
	public String account(Model model) {
		model.addAttribute("user", userService.findUser(User.getCurrentUserId()));
		return "settings/account";
	}

	@RequestMapping(value = "account", method = RequestMethod.POST)
	public String account(@Valid @ModelAttribute("user") User user, Model model) {
		userService.updateUser(user);
		updateCurrentScreenName(user.getScreenName());
		model.addAttribute("success", true);
		return "settings/account";
	}

	@RequestMapping(value = "password", method = RequestMethod.GET)
	public String password() {
		return "settings/password";
	}

	@RequestMapping(value = "password", method = RequestMethod.POST)
	public String password(String oldPassword, User user, Model model) {
		userService.updatePassword(User.getCurrentUserId(), oldPassword, user.getPlainPassword());
		model.addAttribute("success", true);
		return "settings/password";
	}

	@ModelAttribute
	public void getUser(@RequestParam(value = "id", required = false) Long id, Model model) {
		if (id != null) {
			model.addAttribute("user", userService.findUser(id));
		}
	}

	private void updateCurrentScreenName(String screenName) {
		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		user.screenName = screenName;
	}
}
