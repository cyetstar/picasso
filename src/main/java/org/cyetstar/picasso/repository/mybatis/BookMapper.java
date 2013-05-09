package org.cyetstar.picasso.repository.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.cyetstar.picasso.entity.Book;
import org.springframework.data.domain.Sort.Order;


public interface BookMapper extends SqlMapper {

	Book findWithDetail(String id);

	Book findByAbbr(String abbr);

	Book findByTitle(String title);

	Book findByTitleOrAbbr(@Param("title") String title, @Param("abbr") String abbr);

	List<Book> findAll(Order order);

}
