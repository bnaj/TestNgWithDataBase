package sample.database.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ComunicationWithBase {

    /**
     * This method is used to connect with base.
     * Fragment "Class.forName("org.sqlite.JDBC");" provide data base driver.
     * @param baseName name of base to connect.
     */
    public static Connection connect(String baseName) {
         String pathToBase = "jdbc:sqlite:"+System.getProperty("user.dir") + "/src/main/resources/" + baseName + ".db";
            try {
                Class.forName("org.sqlite.JDBC");
                Connection connection = DriverManager.getConnection(pathToBase);
                return connection;
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        return null;
    }
    }