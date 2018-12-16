package database;

import Model.Profile;

import java.sql.ResultSet;

public class convertProfiles {
    public static Profile createProfile(ResultSet rs) throws Exception {
        Profile profile = new Profile();
        profile.setId(rs.getString("id"));
        profile.setName(rs.getNString("Name"));
        profile.setEmail(rs.getString("Email"));
        profile.setAdress(rs.getString("Adress"));
        profile.setAge(rs.getInt("Age"));
        return profile;
    }
}
