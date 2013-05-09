package org.cyetstar.picasso.repository.mybatis;

import org.apache.ibatis.annotations.Param;

public interface FollowershipFollowershipCollectionMapper extends SqlMapper {

	void insert(@Param("followershipId") Long followershipId,
			@Param("followershipCollectionId") Long followershipCollectionId);

	void deleteByFollowershipId(Long followershipId);

}
