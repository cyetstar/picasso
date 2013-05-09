package com.cyetstar.picasso.repository.mybatis;

import static org.junit.Assert.*;

import java.util.List;

import org.cyetstar.picasso.entity.User;
import org.cyetstar.picasso.repository.mybatis.UserMapper;
import org.joda.time.DateTime;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;


@ActiveProfiles(profiles = "test")
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class UserMapperTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private UserMapper userMapper;

	@Test
	public void find() {
		Pageable pageable = new PageRequest(0, Integer.MAX_VALUE);
		User user = userMapper.findOne(1L);
		assertEquals("cyetstar", user.getScreenName());

		user = userMapper.findWithDetail(1L);
		assertEquals("1", user.getProfile().getGender());

		user = userMapper.findByLoginName("cyetstar@gmail.com");
		assertEquals("cyetstar", user.getScreenName());

		user = userMapper.findByScreenName("cyetstar");
		assertEquals(1, user.getId().longValue());

		List<User> uses = userMapper.findNoFollow(1L, pageable);
		assertTrue(!uses.isEmpty());

		long total = userMapper.countNoFollow(1L);
		assertEquals(uses.size(), total);
	}

	@Test
	public void save() {
		User user = new User();
		user.setLoginName("abc@gmail.com");
		user.setPassword("123");
		user.setSalt("123");
		user.setScreenName("abc");
		user.setRoles("user");
		user.setCreatedAt(DateTime.now());
		userMapper.insert(user);
		assertNotNull(user.getId());

		user.setPassword("456");
		userMapper.update(user);
	}

	@Test
	public void delete() {
		userMapper.delete(1L);
	}
}
