package comp7700.storemanagementsystem;

import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TXTDataAdapter { // implements IDataAccess {
    Map<Integer, ProductModel> products = new HashMap<>();

    public void connect(String path) {
        try {
            try (Scanner scanner = new Scanner(new FileReader(new File(path)))) {
                ProductModel product = new ProductModel();
                
                while (scanner.hasNext()) {
                    product.setProduct_id(scanner.nextInt()); 
                    scanner.nextLine();
                    product.setName(scanner.nextLine());
                    product.setPrice(scanner.nextDouble());
                    product.setQuantity(scanner.nextInt());
                    
//                scanner.next(); // empty line
                    System.out.println(product);
                    products.put(product.getProduct_id(), product);
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public ProductModel loadProduct(int id) {
        if (products.containsKey(id))
            return products.get(id);
        else
            return null;
    }

}
