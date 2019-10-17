package comp7700.storemanagementsystem;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerModel {
    private int customer_id;
    private String name, address, phone;
    
    public CustomerModel() {
        
    }
    
    public CustomerModel(ResultSet rs) throws SQLException {
        this.customer_id = rs.getInt("customer_id");
        this.name = rs.getString("name");
        this.address = rs.getString("address");
        this.phone = rs.getString("phone");
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
}
