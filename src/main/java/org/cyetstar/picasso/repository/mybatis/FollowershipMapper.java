package org.cyetstar.picasso.repository.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.cyetstar.picasso.entity.Followership;
import org.cyetstar.picasso.entity.User;
import org.springframework.data.domain.Pageable;


public interface FollowershipMapper extends SqlMapper {

	Followership findOne(Long id);

	List<User> findLeadersByFollowerId(@Param("followerId") Long followerId, @Param("pageable") Pageable pageable);

	long countLeadersByFollowerId(Long followerId);

	List<User> findFollowersByLeaderId(@Param("leaderId") Long leaderId, @Param("pageable") Pageable pageable);

	long countFollowersByLeaderId(Long followerId);

	Followership findByLeaderIdAndFollowerId(@Param("leaderId") Long leaderId, @Param("followerId") Long followerId);

	void insert(Followership followership);

	void update(Followership followership);

	void delete(Long id);

	void deleteByLeaderIdAndFollowerId(@Param("leaderId") Long leaderId, @Param("followerId") Long followerId);

}
