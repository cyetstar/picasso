package org.cyetstar.picasso.repository.mybatis;

import java.util.List;

import org.cyetstar.picasso.entity.Paragraph;


public interface ParagraphMapper extends SqlMapper {

	Paragraph findWithDetail(Long id);

	List<Paragraph> findWithDetailByChapterId(Long chapterId);

	void insert(Paragraph paragraph);

	void update(Paragraph paragraph);

	void delete(Long id);

}
