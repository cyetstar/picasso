package org.cyetstar.picasso.web.controller.settings;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.cyetstar.picasso.entity.User;
import org.cyetstar.picasso.service.AvatarService;
import org.cyetstar.picasso.service.AvatarService.Croods;
import org.cyetstar.picasso.service.ShiroDbRealm.ShiroUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping("/settings")
public class AvatarController {

	@Autowired
	AvatarService avatarService;

	@RequestMapping(value = "avatar", method = RequestMethod.GET)
	public String avatar() {
		return "settings/avatar";
	}

	@RequestMapping(value = "avatar/upload", method = RequestMethod.POST)
	public String avatarUpload(@RequestParam(value = "file") MultipartFile file, HttpSession session, Model model)
			throws IOException {
		if (!file.isEmpty()) {
			String rootPath = session.getServletContext().getRealPath("/");
			String avatar = avatarService.upload(User.getCurrentUserId(), file, rootPath);
			model.addAttribute("avatar", avatar);
		}
		return "settings/avatar";
	}

	@RequestMapping(value = "avatar/crop", method = RequestMethod.POST)
	public String avatarCrop(Croods croods, HttpSession session, Model model) throws IOException {
		String rootPath = session.getServletContext().getRealPath("/");
		String avatar = avatarService.crop(User.getCurrentUserId(), croods, rootPath);
		avatar += "?" + new Date().getTime();
		updateCurrentAvatar(avatar);
		model.addAttribute("avatar", avatar);
		model.addAttribute("success", true);
		return "settings/avatar";
	}

	private void updateCurrentAvatar(String avatar) {
		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		user.avatar = avatar;
	}

}
