package com.fitec.formation.wiki.repository;

import com.fitec.formation.wiki.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
