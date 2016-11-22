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
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author ellie
 */
public class ReqConvoFrame extends JFrame {
    private ConvoJList convoList;
    private DefaultListModel listModel;
    private JScrollPane listScroller;
    private ConvoLowerButtonPanel lowerButtonPanel;
    
    public ReqConvoFrame() {
        initComponents();
    }
    
    private void initComponents() {
        System.out.println("Request Frame Initializing");
        
        GridBagLayout layout = new GridBagLayout();
        getContentPane().setLayout(layout);
        
        GridBagConstraints gbc;
        
        convoList = new ConvoJList();
        lowerButtonPanel = new ConvoLowerButtonPanel();
        listModel = new DefaultListModel();
        
        convoList = new ConvoJList();
        convoList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        convoList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        convoList.setVisibleRowCount(-1);
        //convoList.addListSelectionListener(this);
        
        System.out.println("Created Conversation List");
        
        listScroller = new JScrollPane(convoList);
        
        listScroller.setPreferredSize(new Dimension(500, 200));
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
        this.add(listScroller, gbc);
        
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
        this.repaint();
    }
}
