package org.cyetstar.picasso.repository.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.cyetstar.picasso.entity.User;
import org.springframework.data.domain.Pageable;


public interface UserMapper extends SqlMapper {

	User findOne(Long id);

	User findWithDetail(Long id);

	User findByLoginName(String loginName);

	User findByScreenName(String screenName);

	List<User> findNoFollow(@Param("userId") Long userId, @Param("pageable") Pageable pageable);

	long countNoFollow(@Param("userId") Long userId);

	Long insert(User user);

	void update(User user);

	void delete(Long id);

}
