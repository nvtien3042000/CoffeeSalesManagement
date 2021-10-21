/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nguyenvantien.csm.model;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.EventObject;
import javax.swing.AbstractCellEditor;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerListModel;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author Admin
 */
public class SpinnerEditor extends AbstractCellEditor implements TableCellEditor {
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
