package com.nissum.challenge.users.repository;

import com.nissum.challenge.users.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
  UserEntity findByEmail(String email);

  @Modifying
  @Transactional
  @Query("UPDATE UserEntity u SET u.token = :newToken WHERE u.id = :userId")
  void updateUserName(@Param("userId") Integer userId, @Param("newToken") String newToken);
}
