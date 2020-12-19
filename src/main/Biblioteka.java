package main;

import java.sql.*;
import java.util.HashMap;

public class Biblioteka {

    public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    public static final String DB_URL = "jdbc:mysql://116.202.211.83:3306/db_62692";

    //  Database credentials
    public static final String USER = "db_62692";
    public static final String PASS = "NwLurZQOTOnY";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);
            HashMap map=new HashMap<String,String>();
            
            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM dostepne_ksiazki";
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while (rs.next()) {
                String title = rs.getString("title");
                int count = rs.getInt("COUNT(*)");
                //Display values
                System.out.println("title: " + title + " count: " + count);
            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
