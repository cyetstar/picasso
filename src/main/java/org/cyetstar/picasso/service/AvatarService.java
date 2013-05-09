package org.cyetstar.picasso.service;

import java.io.File;
import java.io.IOException;

import net.coobird.thumbnailator.Thumbnails;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.cyetstar.picasso.entity.User;
import org.cyetstar.picasso.repository.mybatis.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;


@Component
public class AvatarService {

	public static final String AVATAR_ORIGIN_PATH = "static/avatar/origin/";
	public static final String AVATAR_LARGE_PATH = "static/avatar/large/";
	public static final String AVATAR_SMALL_PATH = "static/avatar/small/";
	public static final String AVATAR_MINI_PATH = "static/avatar/mini/";

	public static final String NORMAL_AVATAR = "avatar_normal.png";

	public static final String SUFFIX = ".jpg";

	public static final int AVATAR_MAX_WIDTH = 300;
	public static final int AVATAR_LARGE_WIDTH = 130;
	public static final int AVATAR_SMALL_WIDTH = 60;
	public static final int AVATAR_MINI_WIDTH = 45;

	@Autowired
	UserMapper userMapper;

	public String upload(Long userId, MultipartFile file, String rootPath) throws IOException {
		User user = userMapper.findOne(userId);
		String avatar = user.getAvatar();
		if (StringUtils.isEmpty(avatar)) {
			avatar = DigestUtils.md5Hex(user.getLoginName().toLowerCase()) + SUFFIX;
		}
		Thumbnails.of(file.getInputStream()).size(AVATAR_MAX_WIDTH, AVATAR_MAX_WIDTH)
				.toFile(rootPath + File.separator + AVATAR_ORIGIN_PATH + avatar);
		return avatar;
	}

	public String crop(Long userId, Croods croods, String rootPath) throws IOException {
		User user = userMapper.findOne(userId);
		String avatar = user.getAvatar();
		if (StringUtils.isEmpty(avatar)) {
			avatar = DigestUtils.md5Hex(user.getLoginName().toLowerCase()) + SUFFIX;
			user.setAvatar(avatar);
			userMapper.update(user);
		}
		String filePath = rootPath + File.separator + AVATAR_ORIGIN_PATH + avatar;
		Thumbnails.of(filePath).sourceRegion(croods.x, croods.y, croods.w, croods.h)
				.size(AVATAR_LARGE_WIDTH, AVATAR_LARGE_WIDTH)
				.toFile(rootPath + File.separator + AVATAR_LARGE_PATH + avatar);
		Thumbnails.of(filePath).sourceRegion(croods.x, croods.y, croods.w, croods.h)
				.size(AVATAR_SMALL_WIDTH, AVATAR_SMALL_WIDTH)
				.toFile(rootPath + File.separator + AVATAR_SMALL_PATH + avatar);
		Thumbnails.of(filePath).sourceRegion(croods.x, croods.y, croods.w, croods.h)
				.size(AVATAR_MINI_WIDTH, AVATAR_MINI_WIDTH)
				.toFile(rootPath + File.separator + AVATAR_MINI_PATH + avatar);
		return avatar;
	}

	public static class Croods {
		public int w;
		public int h;
		public int x;
		public int y;
		public int x2;
		public int y2;

		public void setW(int w) {
			this.w = w;
		}

		public void setH(int h) {
			this.h = h;
		}

		public void setX(int x) {
			this.x = x;
		}

		public void setY(int y) {
			this.y = y;
		}

		public void setX2(int x2) {
			this.x2 = x2;
		}

		public void setY2(int y2) {
			this.y2 = y2;
		}

	}

}
