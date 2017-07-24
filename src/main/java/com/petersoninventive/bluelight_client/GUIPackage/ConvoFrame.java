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

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;

import javax.swing.JFrame;

import com.petersoninventive.bluelight_client.DataModels.Request;

/**
 *
 * @author ellie
 */
public class ConvoFrame extends JFrame implements ActionListener {
    private ConvoJList convoList;
    private ConvoLowerButtonPanel lowerButtonPanel;
    private Request req;
    private int reqSelection;
    
    public ConvoFrame() {
        initComponents();
    }
    
    public ConvoFrame(Request r, int selection) {
    	req = r;
    	reqSelection = selection;
    	initComponents();
    }
    
    private void initComponents() {
        System.out.println("Request Frame Initializing");
        
        GridBagLayout layout = new GridBagLayout();
        getContentPane().setLayout(layout);
        
        GridBagConstraints gbc;
        
        convoList = new ConvoJList();
        lowerButtonPanel = new ConvoLowerButtonPanel();
        
        System.out.println("Created Conversation List");
        
        
        
        
        convoList.setPreferredSize(new Dimension(500, 500));
        lowerButtonPanel.setPreferredSize(new Dimension(500, 100));
        
	    	//set new grid bag constraints
	        gbc = new GridBagConstraints();
	        gbc.gridheight = 2;
	        gbc.gridwidth = 5;
	        gbc.weightx = 0.5;
	        gbc.gridx = 0;
	        gbc.gridy = 0;
	        //gbc.ipadx = 5;
	        //gbc.insets = new Insets(10,10,5,5); //top, left, bottom, right
	        gbc.fill = GridBagConstraints.BOTH;
	        gbc.anchor = GridBagConstraints.PAGE_START; 
        this.add(convoList, gbc);
        
	      	//set new grid bag constraints
	        gbc = new GridBagConstraints();
	        gbc.gridheight = 2;
	        gbc.gridwidth = 5;
	        gbc.weightx = 0.1;
	        gbc.gridx = 0;
	        gbc.gridy = 2;
	        //gbc.ipadx = 5;
	        //gbc.insets = new Insets(0,0,10,0); //top, left, bottom, right
	        gbc.anchor = GridBagConstraints.PAGE_END; 
        this.add(lowerButtonPanel, gbc);
        
        convoList.initMe();
        lowerButtonPanel.initMe();
        
        System.out.println("added both panels");
        this.repaint();
    }

    
    
    public Request getRequest() {
    	return req;
    }
    
    public UUID getConvoID() {
    	return req.getConvoID();
    }
    
    public int getSelection() {
    	return reqSelection;
    }
    
	@Override
	public void actionPerformed(ActionEvent e) {
		this.repaint();
		
	}
}
