package com.fitec.formation.wiki.repository;

import com.fitec.formation.wiki.entity.Profile;
import com.fitec.formation.wiki.entity.Status;
import com.fitec.formation.wiki.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserLogin_UserName(String username);

    List<User> findByStatus(Status status);

    List<User> findByUserLogin_Profile(Profile profile);

}
