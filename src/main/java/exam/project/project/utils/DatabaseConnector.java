package exam.project.project.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {

    private static final String user = "root";
    private static final String url = "jdbc:mysql://localhost:3306/project";
    private static final String password = "astrie123";

    public static Connection getConnection() {
        try {
            Class.forName( "com.mysql.jdbc.cj.Driver");
            return DriverManager.getConnection( url,user, password);

        }catch(ClassNotFoundException | SQLException e){
            throw new RuntimeException("Error connecting to the database", e);
        }

    }
}
