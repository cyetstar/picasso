package com.cyetstar.picasso.repository.mybatis;

import org.cyetstar.picasso.repository.mybatis.PostTokenMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

@ActiveProfiles(profiles = "test")
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class PostTokenMapperTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private PostTokenMapper postTokenMapper;

	@Test
	public void save() {
		postTokenMapper.insert(1L, 2L);
	}

	@Test
	public void delete() {
		postTokenMapper.delete(1L, 1L);
	}
}
