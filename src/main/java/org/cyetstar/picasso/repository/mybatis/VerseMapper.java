package org.cyetstar.picasso.repository.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.cyetstar.picasso.entity.Verse;


public interface VerseMapper extends SqlMapper {

	Verse findByNumAndChapterId(@Param("num") String num, @Param("chapterId") Long chapterId);

	Verse findByNumsAndChapterId(@Param("num") String num, @Param("chapterId") Long chapterId);

	List<Verse> findByChapterId(Long chapterId);

	void insert(Verse verse);

	void update(Verse verse);

}
