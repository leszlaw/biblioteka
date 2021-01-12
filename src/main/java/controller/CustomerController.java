package main.java.controller;

import main.java.factory.TestStatementBuilder;
import main.java.model.User;
import main.java.repository.UserAuthenticationRepository;
import main.java.repository.UserRepository;
import main.java.service.AuthService;

import java.sql.SQLException;
import java.sql.Statement;

public class CustomerController {

    public static CustomerController istance = new CustomerController();

    Statement statement = TestStatementBuilder.getInstance().createStatement();

    private AuthService authService;

    public CustomerController() {
        createServices();
    }

    private void createServices(){
        authService = new AuthService(new UserRepository(statement),new UserAuthenticationRepository(statement));
    }

    public User login(String login,String password) throws SQLException {
        return authService.login(login,password);
    }

}
