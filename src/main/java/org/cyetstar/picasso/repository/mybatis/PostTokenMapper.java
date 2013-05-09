package org.cyetstar.picasso.repository.mybatis;

import org.apache.ibatis.annotations.Param;

public interface PostTokenMapper extends SqlMapper {

	void insert(@Param("postId") Long postId, @Param("tokenId") Long tokenId);

	void delete(@Param("postId") Long postId, @Param("tokenId") Long tokenId);

}
