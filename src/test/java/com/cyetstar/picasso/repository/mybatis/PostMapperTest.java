package com.cyetstar.picasso.repository.mybatis;

import static org.junit.Assert.*;

import java.util.List;

import org.cyetstar.picasso.entity.Post;
import org.cyetstar.picasso.entity.User;
import org.cyetstar.picasso.repository.mybatis.PostMapper;
import org.joda.time.DateTime;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;


@ActiveProfiles(profiles = "test")
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class PostMapperTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private PostMapper postMapper;

	@Test
	public void find() {
		Pageable pageable = new PageRequest(0, Integer.MAX_VALUE, new Sort(Direction.DESC, "id"));
		List<Post> posts = postMapper.findByUserIdAndOpen(1L, null, pageable);
		assertTrue(!posts.isEmpty());

		long total = postMapper.countByUserIdAndOpen(1L, null);
		assertEquals(2, total);
		assertEquals(posts.size(), total);

		posts = postMapper.findByUserIdOrUsersLeader(1L, pageable);
		assertTrue(!posts.isEmpty());

		total = postMapper.countByUserIdOrUsersLeader(1L);
		assertEquals(3, total);
		assertEquals(posts.size(), total);

		posts = postMapper.findByCollectionId(1L, pageable);
		assertTrue(!posts.isEmpty());

		total = postMapper.countByCollectionId(1L);
		assertEquals(1, total);
		assertEquals(posts.size(), total);
	}

	@Test
	public void save() {
		Post post = new Post();
		post.setUser(new User(1L));
		post.setTitle("123456");
		post.setContent("content123456");
		post.setOpen(true);
		post.setCreatedAt(DateTime.now());
		postMapper.insert(post);
	}
}
