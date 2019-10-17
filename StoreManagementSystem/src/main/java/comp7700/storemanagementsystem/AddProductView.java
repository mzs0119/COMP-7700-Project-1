package comp7700.storemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddProductView {
    public JFrame view;
    
    public JTextField txtVendor = new JTextField(20);
    public JTextField txtName = new JTextField(20);
    public JTextField txtPrice = new JTextField(20);
    public JTextField txtQuantity = new JTextField(20);

    public JButton btnAdd = new JButton("Add Product");
    public JButton btnCancel = new JButton("Cancel");

    public AddProductView() {
        view = new JFrame();
        view.setTitle("Add Product");
        view.setSize(500, 400);
        view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        view.getContentPane().setLayout(new BoxLayout(view.getContentPane(), BoxLayout.PAGE_AXIS));

        JPanel pane = new JPanel();
        pane.setLayout(new GridLayout(11,2, 0,6));
        view.getContentPane().add(pane);

        // The system should create the product id
//        JPanel line1 = new JPanel(new FlowLayout());
//        line1.add(new JLabel("ProductID:"));
//        line1.add(txtProductID);
//        pane.add(line1);

        pane.add(new JLabel("Name:")); pane.add(txtName);
        pane.add(new JLabel("Price:")); pane.add(txtPrice);
        pane.add(new JLabel("Quantity:")); pane.add(txtQuantity);
        pane.add(new JLabel("Vendor:")); pane.add(txtVendor);

        pane = new JPanel();
        pane.setLayout(new FlowLayout());
        pane.add(btnAdd); pane.add(btnCancel);

        btnAdd.addActionListener(new AddButtonController());
        btnCancel.addActionListener((actionEvent) -> view.dispose());
        view.getContentPane().add(pane);
    }

    public void run() {
        view.setVisible(true);
    }

    class AddButtonController implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            ProductModel product = new ProductModel();

//            String s = txtProductID.getText();
//
//            if (s.length() == 0) {
//                JOptionPane.showMessageDialog(null,
//                        "ProductID could not be EMPTY!!!");
//                return;
//            }
//            try {
//                product.mProductID = Integer.parseInt(s);
//            }
//            catch (NumberFormatException e) {
//                JOptionPane.showMessageDialog(null,
//                        "ProductID is INVALID (not a number)!!!");
//                return;
//            }

            String s = txtName.getText();
            if (s.length() == 0) {
                JOptionPane.showMessageDialog(null,
                        "Product Name can not be blank");
                return;
            }
            product.setName(s);

            s = txtPrice.getText();
            if (s.length() == 0) {
                JOptionPane.showMessageDialog(null,
                        "Price can not be blank");
                return;
            }

            try {
                product.setPrice(Double.parseDouble(s));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "Price is INVALID (not a number)");
                return;
            }

            s = txtQuantity.getText();
            if (s.length() == 0) {
                JOptionPane.showMessageDialog(null,
                        "Quantity can not be blank");
                return;
            }

            try {
                product.setQuantity(Integer.parseInt(s));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "Quantity is INVALID (not a number)");
                return;
            }
            IDataAccess adapter = StoreManager.getInstance().getDataAccess();

            if (adapter.saveProduct(product))
                JOptionPane.showMessageDialog(null,
                        "Product is saved successfully!");
            else {
                System.out.println(adapter.getErrorMessage());
            }


        }
    }
}
