package database;

import Model.Account;
import Model.Product;
import Model.Profile;

import java.sql.ResultSet;

public class convertModels {
    public static Profile createProfileModel(ResultSet rs) throws Exception {
        Profile profile = new Profile();
        profile.setId(rs.getString("id"));
        return profile;
    }

    public static Account createAccountModel(ResultSet rs) throws Exception {
        Account account = new Account();
        account.setId(rs.getString("id"));
        account.setUsername(rs.getNString("username"));
        account.setPassword(rs.getString("password"));
        account.setLastname(rs.getNString("lastname"));
        account.setEmail(rs.getString("Email"));
        return account;
    }

    public static Product createProductModel(ResultSet rs) throws Exception {
        Product product = new Product();
        product.setId(rs.getInt("id"));
        product.setName(rs.getNString("Name"));
        product.setDescription(rs.getNString("Description"));
        product.setPrice(rs.getDouble("Price"));
        product.setImage(rs.getString("Picture"));
        return product;
    }
}

