package com.nguyenvantien.csm.view;

import com.nguyenvantien.csm.api.UserApi;
import com.nguyenvantien.csm.utils.UsersListUtils;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class UpdateUser extends javax.swing.JFrame {

    private Admin admin;
    public UpdateUser() {
        initComponents();
        setSize(400, 600);
        this.setLocationRelativeTo(null);
    }
    
    public UpdateUser(Admin admin) {
        this.setUndecorated(true);
        initComponents();
        this.admin = admin;
        setSize(400, 600);
        this.setLocationRelativeTo(null);
    }
    
    public UpdateUser(Admin admin, String name, String userName, String password, String phoneNumber, String address, String role) {
        this.setUndecorated(true);
        initComponents();
        this.admin = admin;
        setSize(400, 600);
        this.setLocationRelativeTo(null);
        setValueForm(name, userName, password, phoneNumber, address, role);
    }
    
    private void setValueForm(String name, String userName, String password, String phoneNumber, String address, String role){
        userNameTf.setText(userName);
        passwordTf.setText(password);
        fullNameFt.setText(name);
        phoneNumberTf.setText(phoneNumber);
        addressTf.setText(address);
        roleCb.setSelectedItem(role);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        userNameTf = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        passwordTf = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        fullNameFt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        phoneNumberTf = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        addressTf = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        roleCb = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        updateUserBt = new javax.swing.JButton();
        exitBt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cập nhập người dùng");
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        jPanel1.setBackground(new java.awt.Color(102, 255, 0));
        jPanel1.setMaximumSize(new java.awt.Dimension(32767, 2000));
        jPanel1.setPreferredSize(new java.awt.Dimension(392, 50));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Cập nhật người dùng");
        jPanel1.add(jLabel1);

        getContentPane().add(jPanel1);

        jPanel2.setLayout(new java.awt.GridLayout(6, 2, 0, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("      Tài khoản");
        jPanel2.add(jLabel2);

        userNameTf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        userNameTf.setEnabled(false);
        jPanel2.add(userNameTf);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("      Mật khẩu");
        jPanel2.add(jLabel3);

        passwordTf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel2.add(passwordTf);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("      Họ và tên");
        jPanel2.add(jLabel4);

        fullNameFt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel2.add(fullNameFt);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("      Số điện thoại");
        jPanel2.add(jLabel5);

        phoneNumberTf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel2.add(phoneNumberTf);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("      Địa chỉ");
        jPanel2.add(jLabel6);

        addressTf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel2.add(addressTf);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("      Quyền truy cập");
        jPanel2.add(jLabel7);

        roleCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "user", "admin", " " }));
        jPanel2.add(roleCb);

        getContentPane().add(jPanel2);

        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 10, 20, 10));
        jPanel3.setMaximumSize(new java.awt.Dimension(32767, 2000));
        jPanel3.setMinimumSize(new java.awt.Dimension(182, 80));
        jPanel3.setPreferredSize(new java.awt.Dimension(392, 80));
        jPanel3.setLayout(new java.awt.GridLayout(1, 2, 20, 0));

        updateUserBt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        updateUserBt.setText("CẬP NHẬT");
        updateUserBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateUserBtActionPerformed(evt);
            }
        });
        jPanel3.add(updateUserBt);

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

    private void updateUserBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateUserBtActionPerformed
        String userName = userNameTf.getText();
        String password = passwordTf.getText();
        String fullName = fullNameFt.getText();
        String phoneNumber = phoneNumberTf.getText();
        String address = addressTf.getText();
        String role = roleCb.getSelectedItem().toString();
        Integer id = UsersListUtils.getIds().get(userName);
        Integer phoneNumberInt = null;
        try {
            phoneNumberInt = Integer.parseInt(phoneNumber);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Nhập giá số điện thoại", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean check = false;
        try {
            check = UserApi.updateUser(id, userName, password, fullName, phoneNumber, address, role);
        } catch (IOException ex) {
            Logger.getLogger(AddItem.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(check == false){
            JOptionPane.showMessageDialog(this, "Tên bị trùng", "WARNING", JOptionPane.WARNING_MESSAGE);
        } else {
            this.admin.setEnabled(true);
            this.admin.setUserTable("");
            this.setVisible(false);
        }
    }//GEN-LAST:event_updateUserBtActionPerformed

    private void exitBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtActionPerformed
        this.admin.setEnabled(true);
        this.setVisible(false);
    }//GEN-LAST:event_exitBtActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addressTf;
    private javax.swing.JButton exitBt;
    private javax.swing.JTextField fullNameFt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField passwordTf;
    private javax.swing.JTextField phoneNumberTf;
    private javax.swing.JComboBox<String> roleCb;
    private javax.swing.JButton updateUserBt;
    private javax.swing.JTextField userNameTf;
    // End of variables declaration//GEN-END:variables
}
