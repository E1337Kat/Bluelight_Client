package GUIPackage;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.border.SoftBevelBorder;

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
        
        
        background = Color.LIGHT_GRAY;
        foreground = Color.WHITE;
        alignment = LEADING;
        
        
        setBackground(background);
        setForeground(foreground);
        setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        setHorizontalAlignment(alignment);
        
        return this;
    }
}
