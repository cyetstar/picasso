package org.cyetstar.picasso.web.controller;

import org.cyetstar.picasso.entity.User;
import org.cyetstar.picasso.service.FollowershipService;
import org.cyetstar.picasso.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class FamilyController {

	public static final int PAGE_SIZE = 10;

	@Autowired
	FollowershipService followershipService;

	@Autowired
	UserService userService;

	@RequestMapping(value = "family")
	public String family(@RequestParam(value = "page", defaultValue = "1") int pageNum, Model model) {
		Page<User> users = userService.findUserNoFollow(User.getCurrentUserId(), pageNum, PAGE_SIZE);
		model.addAttribute("users", users);
		return "user/family";
	}
}
