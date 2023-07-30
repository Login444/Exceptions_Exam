package org.example;

import java.util.List;

public class UserDataBase {
    public List<User> userList;

    public UserDataBase(List<User> userList) {
        this.userList = userList;
    }

    public UserDataBase() {
    }

    public List<User> getUserList() {
        return userList;
    }

    @Override
    public String toString() {
        return "UserDataBase{" +
                "userList=" + userList +
                '}';
    }
}
