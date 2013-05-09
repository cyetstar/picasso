package org.cyetstar.picasso.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.cyetstar.picasso.entity.Profile;
import org.cyetstar.picasso.entity.User;
import org.cyetstar.picasso.repository.mybatis.ProfileMapper;
import org.cyetstar.picasso.repository.mybatis.UserMapper;
import org.cyetstar.picasso.service.ShiroDbRealm.ShiroUser;
import org.cyetstar.picasso.utils.Digests;
import org.cyetstar.picasso.utils.Encodes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


/**
 * 用户管理类.
 * 
 * @author calvin
 */
// Spring Service Bean的标识.
@Component
@Transactional(readOnly = true)
public class UserService {

	public static final String HASH_ALGORITHM = "SHA-1";
	public static final int HASH_INTERATIONS = 1024;
	private static final int SALT_SIZE = 8;

	private static Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	UserMapper userMapper;

	@Autowired
	ProfileMapper profileMapper;

	public Page<User> findUserNoFollow(Long userId, int pageNum, int pageSize) {
		Pageable pageable = new PageRequest(pageNum - 1, pageSize);
		List<User> content = userMapper.findNoFollow(userId, pageable);
		long total = userMapper.countNoFollow(userId);
		return new PageImpl<User>(content, pageable, total);
	}

	public User findUser(Long id) {
		return userMapper.findOne(id);
	}

	public User findUserWithDetail(Long id) {
		return userMapper.findWithDetail(id);
	}

	public User findUserByLoginName(String loginName) {
		return userMapper.findByLoginName(loginName);
	}

	public User findUserByScreenName(String screenName) {
		return userMapper.findByScreenName(screenName);
	}

	@Transactional(readOnly = false)
	public void registerUser(User user) {
		entryptPassword(user);
		user.setRoles("user");
		userMapper.insert(user);
	}

	@Transactional(readOnly = false)
	public void updateUser(User user) {
		if (StringUtils.isNotBlank(user.getPlainPassword())) {
			entryptPassword(user);
		}
		userMapper.update(user);
	}

	@Transactional(readOnly = false)
	public void updatePassword(Long userId, String oldPassword, String newPassword) {
		User user = userMapper.findOne(userId);
		user.setPlainPassword(newPassword);
		entryptPassword(user);
		userMapper.update(user);
	}

	@Transactional(readOnly = false)
	public void deleteUser(Long id) {
		if (isSupervisor(id)) {
			logger.warn("操作员{}尝试删除超级管理员用户", getCurrentUserName());
			throw new RuntimeException("不能删除超级管理员用户");
		}
		userMapper.delete(id);
	}

	public Profile findProfileByUserId(Long userId) {
		return profileMapper.findByUserId(userId);
	}

	public Profile findProfile(Long id) {
		return profileMapper.findOne(id);
	}

	@Transactional
	public Long saveProfile(Profile profile) {
		if (profile.getId() == null) {
			return profileMapper.insert(profile);
		} else {
			profileMapper.update(profile);
			return profile.getId();
		}
	}

	/**
	 * 判断是否超级管理员.
	 */
	private boolean isSupervisor(Long id) {
		return id == 1;
	}

	/**
	 * 取出Shiro中的当前用户LoginName.
	 */
	private String getCurrentUserName() {
		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		return user.loginName;
	}

	/**
	 * 设定安全的密码，生成随机的salt并经过1024次 sha-1 hash
	 */
	private void entryptPassword(User user) {
		byte[] salt = Digests.generateSalt(SALT_SIZE);
		user.setSalt(Encodes.encodeHex(salt));

		byte[] hashPassword = Digests.sha1(user.getPlainPassword().getBytes(), salt, HASH_INTERATIONS);
		user.setPassword(Encodes.encodeHex(hashPassword));
	}

}
