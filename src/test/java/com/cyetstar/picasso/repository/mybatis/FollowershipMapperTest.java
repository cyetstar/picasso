package com.cyetstar.picasso.repository.mybatis;

import static org.junit.Assert.*;

import java.util.List;

import org.cyetstar.picasso.entity.Followership;
import org.cyetstar.picasso.entity.User;
import org.cyetstar.picasso.repository.mybatis.FollowershipMapper;
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
public class FollowershipMapperTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private FollowershipMapper followershipMapper;

	@Test
	public void find() {
		Pageable pageable = new PageRequest(0, Integer.MAX_VALUE, new Sort(Direction.DESC, "id"));

		Followership followership = followershipMapper.findOne(1L);
		assertNotNull(followership.getCreatedAt());
		assertEquals("次号", followership.getRemark());

		List<User> leaders = followershipMapper.findLeadersByFollowerId(1L, pageable);
		assertTrue(!leaders.isEmpty());

		long leaderTotal = followershipMapper.countLeadersByFollowerId(1L);
		assertEquals(4, leaderTotal);
		assertEquals(leaders.size(), leaderTotal);

		List<User> followers = followershipMapper.findFollowersByLeaderId(1L, pageable);
		assertTrue(!followers.isEmpty());

		long followerTotal = followershipMapper.countFollowersByLeaderId(1L);
		assertEquals(1, followerTotal);
		assertEquals(followers.size(), followerTotal);

		followership = followershipMapper.findByLeaderIdAndFollowerId(1L, 2L);
		assertEquals("主号", followership.getRemark());
	}

	@Test
	public void save() {
		Followership followership = new Followership();
		User leader = new User(3L);
		User follower = new User(4L);
		followership.setLeader(leader);
		followership.setFollower(follower);
		followership.setRemark("test");
		followership.setCreatedAt(DateTime.now());
		followershipMapper.insert(followership);
		assertNotNull(followership.getId());

		followership.setRemark("tset");
		followershipMapper.update(followership);
	}

	@Test
	public void delete() {
		followershipMapper.delete(1L);
		followershipMapper.deleteByLeaderIdAndFollowerId(1L, 2L);
	}

}
