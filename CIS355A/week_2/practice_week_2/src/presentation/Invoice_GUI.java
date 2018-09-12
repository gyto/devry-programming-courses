package presentation;

import business.Invoice;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Invoice_GUI extends JFrame {
    
    public static final int WINDOW_WIDTH = 450;
    public static final int WINDOW_HEIGHT = 400;
    
    private Invoice aInvoice;
    
    private JButton btnCalculate;   
    private JButton btnClear;
    private JButton btnExit;
    
    private JTextField txtProductName;
    private JTextField txtQuantity;
    private JTextField txtCostPerItem;
    private  JTextArea txtTotalCost;
    
    public Invoice_GUI() {
        super();
        createPanel();
        setFrame();
    }
    
    private void createPanel() {
        super.setLayout(new GridLayout(0, 2));
        //TODO:  create the GUI components and add them to the form for:
        /*
            1.  Product name label
            2.  Product name textfield (name: txtProductName)
            3.  Quantity label
            4.  Quanitity textfield (name: txtQuantity)
            5.  Item cost label
            6.  Item cost textfield (name: txtCost)
            7.  JButton to calculate the cost (name: btnCalculate
            8.  Add a CalculateHandler handler object to the btnCalculate addActionListener
        */
        
        super.add(new JLabel("Product name"));
        super.add(txtProductName = new JTextField());
        super.add(new JLabel("Product Quantity (1 to 1000)"));
        super.add(txtQuantity = new JTextField());
        super.add(new JLabel("Item cost (10 to 10000)"));
        super.add(txtCostPerItem = new JTextField());
        super.add(new JLabel("Total cost"));
        super.add(txtTotalCost = new JTextArea());
        super.add(btnCalculate = new JButton("Calculate"));
        
        btnCalculate.addActionListener(new CalculateHandler());
        
        
    }
    private void setFrame() {
        Dimension windowSize = new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT); 

        super.setTitle("Week 2 Practice Program--Invoice");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        super.setSize(windowSize);
        super.setMinimumSize(windowSize);
        super.setMaximumSize(windowSize);

        super.setLocationRelativeTo(null);
        super.setVisible(true);
    } 
    private class CalculateHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            boolean valid;
            if (aInvoice == null) {
                //TODO:  create a new invoice object
                aInvoice = new Invoice();
            }
            aInvoice.setProductName(txtProductName.getText());

            try {
                int quanity = Integer.parseInt(txtQuantity.getText());
                aInvoice.setQuantityPurchased(quanity);
                valid = true;
            }
            catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Quantity needs to be a number between 1 and 1000", 
                                                "Illegal Quanity value",
                                                JOptionPane.ERROR_MESSAGE);
                valid = false;
                txtQuantity.setText("");
                txtQuantity.requestFocus();
            }
            if (valid) {
                try {
                    double cost = 0;
                    //TODO: write the state to extract the double value from the txtCost field
                    cost = Double.parseDouble((txtCostPerItem.getText()));
                    aInvoice.setPricePerItem(cost);
                }
                catch (NumberFormatException ex) {
                    valid = false;
                    JOptionPane.showMessageDialog(null, "Costs needs to be a number between 10 and 10000", 
                                                "Illegal Cost value",
                                                JOptionPane.ERROR_MESSAGE);
                    valid = false;
                    txtCostPerItem.setText("");
                    txtCostPerItem.requestFocus();
                }
            }
            if (valid) {
                //TODO:  using the toString method of the invoice object to set the output text
                txtTotalCost.setText(aInvoice.toString());
            }
        }
    }
  
}
