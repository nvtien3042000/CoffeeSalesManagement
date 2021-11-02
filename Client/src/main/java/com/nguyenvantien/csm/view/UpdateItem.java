package com.nguyenvantien.csm.view;

import com.nguyenvantien.csm.api.CategoryApi;
import com.nguyenvantien.csm.api.ItemApi;
import com.nguyenvantien.csm.utils.ItemsListUtils;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class UpdateItem extends javax.swing.JFrame {
    private Admin adminPage;
    private String name;
    
    public UpdateItem() {
        initComponents();
        setSize(400, 500);
        this.setLocationRelativeTo(null);
    }
    public UpdateItem(Admin adminPage) {
        this.setUndecorated(true);
        initComponents();
        this.adminPage = adminPage;
        setSize(400, 500);
        this.setLocationRelativeTo(null);
        setCategory();
    }
    
    public UpdateItem(Admin adminPage, String name, String price, String unit, String category) {
        this.setUndecorated(true);
        initComponents();
        this.adminPage = adminPage;
        this.name = name;
        setSize(400, 500);
        this.setLocationRelativeTo(null);
        setCategory();
        setValueForm(name, price, unit, category);
    }
    
    public void setValueForm(String name, String price, String unit, String category){
        nameTf.setText(name);
        priceTf.setText(price);
        unitTf.setText(unit);
        categoryCb.setSelectedItem(category);
        
    }
    
    private void setCategory(){
        DefaultListModel listModel = new DefaultListModel();
        List<Object> lists = null;
        try {
            lists = CategoryApi.getAllCategory();
        } catch (IOException ex) {
            Logger.getLogger(AddItem.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i < lists.size(); i++) {
            categoryCb.addItem(lists.get(i).toString());
        }     
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        nameTf = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        priceTf = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        unitTf = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        categoryCb = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        updateItemBt = new javax.swing.JButton();
        exitBt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cập nhật sản phẩm");
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        jPanel1.setBackground(new java.awt.Color(102, 255, 0));
        jPanel1.setMaximumSize(new java.awt.Dimension(32767, 2000));
        jPanel1.setPreferredSize(new java.awt.Dimension(392, 50));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Cập nhật sản phẩm");
        jPanel1.add(jLabel1);

        getContentPane().add(jPanel1);

        jPanel2.setLayout(new java.awt.GridLayout(4, 2, 0, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("      Tên");
        jPanel2.add(jLabel2);

        nameTf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel2.add(nameTf);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("      Giá");
        jPanel2.add(jLabel3);

        priceTf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel2.add(priceTf);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("      Đơn vị");
        jPanel2.add(jLabel4);

        unitTf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel2.add(unitTf);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("      Loại sản phẩm");
        jPanel2.add(jLabel5);

        jPanel2.add(categoryCb);

        getContentPane().add(jPanel2);

        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 10, 20, 10));
        jPanel3.setMaximumSize(new java.awt.Dimension(32767, 2000));
        jPanel3.setMinimumSize(new java.awt.Dimension(182, 80));
        jPanel3.setPreferredSize(new java.awt.Dimension(392, 80));
        jPanel3.setLayout(new java.awt.GridLayout(1, 2, 20, 0));

        updateItemBt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        updateItemBt.setText("CẬP NHẬT");
        updateItemBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateItemBtActionPerformed(evt);
            }
        });
        jPanel3.add(updateItemBt);

        exitBt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        exitBt.setText("HỦY");
        exitBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtActionPerformed(evt);
            }
        });
        jPanel3.add(exitBt);

        getContentPane().add(jPanel3);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtActionPerformed
        this.adminPage.setEnabled(true);
        resetValue();
        this.setVisible(false);
    }//GEN-LAST:event_exitBtActionPerformed

    private void updateItemBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateItemBtActionPerformed
        String name = nameTf.getText();
        System.out.println(name);
        System.out.println("name: " + this.name);
        Integer id = ItemsListUtils.getIds().get(this.name);
        System.out.println(id);
        String price = priceTf.getText();
        Double priceDb = null;
        try {
            priceDb = Double.parseDouble(price);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Nhập giá sai", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String unit = unitTf.getText();
        String category = categoryCb.getSelectedItem().toString();
        boolean check = false;
        try {
            check = ItemApi.updateItem(id, name, priceDb, unit, category);
        } catch (IOException ex) {
            Logger.getLogger(AddItem.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(check == false){
            JOptionPane.showMessageDialog(this, "Tên bị trùng", "WARNING", JOptionPane.WARNING_MESSAGE);
        } else {
            this.adminPage.setEnabled(true);
            this.adminPage.setItemsTable("");
            resetValue();
            this.setVisible(false);
        }
    }//GEN-LAST:event_updateItemBtActionPerformed

    private void resetValue(){
        this.nameTf.setText("");
        this.priceTf.setText("");
        this.unitTf.setText("");
        this.categoryCb.setSelectedIndex(0);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JComboBox<String> categoryCb;
    private javax.swing.JButton exitBt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private static javax.swing.JTextField nameTf;
    private static javax.swing.JTextField priceTf;
    private static javax.swing.JTextField unitTf;
    private javax.swing.JButton updateItemBt;
    // End of variables declaration//GEN-END:variables
}
