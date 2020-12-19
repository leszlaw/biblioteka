package test.repository;

import main.factory.LibraryStatementBuilder;
import main.model.Book;
import main.repository.BookRepository;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BookRepositoryTest {

    final Statement statement = new LibraryStatementBuilder().createStatement();

    final BookRepository bookRepository =
            new BookRepository(statement);

    @Before
    public void init() throws SQLException {
        statement.execute("DELETE FROM Book WHERE title = \"Hobbit\";");
    }

    @Test
    public void shouldReturnPanTadeuszBook() throws SQLException {

        Book book = bookRepository
                .selectThatBeginWith("Pan Tadeusz","fajna książka").get(0);

        assertEquals(book.title,"Pan Tadeusz");
        assertEquals(book.description,"fajna książka");

    }

    @Test
    public void shouldSaveBook() throws SQLException {

        Book book = new Book();
        book.title = "Hobbit";
        book.description = "siema";
        book.releaseDate = new Date(1000,10,10);

        bookRepository.save(book);

        List<Book> books = bookRepository.selectThatBeginWith("Hobbit","siema");

        assertEquals(books.size(),1);
        assertEquals(books.get(0).title,"Hobbit");

    }

}
