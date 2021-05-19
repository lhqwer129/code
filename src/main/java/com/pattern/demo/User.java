package com.pattern.demo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class User<T> {

    private Integer username;
    private Integer password;

    public Integer getUsername() {
        return username;
    }

    public void setUsername(Integer username) {
        this.username = username;
    }

    public Integer getPassword() {
        return password;
    }

    public void setPassword(Integer password) {
        this.password = password;
    }

    public User(Integer username, Integer password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


    void buildQuestionValidationParam(T t) {
        String lessonId, studentId;
        Integer curriculumVersion;

        try {
            Field[] fields = t.getClass().getDeclaredFields();
            Field studentIdField = t.getClass().getField("username");
            studentIdField.setAccessible(false);
            studentId = studentIdField.get(t).toString();
        } catch (Exception e) {
            throw new IllegalArgumentException("could not acquire filed", e);
        }

        System.out.println(studentId);
    }

    public static void main(String[] args) {
        User user = new User(1, 2);
        System.out.println(User.class);
        System.out.println(user.getClass());
        System.out.println(User.class.equals(user.getClass()));
    }

}

