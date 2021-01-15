package main.java.service;

import main.java.model.Author;
import main.java.model.Book;
import main.java.model.PublisherBook;
import main.java.model.dto.BookDTO;
import main.java.repository.AuthorRepository;
import main.java.repository.BookRepository;
import main.java.repository.PublisherBookRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookService {

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private PublisherBookRepository publisherBookRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository, PublisherBookRepository publisherBookRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherBookRepository = publisherBookRepository;
    }

    public List<BookDTO> getBooks(String title) throws SQLException {
        List<BookDTO> bookDTOS = new ArrayList<>();
        List<Book> books = bookRepository.selectThatBeginWith(title,"");

        for(Book b:books){
            BookDTO bookDTO=new BookDTO();
            Author a = new Author();
            a.name = "nieznany";
            a.lastName = "";
            if(authorRepository.findByBookId(b.id).size()>0)
                a=authorRepository.findByBookId(b.id).get(0);
            PublisherBook pb = new PublisherBook();
            pb.img = "images/book1.jpg";
            if(publisherBookRepository.findByBookId(b.id).size()>0)
                pb = publisherBookRepository.findByBookId(b.id).get(0);
            bookDTO.title=b.title;
            bookDTO.description=b.description;
            bookDTO.img=pb.img;
            bookDTO.author=a.name + " " + a.lastName;
            bookDTOS.add(bookDTO);
        }
        return bookDTOS;
    }

}
