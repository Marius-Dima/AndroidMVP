package com.example.setek.login;


public class LoginService {

    public boolean login(String username, String password) {
        return username.equals("james") && password.equals("bond");
    }
}
