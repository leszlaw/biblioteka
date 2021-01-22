package main.java.controller;

import main.java.factory.LocalStatementBuilder;
import main.java.model.Book;
import main.java.model.User;
import main.java.model.dto.BookDTO;
import main.java.repository.*;
import main.java.service.AuthService;
import main.java.service.BookService;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Controller {

    public static Controller istance = new Controller();

    Statement statement = LocalStatementBuilder.getInstance().createStatement();

    private AuthService authService;
    private BookService bookService;

    public Controller() {
        createServices();
    }

    private void createServices(){
        BookRepository bookRepository = new BookRepository(statement);
        AuthorRepository authorRepository = new AuthorRepository(statement);
        PublisherBookRepository publisherBookRepository = new PublisherBookRepository(statement);
        authService = new AuthService(new UserRepository(statement),new UserAuthenticationRepository(statement));
        bookService = new BookService(bookRepository,authorRepository,publisherBookRepository);
    }

    public User login(String login,String password) throws SQLException {
        return authService.login(login,password);
    }

    public List<BookDTO> findBooks(String title) throws SQLException {
        return bookService.getBooks(title);
    }

    public void addNewBook(BookDTO book) throws SQLException {
        bookService.addNewBook(book);
    }

}
