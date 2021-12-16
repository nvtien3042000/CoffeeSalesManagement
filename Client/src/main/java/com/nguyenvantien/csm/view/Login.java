package com.nguyenvantien.csm.view;

import com.nguyenvantien.csm.api.LoginApi;
import com.nguyenvantien.csm.model.UserDto;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Title = new javax.swing.JPanel();
        loginLab = new javax.swing.JLabel();
        info = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        userNameTf = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        passwordPw = new javax.swing.JPasswordField();
        Button = new javax.swing.JPanel();
        loginBt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Đăng nhập");
        getContentPane().setLayout(new java.awt.GridLayout(3, 1, 40, 20));

        Title.setLayout(new java.awt.GridLayout(1, 1));

        loginLab.setFont(new java.awt.Font("Tahoma", 3, 34)); // NOI18N
        loginLab.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loginLab.setText("Đăng Nhập");
        Title.add(loginLab);
        loginLab.getAccessibleContext().setAccessibleName("Đăng Nhập");

        getContentPane().add(Title);

        info.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 20));
        info.setLayout(new java.awt.GridLayout(2, 2, 0, 20));

        jLabel1.setText("Tài khoản");
        info.add(jLabel1);

        userNameTf.setColumns(20);
        userNameTf.setMaximumSize(new java.awt.Dimension(1, 1));
        info.add(userNameTf);

        jLabel2.setText("Mật khẩu");
        info.add(jLabel2);
        info.add(passwordPw);

        getContentPane().add(info);

        loginBt.setText("Đăng nhập");
        loginBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtActionPerformed(evt);
            }
        });
        Button.add(loginBt);

        getContentPane().add(Button);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtActionPerformed
        try {
            UserDto user = LoginApi.isLogin(userNameTf.getText(), passwordPw.getText());
            if(user.getRole() != null){
                if(user.getRole().equals("user")) {
                    new Home(user.getUserName()).setVisible(true);
                    this.setVisible(false);
                } else if(user.getRole().equals("admin")){
                    new Admin(user).setVisible(true);
                    this.setVisible(false);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Tài khoản hoặc mật khẩu sai", "WARNING", JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_loginBtActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Button;
    private javax.swing.JPanel Title;
    private javax.swing.JPanel info;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton loginBt;
    private javax.swing.JLabel loginLab;
    private javax.swing.JPasswordField passwordPw;
    private javax.swing.JTextField userNameTf;
    // End of variables declaration//GEN-END:variables
}
