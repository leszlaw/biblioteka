package main.java.repository;

import main.java.model.PublisherBook;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PublisherBookRepository extends Repository{

    public PublisherBookRepository(Statement statement) {
        super(statement);
    }

    public void save(PublisherBook publisherBook) throws SQLException {

        StringBuilder sb =new StringBuilder("INSERT INTO PublisherBook(");

        if(publisherBook.img!=null)
            sb.append("img,");
        if(publisherBook.pages!=null)
            sb.append("pages,");
        if(publisherBook.isbn!=null)
            sb.append("isbn,");

        sb.append("book_id,publisher_id) VALUES(");

        if(publisherBook.img!=null)
            sb.append("\"" + publisherBook.img +"\",");
        if(publisherBook.pages!=null)
            sb.append("" + publisherBook.pages +",");
        if(publisherBook.isbn!=null)
            sb.append("" + publisherBook.isbn.toString() +",");

        sb.append("" + publisherBook.bookId +"," + publisherBook.publisherId + ");");

        String sql = sb.toString();

        statement.execute(sql);
    }

    public void update(PublisherBook publisherBook) throws SQLException {

        StringBuilder sb = new StringBuilder("UPDATE PublisherBook " +
                "SET book_id = " + publisherBook.bookId + ", publisher_id = " + publisherBook.publisherId);

        if(publisherBook.img != null)
            sb.append(", img =\"" + publisherBook.img + "\"");
        if(publisherBook.pages != null)
            sb.append(", pages = " + publisherBook.pages.intValue() );
        if(publisherBook.isbn != null)
            sb.append(", isbn = " + publisherBook.isbn.longValue() );

        sb.append(" WHERE id = " + publisherBook.id +";");

        String sql = sb.toString();

        statement.execute(sql);
    }

    public void removeById(int id) throws SQLException {

        String sql = "DELETE FROM PublisherBook WHERE id = "+ id;

        statement.executeQuery(sql);

    }

    public PublisherBook findById(int id) throws SQLException {
        String sql = "SELECT * FROM PublisherBook WHERE id = " + id;
        ResultSet rs = statement.executeQuery(sql);
        rs.next();
        PublisherBook publisherBook = new PublisherBook();
        publisherBook.id=rs.getInt("id");
        publisherBook.pages=rs.getInt("pages");
        publisherBook.bookId=rs.getInt("book_id");
        publisherBook.publisherId=rs.getInt("publisher_id");
        publisherBook.isbn=rs.getLong("isbn");
        publisherBook.img=rs.getString("img");
        return publisherBook;
    }

    public List<PublisherBook> findByBookId(int bookId) throws SQLException {
        String sql = "SELECT * FROM PublisherBook WHERE book_id = " + bookId;
        List<PublisherBook> publisherBooks = getPublisherBooks(sql);
        return publisherBooks;
    }

    public List<PublisherBook> findAll() throws SQLException {
        String sql = "SELECT * FROM PublisherBook";
        List<PublisherBook> publisherBooks = getPublisherBooks(sql);
        return publisherBooks;
    }

    private List<PublisherBook> getPublisherBooks(String sql) throws SQLException {
        ResultSet rs = statement.executeQuery(sql);
        List<PublisherBook> publisherBooks = new ArrayList<>();
        while (rs.next()) {
            PublisherBook publisherBook = new PublisherBook();
            publisherBook.id = rs.getInt("id");
            publisherBook.pages = rs.getInt("pages");
            publisherBook.bookId = rs.getInt("book_id");
            publisherBook.publisherId = rs.getInt("publisher_id");
            publisherBook.isbn = rs.getLong("isbn");
            publisherBook.img = rs.getString("img");
            publisherBooks.add(publisherBook);
        }
        return publisherBooks;
    }
}
