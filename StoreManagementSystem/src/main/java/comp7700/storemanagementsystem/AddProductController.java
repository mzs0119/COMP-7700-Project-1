package comp7700.storemanagementsystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddProductController {
    public AddProductView view;

    public AddProductController(AddProductView view) {
        this.view = view;

        view.btnAdd.addActionListener(new AddButtonController());
    }

    class AddButtonController implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            ProductModel product = new ProductModel();
            product.setVendor(view.txtVendor.getText());
            product.setName(view.txtName.getText());
            product.setPrice(Double.parseDouble(view.txtPrice.getText()));
            product.setQuantity(Integer.parseInt(view.txtQuantity.getText()));

            StoreManager.getInstance().getDataAccess().saveProduct(product);

            JOptionPane.showMessageDialog(null, "Successfully saved product: " + product.getName());
            view.view.dispose();
        }
    }
}