package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class database {
    private Connection conn;


    public database() {
    }

    public Connection openConnection() {
        try {
            if (conn == null || conn.isClosed()) {
                String url = "";

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
