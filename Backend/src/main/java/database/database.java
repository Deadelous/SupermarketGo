package database;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class database implements  IDatabase {
    private Connection conn;


    public database() {

    }

    public Connection openConnection() {
        Properties prop = new Properties();
        InputStream input = null;
        try {
            if (conn == null || conn.isClosed()) {
                input = getClass().getClassLoader().getResourceAsStream("supermarketdatabase.properties");
                prop.load(input);
                String url = "jdbc:sqlserver://supermarketgo.database.windows.net:1433;database=Supermarket;user="+prop.getProperty("user")+";password="+prop.getProperty("password")+";encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;";

                conn = DriverManager.getConnection(url);
            }
        } catch (Exception error) {
            System.err.println(error.getMessage());
        }

        return conn;

    }

    public void closeConnection() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (Exception error) {
            System.err.println(error);
        }
    }

}
