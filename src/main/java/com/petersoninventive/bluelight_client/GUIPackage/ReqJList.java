package com.petersoninventive.bluelight_client.GUIPackage;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.petersoninventive.bluelight_client.Backend.Request;

public class ReqJList<T> extends JList<T> implements ListSelectionListener {
	
	private JScrollPane listScroller;
	private int JListSelection;
	String[] fakeData = {"Request for Safe Ride at Library - UTCID=pre345 - NAME=Kellie Peace", 
			"Request for Safe Ride at Library - UTCID=pre234 - NAME=Ellie Prean",
			"Request for Safe Ride at Library - UTCID=pra457 - NAME=Kel Kyl"};
	
	public ReqJList () {
		
        super();
        setCellRenderer(new ReqCellRenderer());
        this.setModel((ListModel<T>)ReqListModel.getModel());
        this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.setLayoutOrientation(JList.VERTICAL);
        this.setVisibleRowCount(-1);
        
	}
    
    public void refresh(){
    	
    	listScroller = new JScrollPane(new ReqJList());
    	listScroller.setPreferredSize(new Dimension(500, 200));
        
        this.revalidate();
        this.repaint();
    }
    
    public void setSelection(int index) {
    	JListSelection = index;
    }
    
    public int getSelection() {
    	return JListSelection;
    }
    

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (e.getValueIsAdjusting() == false) {
			 
            if (this.getSelectedIndex() == -1) {
            
 
            } else {
            	setSelection(this.getSelectedIndex());
            }
        }
	}
}
