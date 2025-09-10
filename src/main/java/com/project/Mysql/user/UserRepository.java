package com.project.Mysql.user;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByUsername(String username);
    User findByEmailAndPassword(String email, String password);
}
