package org.cyetstar.picasso.web.controller;

import java.util.List;

import org.cyetstar.picasso.entity.FollowershipCollection;
import org.cyetstar.picasso.entity.User;
import org.cyetstar.picasso.service.FollowershipService;
import org.cyetstar.picasso.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 
 * @author cyetstar
 */
@Controller
public class IndexController {

	@Autowired
	FollowershipService followershipService;

	@Autowired
	UserService userService;

	/**
	 * 系统首页
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/")
	public String index(Model model) {
		// 取得当前用户关注分类
		List<FollowershipCollection> followershipCollections = followershipService
				.findFollowershipCollectionsByUserId(User.getCurrentUserId());
		model.addAttribute("followershipCollections", followershipCollections);
		return "index";
	}

	/**
	 * 用户主页
	 * 
	 * @param screenName
	 * @return
	 */
	@RequestMapping("/{screenName}")
	public String home(@PathVariable("screenName") String screenName) {
		User user = userService.findUserByScreenName(screenName);
		if (user == null) {
			// 未设置screenName，则认为该值为用户id。
			user = userService.findUser(Long.valueOf(screenName));
			if (user == null) {
				return "redirect:error/404";
			}
		}
		return "forward:/posts/" + user.getId();
	}

}
