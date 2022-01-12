package com.example.firebasepractice;

public class User {
    private String profile;
    private String id;
    private int pw;
    private String username;

    public User(){}

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPw(int pw) {
        this.pw = pw;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProfile() {
        return profile;
    }

    public String getId() {
        return id;
    }

    public int getPw() {
        return pw;
    }

    public String getUsername() {
        return username;
    }
}
