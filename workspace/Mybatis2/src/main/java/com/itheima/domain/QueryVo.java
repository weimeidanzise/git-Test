package com.itheima.domain;

import java.io.Serializable;

public class QueryVo implements Serializable {
    private User user;

    @Override
    public String toString() {
        return "QueryVo{" +
                "user=" + user +
                '}';
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
