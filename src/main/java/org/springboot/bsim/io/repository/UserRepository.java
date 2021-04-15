package org.springboot.bsim.io.repository;

import org.springboot.bsim.io.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByUsername(String userName);
    UserEntity findByUserid(String userID);
}
