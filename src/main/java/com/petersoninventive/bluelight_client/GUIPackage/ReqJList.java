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
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.petersoninventive.bluelight_client.DataModels.Request;

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
