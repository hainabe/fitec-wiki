package com.fitec.formation.wiki.service;

import com.fitec.formation.wiki.entity.*;
import com.fitec.formation.wiki.model.ProfileModel;
import com.fitec.formation.wiki.model.StatusModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    boolean addUser(User u);

    User getUser(Long id);

    User getUserByUsername(String username);

    boolean updateUser(User u);

    boolean deleteUser(Long id);

    List<User> getUsers();

    List<User> getUsersByStatus(StatusModel status);

    List<User> getUsersByProfile(ProfileModel profile);

    // boolean setStatusOfArticle(Article article, StatusModel status);
    // boolean setStatusOfComment(Comment comment, StatusModel status);
    // boolean setStatusOfUser(User user, StatusModel status);
    boolean setStatus(Object object, StatusModel status);
}
