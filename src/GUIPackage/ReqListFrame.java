/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIPackage;


import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author ellie
 */
public class ReqListFrame extends JFrame 
                          implements ListSelectionListener {
    
    private JList list;
    private DefaultListModel listModel;
    private JButton selectButton;
    private JButton purgeButton;
    
    /**
     * Creates new frame to make selections
     */
    public ReqListFrame() {
        initComponents();
    }
    
    private void initComponents() {
        
               
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        
        listModel = new DefaultListModel();
        
        list = new JList(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        list.setVisibleRowCount(-1);
        list.addListSelectionListener(this);
        
        
        
        JScrollPane listScroller = new JScrollPane(list);
        listScroller.setPreferredSize(new Dimension(250, 80));
        
        setSize(100,500);

    }
    
    //This method is required by ListSelectionListener.
    public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting() == false) {
 
            if (list.getSelectedIndex() == -1) {
            
 
            } else {
            
            }
        }
    }
}
