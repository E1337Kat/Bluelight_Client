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


import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.petersoninventive.bluelight_client.DataModels.Request;

/**
 *
 * @author ellie
 */
public class ReqListFrame extends JFrame 
                          implements ListSelectionListener {
    
    private ReqJList<Request> list;
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
        
        list = new ReqJList<Request>();
        //list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //list.setLayoutOrientation(JList.VERTICAL);
        //list.setVisibleRowCount(-1);
        list.addListSelectionListener(this);
        
        System.out.println("Created JList");
        
        //listScroller = new JScrollPane(list);
        
        list.setPreferredSize(new Dimension(500, 500));
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
	        gbc.anchor = GridBagConstraints.PAGE_START; 
        this.add(list, gbc);
        
	      	//set new grid bag constraints
	        gbc = new GridBagConstraints();
	        gbc.gridheight = 2;
	        gbc.gridwidth = 5;
	        gbc.weightx = 0.1;
	        gbc.gridx = 0;
	        gbc.gridy = 2;
	        //gbc.ipadx = 5;
	        //gbc.insets = new Insets(0,0,10,0); //top, left, bottom, right
	        //gbc.anchor = GridBagConstraints.PAGE_END; 
        this.add(lowerButtonPanel, gbc);
        
        lowerButtonPanel.initMe();
        
        this.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				focusedOnFrame(arg0);
			}

			@Override
			public void focusLost(FocusEvent arg0) {}
        });
        System.out.println("added both panels");
        list.refresh();
        this.repaint();
    }
    
    
    //This method is required by ListSelectionListener.
    public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting() == false) {
 
            if (list.getSelectedIndex() == -1) {
            	lowerButtonPanel.getSelectButton().setEnabled(false);
            	this.revalidate();
            	this.repaint();
            } else {
            	lowerButtonPanel.setSelection(list.getSelectedIndex());
            	
            }
        }
    }
    
    public void focusedOnFrame(FocusEvent e) {
    	System.out.println("Refreshing list");
		list.refresh();
		this.revalidate();
		this.repaint();
    }
}
