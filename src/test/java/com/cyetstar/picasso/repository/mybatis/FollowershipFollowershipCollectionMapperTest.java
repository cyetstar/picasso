package com.cyetstar.picasso.repository.mybatis;

import org.cyetstar.picasso.repository.mybatis.FollowershipFollowershipCollectionMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

@ActiveProfiles(profiles = "test")
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class FollowershipFollowershipCollectionMapperTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private FollowershipFollowershipCollectionMapper followershipFollowershipCollectionMapper;

	@Test
	public void save() {
		followershipFollowershipCollectionMapper.insert(3L, 1L);
	}

	@Test
	public void delete() {
		followershipFollowershipCollectionMapper.deleteByFollowershipId(1L);
	}
}
