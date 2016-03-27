package com.example.setek.loginapp.login;


import com.example.setek.R;

public class LoginPresenter {

    private LoginView loginView;
    private LoginService loginService;

    public LoginPresenter(LoginView loginView, LoginService loginService) {
        this.loginView = loginView;
        this.loginService = loginService;
    }

    public void onLoginClicked() {
        String username = loginView.getUsername();

        if (username.isEmpty()) {
            loginView.showUsernameError(R.string.username_error);
            return;
        }

        String password = loginView.getPassword();
        if (password.isEmpty()) {
            loginView.showPasswordError(R.string.password_error);
            return;
        }

        boolean isLoggedIn = loginService.login(username, password);
        if (isLoggedIn) {
            loginView.startMainActivity();
            return;
        }

        loginView.showLoginError(R.string.login_failed);
    }
}
