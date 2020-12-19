package main.repository;

import main.mapper.DateMapper;
import main.model.Book;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookRepository {

    private Statement statement;

    public BookRepository(Statement statement) {
        this.statement = statement;
    }

    public void save(Book book) throws SQLException {

        String sql = "INSERT INTO Book(title,description,release_date) " +
                "VALUES(\"" + book.title + "\",\"" + book.description + "\"," +
                "\"" + new DateMapper().dateToString(book.releaseDate) + "\");";

        statement.execute(sql);

    }

    public void update(Book book) throws SQLException {

        String sql = "UPDATE Book " +
                "SET title = \"" + book.title + "\"," +
                "description \"= " + book.description + "\"," +
                "releaseDate \"= " + book.releaseDate + "\"," +
                "WHERE id = " + book.id +";";

        statement.executeQuery(sql);

    }

    public void remove(Book book) throws SQLException {

        String sql = "DELETE Book " +
                "WHERE title = \"" + book.title + "\" " +
                "AND description \"= " + book.description + "\" " +
                "AND releaseDate \"= " + book.releaseDate + "\" " +
                "AND id = " + book.id +";";

        statement.executeQuery(sql);

    }

    public List<Book> selectThatBeginWith(String title,String description) throws SQLException {

        String sql = "SELECT * FROM Book " +
                "WHERE title LIKE \"" + title + "%\"" +
                "AND description LIKE \"" + description + "%\";";

        ResultSet rs = statement.executeQuery(sql);

        List<Book> books = new ArrayList<>();

        while (rs.next()) {
            Book book = new Book();

            book.id = rs.getInt("id");
            book.title = rs.getString("title");
            book.description = rs.getString("description");

            books.add(book);
        }

        return books;

    }


}
