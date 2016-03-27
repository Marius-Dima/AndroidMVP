package com.example.setek.loginapp;

/**
 * Created by Setek on 3/27/2016.
 */

import com.example.setek.R;
import com.example.setek.loginapp.login.LoginPresenter;
import com.example.setek.loginapp.login.LoginService;
import com.example.setek.loginapp.login.LoginView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LoginPresenterTest {

    @Mock
    private LoginService service;

    @Mock
    private LoginView view;
    private LoginPresenter loginPresenter;

    @Before
    public void setUp() {
        loginPresenter = new LoginPresenter(view, service);
    }

    @Test
    public void shouldShowErrorMsgWhenUsernameisEmpty() throws Exception {
        when(view.getUsername()).thenReturn("");

        loginPresenter.onLoginClicked();

        Mockito.verify(view).showUsernameError(R.string.username_error);
    }

    @Test
    public void shouldShowErorWhenPasswordisEmpty() throws Exception {
        when(view.getUsername()).thenReturn("james");
        when(view.getPassword()).thenReturn("");

        loginPresenter.onLoginClicked();

        Mockito.verify(view).showPasswordError(R.string.password_error);
    }

    @Test
    public void testShouldStartMainActivity() throws Exception {
        when(view.getUsername()).thenReturn("james");
        when(view.getPassword()).thenReturn("bond");

        String username = view.getUsername();
        String password = view.getPassword();

        when(service.login(username, password)).thenReturn(true);

        loginPresenter.onLoginClicked();

        verify(view).startMainActivity();
    }

    @Test
    public void testShouldShowLoginErrorWhenUserPassInvalid() throws Exception {

        when(view.getUsername()).thenReturn("james");
        when(view.getPassword()).thenReturn("bond");

        String username = view.getUsername();
        String password = view.getPassword();

        when(service.login(username, password)).thenReturn(false);
        loginPresenter.onLoginClicked();

        verify(view).showLoginError(R.string.login_failed);
    }
}