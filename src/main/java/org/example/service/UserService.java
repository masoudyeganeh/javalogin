package org.example.service;

import org.example.common.UserAlreadyExists;
import org.example.entity.User;
import org.example.repository.UserDA;

import java.sql.SQLException;

public class UserService {
    public static Boolean auth(User user) throws Exception {
        UserDA userDA = new UserDA();
        try (userDA) {
            userDA.selectOneByUsernameAndPassword(user);
            if (user.getUser_id() == null) {
                return false;
            } else {
                return true;
            }
        }
    }
    public static User signUp(User user) throws Exception {
        UserDA userDA = new UserDA();
        try (userDA) {
            if (userDA.selectOneByUsername(user).getUser_id() == null) {
                userDA.Insert(user);
                userDA.commit();
            } else {
                throw new UserAlreadyExists();
            }
        }
        return user;
    }

    public static void checkDuplicateUsername(User user) throws Exception {
        UserDA userDA = new UserDA();
        try (userDA) {
            if (userDA.selectOneByUsername(user).getUser_id() != null) {
                throw new UserAlreadyExists();
            }
        }
    }
}
