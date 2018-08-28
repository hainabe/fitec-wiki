package com.fitec.formation.wiki.repository;

import com.fitec.formation.wiki.entity.UserLogger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLoggerRepository extends JpaRepository<UserLogger, Long> {
}
