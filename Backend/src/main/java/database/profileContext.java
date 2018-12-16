package database;

import interfaces.IProfileContext;
import Model.Profile;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import static database.convertProfiles.createProfile;

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
                result = createProfile(rs);
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
    public Profile updateProfile(Profile profile) {
        return null;
    }

    @Override
    public List<Profile> getAllProfiles() {
        return null;
    }
}
