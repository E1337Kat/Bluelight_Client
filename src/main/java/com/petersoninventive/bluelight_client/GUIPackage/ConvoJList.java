/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.petersoninventive.bluelight_client.GUIPackage;

import java.awt.Dimension;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import com.petersoninventive.bluelight_client.Backend.Request;

/**
 *
 * @author ellie
 */
public class ConvoJList extends JList {
    
	private ConvoFrame parent;
	private JScrollPane listScroller;
    String[] fakeData = {"Safe Ride Requested", "Officer on route", "thanks."};
    
    public ConvoJList() {
    	
    	super();
        
        //setListData(fakeData);
    }
    
    public void initMe() {
    	setCellRenderer(new ConvoCellRenderer());
    	parent = (ConvoFrame) getTopLevelAncestor();
    	System.out.println("Parent Window is: " + parent.toString());
        this.setModel(((Request) ReqListModel.getModel().elementAt(parent.getSelection())).getConvoListModel());
        this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.setLayoutOrientation(JList.VERTICAL);
        this.setVisibleRowCount(-1);
    }
    
    public void refresh(){
    	
    	listScroller = new JScrollPane(new ConvoJList());
    	listScroller.setPreferredSize(new Dimension(500, 200));
        
        this.revalidate();
        this.repaint();
    }
    
}
