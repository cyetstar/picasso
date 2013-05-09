package org.cyetstar.picasso.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.cyetstar.picasso.entity.Post;
import org.cyetstar.picasso.entity.Token;
import org.cyetstar.picasso.entity.User;
import org.cyetstar.picasso.repository.mybatis.FollowershipCollectionMapper;
import org.cyetstar.picasso.repository.mybatis.FollowershipMapper;
import org.cyetstar.picasso.repository.mybatis.PostMapper;
import org.cyetstar.picasso.repository.mybatis.PostTokenMapper;
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
public class PostService {

	@Autowired
	TokenService tokenService;

	@Autowired
	UserMapper userMapper;

	@Autowired
	PostMapper postMapper;

	@Autowired
	PostTokenMapper postTokenMapper;

	@Autowired
	FollowershipMapper followershipMapper;

	@Autowired
	FollowershipCollectionMapper followershipCollectionMapper;

	public Page<Post> findByUserId(Long userId, boolean all, int pageNum, int pageSize) {
		Pageable pageable = new PageRequest(pageNum - 1, pageSize, new Sort(Direction.DESC, "id"));
		Boolean open = all ? null : all;
		List<Post> content = postMapper.findByUserIdAndOpen(userId, open, pageable);
		long total = postMapper.countByUserIdAndOpen(userId, open);
		return new PageImpl<Post>(content, pageable, total);
	}

	public Page<Post> findByScreenName(String screenName, boolean all, int pageNum, int pageSize) {
		User user = userMapper.findByScreenName(screenName);
		Long userId = user == null ? Long.valueOf(screenName) : user.getId();
		return findByUserId(userId, all, pageNum, pageSize);
	}

	public Page<Post> findFollowingPost(Long followerId, int pageNum, int pageSize) {
		Pageable pageable = new PageRequest(pageNum - 1, pageSize, new Sort(Direction.DESC, "id"));
		List<Post> content = postMapper.findByUserIdOrUsersLeader(followerId, pageable);
		long total = postMapper.countByUserIdOrUsersLeader(followerId);
		return new PageImpl<Post>(content, pageable, total);
	}

	public Page<Post> findFollowingPost(String followerScreenName, int pageNum, int pageSize) {
		User follower = userMapper.findByScreenName(followerScreenName);
		Long followerId = follower == null ? Long.valueOf(followerScreenName) : follower.getId();
		return findFollowingPost(followerId, pageNum, pageSize);
	}

	public Page<Post> findFollowingPostByCollectionId(Long collectionId, int pageNum, int pageSize) {
		Pageable pageable = new PageRequest(pageNum - 1, pageSize, new Sort(Direction.DESC, "id"));
		List<Post> content = postMapper.findByCollectionId(collectionId, pageable);
		long total = postMapper.countByCollectionId(collectionId);
		return new PageImpl<Post>(content, pageable, total);
	}

	@Transactional
	public Post savePost(Post post) {
		post.setCreatedAt(DateTime.now());
		postMapper.insert(post);
		Long postId = post.getId();
		String tokenString = post.getTokenString();
		if (!StringUtils.isEmpty(tokenString)) {
			String[] tokenArray = tokenString.split(",");
			for (String string : tokenArray) {
				Token token = tokenService.saveTokenFormString(string);
				if (token == null)
					continue;
				postTokenMapper.insert(postId, token.getId());
			}
		}
		return post;
	}

}
