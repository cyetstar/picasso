package com.cyetstar.picasso.service;

import static org.junit.Assert.*;

import org.cyetstar.picasso.entity.User;
import org.cyetstar.picasso.service.UserService;
import org.joda.time.DateTime;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;


@ActiveProfiles("test")
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class UserServiceTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private UserService userService;

	@Test
	public void save() {
		User user = new User();
		user.setLoginName("abc@gmail.com");
		user.setPlainPassword("123");
		user.setRoles("user");
		user.setCreatedAt(new DateTime());
		userService.registerUser(user);
		assertNotNull(user.getId());
	}

}
