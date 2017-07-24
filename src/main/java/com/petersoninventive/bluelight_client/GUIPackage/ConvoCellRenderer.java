/*
 * Copyright 2017 Elliekat.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.petersoninventive.bluelight_client.GUIPackage;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.border.SoftBevelBorder;

/**
 *
 * @author ellie
 */
public class ConvoCellRenderer extends JLabel implements ListCellRenderer<Object> {
    
    public ConvoCellRenderer() {
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
        setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        setHorizontalAlignment(alignment);
        
        return this;
    }
}
