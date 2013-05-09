package org.cyetstar.picasso.web.controller;

import javax.validation.Valid;

import org.cyetstar.picasso.entity.User;
import org.cyetstar.picasso.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 * 用户注册的Controller.
 * 
 * @author calvin
 */
@Controller
@RequestMapping(value = "/signup")
public class SignupController {

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public String signupForm() {
		return "signup";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String signup(@Valid User user, RedirectAttributes redirectAttributes) {
		userService.registerUser(user);
		redirectAttributes.addFlashAttribute("username", user.getLoginName());
		return "redirect:/login";
	}

	/**
	 * Ajax请求校验loginName是否唯一。
	 */
	@RequestMapping(value = "checkLoginName")
	@ResponseBody
	public String checkLoginName(@RequestParam("loginName") String loginName) {
		if (userService.findUserByLoginName(loginName) == null) {
			return "true";
		} else {
			return "false";
		}
	}
}
