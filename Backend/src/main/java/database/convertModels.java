package database;

import Model.Account;
import Model.Profile;

import java.sql.ResultSet;

public class convertModels {
    public static Profile createProfileModel(ResultSet rs) throws Exception {
        Profile profile = new Profile();
        profile.setId(rs.getString("id"));
        profile.setName(rs.getNString("Name"));
        profile.setEmail(rs.getString("Email"));
        profile.setAdress(rs.getString("Adress"));
        profile.setAge(rs.getInt("Age"));
        return profile;
    }

    public static Account createAccountModel(ResultSet rs) throws Exception {
        Account account = new Account();
        account.setId(rs.getInt("id"));
        account.setUsername(rs.getNString("Username"));
        account.setPassword(rs.getString("Password"));
        return account;
    }
}
