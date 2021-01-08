package main.java.factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestStatementBuilder implements StatementBuilder{

    private static TestStatementBuilder istance = null;

    private String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private String DB_URL = "jdbc:mysql://localhost:3306/biblioteka?serverTimezone=UTC";

    private String USER = "root";
    private String PASS = "admin";

    private Connection connection;

    public TestStatementBuilder() {

        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASS);

            resetDatabase();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void resetDatabase() throws IOException, SQLException {
        ScriptRunner runner=new ScriptRunner(connection, false, false);
        InputStreamReader reader1 = new InputStreamReader(new FileInputStream("./src/main/resources/delete.sql"));
        InputStreamReader reader2 = new InputStreamReader(new FileInputStream("./src/main/resources/table.sql"));
        InputStreamReader reader3 = new InputStreamReader(new FileInputStream("./src/main/resources/view.sql"));
        InputStreamReader reader4 = new InputStreamReader(new FileInputStream("./src/main/resources/index.sql"));
        InputStreamReader reader5 = new InputStreamReader(new FileInputStream("./src/main/resources/example.sql"));
        runner.runScript(reader1);
        runner.runScript(reader2);
        runner.runScript(reader3);
        runner.runScript(reader4);
        runner.runScript(reader5);
        reader1.close();
        reader2.close();
        reader3.close();
        reader4.close();
        reader5.close();
    }

    public Statement createStatement(){
        try {
            return connection.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public static TestStatementBuilder getInstance(){
        if(istance==null)
            istance = new TestStatementBuilder();
        return istance;
    }

}
