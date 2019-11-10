package com.smart;

public class User<T> {
    public User() {

    }

    protected T initialValue(){
        return null;
    }
    public User(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private String userName;
}
