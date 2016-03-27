# AndroidMVP
Android Login App using the Model-View-Presenter

The Application starts in the LoginActivity which implements a LoginView

The Login Presenter acts as a Controller that calls the Login Service with the user/pass from the View.

Mockito is used for injecting LoginView and LoginService in order to test the Presenter exposed method: .onLoginClicked()
