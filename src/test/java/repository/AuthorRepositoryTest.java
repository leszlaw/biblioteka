package test.java.repository;

import main.java.factory.TestStatementBuilder;
import main.java.model.Author;
import main.java.repository.AuthorRepository;
import org.junit.Test;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AuthorRepositoryTest{

    final Statement statement = TestStatementBuilder.getInstance().createStatement();

    final AuthorRepository authorRepository =
                new AuthorRepository(statement);


    @Test
    public void shouldGiveBookToAuthor() throws SQLException {
        List<Author> authors = authorRepository.findByBookId(1);
        assertEquals(authors.size(),1);
        authorRepository.giveBookToAuthorById(1,2);
        authors = authorRepository.findByBookId(1);
        assertEquals(authors.size(),2);
    }

    @Test
    public void shouldFind_NicolaTesla_ByNameAndLastName() throws SQLException {
        List<Author> authors = authorRepository.findByNameAndLastName("Ni", "Te");
        assertEquals(authors.get(0).name,"Nicola");
        assertEquals(authors.get(0).lastName,"Tesla");
    }

}
