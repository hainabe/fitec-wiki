package com.fitec.formation.wiki.repository;

import com.fitec.formation.wiki.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
