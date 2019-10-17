package comp7700.storemanagementsystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCustomerController {
    public AddCustomerView view;

    public AddCustomerController(AddCustomerView view) {
        this.view = view;

        view.btnAdd.addActionListener(new AddButtonController());
    }

    class AddButtonController implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            CustomerModel customer = new CustomerModel();
            customer.setAddress(view.txtAddress.getText());
            customer.setName(view.txtName.getText());
            customer.setPhone(view.txtPhone.getText());

            StoreManager.getInstance().getDataAccess().saveCustomer(customer);

            JOptionPane.showMessageDialog(null, "Sucessfully saved customer:  " + customer.getName());
            view.view.dispose();
        }
    }
}