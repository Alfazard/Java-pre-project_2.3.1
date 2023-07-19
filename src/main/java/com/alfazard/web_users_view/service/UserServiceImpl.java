package com.alfazard.web_users_view.service;

import com.alfazard.web_users_view.dao.DaoUser;

import com.alfazard.web_users_view.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Alfazard on 08.07.2023
 */
@Service
public class UserServiceImpl implements UserService {

    private final DaoUser daoUser;

    public UserServiceImpl(DaoUser daoUser) {
        this.daoUser = daoUser;
    }

    @Override
    public List<User> getAllUsers() {
        return daoUser.getAllUsers();
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public void addUser(User user) {
        daoUser.addUser(user);
    }

    @Override
    public User getUser(int id) {
        return daoUser.getUser(id);
    }

    @Override
    public void deleteUser(int id) {
        daoUser.deleteUser(id);
    }
}
