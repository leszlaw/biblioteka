package test.java.repository;

import main.java.factory.TestStatementBuilder;
import main.java.repository.AddressRepository;
import org.junit.Test;

import java.sql.Statement;

import static org.junit.Assert.assertEquals;

public class AddressRepositoryTest {

    final Statement statement = TestStatementBuilder.getInstance().createStatement();

    final AddressRepository addressRepository =
            new AddressRepository(statement);

    @Test
    public void shouldSaveAddress(){


    }

    @Test
    public void shouldFindByUserId(){


        
    }

}
