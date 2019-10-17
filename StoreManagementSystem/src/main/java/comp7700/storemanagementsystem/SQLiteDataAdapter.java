package comp7700.storemanagementsystem;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLiteDataAdapter implements IDataAccess {
    Connection conn = null;
    int errorCode = 0;

    public boolean connect(String path) {
        try {
            String url = "jdbc:sqlite:" + path;
            conn = DriverManager.getConnection(url); // create a connection to the database

            System.out.println("Connection to SQLite has been established.");
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            errorCode = CONNECTION_OPEN_FAILED;
            return false;
        }
    }

    @Override
    public boolean disconnect() {
        return true;
    }

    @Override
    public int getErrorCode() {
        return errorCode;
    }

    @Override
    public String getErrorMessage() {
        switch (errorCode) {
            case CONNECTION_OPEN_FAILED: return "Connection is not opened!";
            case PRODUCT_LOAD_FAILED: return "Cannot load the product!";
            case CUSTOMER_LOAD_FAILED: return "Cannot load the customer!";
        };
        return "OK";
    }

    @Override
    public ProductModel loadProduct(int productID) {
        ProductModel product = null;

        try {
            String sql = "SELECT product_id, name, price, quantity FROM Product WHERE product_id = " + productID;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            product = new ProductModel(rs);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return product;
    }

    @Override
    public boolean saveProduct(ProductModel product) {
        final String SQL = "INSERT INTO PRODUCT (name, price, quantity, vendor) VALUES(?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(SQL); 
            
            ps.setString(1, product.getName());
            ps.setDouble(2, product.getPrice());
            ps.setInt(3, product.getQuantity());
            ps.setString(4, product.getVendor());
            
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        
        return true;
    }

    @Override
    public CustomerModel loadCustomer(int id) {
        CustomerModel customer = null;

        try {
            String sql = "SELECT customer_id, name, phone, address FROM Customer WHERE customer_id = " + id;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            customer = new CustomerModel(rs);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return customer;
    }

    @Override
    public boolean saveCustomer(CustomerModel customer) {
        final String SQL = "INSERT INTO Customer (name, phone, address) VALUES(?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(SQL); 
            
            ps.setString(1, customer.getName());
            ps.setString(2, customer.getPhone());
            ps.setString(3, customer.getAddress());
            
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            errorCode = CUSTOMER_LOAD_FAILED;
            return false;
        }
        
        return true;
    }
    
    public boolean savePurchase(PurchaseModel purchase) {
        final String SQL = "INSERT INTO Purchase (customer_id, product_id, cost, tax, total_cost, price, quantity, date) VALUES(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(SQL); 
            
            ps.setInt(1, purchase.getCustomer_id());
            ps.setInt(2, purchase.getProduct_id());
            ps.setDouble(3, purchase.getCost());
            ps.setDouble(4, purchase.getTax());
            ps.setDouble(5, purchase.getTotal_cost());
            ps.setDouble(6, purchase.getPrice());
            ps.setDouble(7, purchase.getQuantity());
            ps.setString(8, purchase.getDate());
            
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        
        return true;
    }

}
