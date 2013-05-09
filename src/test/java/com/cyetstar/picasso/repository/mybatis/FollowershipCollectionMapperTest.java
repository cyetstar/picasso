package com.cyetstar.picasso.repository.mybatis;

import static org.junit.Assert.*;

import java.util.List;

import org.cyetstar.picasso.entity.FollowershipCollection;
import org.cyetstar.picasso.entity.User;
import org.cyetstar.picasso.repository.mybatis.FollowershipCollectionMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;


@ActiveProfiles(profiles = "test")
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class FollowershipCollectionMapperTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private FollowershipCollectionMapper followershipCollectionMapper;

	@Test
	public void find() {
		List<FollowershipCollection> collections = followershipCollectionMapper.findByUserId(1L);
		assertTrue(!collections.isEmpty());
	}

	@Test
	public void save() {
		FollowershipCollection collection = new FollowershipCollection();
		collection.setName("test");
		collection.setUser(new User(1L));
		followershipCollectionMapper.insert(collection);
		assertNotNull(collection.getId());
	}
}
