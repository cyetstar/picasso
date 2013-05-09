package org.cyetstar.picasso.repository.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.cyetstar.picasso.entity.Chapter;


public interface ChapterMapper extends SqlMapper {

	List<Chapter> findAll();

	Chapter findOne(Long id);

	Chapter findWithDetail(Long id);

	Chapter findWithDetailByNumAndBookId(@Param("num") String num, @Param("bookId") String bookId);

	Chapter findByNumAndBookId(@Param("num") String num, @Param("bookId") String bookId);

	List<Chapter> findChaptersByBookId(String bookId);

}
