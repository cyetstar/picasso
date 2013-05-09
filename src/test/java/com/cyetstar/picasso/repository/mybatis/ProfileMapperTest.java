package com.cyetstar.picasso.repository.mybatis;

import static org.junit.Assert.*;

import org.cyetstar.picasso.entity.Profile;
import org.cyetstar.picasso.entity.User;
import org.cyetstar.picasso.repository.mybatis.ProfileMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;


@ActiveProfiles(profiles = "test")
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class ProfileMapperTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private ProfileMapper profileMapper;

	@Test
	public void find() {
		Profile profile = profileMapper.findOne(1L);
		assertEquals("1", profile.getGender());

		profile = profileMapper.findByUserId(1L);
		assertEquals("1", profile.getGender());
	}

	@Test
	public void save() {
		Profile profile = new Profile();
		profile.setGender("1");
		profile.setBrithday("1980/01/01");
		profile.setLocation("杭州");
		profile.setUser(new User(2L));
		profileMapper.insert(profile);
		assertNotNull(profile.getId());

		profile.setGender("2");
		profileMapper.update(profile);
	}
}
