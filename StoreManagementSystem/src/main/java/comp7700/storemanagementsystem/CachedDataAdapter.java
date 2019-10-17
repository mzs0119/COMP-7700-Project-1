package comp7700.storemanagementsystem;

import java.util.HashMap;
import java.util.Map;

public class CachedDataAdapter { //implements IDataAccess {
    Map<Integer, ProductModel> cachedProducts = new HashMap<>();
    Map<Integer, CustomerModel> cachedCustomers = new HashMap<>();
    IDataAccess adapter;
    
    public CachedDataAdapter(IDataAccess adapter) {
        this.adapter = adapter;
    }
    
    public boolean connect(String path) {
        try {
            this.adapter.connect(path);
            return true;
        }
        catch(Exception e) {
            return false;
        }
    }

    public ProductModel loadProduct(int id) {
        if(cachedProducts.containsKey(id)) {
            return cachedProducts.get(id);
        }
        
        ProductModel product = adapter.loadProduct(id);
        if(product != null) {
            cachedProducts.put(id, product); // update cache
            return product;
        }
        
        return null;
    }

    public boolean saveProduct(ProductModel product) {
        adapter.saveProduct(product);
        cachedProducts.put(product.getProduct_id(), product); // update cache
        return true;
    }

    public CustomerModel loadCustomer(int id) {
        if(cachedCustomers.containsKey(id)) {
            return cachedCustomers.get(id);
        }
        
        CustomerModel customer = adapter.loadCustomer(id);
        if(customer != null) {
            cachedCustomers.put(id, customer); // update cache
            return customer;
        }
        
        return null;
    }

    public boolean saveCustomer(CustomerModel customer) {
        adapter.saveCustomer(customer);
        cachedCustomers.put(customer.getCustomer_id(), customer); // update cache
        return true;
    }
    
}
