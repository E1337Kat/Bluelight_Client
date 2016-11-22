/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIPackage;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author ellie
 */
public class ReqCellRenderer extends JLabel implements ListCellRenderer<Object> {
    
    public ReqCellRenderer() {
        setOpaque(true);
    }

    Color background;
    Color foreground;
    int alignment;
    
    @Override
    public Component getListCellRendererComponent(JList<? extends Object> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        setText(value.toString());
        
        if ((index == 0) || ((index%2) == 0)) {
            background = Color.BLUE;
            foreground = Color.WHITE;
            alignment = TRAILING;
        } else {//index is odd 
            background = Color.RED;
            foreground = Color.WHITE;
            alignment = LEADING;
        }
        
        setBackground(background);
        setForeground(foreground);
        setHorizontalAlignment(alignment);
        
        return this;
    }
}
