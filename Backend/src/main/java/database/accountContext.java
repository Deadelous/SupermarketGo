package database;

import Model.Account;
import interfaces.IAccountContext;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import static database.convertModels.*;

public class accountContext extends database implements IAccountContext {

    @Override
    public Account authenticate(Account account) {
        return null;
    }

    @Override
    public boolean createAccount(Account account) {
        Account result = null;
        try {
            String SPsql = "EXEC createAccount ?, ? ";
            Connection connection = openConnection();
            CallableStatement stmt = connection.prepareCall(SPsql);
            stmt.setString(1, account.getUsername());
            stmt.setString(2, account.getPassword());
            stmt.execute();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e);
            return false;
        } finally {
            closeConnection();
        }
        return true;
    }


    @Override
    public Account updateAccount(Account account) {
        return null;
    }
}
