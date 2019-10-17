package comp7700.storemanagementsystem;

/**
 *
 * @author melanasmith
 */
public interface IReceiptBuilder {
    public void appendHeader(String s);
    public void appendCustomer(CustomerModel customer);
    public void appendProduct(ProductModel product);
    public void appendPurchase(PurchaseModel purchase);
    public void appendFooter(String s);
    
    @Override
    public String toString();
}
