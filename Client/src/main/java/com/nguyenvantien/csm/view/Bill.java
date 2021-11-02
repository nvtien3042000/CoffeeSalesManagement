package com.nguyenvantien.csm.view;

import com.nguyenvantien.csm.utils.StringUtils;

public class Bill extends javax.swing.JFrame {

    /**
     * Creates new form Bill
     */
    private Home home;
    public Bill() {
        
    }
    public Bill(String date, String total, String discount, String finalTotal, String customerPay, Home home) {
        this.setUndecorated(true);
        initComponents();
        setSize(400, 600);
        this.setLocationRelativeTo(null);
        setBill(date, total, discount, finalTotal, customerPay);
        this.home = home;
        home.setEnabled(false);
    }
    private void setBill(String date, String total, String discount, String finalTotal, String customerPay){
        dateLb.setText(date);
        totalMoneyLb.setText(StringUtils.formatMoney(total));
        discountLb.setText(discount);
        finalTotalLb.setText(StringUtils.formatMoney(finalTotal));
        customerPayLb.setText(StringUtils.formatMoney(customerPay));
        Double storePay = Double.valueOf(customerPay) - Double.valueOf(finalTotal);
        storePayLb.setText(StringUtils.formatMoney(storePay));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        dateLb = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        totalMoneyLb = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        discountLb = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        finalTotalLb = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        customerPayLb = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        storePayLb = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        billOkBt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hóa đơn");
        setBackground(new java.awt.Color(204, 255, 204));
        getContentPane().setLayout(new java.awt.GridLayout(1, 1));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 255, 0), 3));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Thông tin hóa đơn");
        jPanel2.add(jLabel1);

        jPanel1.add(jPanel2);

        jPanel11.setBackground(new java.awt.Color(255, 153, 153));
        jPanel11.setForeground(new java.awt.Color(255, 255, 255));
        jPanel11.setLayout(new javax.swing.BoxLayout(jPanel11, javax.swing.BoxLayout.Y_AXIS));

        jPanel13.setLayout(new java.awt.GridLayout(1, 2));

        jPanel25.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel6.setText("Thời gian :");
        jPanel25.add(jLabel6);

        jPanel13.add(jPanel25);

        jPanel17.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        dateLb.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jPanel17.add(dateLb);

        jPanel13.add(jPanel17);

        jPanel11.add(jPanel13);

        jPanel12.setLayout(new java.awt.GridLayout(1, 2));

        jPanel18.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel5.setText("Tiền hàng :");
        jPanel18.add(jLabel5);

        jPanel12.add(jPanel18);

        jPanel16.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        totalMoneyLb.setText("0 VNĐ");
        totalMoneyLb.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jPanel16.add(totalMoneyLb);

        jPanel12.add(jPanel16);

        jPanel11.add(jPanel12);

        jPanel19.setLayout(new java.awt.GridLayout(1, 2));

        jPanel20.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel8.setText("Giảm(%) :");
        jPanel20.add(jLabel8);

        jPanel19.add(jPanel20);

        jPanel21.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        discountLb.setText("0");
        jPanel21.add(discountLb);

        jPanel19.add(jPanel21);

        jPanel11.add(jPanel19);

        jPanel22.setLayout(new java.awt.GridLayout(1, 2));

        jPanel23.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel12.setText("Thành tiền :");
        jPanel23.add(jLabel12);

        jPanel22.add(jPanel23);

        jPanel24.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        finalTotalLb.setText("0 VNĐ");
        finalTotalLb.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jPanel24.add(finalTotalLb);

        jPanel22.add(jPanel24);

        jPanel11.add(jPanel22);

        jPanel26.setLayout(new java.awt.GridLayout(1, 2));

        jPanel27.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel13.setText("Khách đưa :");
        jPanel27.add(jLabel13);

        jPanel26.add(jPanel27);

        jPanel28.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        customerPayLb.setText("0 VNĐ");
        customerPayLb.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jPanel28.add(customerPayLb);

        jPanel26.add(jPanel28);

        jPanel11.add(jPanel26);

        jPanel29.setLayout(new java.awt.GridLayout(1, 2));

        jPanel30.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel14.setText("Trả cho khách :");
        jPanel30.add(jLabel14);

        jPanel29.add(jPanel30);

        jPanel31.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        storePayLb.setText("0 VNĐ");
        storePayLb.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jPanel31.add(storePayLb);

        jPanel29.add(jPanel31);

        jPanel11.add(jPanel29);

        jPanel1.add(jPanel11);

        billOkBt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        billOkBt.setText("Ok");
        billOkBt.setMaximumSize(new java.awt.Dimension(90, 31));
        billOkBt.setMinimumSize(new java.awt.Dimension(90, 31));
        billOkBt.setPreferredSize(new java.awt.Dimension(90, 31));
        billOkBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                billOkBtActionPerformed(evt);
            }
        });
        jPanel3.add(billOkBt);

        jPanel1.add(jPanel3);

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void billOkBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_billOkBtActionPerformed
        this.home.setEnabled(true);
        this.home.resetValue();
        this.setVisible(false);
    }//GEN-LAST:event_billOkBtActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton billOkBt;
    private javax.swing.JLabel customerPayLb;
    private javax.swing.JLabel dateLb;
    private javax.swing.JLabel discountLb;
    private javax.swing.JLabel finalTotalLb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JLabel storePayLb;
    private javax.swing.JLabel totalMoneyLb;
    // End of variables declaration//GEN-END:variables
}
