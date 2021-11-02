package com.nguyenvantien.csm.view;

import com.google.gson.Gson;
import com.nguyenvantien.csm.api.BillApi;
import com.nguyenvantien.csm.api.CategoryApi;
import com.nguyenvantien.csm.api.ItemApi;
import com.nguyenvantien.csm.model.Item;
import com.nguyenvantien.csm.utils.ItemsListUtils;
import com.nguyenvantien.csm.utils.StringUtils;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

public class Home extends javax.swing.JFrame {

    public Home() throws IOException {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        setCategory();
        setTable();
    }
    private void setCategory() throws IOException{
        DefaultListModel listModel;
        listModel = new DefaultListModel();
        List<Object> lists = CategoryApi.getAllCategory();
        for (int i = 0; i < lists.size(); i++) {
            listModel.add(i, lists.get(i).toString());
        }
        listModel.add(0, "tất cả");
        categoryList.setModel(listModel);
    }
    private void setTable() throws IOException{
        List<Item> lists = ItemApi.getAllItem();
        DefaultTableModel defaultTableModel = (DefaultTableModel) listsItemTb.getModel();
        for (int i = 0; i < lists.size(); i++) {
            defaultTableModel.addRow(new Object[]{
                lists.get(i).getName(),
                StringUtils.formatMoney(lists.get(i).getPrice().toString()),
                lists.get(i).getUnit(),
            });
            ItemsListUtils.itemsList.put(lists.get(i).getName(), lists.get(i).getId());
        }
        ItemsListUtils.itemsList.entrySet().forEach(e->{
            System.out.println(e);
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bill = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        billTb = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        totalMoneyLb = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        discountSp = new javax.swing.JSpinner();
        jPanel22 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        customerPayTf = new javax.swing.JTextField();
        finalTotalLb = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        payBt = new javax.swing.JButton();
        resetBt = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        upQuantityBt = new javax.swing.JButton();
        jPanel30 = new javax.swing.JPanel();
        downQuantityBt = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        deleteItemBt = new javax.swing.JButton();
        jPanel28 = new javax.swing.JPanel();
        addItemBt = new javax.swing.JButton();
        jPanel25 = new javax.swing.JPanel();
        items = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        searchTf = new javax.swing.JTextField();
        searchBt = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        categoryList = new javax.swing.JList<>();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listsItemTb = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        logoutMn = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý bán hàng");
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.X_AXIS));

        bill.setBackground(new java.awt.Color(255, 255, 255));
        bill.setPreferredSize(new java.awt.Dimension(600, 320));
        bill.setLayout(new javax.swing.BoxLayout(bill, javax.swing.BoxLayout.Y_AXIS));

        jPanel7.setBackground(new java.awt.Color(51, 255, 51));
        jPanel7.setPreferredSize(new java.awt.Dimension(344, 300));
        jPanel7.setLayout(new javax.swing.BoxLayout(jPanel7, javax.swing.BoxLayout.Y_AXIS));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Hóa Đơn");
        jPanel7.add(jLabel3);

        jPanel9.setLayout(new java.awt.GridLayout(1, 1));

        billTb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ));
        billTb.setRowHeight(30);
        jScrollPane3.setViewportView(billTb);
        if (billTb.getColumnModel().getColumnCount() > 0) {
            billTb.getColumnModel().getColumn(1).setMinWidth(80);
            billTb.getColumnModel().getColumn(1).setPreferredWidth(80);
            billTb.getColumnModel().getColumn(1).setMaxWidth(80);
            billTb.getColumnModel().getColumn(3).setPreferredWidth(30);
        }

        jPanel9.add(jScrollPane3);

        jPanel7.add(jPanel9);

        bill.add(jPanel7);

        jPanel8.setLayout(new java.awt.GridLayout(1, 2));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 206, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 145, Short.MAX_VALUE)
        );

        jPanel8.add(jPanel10);

        jPanel11.setBackground(new java.awt.Color(255, 153, 153));
        jPanel11.setForeground(new java.awt.Color(255, 255, 255));
        jPanel11.setLayout(new javax.swing.BoxLayout(jPanel11, javax.swing.BoxLayout.Y_AXIS));

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

        discountSp.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 5));
        discountSp.setMinimumSize(new java.awt.Dimension(60, 30));
        discountSp.setPreferredSize(new java.awt.Dimension(60, 30));
        jPanel21.add(discountSp);

        jPanel19.add(jPanel21);

        jPanel11.add(jPanel19);

        jPanel22.setLayout(new java.awt.GridLayout(1, 2));

        jPanel23.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel12.setText("Tiền khách trả :");
        jPanel23.add(jLabel12);

        jPanel22.add(jPanel23);

        jPanel24.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        customerPayTf.setColumns(6);
        customerPayTf.setText("0");
        jPanel24.add(customerPayTf);

        finalTotalLb.setText("VNĐ");
        finalTotalLb.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jPanel24.add(finalTotalLb);

        jPanel22.add(jPanel24);

        jPanel11.add(jPanel22);

        jPanel13.setLayout(new java.awt.GridLayout(1, 2, 20, 0));

        payBt.setText("Thanh toán");
        payBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payBtActionPerformed(evt);
            }
        });
        jPanel13.add(payBt);

        resetBt.setText("Hủy");
        resetBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBtActionPerformed(evt);
            }
        });
        jPanel13.add(resetBt);

        jPanel11.add(jPanel13);

        jPanel8.add(jPanel11);

        bill.add(jPanel8);

        getContentPane().add(bill);

        jPanel14.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204)));
        jPanel14.setMaximumSize(new java.awt.Dimension(80, 32767));
        jPanel14.setMinimumSize(new java.awt.Dimension(80, 0));
        jPanel14.setLayout(new java.awt.GridLayout(3, 1));

        jPanel15.setLayout(new javax.swing.BoxLayout(jPanel15, javax.swing.BoxLayout.Y_AXIS));

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 82, Short.MAX_VALUE)
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 52, Short.MAX_VALUE)
        );

        jPanel15.add(jPanel29);

        upQuantityBt.setText("Tăng + +");
        upQuantityBt.setMaximumSize(new java.awt.Dimension(120, 21));
        upQuantityBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upQuantityBtActionPerformed(evt);
            }
        });
        jPanel15.add(upQuantityBt);

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 82, Short.MAX_VALUE)
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 52, Short.MAX_VALUE)
        );

        jPanel15.add(jPanel30);

        downQuantityBt.setText("Giảm - -");
        downQuantityBt.setMaximumSize(new java.awt.Dimension(120, 21));
        downQuantityBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downQuantityBtActionPerformed(evt);
            }
        });
        jPanel15.add(downQuantityBt);

        jPanel14.add(jPanel15);

        jPanel17.setLayout(new javax.swing.BoxLayout(jPanel17, javax.swing.BoxLayout.Y_AXIS));

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 82, Short.MAX_VALUE)
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 52, Short.MAX_VALUE)
        );

        jPanel17.add(jPanel27);

        deleteItemBt.setText("Xóa >>");
        deleteItemBt.setMaximumSize(new java.awt.Dimension(120, 21));
        deleteItemBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteItemBtActionPerformed(evt);
            }
        });
        jPanel17.add(deleteItemBt);

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 82, Short.MAX_VALUE)
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 52, Short.MAX_VALUE)
        );

        jPanel17.add(jPanel28);

        addItemBt.setText("<< Thêm");
        addItemBt.setMaximumSize(new java.awt.Dimension(120, 21));
        addItemBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addItemBtActionPerformed(evt);
            }
        });
        jPanel17.add(addItemBt);

        jPanel14.add(jPanel17);

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 82, Short.MAX_VALUE)
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 147, Short.MAX_VALUE)
        );

        jPanel14.add(jPanel25);

        getContentPane().add(jPanel14);

        items.setMaximumSize(new java.awt.Dimension(400, 65609));
        items.setLayout(new javax.swing.BoxLayout(items, javax.swing.BoxLayout.Y_AXIS));

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setMaximumSize(new java.awt.Dimension(32767, 40));
        jPanel1.setPreferredSize(new java.awt.Dimension(135, 40));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.X_AXIS));

        jLabel1.setText("  Tìm kiếm:    ");
        jLabel1.setMaximumSize(new java.awt.Dimension(50, 13));
        jPanel1.add(jLabel1);

        searchTf.setColumns(50);
        jPanel1.add(searchTf);

        searchBt.setText("Tìm");
        searchBt.setMaximumSize(new java.awt.Dimension(21, 71));
        searchBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtActionPerformed(evt);
            }
        });
        jPanel1.add(searchBt);

        items.add(jPanel1);

        jPanel4.setBackground(new java.awt.Color(51, 255, 153));
        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.Y_AXIS));

        jPanel5.setMaximumSize(new java.awt.Dimension(32767, 68));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Các loại đồ dùng");
        jPanel5.add(jLabel2);

        jPanel4.add(jPanel5);

        jPanel26.setMinimumSize(new java.awt.Dimension(23, 100));
        jPanel26.setPreferredSize(new java.awt.Dimension(204, 100));
        jPanel26.setLayout(new java.awt.GridLayout(1, 1));

        jScrollPane1.setMaximumSize(new java.awt.Dimension(32767, 122));

        categoryList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "tất cả" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        categoryList.setMaximumSize(new java.awt.Dimension(32, 55));
        categoryList.setMinimumSize(new java.awt.Dimension(32, 55));
        categoryList.setPreferredSize(new java.awt.Dimension(32, 55));
        categoryList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                categoryListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(categoryList);

        jPanel26.add(jScrollPane1);

        jPanel4.add(jPanel26);

        items.add(jPanel4);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.Y_AXIS));

        jPanel3.setMaximumSize(new java.awt.Dimension(32767, 105));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Danh sách đồ dùng");
        jPanel3.add(jLabel4);

        jPanel2.add(jPanel3);

        jPanel6.setLayout(new java.awt.GridLayout(1, 0));

        listsItemTb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên", "Giá", "Đơn vị"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(listsItemTb);

        jPanel6.add(jScrollPane2);

        jPanel2.add(jPanel6);

        items.add(jPanel2);

        getContentPane().add(items);

        jMenuBar1.setMaximumSize(new java.awt.Dimension(64, 60));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(64, 20));

        jMenu1.setText("File");

        logoutMn.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        logoutMn.setText("Đăng xuất");
        logoutMn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutMnActionPerformed(evt);
            }
        });
        jMenu1.add(logoutMn);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void categoryListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_categoryListMouseClicked
        try {
            // TODO add your handling code here:
            String category = (categoryList.getSelectedValue().equals("tất cả")) ? "" : categoryList.getSelectedValue();
            List<Item> lists = ItemApi.getItemsByCategory(category);
            setTable(lists);
        } catch (IOException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(categoryList.getSelectedValue());
    }//GEN-LAST:event_categoryListMouseClicked

    private void searchBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtActionPerformed
        try {
            List<Item> lists = ItemApi.getItemsByName(searchTf.getText());
            setTable(lists);
        } catch (IOException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchBtActionPerformed

    private void addItemBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addItemBtActionPerformed
        // TODO add your handling code here:
        int indexOfItem = listsItemTb.getSelectedRow();
        if(indexOfItem>=0){
            String name = (String) listsItemTb.getValueAt(indexOfItem, 0);
            String price = (String) listsItemTb.getValueAt(indexOfItem, 1);
            addRowBillTable(name, price);
        }
        setTotalMoney();
    }//GEN-LAST:event_addItemBtActionPerformed

    private void upQuantityBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upQuantityBtActionPerformed
        int index = billTb.getSelectedRow();
        if(index >= 0){
            setQuantityAndTotalInRowBillTable(index, true);
        }
        setTotalMoney();
    }//GEN-LAST:event_upQuantityBtActionPerformed

    private void downQuantityBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downQuantityBtActionPerformed
        int index = billTb.getSelectedRow();
        if(index >= 0){
            setQuantityAndTotalInRowBillTable(index, false);
        }
        setTotalMoney();
    }//GEN-LAST:event_downQuantityBtActionPerformed

    private void deleteItemBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteItemBtActionPerformed
        int index = billTb.getSelectedRow();
        if(index >= 0){
            DefaultTableModel defaultTableModel = (DefaultTableModel) billTb.getModel();
            defaultTableModel.removeRow(index);
        }
        setTotalMoney();
    }//GEN-LAST:event_deleteItemBtActionPerformed

    private void payBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payBtActionPerformed
        String discountStr = discountSp.getValue().toString();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String  dateStr = dateFormat.format(new Date());
        Double totalMoney = StringUtils.toValue(totalMoneyLb.getText());
        if(totalMoney==0){
            System.out.println("chưa có sản phẩm nào");
            return;
        }
        int discount = Integer.parseInt(discountStr);
        System.out.println(discount);
        Double finalTotal = totalMoney - (totalMoney/100)*discount;
        String totalStr = String.valueOf(finalTotal);
        List<Map<String, Integer>> itemsList = new ArrayList<>();
        Map<String,Integer> idItem = ItemsListUtils.getIds();
        for (int i = 0; i < billTb.getRowCount(); i++) {
            Map<String, Integer> item = new TreeMap<>();
            item.put("idItem",idItem.get(billTb.getModel().getValueAt(i, 0)));
            item.put("quantity",Integer.parseInt(billTb.getModel().getValueAt(i, 1).toString()));
            itemsList.add(item);
        }
        Gson gson = new Gson();
        String itemsListStr = gson.toJson(itemsList);
        System.out.println("items: " + itemsListStr);
        boolean resp = true;
        try {
            resp = BillApi.insertBill(discountStr, totalStr, dateStr, itemsListStr);
        } catch (IOException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        new Bill(dateStr, String.valueOf(totalMoney), discountStr, String.valueOf(finalTotal), customerPayTf.getText(), this).setVisible(true);
        System.out.println(resp);
    }//GEN-LAST:event_payBtActionPerformed

    private void resetBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetBtActionPerformed
        resetValue();
    }//GEN-LAST:event_resetBtActionPerformed

    private void logoutMnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutMnActionPerformed
        resetValue();
        this.setVisible(false);
        new Login().setVisible(true);
    }//GEN-LAST:event_logoutMnActionPerformed

    public void resetValue(){
        DefaultTableModel defaultTableModel = (DefaultTableModel) billTb.getModel();
        defaultTableModel.setNumRows(0);
        totalMoneyLb.setText(StringUtils.formatMoney(String.valueOf(0)));
        discountSp.setValue(0);
        customerPayTf.setText("0");
    }
    private void addRowBillTable(String name, String price){
        int index = checkNameInBill(name);
        if(index >= 0){
            setQuantityAndTotalInRowBillTable(index, true);
        } else{
            DefaultTableModel defaultTableModel = (DefaultTableModel) billTb.getModel();
            defaultTableModel.addRow(new Object[]{
            name, 1, price, price
            });
        }
        
    }
    
    private void setQuantityAndTotalInRowBillTable(int index, boolean check){
        DefaultTableModel defaultTableModel = (DefaultTableModel) billTb.getModel();
        Integer quantity = Integer.parseInt(defaultTableModel.getValueAt(index, 1).toString());
        if(check){
            quantity = Integer.parseInt(defaultTableModel.getValueAt(index, 1).toString()) + 1;
        } else if(quantity > 1){
            quantity = Integer.parseInt(defaultTableModel.getValueAt(index, 1).toString()) - 1;
        }
        Double total = StringUtils.toValue(defaultTableModel.getValueAt(index, 2).toString())*quantity;
        defaultTableModel.setValueAt(quantity, index, 1);
        defaultTableModel.setValueAt(StringUtils.formatMoney(total.toString()), index, 3);
    }
    
    private void setTotalMoney(){
        Double totalMoney = 0.0;
        for (int i = 0; i < billTb.getRowCount(); i++) {
            totalMoney += StringUtils.toValue(billTb.getValueAt(i, 3).toString());
        }
        totalMoneyLb.setText(StringUtils.formatMoney(totalMoney.toString()));
    }
    
    private int checkNameInBill(String name){
        for (int i = 0; i < billTb.getRowCount(); i++) {
            if(billTb.getValueAt(i, 0).equals(name)){
                return i;
            }
        }
        return -1;
    }
    
    private void setTable(List<Item> lists){
        DefaultTableModel defaultTableModel = (DefaultTableModel) listsItemTb.getModel();
        defaultTableModel.getDataVector().removeAllElements();
        for (int i = 0; i < lists.size(); i++) {
            defaultTableModel.addRow(new Object[]{
                lists.get(i).getName(),
                StringUtils.formatMoney(lists.get(i).getPrice().toString()),
                lists.get(i).getUnit(),
            });
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addItemBt;
    private javax.swing.JPanel bill;
    private javax.swing.JTable billTb;
    private javax.swing.JList<String> categoryList;
    private javax.swing.JTextField customerPayTf;
    private javax.swing.JButton deleteItemBt;
    private javax.swing.JSpinner discountSp;
    private javax.swing.JButton downQuantityBt;
    private javax.swing.JLabel finalTotalLb;
    private javax.swing.JPanel items;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable listsItemTb;
    private javax.swing.JMenuItem logoutMn;
    private javax.swing.JButton payBt;
    private javax.swing.JButton resetBt;
    private javax.swing.JButton searchBt;
    private javax.swing.JTextField searchTf;
    private javax.swing.JLabel totalMoneyLb;
    private javax.swing.JButton upQuantityBt;
    // End of variables declaration//GEN-END:variables
}
