/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import models.User;
import models.Role;
import dataaccess.UserDB;
import java.util.ArrayList;
import java.util.List;
import exceptions.InvalidFieldsException;

//Get users from dataaccess
public class UserService {

    private final UserDB accessUsers = new UserDB();
    private final RoleService rs = new RoleService();

    //Get all users
    public List<User> getAll() throws Exception {

        List<User> users = accessUsers.getAll();

        // match role id with the role from the role table and update.
        for (int i = 0; i < users.size(); i++) {

            int id = users.get(i).getRole().getId();
            Role role = rs.get(id);

            users.get(i).setRole(role);
        }

        return users;
    }

    //Get all users
    public User get(String email) throws Exception {

        User user = accessUsers.get(email);

        // match role id with the role from the role table and update.
        int id = user.getRole().getId();
        Role role = rs.get(id);
        user.setRole(role);

        return user;
    }

    //Insert new user
    public void insert(User user) throws Exception, InvalidFieldsException {

        // match role id with the role from the role table and update.
        int id = user.getRole().getId();
        Role role = rs.get(id);
        user.setRole(role);

        // check all attributes are valid
        if (user.getEmail() == null || user.getFirstName() == null || user.getLastName() == null || user.getPassword() == null
                || user.getEmail().equals("") || user.getFirstName().equals("") || user.getLastName().equals("") || user.getPassword().equals("")) {
            throw new InvalidFieldsException();
        } else {
            accessUsers.insert(user);
        }

    }
    //delete a user by email

    public void delete(String email) throws Exception {
        accessUsers.delete(email);
        //update user
        ic void update
        (User user) throws Exception, InvalidFieldsException {

            // match role id with the role from the role table and update.
            int id = user.getRole().getId();
            Role role = rs.get(id);
            user.setRole(role);

            // check all attributes are valid
            if (user.getEmail() == null || user.getFirstName() == null || user.getLastName() == null || user.getPassword() == null
                    || user.getEmail().equals("") || user.getFirstName().equals("") || user.getLastName().equals("") || user.getPassword().equals("")) {
                throw new InvalidFieldsException();
            } else {
                accessUsers.update(user);
            }

        }

    }
}
