/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIPackage;


import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author ellie
 */
public class ReqListFrame extends JFrame 
                          implements ListSelectionListener {
    
    private ReqJList<ArrayList<String>> list;
    private ReqListModel listModel;
    private JScrollPane listScroller;
    private LowerButtonPanel lowerButtonPanel;
    
    /**
     * Creates new frame to make selections
     */
    public ReqListFrame() {
        initComponents();
    }
    
    private void initComponents() {
    	
    	System.out.println("init JFrame");
    	lowerButtonPanel = new LowerButtonPanel();
        
               
        GridBagLayout layout = new GridBagLayout();
        getContentPane().setLayout(layout);
        
        GridBagConstraints gbc;
        
        list = new ReqJList<ArrayList<String>>();
        //list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //list.setLayoutOrientation(JList.VERTICAL);
        //list.setVisibleRowCount(-1);
        list.addListSelectionListener(this);
        
        System.out.println("Created JList");
        
        //listScroller = new JScrollPane(list);
        
        list.setPreferredSize(new Dimension(500, 200));
        lowerButtonPanel.setPreferredSize(new Dimension(500, 20));
        
	    	//set new grid bag constraints
	        gbc = new GridBagConstraints();
	        gbc.gridheight = 2;
	        gbc.gridwidth = 5;
	        gbc.weightx = 0.5;
	        gbc.gridx = 0;
	        gbc.gridy = 0;
	        //gbc.ipadx = 5;
	        //gbc.insets = new Insets(10,10,5,5); //top, left, bottom, right
	        gbc.anchor = gbc.PAGE_START; 
        this.add(list, gbc);
        
	      	//set new grid bag constraints
	        gbc = new GridBagConstraints();
	        gbc.gridheight = 2;
	        gbc.gridwidth = 5;
	        gbc.weightx = 0.1;
	        gbc.gridx = 0;
	        gbc.gridy = 2;
	        //gbc.ipadx = 5;
	        gbc.insets = new Insets(10,10,20,10); //top, left, bottom, right
	        gbc.anchor = gbc.PAGE_END; 
        this.add(lowerButtonPanel, gbc);
        
        lowerButtonPanel.initMe();
        
        
        System.out.println("added both panels");
        list.refresh();
        this.repaint();
    }
    
    
    //This method is required by ListSelectionListener.
    public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting() == false) {
 
            if (list.getSelectedIndex() == -1) {
            } else {
            	lowerButtonPanel.setSelection(list.getSelectedIndex());
            }
        }
    }
}
