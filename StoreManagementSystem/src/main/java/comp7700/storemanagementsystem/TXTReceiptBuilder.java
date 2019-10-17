package comp7700.storemanagementsystem;

/**
 *
 * @author melanasmith
 */
public class TXTReceiptBuilder implements IReceiptBuilder {
    StringBuilder sb = new StringBuilder();
    
    @Override
    public void appendHeader(String s) {
        sb.append(s);
    }

    @Override
    public void appendCustomer(CustomerModel customer) {
        sb.append("Customer information: \n-----------------------------\n");
        sb.append("Customer ID: " + customer.getCustomer_id() + "\n");
        sb.append("Name: " + customer.getName() + "\n");
        sb.append("Phone: " + customer.getPhone() + "\n");
        sb.append("Address: " + customer.getAddress() + "\n");
    }

    @Override
    public void appendProduct(ProductModel product) {
        sb.append("Product information: \n-----------------------------\n");
        sb.append(String.format("%10d  %20s  %8.2f", 
                product.getProduct_id(),
                product.getName(),
                product.getPrice()));//"Product ID, Name, Price,  \n");
        
    }

    @Override
    public void appendPurchase(PurchaseModel purchase) {
        sb.append("\nOrder information: \n-----------------------------\n");
        sb.append(String.format("                         Subtotal: %8.2f", purchase.getCost()));
        sb.append(String.format("                         Tax: %8.2f", purchase.getTax()));
        sb.append(String.format("                         TOTAL: %8.2f", purchase.getTotal_cost()));
    }

    @Override
    public void appendFooter(String s) {
        sb.append(s);
    }
    
    public String toString() {
        return sb.toString();
    }
    
}
