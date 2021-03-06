package com.junprogrammer.restapi.repositroy;

import com.junprogrammer.restapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJpaRepo extends JpaRepository<User, Long> {
    Optional<User> findByUid(String email);

    // kakao
    Optional<User> findByUidAndProvider(String uid, String provider);
}
