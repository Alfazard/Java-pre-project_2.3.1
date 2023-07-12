package com.alfazard.web_users_view.dao;

import com.alfazard.web_users_view.model.User;

import java.util.List;

/**
 * @author Alfazard on 08.07.2023
 */
public interface DaoUser {
    List<User> getAllUsers();
    void addUser(User user);

    User getUser(int id);

    void deleteUser(int id);
}
