package database;

import java.sql.Connection;

public interface IDatabase {
    Connection openConnection();
    void closeConnection();
}
