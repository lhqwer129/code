package com.pattern.demo;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;

public class User {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        User user = new User();
        user.setPassword("123");
        user.setUsername("lihui23");
        userList.add(user);
        User user1 = new User();
        BeanUtils.copyProperties(user, user1);
        user1.setUsername("lihui");

        System.out.println(user);
        System.out.println(user1);
    }

}

