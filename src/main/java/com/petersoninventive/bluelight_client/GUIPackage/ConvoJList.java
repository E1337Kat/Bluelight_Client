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

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import com.petersoninventive.bluelight_client.DataModels.Request;

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
