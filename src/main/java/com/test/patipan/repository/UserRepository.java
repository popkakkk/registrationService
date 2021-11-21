package com.test.patipan.repository;

import com.test.patipan.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

     User findByUsername(String userName);

}
