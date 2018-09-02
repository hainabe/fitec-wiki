package com.fitec.formation.wiki.service;

import com.fitec.formation.wiki.entity.*;
import com.fitec.formation.wiki.model.ProfileModel;
import com.fitec.formation.wiki.model.StatusModel;
import com.fitec.formation.wiki.repository.UserRepository;
import com.fitec.formation.wiki.util.MessageUtil;
import com.fitec.formation.wiki.util.PropertyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PropertyUtil propertyUtil;

    @Override
    public boolean addUser(User u) {
        boolean result = false;
        if (Objects.nonNull(u)) {
            result = userRepository.save(u) != null;
            System.out.println(MessageUtil.MSG_SUCCESS_ADD);
        } else {
            System.out.println(MessageUtil.MSG_ERROR_NULL);
        }
        return result;
    }

    @Override
    public User getUser(Long id) {
        User user = userRepository.getOne(id);
        return user;
    }

    @Override
    public User getUserByUsername(String username) {
        User user = userRepository.getUserByUsername(username);
        return user;
    }

    @Override
    public boolean updateUser(User oldU) {
        boolean result = false;
        User targetUser = userRepository.getOne(oldU.getIdUser());
        if (Objects.nonNull(oldU) && userRepository.existsById(oldU.getIdUser())) {
            BeanUtils.copyProperties(oldU, targetUser, propertyUtil.getNullPropertyNames(oldU));
            result = Objects.nonNull(userRepository.save(targetUser));
            System.out.println(MessageUtil.MSG_SUCCESS_UPDATE);
        } else {
            System.out.println(MessageUtil.MSG_ERROR_NULL_NOT_FOUND);
        }
        return result;
    }

    @Override
    public boolean deleteUser(Long id) {
        boolean result = false;
        if (userRepository.existsById(id)) {
            userRepository.delete(getUser(id));
            result = true;
            System.out.println(MessageUtil.MSG_SUCCESS_DELETE);
        } else {
            System.out.println(MessageUtil.MSG_ERROR_NOT_FOUND);
        }
        return result;
    }

    @Override
    public List<User> getUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }

    @Override
    public List<User> getUsersByStatus(StatusModel status) {
        List<User> users = userRepository.getUsersByStatus(status);
        return users;
    }

    @Override
    public List<User> getUsersByProfile(ProfileModel profile) {
        List<User> users = userRepository.getUsersByProfile(profile);
        return users;
    }

    @Override
    public boolean setStatus(Object object, StatusModel status) {
        boolean result = false;
        if (Objects.nonNull(object) && Objects.nonNull(status)) {
            if (Objects.equals(object.getClass(), Article.class)) {
                ((Article) object).setStatus(status);
            } else if (Objects.equals(object.getClass(), Comment.class)) {
                ((Comment) object).setStatus(status);
            } else if (Objects.equals(object.getClass(), User.class)) {
                ((User) object).setStatus(status);
            }
            result = true;
            System.out.println(MessageUtil.MSG_SUCCESS_SET_STATUS);
        } else {
            System.out.println(MessageUtil.MSG_ERROR_SET_STATUS);
        }
        return result;
    }
}
