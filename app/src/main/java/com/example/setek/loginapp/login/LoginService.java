package com.example.setek.loginapp.login;

/**
 * Created by Setek on 3/27/2016.
 */
public class LoginService {

    public boolean login(String username, String password) {
        return username.equals("james") && password.equals("bond");
    }
}
