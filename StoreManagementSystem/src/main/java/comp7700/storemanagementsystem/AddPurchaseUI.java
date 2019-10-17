package comp7700.storemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Calendar;

public class AddPurchaseUI {
    public JFrame view;

    public JLabel labPurchaseDate = new JLabel("Purchase Date: ");
    public JLabel labPurchaseID = new JLabel("Purchase ID: ");
    public JLabel labCustomerID = new JLabel("Customer ID: ");
    public JLabel labCustomerName = new JLabel("Customer Name: ");
    public JLabel labProductID = new JLabel("Product ID: ");
    public JLabel labProductName = new JLabel("Product Name: ");
    public JLabel labProductPrice = new JLabel("Product Price: ");
    public JLabel labProductQuantity = new JLabel("Purchase Quantity: ");

    public JTextField txtProductID = new JTextField(10);
//    public JTextField txtPurchaseID = new JTextField(10);
    public JTextField txtCustomerID = new JTextField(10);
    public JTextField txtPurchaseDate = new JTextField(10);
    public JTextField txtProductName = new JTextField(20);
    public JTextField txtCustomerName = new JTextField(20);
    public JTextField txtPrice = new JTextField(20);
    public JTextField txtQuantity = new JTextField(20);
    public JTextField txtCost = new JTextField(20);
    public JTextField txtTax = new JTextField(20);
    public JTextField txtTotalCost = new JTextField(20);

    public JButton btnAdd = new JButton("Add");
    public JButton btnCancel = new JButton("Cancel");

    ProductModel product;
    CustomerModel customer;
    PurchaseModel purchase;

    public AddPurchaseUI() {
        view = new JFrame();
        view.setTitle("Add Purchase");
        view.setSize(500, 400);
        view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        view.getContentPane().setLayout(new BoxLayout(view.getContentPane(), BoxLayout.PAGE_AXIS));

        JPanel pane = new JPanel();
        pane.setLayout(new GridLayout(11,2, 0,6));
        view.getContentPane().add(pane);

        pane.add(new JLabel("Purchase Date:")); pane.add(txtPurchaseDate);
//        pane.add(labPurchaseID); pane.add(txtPurchaseID);
        pane.add(labCustomerID); pane.add(txtCustomerID);
        pane.add(labCustomerName); pane.add(txtCustomerName);
        pane.add(labProductID); pane.add(txtProductID);
        pane.add(labProductName); pane.add(txtProductName);
        pane.add(labProductPrice); pane.add(txtPrice);
        pane.add(labProductQuantity); pane.add(txtQuantity);
        pane.add(new JLabel("Cost")); pane.add(txtCost);
        pane.add(new JLabel("Tax")); pane.add(txtTax);
        pane.add(new JLabel("Total Cost")); pane.add(txtTotalCost);


        pane = new JPanel();
        pane.setLayout(new FlowLayout());
        pane.add(btnAdd); pane.add(btnCancel);

        btnAdd.addActionListener(new AddButtonController());
        btnCancel.addActionListener((actionEvent) -> view.dispose());
        view.getContentPane().add(pane);

        txtProductID.addFocusListener(new ProductNameLoader());
        txtQuantity.addFocusListener(new CostCalculator());
        txtCustomerID.addFocusListener(new CustomerNameLoader());
    }
    
    class AddButtonController implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            String s = txtProductID.getText();
            if (s.length() == 0) {
                JOptionPane.showMessageDialog(null,
                        "Product ID could not be EMPTY!!!");
                return;
            }
            try {
                purchase.setProduct_id(Integer.parseInt(s));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "Product ID is INVALID (not a number)!!!");
                return;
            }
            
//            s = txtPurchaseID.getText();
//            if (s.length() == 0) {
//                JOptionPane.showMessageDialog(null,
//                        "Purchase ID could not be EMPTY!!!");
//                return;
//            }
//            try {
//                purchase.setPurchase_id(Integer.parseInt(s));
//            } catch (NumberFormatException e) {
//                JOptionPane.showMessageDialog(null,
//                        "Purchase ID is INVALID (not a number)!!!");
//                return;
//            }
            
            s = txtCustomerID.getText();
            if (s.length() == 0) {
                JOptionPane.showMessageDialog(null,
                        "Customer ID could not be EMPTY!!!");
                return;
            }
            try {
                purchase.setCustomer_id(Integer.parseInt(s));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "Customer ID is INVALID (not a number)!!!");
                return;
            }
            
            s = txtPurchaseDate.getText();
            if (s.length() == 0) {
                JOptionPane.showMessageDialog(null,
                        "Purchase Date could not be EMPTY!!!");
                return;
            }
            try{
                purchase.setDate(s);
            } catch(Exception e) {
                JOptionPane.showMessageDialog(null,
                        "Date is INVALID (not a date)!!!");
                return;
            }
            
            s = txtPrice.getText();
            if (s.length() == 0) {
                JOptionPane.showMessageDialog(null,
                        "Price could not be EMPTY!!!");
                return;
            }
            try {
                purchase.setPrice(Double.parseDouble(s));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "Price is INVALID (not a number)!!!");
                return;
            }
            
            s = txtQuantity.getText();
            if (s.length() == 0) {
                JOptionPane.showMessageDialog(null,
                        "Quantity could not be EMPTY!!!");
                return;
            }
            try {
                purchase.setQuantity(Double.parseDouble(s));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "Quantity is INVALID (not a number)!!!");
                return;
            }
            
            s = txtCost.getText();
            if (s.length() == 0) {
                JOptionPane.showMessageDialog(null,
                        "Cost could not be EMPTY!!!");
                return;
            }
            try {
                purchase.setCost(Double.parseDouble(s));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "Cost is INVALID (not a number)!!!");
                return;
            }
            
            s = txtTax.getText();
            if (s.length() == 0) {
                JOptionPane.showMessageDialog(null,
                        "Tax could not be EMPTY!!!");
                return;
            }
            try {
                purchase.setTax(Double.parseDouble(s));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "Tax is INVALID (not a number)!!!");
                return;
            }
            
            s = txtTotalCost.getText();
            if (s.length() == 0) {
                JOptionPane.showMessageDialog(null,
                        "Total could not be EMPTY!!!");
                return;
            }
            try {
                purchase.setTotal_cost(Double.parseDouble(s));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "Total is INVALID (not a number)!!!");
                return;
            }
            
            IDataAccess adapter = StoreManager.getInstance().getDataAccess();

            if (adapter.savePurchase(purchase)) {
//                JOptionPane.showMessageDialog(null, "Purchase is saved successfully!");
                TXTReceiptBuilder tb = new TXTReceiptBuilder();
                tb.appendHeader("Store Management System\n\n");
                tb.appendCustomer(customer);
                tb.appendProduct(product);
                tb.appendPurchase(purchase);
                tb.appendFooter("\n\nThank you! See you soon!");
                
//                IReceiptBuilder tb = new HTMLReceiptBuilder();
//                tb.appendHeader("STORE MANAGEMENT SYSTEM");
//                tb.appendCustomer(customer);
//                tb.appendProduct(product);
//                tb.appendPurchase(purchase);
//                tb.appendFooter("THANK YOU AND SEE YOU AGAIN!");
//                System.out.println(tb.toString());
                
                JOptionPane.showMessageDialog(null, tb.toString());
           }
            else {
                System.out.println(adapter.getErrorMessage());
            }
        }
    }

    class CostCalculator implements FocusListener  {

        @Override
        public void focusGained(FocusEvent focusEvent) {

        }

        @Override
        public void focusLost(FocusEvent focusEvent) {
            String s = txtQuantity.getText();
            try {
                purchase.setQuantity(Double.parseDouble(s));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid Quantity");
                return;
            }

            if (purchase.getQuantity() > product.getQuantity()) {
                JOptionPane.showMessageDialog(null, "Purchase Quantity > Available Quantity!");
                return;
            }

            purchase.setCost(purchase.getQuantity() * product.getPrice());
            txtCost.setText(Double.toString(purchase.getCost()));
            purchase.setTax(purchase.getCost() * 0.09);
            txtTax.setText(Double.toString(purchase.getTax()));
            purchase.setTotal_cost(purchase.getCost() + purchase.getTax());
            txtTotalCost.setText(Double.toString(purchase.getTotal_cost()));

        }
    }

    class ProductNameLoader implements FocusListener  {

        @Override
        public void focusGained(FocusEvent focusEvent) {

        }

        @Override
        public void focusLost(FocusEvent focusEvent) {
            String s = txtProductID.getText();
            try {
                purchase.setProduct_id(Integer.parseInt(s));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid ProductID");
                return;
            }
            if (product == null || product.getProduct_id() != purchase.getProduct_id())
                product = StoreManager.getInstance().getDataAccess().loadProduct(purchase.getProduct_id());
            if (product == null) {
                JOptionPane.showMessageDialog(null, "No Product with ID = " + purchase.getProduct_id());
                txtProductName.setText("");
                txtPrice.setText("");
                return;
            }

            txtProductName.setText(product.getName());
            txtPrice.setText(Double.toString(product.getPrice()));

        }
    }
    
    class CustomerNameLoader implements FocusListener {
        @Override
        public void focusGained(FocusEvent focusEvent) {

        }

        @Override
        public void focusLost(FocusEvent focusEvent) {
            String s = txtCustomerID.getText();
            try {
                purchase.setCustomer_id(Integer.parseInt(s));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid CustomerID");
                return;
            }
            if (customer == null || customer.getCustomer_id() != purchase.getCustomer_id())
                customer = StoreManager.getInstance().getDataAccess().loadCustomer(purchase.getCustomer_id());
            if (customer == null) {
                JOptionPane.showMessageDialog(null, "No customer with ID = " + purchase.getCustomer_id());
                txtCustomerName.setText("");
                return;
            }

            txtCustomerName.setText(customer.getName());
        }
    }

    public void run() {
        purchase = new PurchaseModel();

        txtPurchaseDate.setText(Calendar.getInstance().getTime().toString());
        txtCustomerName.setEnabled(false);
        txtProductName.setEnabled(false);
        txtCost.setEnabled(false);
        txtTax.setEnabled(false);
        txtTotalCost.setEnabled(false);
        view.setVisible(true);
    }
}
