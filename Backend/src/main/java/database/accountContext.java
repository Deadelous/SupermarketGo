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
        Account login = new Account();
        try {
            String SPsql = "EXEC login ?, ?, ?";
            Connection connection = openConnection();
            CallableStatement stmt = connection.prepareCall(SPsql);
            stmt.setInt(1, login.getId());
            stmt.setString(2, login.getUsername());
            stmt.setString(3, login.getPassword());
            ResultSet rs = stmt.executeQuery();
            if (rs.next())
            {
                login = createAccountModel(rs);
            }
            rs.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e);
            return null;
        } finally {
            closeConnection();
        }
        return login;
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
