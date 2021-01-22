package main.java;

import main.java.factory.LocalStatementBuilder;
import main.java.model.Book;
import main.java.model.Opinion;
import main.java.model.User;
import main.java.repository.*;
import main.java.service.BookService;
import main.java.service.ReservationService;
import main.java.ui.LoginView;
import main.java.ui.OpinionView;

import java.sql.Statement;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;


public class Biblioteka {



    public static void main(String[] args) {
        final Statement statement = LocalStatementBuilder.getTestInstance().createStatement();

        final BookRepository bookRepository = new BookRepository(statement);
        final AuthorRepository auRep = new AuthorRepository(statement);
        final PublisherBookRepository pubRep = new PublisherBookRepository(statement);
        final OpinionRepository opRep = new OpinionRepository(statement);
        final BookService bookService = new BookService(bookRepository, auRep, pubRep);

        Book book;
        User user;
        book = new Book();
        book.id = 7;
        book.description = "Opis";
        book.title = "Testowa ksiazka";
        book.releaseDate = LocalDate.now().toString();

        try {
            bookRepository.save(book);
        }catch (Exception e){}

        Opinion op1 = new Opinion();

        op1.id = 1;
        op1.rate = 5;
        op1.text = "Ale fajna ksiązka. Polecam wszystkim";
        op1.userId = 1;
        op1.bookId = 7;

        Opinion op2 = new Opinion();

        op2.id = 1;
        op2.rate = 9;
        op2.text = "Teskt 22222222";
        op2.userId = 2;
        op2.bookId = 7;

        Opinion op3 = new Opinion();

        op3.id = 1;
        op3.rate = 7;
        op3.text = "ASFSAGASHASDHASDHHHHHHHHHHHHHHHHHHHHHHHHHHAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
        op3.userId = 3;
        op3.bookId = 7;

        Opinion op4 = new Opinion();

        op4.id = 1;
        op4.rate = 0;
        op4.text = "Tekst 4";
        op4.userId = 4;
        op4.bookId = 7;

        Opinion op5 = new Opinion();

        op5.id = 1;
        op5.rate = 0;
        op5.text = "Tekst 5";
        op5.userId = 5;
        op5.bookId = 7;

        Opinion op6 = new Opinion();

        op6.id = 1;
        op6.rate = 0;
        op6.text = "";
        op6.userId = 6;
        op6.bookId = 7;

        try {
            opRep.save(op1);
            opRep.save(op2);
            opRep.save(op3);
            opRep.save(op4);
            opRep.save(op5);
            opRep.save(op6);
        }catch (Exception e){

        }


        user = new User();
        user.name = "Imie xd";
        user.id = 3;

        //new LoginView();
        new OpinionView(book, user);
    }

}
