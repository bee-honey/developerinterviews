package com.honeybee.developerinterviews.developerinterviews.repositories;

import com.honeybee.developerinterviews.developerinterviews.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);
}
