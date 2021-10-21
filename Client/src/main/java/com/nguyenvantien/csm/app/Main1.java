package com.nguyenvantien.csm.app;

//*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.nguyenvantien.quanlyquancafe.app;
//
// *
// * @author Admin
// */
//import java.awt.Component;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import javax.swing.DefaultCellEditor;
//import javax.swing.JButton;
//import javax.swing.JCheckBox;
//import javax.swing.JFrame;
//import javax.swing.JOptionPane;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;
//import javax.swing.SwingUtilities;
//import javax.swing.UIManager;
//import javax.swing.table.DefaultTableModel;
//import javax.swing.table.TableCellRenderer;
//
//public class JButtonTableExample {
//    public static JTable table;
//    public JButtonTableExample() {
//        JFrame frame = new JFrame("JButtonTable Example");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        DefaultTableModel dm = new DefaultTableModel();
//        dm.setDataVector(new Object[][]{{"button 1", "foo"},
//                    {"button 2", "bar"}}, new Object[]{"Button", "String"});
//
//        table = new JTable(dm);
//        table.getColumn("Button").setCellRenderer(new ButtonRenderer());
//        table.getColumn("Button").setCellEditor(new ButtonEditor(new JCheckBox()));
//
//
//        JScrollPane scroll = new JScrollPane(table);
//
//        table.setPreferredScrollableViewportSize(table.getPreferredSize());//thanks mKorbel +1 http://stackoverflow.com/questions/10551995/how-to-set-jscrollpane-layout-to-be-the-same-as-jtable
//
//        table.getColumnModel().getColumn(0).setPreferredWidth(100);//so buttons will fit and not be shown butto..
//
//        frame.add(scroll);
//
//        frame.pack();
//        frame.setVisible(true);
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new JButtonTableExample();
//            }
//        });
//
//    }
//}
//
//class ButtonRenderer extends JButton implements TableCellRenderer {
//
//    public ButtonRenderer() {
//        setOpaque(true);
//    }
//
//    @Override
//    public Component getTableCellRendererComponent(JTable table, Object value,
//            boolean isSelected, boolean hasFocus, int row, int column) {
//        if (isSelected) {
//            setForeground(table.getSelectionForeground());
//            setBackground(table.getSelectionBackground());
//        } else {
//            setForeground(table.getForeground());
//            setBackground(UIManager.getColor("Button.background"));
//        }
//        setText((value == null) ? "" : value.toString());
//        return this;
//    }
//}
//
//class ButtonEditor extends DefaultCellEditor {
//
//    protected JButton button;
//    private String label;
//    private boolean isPushed;
//
//    public ButtonEditor(JCheckBox checkBox) {
//        super(checkBox);
//        button = new JButton();
//        button.setOpaque(true);
//        button.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                DefaultTableModel model = new DefaultTableModel();
//                model = (DefaultTableModel) JButtonTableExample.table.getModel();  
//                int row = JButtonTableExample.table.getSelectedRow();
//                System.out.println(row);
//                model.removeRow(row);
//            }
//        });
//    }
//
//    @Override
//    public Component getTableCellEditorComponent(JTable table, Object value,
//            boolean isSelected, int row, int column) {
//        if (isSelected) {
//            button.setForeground(table.getSelectionForeground());
//            button.setBackground(table.getSelectionBackground());
//        } else {
//            button.setForeground(table.getForeground());
//            button.setBackground(table.getBackground());
//        }
//        label = (value == null) ? "" : value.toString();
//        button.setText(label);
//        isPushed = true;
//        return button;
//    }
//
//    @Override
//    public Object getCellEditorValue() {
//        if (isPushed) {
//            JOptionPane.showMessageDialog(button, label + ": Ouch!");
//        }
//        isPushed = false;
//        return label;
//    }
//
//    @Override
//    public boolean stopCellEditing() {
//        isPushed = false;
//        return super.stopCellEditing();
//    }
//}










import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.EventObject;

import javax.swing.AbstractCellEditor;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerListModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;

public class Main1 {
  public static void main(String[] argv) throws Exception {
    JTable table = new JTable();
    DefaultTableModel model = (DefaultTableModel) table.getModel();

    model.addColumn("A", new Object[] { "item1" });
    model.addColumn("B", new Object[] { "item2" });

    String[] values = new String[] { "1", "2", "3" };
    TableColumn col = table.getColumnModel().getColumn(0);
    col.setCellEditor(new SpinnerEditor(values));
  }
}

class SpinnerEditor extends AbstractCellEditor implements TableCellEditor {
  final JSpinner spinner = new JSpinner();

  public SpinnerEditor(String[] items) {
    spinner.setModel(new SpinnerListModel(Arrays.asList(items)));
  }

  public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected,
      int row, int column) {
    spinner.setValue(value);
    return spinner;
  }

  public boolean isCellEditable(EventObject evt) {
    if (evt instanceof MouseEvent) {
      return ((MouseEvent) evt).getClickCount() >= 2;
    }
    return true;
  }

  public Object getCellEditorValue() {
    return spinner.getValue();
  }
}