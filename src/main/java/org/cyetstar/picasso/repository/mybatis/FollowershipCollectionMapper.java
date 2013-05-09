package org.cyetstar.picasso.repository.mybatis;

import java.util.List;

import org.cyetstar.picasso.entity.FollowershipCollection;


public interface FollowershipCollectionMapper extends SqlMapper {

	List<FollowershipCollection> findByUserId(Long userId);

	void insert(FollowershipCollection collection);

}
