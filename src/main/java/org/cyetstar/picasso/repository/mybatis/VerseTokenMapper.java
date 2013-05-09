package org.cyetstar.picasso.repository.mybatis;

import org.apache.ibatis.annotations.Param;

public interface VerseTokenMapper extends SqlMapper {

	Long insert(@Param("verseId") Long verseId, @Param("tokenId") Long tokenId);

	void delete(@Param("verseId") Long verseId, @Param("tokenId") Long tokenId);

}
