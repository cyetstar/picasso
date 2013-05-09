package org.cyetstar.picasso.web.controller;

import java.util.List;

import org.cyetstar.picasso.domain.JsonResult;
import org.cyetstar.picasso.entity.Followership;
import org.cyetstar.picasso.entity.FollowershipCollection;
import org.cyetstar.picasso.entity.User;
import org.cyetstar.picasso.service.FollowershipService;
import org.cyetstar.picasso.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/followership")
public class FollowershipController {

	public static final int PAGE_SIZE = 10;

	@Autowired
	FollowershipService followershipService;

	@Autowired
	UserService userService;

	// TODO
	@RequestMapping(value = "following", method = RequestMethod.GET)
	public String following(@RequestParam(value = "page", defaultValue = "1") int pageNum, Model model) {
		Page<User> users = followershipService.findLeaderByFollowerId(User.getCurrentUserId(), 1, PAGE_SIZE);
		model.addAttribute("users", users);
		// TODO
		return "follow/follow";
	}

	// TODO
	@RequestMapping(value = "follower", method = RequestMethod.GET)
	public String follower(@RequestParam(value = "page", defaultValue = "1") int pageNum, Model model) {
		Page<User> users = followershipService.findLeaderByFollowerId(User.getCurrentUserId(), 1, PAGE_SIZE);
		model.addAttribute("users", users);
		return "follow/follow";
	}

	// // TODO
	// @RequestMapping(value = "{screenName}/following", method =
	// RequestMethod.GET)
	// public String following(@PathVariable("screenName") String screenName,
	// @RequestParam(value = "page", defaultValue = "1") int pageNum, Model
	// model) {
	// Page<User> users =
	// followershipService.findLeaderByFollowerScreenName(screenName, 1,
	// PAGE_SIZE);
	// model.addAttribute("users", users);
	// return "follow/following";
	// }

	// TODO
	@RequestMapping(value = "{screenName}/follower", method = RequestMethod.GET)
	public String follower(@PathVariable("screenName") String screenName,
			@RequestParam(value = "page", defaultValue = "1") int pageNum, Model model) {
		User user = userService.findUserByScreenName(screenName);
		Long followerId = user == null ? Long.valueOf(screenName) : user.getId();
		Page<User> users = followershipService.findLeaderByFollowerId(followerId, 1, PAGE_SIZE);
		model.addAttribute("users", users);
		return "follow/follower";
	}

	@RequestMapping(value = "/following-aside", method = RequestMethod.GET)
	public String follow(@RequestParam(value = "userId", required = false) Long userId,
			@RequestParam(value = "pageSize", defaultValue = "6") int pageSize, Model model) {
		if (userId == null) {
			userId = User.getCurrentUserId();
		}
		Page<User> users = followershipService.findLeaderByFollowerId(userId, 1, pageSize);
		model.addAttribute("users", users);
		return "followership/aside";
	}

	@RequestMapping(value = "follow", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult<Followership> follow(@RequestParam("leaderId") Long leaderId) {
		JsonResult<Followership> result = new JsonResult<Followership>();
		try {
			Followership followership = followershipService.follow(leaderId, User.getCurrentUserId(), null);
			result.setSuccess(true);
			result.setData(followership);
		} catch (Exception e) {
			result.setSuccess(false);
			result.setMessage(e.getMessage());
		}
		return result;
	}

	@RequestMapping(value = "unfollow", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult<Followership> unfollow(@RequestParam("leaderId") Long leaderId) {
		JsonResult<Followership> result = new JsonResult<Followership>();
		try {
			followershipService.unfollow(leaderId, User.getCurrentUserId());
			result.setSuccess(true);
		} catch (Exception e) {
			result.setSuccess(false);
			result.setMessage(e.getMessage());
		}
		return result;
	}

	@RequestMapping(value = "remark", method = RequestMethod.GET)
	public String remark(@RequestParam("leaderId") Long leaderId, Model model) {
		Followership followership = followershipService.findFollowershipByLeaderIdAndFollowerId(leaderId,
				User.getCurrentUserId());
		List<FollowershipCollection> followershipCollections = followershipService
				.findFollowershipCollectionsByUserId(User.getCurrentUserId());
		model.addAttribute("followership", followership);
		model.addAttribute("followershipCollections", followershipCollections);
		return "followership/remark";
	}

	@RequestMapping(value = "remark", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult<Followership> remark(Followership followership,
			@RequestParam(value = "collectionIds", required = false) List<Long> collectionIds) {
		JsonResult<Followership> result = new JsonResult<Followership>();
		try {
			followershipService.saveFollowership(followership, collectionIds);
			result.setSuccess(true);
			result.setData(followership);
		} catch (Exception e) {
			result.setSuccess(false);
			result.setMessage(e.getMessage());
		}
		return result;
	}

	@RequestMapping(value = "/collection/create", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult<FollowershipCollection> followershipCollection(@RequestParam("name") String name) {
		JsonResult<FollowershipCollection> result = new JsonResult<FollowershipCollection>();
		try {
			FollowershipCollection collection = followershipService.saveFollowershipCollection(User.getCurrentUserId(),
					name);
			result.setSuccess(true);
			result.setData(collection);
		} catch (Exception e) {
			result.setSuccess(false);
			result.setMessage(e.getMessage());
		}
		return result;
	}

}
