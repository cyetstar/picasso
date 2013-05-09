package org.cyetstar.picasso.web.controller;

import org.cyetstar.picasso.entity.Followership;
import org.cyetstar.picasso.entity.Post;
import org.cyetstar.picasso.entity.User;
import org.cyetstar.picasso.service.FollowershipService;
import org.cyetstar.picasso.service.PostService;
import org.cyetstar.picasso.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/posts")
public class PostController {

	public static final int PAGE_SIZE = 10;

	@Autowired
	PostService postService;

	@Autowired
	UserService userService;

	@Autowired
	FollowershipService followershipService;

	/**
	 * 用户笔记
	 * 
	 * @param userId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "{userId}", method = RequestMethod.GET)
	public String posts(@PathVariable Long userId, Model model) {
		User user = userService.findUserWithDetail(userId);
		// 如果是当前用户，则允许查看所有笔记
		boolean myself = userId.longValue() == User.getCurrentUserId().longValue();
		Page<Post> posts = postService.findByUserId(userId, myself, 1, PAGE_SIZE);
		model.addAttribute("myself", myself);
		model.addAttribute("user", user);
		model.addAttribute("posts", posts);
		// 如果不是当前用户，则需要查看该用户的关联信息。
		if (!myself) {
			Followership followership = followershipService.findFollowershipByLeaderIdAndFollowerId(userId,
					User.getCurrentUserId());
			model.addAttribute("followership", followership);
		}
		return "posts/index";
	}

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String posts(@RequestParam(value = "userId") Long useId,
			@RequestParam(value = "page", defaultValue = "1") int pageNum, Model model) {
		boolean all = useId == User.getCurrentUserId();
		Page<Post> posts = postService.findByUserId(useId, all, pageNum, PAGE_SIZE);
		model.addAttribute("page", pageNum);
		model.addAttribute("posts", posts);
		return "posts/list";
	}

	@RequestMapping(value = "following-list", method = RequestMethod.GET)
	public String posts(@RequestParam(value = "page", defaultValue = "1") int pageNum,
			@RequestParam(value = "collectionId", required = false) Long collectionId, Model model) {
		Page<Post> posts = null;
		if (collectionId == null || collectionId < 0) {
			posts = postService.findFollowingPost(User.getCurrentUserId(), pageNum, PAGE_SIZE);
		} else {
			posts = postService.findFollowingPostByCollectionId(collectionId, pageNum, PAGE_SIZE);
		}
		model.addAttribute("page", pageNum);
		model.addAttribute("posts", posts);
		return "posts/following-list";
	}

	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String create(Post post, Model model) {
		post.setUser(new User(User.getCurrentUserId()));
		postService.savePost(post);
		return "redirect:/";
	}

}
