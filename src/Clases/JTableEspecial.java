package Clases;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * @author Daniel Sánchez <daniel_s2604@hotmail.com>
 * @author DJ-Raven
 * Recuperado y adaptado de github
 * https://github.com/DJ-Raven/jtable-dark-mode
 */

public class JTableEspecial extends JTable {

    public JTableEspecial() {
        init();
    }
    
    public void fixTabla (JScrollPane scroll) {
        scroll.setVerticalScrollBar(new ScrollBarEspecial());
        JPanel panel = new JPanel();
        // Se debe colocar el color del header.
        panel.setBackground(new Color(30, 30, 30));
        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, panel);
        // Color del fondo del JScrollPane.
        scroll.getViewport().setBackground(new Color (30, 30, 30));
        // Color de las divisiones.
        scroll.setBorder(BorderFactory.createLineBorder(new Color (60, 60, 60), 2));
    }

    private class headerColorTabla extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            // Color header
            com.setBackground(new Color(30, 30, 30));
            // Color letra 
            com.setForeground(new Color(200, 200, 200));
            // Fuente
            com.setFont(com.getFont().deriveFont(Font.BOLD));
            // Posición del texto
            setHorizontalAlignment(JLabel.CENTER);
            return com;
        }
    }

    private class celdasColorTabla extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (isCellSelected(row, column)) {
                // Color celdas seleccionadas
                if (row % 2 == 0) {
                    com.setBackground(new Color(33, 103, 153));
                }else {
                    com.setBackground(new Color(29, 86, 127));
                }
            } else {
                // Color de las celdas libres
                if (row % 2 == 0) {
                    com.setBackground(new Color(50, 50, 50));
                } else {
                    com.setBackground(new Color(30, 30, 30));
                }
            }
            setBorder(new EmptyBorder(0, 5, 0, 5));
            return com;
        }

    }

    private void init() {
        getTableHeader().setDefaultRenderer(new headerColorTabla());
        getTableHeader().setPreferredSize(new Dimension(0, 35));
        setDefaultRenderer(Object.class, new celdasColorTabla());
        setRowHeight(30);
    }
}
