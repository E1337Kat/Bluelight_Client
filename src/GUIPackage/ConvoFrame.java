/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIPackage;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import Backend.Request;

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
        
        
        
        
        convoList.refresh();
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
    
    public long getConvoID() {
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
