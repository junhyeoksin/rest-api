package com.junprogrammer.restapi.repositroy;

import com.junprogrammer.restapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepo extends JpaRepository<User, Long> {
}
