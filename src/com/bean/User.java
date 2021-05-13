package com.bean;

public class User {

    private String username;
    private String key_value;

    public User() {
    }
    public User(String username, String key_value) {
        this.username=username;
        this.key_value=key_value;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getKey_value() {
        return key_value;
    }

    public void setKey_value(String key_value) {
        this.key_value = key_value;
    }
}
