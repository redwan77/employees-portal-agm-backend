package com.jobcommit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jobcommit.model.DailyRecord;
import com.jobcommit.model.Role;
import com.jobcommit.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public List<User> findByRole(Role role);

	public List<User> findByNameContaining(String likeKey);

	public User findByLoginAndPassword(String email, String password);

	@Query(
			value = "SELECT USER.ID FROM" +
					" USER INNER JOIN USER_DAILY_RECORDS" + 
					" ON USER.ID =USER_DAILY_RECORDS.USER_ID "+
					" WHERE USER.ID=:userID "
					, nativeQuery = true)
	public Long findDailyByDateAndUser(@Param("userID") Long userID);
}
