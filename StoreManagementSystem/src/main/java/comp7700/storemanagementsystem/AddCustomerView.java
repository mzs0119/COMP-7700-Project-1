package comp7700.storemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCustomerView {
    public JFrame view;
    
    public JTextField txtAddress = new JTextField(20);
    public JTextField txtName = new JTextField(20);
    public JTextField txtPhone = new JTextField(20);

    public JButton btnAdd = new JButton("Add Customer");
    public JButton btnCancel = new JButton("Cancel");

    public AddCustomerView() {
        view = new JFrame();
        view.setTitle("Add Customer");
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
        pane.add(new JLabel("Address:")); pane.add(txtAddress);
        pane.add(new JLabel("Phone:")); pane.add(txtPhone);

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
            CustomerModel customer = new CustomerModel();

            String s = txtName.getText();
            if (s.length() == 0) {
                JOptionPane.showMessageDialog(null,
                        "Customer Name could not be blank");
                return;
            }
            customer.setName(s);

            s = txtAddress.getText();
            if (s.length() == 0) {
                JOptionPane.showMessageDialog(null,
                        "Address could not be blank");
                return;
            }
            customer.setAddress(s);

            s = txtPhone.getText();
            if (s.length() == 0) {
                JOptionPane.showMessageDialog(null,
                        "Phone could not be blank");
                return;
            }
            customer.setPhone(s);

            
            IDataAccess adapter = StoreManager.getInstance().getDataAccess();

            if (adapter.saveCustomer(customer))
                JOptionPane.showMessageDialog(null,
                        "Customer is saved successfully!");
            else {
                System.out.println(adapter.getErrorMessage());
            }
        }
    }
}
