package database;

import Model.Account;
import interfaces.Context.IAccountContext;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import static database.convertModels.*;

public class accountContext extends database implements IAccountContext {

    @Override
    public Account authenticate(Account account) {
        Account login = new Account();
        try {
            String SPsql = "EXEC Login ?, ?";
            Connection connection = openConnection();
            CallableStatement stmt = connection.prepareCall(SPsql);
            stmt.setString(1, account.getUsername());
            stmt.setString(2, account.getPassword());
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
    public Account createAccount(Account account) {
        Account result = null;
        try {
            String SPsql = "EXEC createProfile ?, ? , ?, ? ";
            Connection connection = openConnection();
            CallableStatement stmt = connection.prepareCall(SPsql);
            stmt.setString(1, account.getUsername());
            stmt.setString(2, account.getPassword());
            stmt.setString(3,account.getLastname());
            stmt.setString(4,account.getEmail());

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                result = createAccountModel(rs);
            }
            rs.close();

        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e);
        } finally {
            closeConnection();
        }

        return result;
    }
    @Override
    public Account updateAccount(Account account) {
        return null;
    }

    @Override
    public Account getAccount(Account account) {
        return null;
    }
}
