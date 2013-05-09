package org.cyetstar.picasso.service;

import java.util.List;

import org.cyetstar.picasso.entity.Followership;
import org.cyetstar.picasso.entity.FollowershipCollection;
import org.cyetstar.picasso.entity.User;
import org.cyetstar.picasso.repository.mybatis.FollowershipCollectionMapper;
import org.cyetstar.picasso.repository.mybatis.FollowershipFollowershipCollectionMapper;
import org.cyetstar.picasso.repository.mybatis.FollowershipMapper;
import org.cyetstar.picasso.repository.mybatis.UserMapper;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
@Transactional(readOnly = true)
public class FollowershipService {

	@Autowired
	FollowershipMapper followershipMapper;

	@Autowired
	FollowershipCollectionMapper followershipCollectionMapper;

	@Autowired
	FollowershipFollowershipCollectionMapper followershipFollowershipCollectionMapper;

	@Autowired
	UserMapper userMapper;

	public Followership findFollowershipById(Long id) {
		return followershipMapper.findOne(id);
	}

	public Page<User> findLeaderByFollowerId(Long followerId, int pageNum, int pageSize) {
		Pageable pageable = new PageRequest(pageNum - 1, pageSize, new Sort(Direction.DESC, "id"));
		List<User> content = followershipMapper.findLeadersByFollowerId(followerId, pageable);
		long total = followershipMapper.countLeadersByFollowerId(followerId);
		return new PageImpl<User>(content, pageable, total);
	}

	public Page<User> findFollowerByLeader(Long leadId, int pageNum, int pageSize) {
		Pageable pageable = new PageRequest(pageNum - 1, pageSize, new Sort(Direction.DESC, "id"));
		List<User> content = followershipMapper.findFollowersByLeaderId(leadId, pageable);
		long total = followershipMapper.countFollowersByLeaderId(leadId);
		return new PageImpl<User>(content, pageable, total);
	}

	@Transactional
	public Followership follow(Long leaderId, Long followerId, String remark) {
		User leader = new User(leaderId);
		User follower = new User(followerId);
		Followership followership = new Followership();
		followership.setLeader(leader);
		followership.setFollower(follower);
		followership.setRemark(remark);
		followership.setCreatedAt(DateTime.now());
		followershipMapper.insert(followership);
		return followership;
	}

	@Transactional
	public void unfollow(Long leaderId, Long followerId) {
		followershipMapper.deleteByLeaderIdAndFollowerId(leaderId, followerId);
	}

	public Followership findFollowershipByLeaderIdAndFollowerId(Long leaderId, Long followerId) {
		return followershipMapper.findByLeaderIdAndFollowerId(leaderId, followerId);
	}

	public List<FollowershipCollection> findFollowershipCollectionsByUserId(Long owerId) {
		return followershipCollectionMapper.findByUserId(owerId);
	}

	@Transactional
	public Followership saveFollowership(Followership followership, List<Long> collectionIds) {
		if (followership.getId() == null) {
			followershipMapper.insert(followership);
		} else {
			followershipMapper.update(followership);
			followershipFollowershipCollectionMapper.deleteByFollowershipId(followership.getId());
		}
		if (collectionIds != null) {
			for (Long collectionId : collectionIds) {
				followershipFollowershipCollectionMapper.insert(followership.getId(), collectionId);
			}
		}
		return followership;
	}

	@Transactional
	public FollowershipCollection saveFollowershipCollection(Long userId, String name) {
		FollowershipCollection collection = new FollowershipCollection();
		collection.setName(name);
		collection.setUser(new User(userId));
		followershipCollectionMapper.insert(collection);
		return collection;
	}
}
