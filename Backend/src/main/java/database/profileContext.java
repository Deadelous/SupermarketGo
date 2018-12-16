package database;

import Model.Profile;
import interfaces.IProfileContext;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;


import static database.convertModels.*;

public class profileContext extends database implements IProfileContext {
    @Override
    public Profile getProfile(Profile profile) {
        Profile result = null;
        try {
            String SPsql = "EXEC getProfile ?";
            Connection connection = openConnection();
            CallableStatement stmt = connection.prepareCall(SPsql);
            stmt.setString(1, profile.getId());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                result = createProfileModel(rs);
            }
            rs.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e);
            return null;
        } finally {
            closeConnection();
        }
        return result;
    }

    @Override
    public Profile createProfile(Profile profile) {
        Profile result = null;
        try {
            String SPsql = "EXEC createProfile ? ? ? ? ?";
            Connection connection = openConnection();
            CallableStatement stmt = connection.prepareCall(SPsql);
            stmt.setString(1, profile.getId());
            stmt.setString(2, profile.getName());
            stmt.setString(3, profile.getEmail());
            stmt.setString(4, profile.getAdress());
            stmt.setInt(5,profile.getAge());
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                result = createProfileModel(rs);
            }
            rs.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e);
        } finally {
            closeConnection();
        }
        return result;
    }

    @Override
    public List<Profile> getAllProfiles() {
        return null;
    }
}
