package test.java.repository;

import main.java.factory.TestStatementBuilder;
import main.java.model.Role;
import main.java.repository.RoleRepository;
import org.junit.Test;

import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.assertEquals;

public class RoleRepositoryTest {

    final Statement statement = TestStatementBuilder.getInstance().createStatement();

    final RoleRepository roleRepository =
            new RoleRepository(statement);

    @Test
    public void shouldFindByUserId() throws SQLException {
        Role role = roleRepository.findByUserId(1);
        assertEquals("pracownik",role.roleName);
    }

}
