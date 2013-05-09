package org.cyetstar.picasso.repository.mybatis;

import org.cyetstar.picasso.entity.Profile;

public interface ProfileMapper extends SqlMapper {

	Profile findOne(Long id);

	Profile findByUserId(Long userId);

	Long insert(Profile profile);

	void update(Profile profile);

}
