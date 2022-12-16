package com.mehmetari.hrms.repository;

import com.mehmetari.hrms.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
