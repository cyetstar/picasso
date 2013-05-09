package org.cyetstar.picasso.entity;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.cyetstar.picasso.service.AvatarService;
import org.cyetstar.picasso.service.ShiroDbRealm.ShiroUser;
import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.ImmutableList;

public class User extends IdEntity {

	private String loginName;

	private String screenName;

	private String name;

	private String plainPassword;

	private String password;

	private String salt;

	private String roles;

	private String avatar;

	private DateTime createdAt;

	private Profile profile;

	public User() {

	}

	public User(Long id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlainPassword() {
		return plainPassword;
	}

	public void setPlainPassword(String plainPassword) {
		this.plainPassword = plainPassword;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public DateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(DateTime createdAt) {
		this.createdAt = createdAt;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public String getScreenNameOrId() {
		return this.screenName == null ? String.valueOf(this.getId()) : this.screenName;
	}

	@JsonIgnore
	public List<String> getRoleList() {
		// 角色列表在数据库中实际以逗号分隔字符串存储，因此返回不能修改的List.
		return ImmutableList.copyOf(StringUtils.split(roles, ","));
	}

	public static Long getCurrentUserId() {
		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		return user.id;
	}

	public static String getCurrentUserScreenName() {
		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		return user.getScreenName();
	}

	public String getOriginAvatar() {
		if (!StringUtils.isEmpty(this.avatar)) {
			return AvatarService.AVATAR_ORIGIN_PATH + this.avatar;
		} else {
			return AvatarService.AVATAR_ORIGIN_PATH + AvatarService.NORMAL_AVATAR;
		}
	}

	public String getLargeAvatar() {
		if (!StringUtils.isEmpty(this.avatar)) {
			return AvatarService.AVATAR_LARGE_PATH + this.avatar;
		} else {
			return AvatarService.AVATAR_LARGE_PATH + AvatarService.NORMAL_AVATAR;
		}
	}

	public String getSmallAvatar() {
		if (!StringUtils.isEmpty(this.avatar)) {
			return AvatarService.AVATAR_SMALL_PATH + this.avatar;
		} else {
			return AvatarService.AVATAR_SMALL_PATH + AvatarService.NORMAL_AVATAR;
		}
	}

	public String getMiniAvatar() {
		if (!StringUtils.isEmpty(this.avatar)) {
			return AvatarService.AVATAR_MINI_PATH + this.avatar;
		} else {
			return AvatarService.AVATAR_MINI_PATH + AvatarService.NORMAL_AVATAR;
		}
	}
}
