package comp7700.storemanagementsystem;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductModel {
    private int product_id, quantity;
    private String name, vendor;
    private double price;
    
    public ProductModel() {
        
    }
    
    public ProductModel(ResultSet rs) throws SQLException {
        this.product_id = rs.getInt("product_id");
        this.name = rs.getString("name");
        this.price = rs.getDouble("price");
        this.quantity = rs.getInt("quantity");
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
}
