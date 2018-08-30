package com.fitec.formation.wiki.repository;

import com.fitec.formation.wiki.entity.UserLogger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLoggerRepository extends JpaRepository<UserLogger, Long> {
}
