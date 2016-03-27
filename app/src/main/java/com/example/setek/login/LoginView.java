package com.example.setek.login;

/**
 * Created by Setek on 3/27/2016.
 */
public interface LoginView {


    String getUsername();

    void showUsernameError(int resId);

    String getPassword();

    void showPasswordError(int resId);

    void startMainActivity();

    void showLoginError(int resId);
}
