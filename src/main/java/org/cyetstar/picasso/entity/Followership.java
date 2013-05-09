package org.cyetstar.picasso.entity;

import java.util.List;

import org.joda.time.DateTime;

import com.google.common.collect.Lists;

/**
 * 关注关系
 * 
 * @author cyetstar
 * 
 */
public class Followership extends IdEntity {

	private String remark;

	private User leader;

	private User follower;

	private DateTime createdAt;

	private List<FollowershipCollection> followershipCollections = Lists.newArrayList();

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public User getLeader() {
		return leader;
	}

	public void setLeader(User leader) {
		this.leader = leader;
	}

	public User getFollower() {
		return follower;
	}

	public void setFollower(User follower) {
		this.follower = follower;
	}

	public DateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(DateTime createdAt) {
		this.createdAt = createdAt;
	}

	public List<FollowershipCollection> getFollowershipCollections() {
		return followershipCollections;
	}

	public void setFollowershipCollections(List<FollowershipCollection> followershipCollections) {
		this.followershipCollections = followershipCollections;
	}

}
