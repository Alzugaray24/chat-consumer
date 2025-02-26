package com.asessment.chat.repositories;

import com.asessment.chat.dtos.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
