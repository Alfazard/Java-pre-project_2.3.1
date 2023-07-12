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
public class ServiceUserImpl implements ServiceUser {

    private final DaoUser daoUser;

    public ServiceUserImpl(DaoUser daoUser) {
        this.daoUser = daoUser;
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return daoUser.getAllUsers();
    }

    @Override
    @Transactional
    public void addUser(User user) {
        daoUser.addUser(user);
    }

    @Override
    @Transactional
    public User getUser(int id) {
        return daoUser.getUser(id);
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        daoUser.deleteUser(id);
    }
}
