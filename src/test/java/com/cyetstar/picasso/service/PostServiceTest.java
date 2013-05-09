package com.cyetstar.picasso.service;

import static org.junit.Assert.*;

import org.cyetstar.picasso.entity.Post;
import org.cyetstar.picasso.entity.User;
import org.cyetstar.picasso.service.PostService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;


@ActiveProfiles("test")
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class PostServiceTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private PostService postService;

	@Test
	public void save() {
		Post post = new Post();
		User user = new User();
		user.setId(1L);
		post.setUser(user);
		post.setTitle("标题");
		post.setContent("内容");
		post.setTokenString("约 1:1,约2:2");
		postService.savePost(post);
		assertNotNull(post.getId());
	}
}
