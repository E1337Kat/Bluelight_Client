/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIPackage;

import javax.swing.JList;

/**
 *
 * @author ellie
 */
public class ConvoJList extends JList {
    
    String[] fakeData = {"Safe Ride Requested", "Officer on route", "thanks."};
    
    public ConvoJList() {
        setCellRenderer(new ReqCellRenderer());
        setListData(fakeData);
    }
    
    
}
