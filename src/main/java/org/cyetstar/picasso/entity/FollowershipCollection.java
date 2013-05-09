package org.cyetstar.picasso.entity;

import java.util.List;

/**
 * 关注分组
 * 
 * @author cyetstar
 * 
 */
public class FollowershipCollection extends IdEntity {

	private String name;

	private User user;

	private List<Followership> followerships;

	public FollowershipCollection() {

	}

	public FollowershipCollection(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Followership> getFollowerships() {
		return followerships;
	}

	public void setFollowerships(List<Followership> followerships) {
		this.followerships = followerships;
	}

}
