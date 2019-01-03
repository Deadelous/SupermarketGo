package database;

import Model.Product;
import interfaces.Context.IProductContext;

import java.sql.CallableStatement;
import java.sql.Connection;

import java.sql.ResultSet;

import static database.convertModels.*;

public class productContext extends database implements IProductContext {

    @Override
    public Product getProduct(Product product) {
        Product result = null;
        try {
            String SPsql = "EXEC getProduct ?";
            Connection connection = openConnection();
            CallableStatement stmt = connection.prepareCall(SPsql);
            stmt.setString(1, product.getId());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                result = createProductModel(rs);
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
    public Product addProduct(Product product) {
        return null;
    }

    @Override
    public Product updateProduct(Product product) {
        return null;
    }
}
