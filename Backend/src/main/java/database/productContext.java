package database;

import Model.Product;
import interfaces.Context.IProductContext;

import java.sql.CallableStatement;
import java.sql.Connection;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static database.convertModels.*;

public class productContext extends database implements IProductContext {

    @Override
    public Product getProduct(Product product) {
        Product result = null;
        try {
            String SPsql = "EXEC getProduct ?";
            Connection connection = openConnection();
            CallableStatement stmt = connection.prepareCall(SPsql);
            stmt.setInt(1, product.getId());
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
        Product result = null;
        try {
            String SPsql = "EXEC createProduct ?, ? , ?";
            Connection connection = openConnection();
            CallableStatement stmt = connection.prepareCall(SPsql);
            stmt.setString(1, product.getName());
            stmt.setDouble(2, product.getPrice());
            stmt.setString(3, product.getDescription());
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                result = createProductModel(rs);
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
    public Product updateProduct(Product product) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> result = null;

        Connection connection = openConnection();
        try {
            String SPsql = "EXEC getAllProducts";

            CallableStatement stmt = connection.prepareCall(SPsql);
            ResultSet rs = stmt.executeQuery();

            result = new ArrayList<Product>();

            while (rs.next()) {
                result.add(createProductModel(rs));
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
}
