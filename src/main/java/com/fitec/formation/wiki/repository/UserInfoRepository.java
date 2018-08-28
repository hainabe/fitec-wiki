package com.fitec.formation.wiki.repository;

import com.fitec.formation.wiki.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
}
