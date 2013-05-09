package org.cyetstar.picasso.repository.mybatis;

import org.cyetstar.picasso.entity.Token;

public interface TokenMapper extends SqlMapper {

	Token findWithDetail(Long id);

	Token findByName(String name);

	Long insert(Token token);

}
