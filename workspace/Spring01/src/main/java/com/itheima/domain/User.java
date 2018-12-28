package com.itheima.domain;

import java.util.List;

public class User {
    private Integer age;
    private String username;

    private List<String> list;

    public User(Integer age, String username, List<String> list) {
        this.age = age;
        this.username = username;
        this.list = list;
    }

    public User(String age) {
    }

    public User(String age, String username) {
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + username + '\'' +
                ", list=" + list +
                '}';
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return username;
    }

    public void setName(String name) {
        this.username = name;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
