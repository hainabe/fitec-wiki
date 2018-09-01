package com.fitec.formation.wiki.repository;

import com.fitec.formation.wiki.entity.Profile;
import com.fitec.formation.wiki.entity.Status;
import com.fitec.formation.wiki.entity.User;
import com.fitec.formation.wiki.model.ProfileModel;
import com.fitec.formation.wiki.model.StatusModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    //    User findByUserLogin_UserName(String username);
    @Query("SELECT u FROM User as u WHERE u.userLogger.username = :argUsername")
    User getUserByUsername(@Param(value = "argUsername") String username);

    //    List<User> findByStatus(Status status);
    @Query("SELECT u FROM User as u WHERE u.status = :argStatus")
    List<User> getUsersByStatus(@Param(value = "argStatus") StatusModel status);

    //    List<User> findByUserLogin_Profile(Profile profile);
    @Query("SELECT u FROM User as u WHERE u.userLogger.profile = :argProfile")
    List<User> getUsersByProfile(@Param(value = "argProfile") ProfileModel profile);
}
