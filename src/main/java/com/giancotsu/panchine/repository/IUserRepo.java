package com.giancotsu.panchine.repository;

import com.giancotsu.panchine.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepo extends JpaRepository<UserEntity, Long> {

    UserEntity findByUsername(String username);
}
