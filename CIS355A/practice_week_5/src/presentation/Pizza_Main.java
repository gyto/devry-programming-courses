/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;
import business.OrderList;
import business.PizzaOrder;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class Pizza_Main extends javax.swing.JFrame {

    private PizzaOrder aOrder; 
    private final DefaultListModel<PizzaOrder> listModel;
    private final OrderList orderList;
   
    public Pizza_Main() {
        initComponents();
        super.setLocationRelativeTo(null);
        newOrder();
        
        listModel = new DefaultListModel<>();
        lstOrders.setModel(listModel);
        
        orderList = new OrderList();
        
    }
    private void showOrderDetails() {
        if (lstOrders.getSelectedIndex() != -1) {
            aOrder = lstOrders.getSelectedValue();
            txtOrderDetails.setText(aOrder.getOrderInformation());
        }
    }    
    private void submitOrder() {
        StringBuilder str = new StringBuilder();
        if (aOrder != null) {
            str.append("Order submitted\n");
            str.append (aOrder.getOrderInformation());
            listModel.addElement(aOrder);  
            orderList.add(aOrder);
        }
    }
     private void deleteOrder() {
        int item = lstOrders.getSelectedIndex();
        if (item != -1) {
            int response;
            PizzaOrder theOrder = lstOrders.getSelectedValue();
            String prompt = "Are you sure you want to delete order for: " + theOrder.toString();
            response = JOptionPane.showConfirmDialog(null, prompt, "Delete order " + theOrder.toString(), 
                                                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                listModel.removeElement(theOrder);
                orderList.remove(theOrder);
                txtOrderDetails.setText("");
            }
        }
    }
    private void updateOrder() throws NumberFormatException {
        double value;
        try {
            value = Double.parseDouble(txtTotal.getText());
            aOrder.setTotal(value);
            txtOrderDetails.setText(aOrder.getOrderInformation());
        }
        catch (NumberFormatException ex) {
            String message = txtTotal.getText() + " value is an illegal, enter a number greater than 0";
            JOptionPane.showMessageDialog(null, message, "Illegal total value", JOptionPane.ERROR_MESSAGE);
        }
    }
    /************** File Operations ********************************************/
    
    private void saveOrders() throws IOException {
        int count = orderList.save();
        String message = count + " pizza orders saved to file: " + orderList.getFileName();
        JOptionPane.showMessageDialog(null, message, "Orders Saved", JOptionPane.PLAIN_MESSAGE);
        
    }
    private void retrieveOrders() throws IllegalArgumentException, IOException {
        int count = 0;
        //TODO: add statement to retrieved the order list (remember to pass in the list model)
        count = orderList.retrieve(listModel);
        
        String message = count + " pizza orders retreived from file: " + orderList.getFileName();
        JOptionPane.showMessageDialog(null, message, "Orders Retrieved", JOptionPane.PLAIN_MESSAGE);
        
    }
    
    /************** existing functions from previous iteration *****************/
    private void setLastName() {
        if (aOrder != null) {
            aOrder.setLastName(txtLastName.getText());
        }
    }
    private void setFirstName() {
        if (aOrder != null) {
            aOrder.setFirstName(txtFirstName.getText());
        }
    }
    private void newOrder() {
        aOrder = new PizzaOrder();
        clearOrder();
    }
    private void clearOrder() {
        txtFirstName.setText("");
        txtLastName.setText("");
        radLarge.setSelected(true);
        chkExtraCheese.setSelected(false);
        chkSausage.setSelected(false);
        chkHam.setSelected(false);
        lblSubTotal.setText("");
        aOrder.clearOrder();
    }
    private void setSize(PizzaOrder.PizzaSize size) {
        aOrder.setPizzaSize(size);
        setSubTotal();
    }
    private void setCheese() {
        if (chkExtraCheese.isSelected()) {
            aOrder.setCheese(true);
        }
        else {
             aOrder.setCheese(false);
        }
        setSubTotal();
    }
    private void setSausage() {
        if (chkSausage.isSelected()) {
            aOrder.setSausage(true);
        }
        else {
             aOrder.setSausage(false);
        }
        setSubTotal();
    }
    private void setHam() {
        if (chkHam.isSelected()) {
           aOrder.setHam(true);
        }
        else {
           aOrder.setHam(false);
        }
        setSubTotal();
    }
    private void setSubTotal() {
        lblSubTotal.setText(aOrder.getTotalCost());
    }
     
     private void terminateApplication() {
         int response = JOptionPane.NO_OPTION;
			String prompt = "Do you want to quit the pizza program?";
			String title = "Quit Pizza Program";
			response = JOptionPane.showConfirmDialog(null, prompt, title, 
										  JOptionPane.OK_CANCEL_OPTION, 
										  JOptionPane.QUESTION_MESSAGE);
			if(response == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grpSize = new javax.swing.ButtonGroup();
        tabPizzaInformation = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        pnlOrder = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        pnlCustomer = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        pnlSize = new javax.swing.JPanel();
        radSmall = new javax.swing.JRadioButton();
        radMedium = new javax.swing.JRadioButton();
        radLarge = new javax.swing.JRadioButton();
        pnlToppings = new javax.swing.JPanel();
        chkExtraCheese = new javax.swing.JCheckBox();
        chkSausage = new javax.swing.JCheckBox();
        chkHam = new javax.swing.JCheckBox();
        btnSubmitOrder = new javax.swing.JButton();
        btnNewOrder = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        lblTotal = new javax.swing.JLabel();
        lblSubTotal = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstOrders = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtOrderDetails = new javax.swing.JTextArea();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        txtTotal = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnRetreive = new javax.swing.JButton();
        lblWelcome = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();
        mnuBar = new javax.swing.JMenuBar();
        mnuFile = new javax.swing.JMenu();
        mnuSave = new javax.swing.JMenuItem();
        mnuRetrieve = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mnuExit = new javax.swing.JMenuItem();
        mnuOrder = new javax.swing.JMenu();
        mnuNewOrder = new javax.swing.JMenuItem();
        mnuSubmit = new javax.swing.JMenuItem();
        mnuClearOrder = new javax.swing.JMenuItem();
        mnuSummary = new javax.swing.JMenu();
        mnuDelete = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Best Pizza Ordering");

        tabPizzaInformation.setForeground(new java.awt.Color(0, 0, 80));
        tabPizzaInformation.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N

        pnlOrder.setPreferredSize(new java.awt.Dimension(579, 550));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Please enter your name and select your ordering options:");

        pnlCustomer.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Customer Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(51, 51, 255))); // NOI18N

        jLabel5.setText("First Name:");

        txtFirstName.setToolTipText("Enter your first name");
        txtFirstName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFirstNameFocusLost(evt);
            }
        });

        jLabel6.setText("Last Name:");

        txtLastName.setToolTipText("Enter your last name");
        txtLastName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtLastNameFocusLost(evt);
            }
        });

        javax.swing.GroupLayout pnlCustomerLayout = new javax.swing.GroupLayout(pnlCustomer);
        pnlCustomer.setLayout(pnlCustomerLayout);
        pnlCustomerLayout.setHorizontalGroup(
            pnlCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCustomerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtFirstName)
                    .addComponent(txtLastName, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlCustomerLayout.setVerticalGroup(
            pnlCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCustomerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pnlSize.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pizza Size (please select one)", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(51, 51, 255))); // NOI18N

        grpSize.add(radSmall);
        radSmall.setText("Small: $6.99 ");
        radSmall.setToolTipText("Select for small pizza at $6.99");
        radSmall.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radSmallItemStateChanged(evt);
            }
        });

        grpSize.add(radMedium);
        radMedium.setText("Medium: $9.99  ");
        radMedium.setToolTipText("Select for medium pizza at $9.99");
        radMedium.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radMediumItemStateChanged(evt);
            }
        });

        grpSize.add(radLarge);
        radLarge.setSelected(true);
        radLarge.setText("Large: $12.99");
        radLarge.setToolTipText("Select for large pizza at $12.99");
        radLarge.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radLargeItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout pnlSizeLayout = new javax.swing.GroupLayout(pnlSize);
        pnlSize.setLayout(pnlSizeLayout);
        pnlSizeLayout.setHorizontalGroup(
            pnlSizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSizeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radMedium)
                    .addComponent(radSmall)
                    .addComponent(radLarge))
                .addContainerGap(438, Short.MAX_VALUE))
        );
        pnlSizeLayout.setVerticalGroup(
            pnlSizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSizeLayout.createSequentialGroup()
                .addComponent(radSmall)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(radMedium)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(radLarge))
        );

        pnlToppings.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Toppings (Select as many as you like)", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(51, 51, 255))); // NOI18N

        chkExtraCheese.setText("Extra Cheese: $1.50 ");
        chkExtraCheese.setToolTipText("Select to add extra cheese for $1.50");
        chkExtraCheese.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkExtraCheeseItemStateChanged(evt);
            }
        });

        chkSausage.setText("Sausage: $2.25");
        chkSausage.setToolTipText("Check to add Sausage for $2.25");
        chkSausage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkSausageActionPerformed(evt);
            }
        });

        chkHam.setText("Ham: $2.50");
        chkHam.setToolTipText("Check to add Ham for $2.50");
        chkHam.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkHamItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout pnlToppingsLayout = new javax.swing.GroupLayout(pnlToppings);
        pnlToppings.setLayout(pnlToppingsLayout);
        pnlToppingsLayout.setHorizontalGroup(
            pnlToppingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlToppingsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlToppingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkExtraCheese)
                    .addComponent(chkSausage)
                    .addComponent(chkHam))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlToppingsLayout.setVerticalGroup(
            pnlToppingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlToppingsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(chkExtraCheese)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkSausage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkHam))
        );

        btnSubmitOrder.setText("Submit Order");
        btnSubmitOrder.setToolTipText("Click to show the order total and order summary, and store the order");
        btnSubmitOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitOrderActionPerformed(evt);
            }
        });

        btnNewOrder.setText("New Order");
        btnNewOrder.setToolTipText("Click to clear all fields and start a new order.");
        btnNewOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewOrderActionPerformed(evt);
            }
        });

        btnClear.setText("Clear Order");
        btnClear.setToolTipText("Click to clear all fields and start a new order.");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        lblTotal.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(0, 0, 80));
        lblTotal.setText("Subtotal:");

        lblSubTotal.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        lblSubTotal.setForeground(new java.awt.Color(0, 0, 80));
        lblSubTotal.setText("$0");

        javax.swing.GroupLayout pnlOrderLayout = new javax.swing.GroupLayout(pnlOrder);
        pnlOrder.setLayout(pnlOrderLayout);
        pnlOrderLayout.setHorizontalGroup(
            pnlOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOrderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlOrderLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 206, Short.MAX_VALUE))
                    .addComponent(pnlToppings, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlSize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlOrderLayout.createSequentialGroup()
                        .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnNewOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSubmitOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)))
                .addContainerGap())
        );
        pnlOrderLayout.setVerticalGroup(
            pnlOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOrderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlToppings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClear)
                    .addComponent(lblTotal)
                    .addComponent(lblSubTotal)
                    .addComponent(btnNewOrder)
                    .addComponent(btnSubmitOrder))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(pnlOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabPizzaInformation.addTab("Pizza Order Information", jPanel3);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 80));
        jLabel1.setText("Order List");

        lstOrders.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstOrders.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstOrdersValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstOrders);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 80));
        jLabel2.setText("Order Details");

        txtOrderDetails.setColumns(20);
        txtOrderDetails.setRows(5);
        jScrollPane2.setViewportView(txtOrderDetails);

        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(0, 0, 80));
        btnDelete.setText("Delete Order");
        btnDelete.setToolTipText("Click to delete the selected pizza order");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(0, 0, 80));
        btnUpdate.setText("Update Total");
        btnUpdate.setToolTipText("Click to update the total cost of the order");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        txtTotal.setToolTipText("Override calculated total price of the order");

        btnSave.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSave.setForeground(new java.awt.Color(0, 0, 80));
        btnSave.setText("Save ");
        btnSave.setToolTipText("Click to save the orders to file");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnRetreive.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRetreive.setForeground(new java.awt.Color(0, 0, 80));
        btnRetreive.setText("Retrieve");
        btnRetreive.setToolTipText("Click to retrieve the orders to file");
        btnRetreive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetreiveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(68, 68, 68)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)))
                        .addGap(114, 114, 114))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRetreive, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete)
                    .addComponent(btnUpdate)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRetreive)
                .addContainerGap(185, Short.MAX_VALUE))
        );

        tabPizzaInformation.addTab("Order Summary", jPanel1);

        lblWelcome.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        lblWelcome.setForeground(new java.awt.Color(0, 0, 255));
        lblWelcome.setText("Welcome to Best Pizza!");
        lblWelcome.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblWelcome.setName("lblWelcome"); // NOI18N

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        mnuFile.setText("File");
        mnuFile.setToolTipText("Click to exit the application");

        mnuSave.setText("Save Orders");
        mnuSave.setToolTipText("Click to save orders to file");
        mnuSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSaveActionPerformed(evt);
            }
        });
        mnuFile.add(mnuSave);

        mnuRetrieve.setText("Retrieve Orders");
        mnuRetrieve.setToolTipText("Click to retrieve orders from the file");
        mnuRetrieve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuRetrieveActionPerformed(evt);
            }
        });
        mnuFile.add(mnuRetrieve);
        mnuFile.add(jSeparator1);

        mnuExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        mnuExit.setForeground(new java.awt.Color(0, 0, 80));
        mnuExit.setText("Exit");
        mnuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuExitActionPerformed(evt);
            }
        });
        mnuFile.add(mnuExit);

        mnuBar.add(mnuFile);

        mnuOrder.setText("Pizza Order");

        mnuNewOrder.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.ALT_MASK));
        mnuNewOrder.setMnemonic('n');
        mnuNewOrder.setText("New order");
        mnuNewOrder.setToolTipText("Click to create a new order");
        mnuNewOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuNewOrderActionPerformed(evt);
            }
        });
        mnuOrder.add(mnuNewOrder);

        mnuSubmit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
        mnuSubmit.setText("Submit Order");
        mnuSubmit.setToolTipText("Click to submit the order");
        mnuSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSubmitActionPerformed(evt);
            }
        });
        mnuOrder.add(mnuSubmit);

        mnuClearOrder.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        mnuClearOrder.setText("Clear Order");
        mnuClearOrder.setToolTipText("Click to clear the order fields");
        mnuClearOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuClearOrderActionPerformed(evt);
            }
        });
        mnuOrder.add(mnuClearOrder);

        mnuBar.add(mnuOrder);

        mnuSummary.setText("Order Summary");

        mnuDelete.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, 0));
        mnuDelete.setText("Delete Order");
        mnuDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuDeleteActionPerformed(evt);
            }
        });
        mnuSummary.add(mnuDelete);

        mnuBar.add(mnuSummary);

        setJMenuBar(mnuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblWelcome))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tabPizzaInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblWelcome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabPizzaInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 481, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnExit)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        terminateApplication();
    }//GEN-LAST:event_btnExitActionPerformed
   
    private void mnuNewOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuNewOrderActionPerformed
        newOrder();
    }//GEN-LAST:event_mnuNewOrderActionPerformed

    private void mnuSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSubmitActionPerformed
        submitOrder();
    }//GEN-LAST:event_mnuSubmitActionPerformed

    private void mnuDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuDeleteActionPerformed
        deleteOrder();
    }//GEN-LAST:event_mnuDeleteActionPerformed

    private void mnuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuExitActionPerformed
         terminateApplication();
    }//GEN-LAST:event_mnuExitActionPerformed

    private void mnuClearOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuClearOrderActionPerformed
        clearOrder();
    }//GEN-LAST:event_mnuClearOrderActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        updateOrder();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        deleteOrder();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void lstOrdersValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstOrdersValueChanged
        showOrderDetails();
    }//GEN-LAST:event_lstOrdersValueChanged

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clearOrder();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnNewOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewOrderActionPerformed
        newOrder();
    }//GEN-LAST:event_btnNewOrderActionPerformed

    private void btnSubmitOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitOrderActionPerformed
        submitOrder();
    }//GEN-LAST:event_btnSubmitOrderActionPerformed

    private void chkHamItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkHamItemStateChanged
        setHam();
    }//GEN-LAST:event_chkHamItemStateChanged

    private void chkSausageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkSausageActionPerformed
        setSausage();
    }//GEN-LAST:event_chkSausageActionPerformed

    private void chkExtraCheeseItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkExtraCheeseItemStateChanged
       setCheese();
    }//GEN-LAST:event_chkExtraCheeseItemStateChanged

    private void radLargeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radLargeItemStateChanged
        setSize(PizzaOrder.PizzaSize.Small);
    }//GEN-LAST:event_radLargeItemStateChanged

    private void radMediumItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radMediumItemStateChanged
       setSize(PizzaOrder.PizzaSize.Medium);
    }//GEN-LAST:event_radMediumItemStateChanged

    private void radSmallItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radSmallItemStateChanged
       setSize(PizzaOrder.PizzaSize.Large);
    }//GEN-LAST:event_radSmallItemStateChanged

    private void txtLastNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLastNameFocusLost
        setLastName();
    }//GEN-LAST:event_txtLastNameFocusLost

    private void txtFirstNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFirstNameFocusLost
        setFirstName();
    }//GEN-LAST:event_txtFirstNameFocusLost

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            saveOrders();
        } catch (IOException ex) {
            Logger.getLogger(Pizza_Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnRetreiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetreiveActionPerformed
        try {
            retrieveOrders();
        } catch (IllegalArgumentException | IOException ex) {
            Logger.getLogger(Pizza_Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRetreiveActionPerformed

    private void mnuSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSaveActionPerformed
        try {
            saveOrders();
        } catch (IOException ex) {
            Logger.getLogger(Pizza_Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mnuSaveActionPerformed

    private void mnuRetrieveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuRetrieveActionPerformed
        try {
            retrieveOrders();
        } catch (IllegalArgumentException | IOException ex) {
            Logger.getLogger(Pizza_Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mnuRetrieveActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Pizza_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pizza_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pizza_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pizza_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Pizza_Main mainForm = new Pizza_Main();
                mainForm.setVisible(true);
                mainForm.setLocationRelativeTo(null);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnNewOrder;
    private javax.swing.JButton btnRetreive;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSubmitOrder;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JCheckBox chkExtraCheese;
    private javax.swing.JCheckBox chkHam;
    private javax.swing.JCheckBox chkSausage;
    private javax.swing.ButtonGroup grpSize;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JLabel lblSubTotal;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JList<PizzaOrder> lstOrders;
    private javax.swing.JMenuBar mnuBar;
    private javax.swing.JMenuItem mnuClearOrder;
    private javax.swing.JMenuItem mnuDelete;
    private javax.swing.JMenuItem mnuExit;
    private javax.swing.JMenu mnuFile;
    private javax.swing.JMenuItem mnuNewOrder;
    private javax.swing.JMenu mnuOrder;
    private javax.swing.JMenuItem mnuRetrieve;
    private javax.swing.JMenuItem mnuSave;
    private javax.swing.JMenuItem mnuSubmit;
    private javax.swing.JMenu mnuSummary;
    private javax.swing.JPanel pnlCustomer;
    private javax.swing.JPanel pnlOrder;
    private javax.swing.JPanel pnlSize;
    private javax.swing.JPanel pnlToppings;
    private javax.swing.JRadioButton radLarge;
    private javax.swing.JRadioButton radMedium;
    private javax.swing.JRadioButton radSmall;
    private javax.swing.JTabbedPane tabPizzaInformation;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextArea txtOrderDetails;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
