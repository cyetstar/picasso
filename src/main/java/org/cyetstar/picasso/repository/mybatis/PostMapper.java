package org.cyetstar.picasso.repository.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.cyetstar.picasso.entity.Post;
import org.springframework.data.domain.Pageable;


public interface PostMapper extends SqlMapper {

	List<Post> findByUserIdAndOpen(@Param("userId") Long userId, @Param("open") Boolean open,
			@Param("pageable") Pageable pageable);

	long countByUserIdAndOpen(@Param("userId") Long userId, @Param("open") Boolean open);

	List<Post> findByUserIdOrUsersLeader(@Param("userId") Long userId, @Param("pageable") Pageable pageable);

	long countByUserIdOrUsersLeader(Long userId);

	List<Post> findByCollectionId(@Param("collectionId") Long collectionId, @Param("pageable") Pageable pageable);

	long countByCollectionId(Long collectionId);

	Long insert(Post post);

}
