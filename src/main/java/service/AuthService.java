package main.java.service;

import main.java.exception.AuthException;
import main.java.model.User;
import main.java.model.UserAuthentication;
import main.java.repository.UserAuthenticationRepository;
import main.java.repository.UserRepository;

import java.sql.SQLException;

public class AuthService {

    private UserRepository userRepository;
    private UserAuthenticationRepository userAuthenticationRepository;

    public AuthService(UserRepository userRepository, UserAuthenticationRepository userAuthenticationRepository) {
        this.userRepository = userRepository;
        this.userAuthenticationRepository = userAuthenticationRepository;
    }

    public User login(String login,String password) throws SQLException {
        UserAuthentication ua = userAuthenticationRepository.findByLogin(login);
        if(ua.password.equals(password)){
            return userRepository.findByLogin(login);
        }else
            throw new AuthException("Niepoprawne hasło!");
    }

}
