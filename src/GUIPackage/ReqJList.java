package GUIPackage;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ReqJList<T> extends JList implements ListSelectionListener {
	private T t;
	private JList list;
	private DefaultListModel listModel;
	private JScrollPane listScroller;
	private int JListSelection;
	String[] fakeData = {"Request for Safe Ride at Library - UTCID=pre345 - NAME=Kellie Peace", 
			"Request for Safe Ride at Library - UTCID=pre234 - NAME=Ellie Prean",
			"Request for Safe Ride at Library - UTCID=pra457 - NAME=Kel Kyl"};
	
	public ReqJList(DefaultListModel d) {
		setListData(fakeData);
		listModel = d;
		
        
        list = new JList(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setLayoutOrientation(JList.VERTICAL);
        list.setVisibleRowCount(-1);
        
        listScroller = new JScrollPane(list);
    	listScroller.setPreferredSize(new Dimension(500, 200));
    	
    	this.revalidate();
        this.repaint();
	}
	
	public void addData(Object obj) {
    	listModel.addElement(obj);
    	list = new JList(listModel);
    	
    	listScroller = new JScrollPane(list);
    	listScroller.setPreferredSize(new Dimension(500, 200));
        
        this.revalidate();
        this.repaint();
    }
    
    public void deleteData(int index) {
    	listModel.remove(index);
    	list = new JList(listModel);
    	
    	listScroller = new JScrollPane(list);
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
			 
            if (list.getSelectedIndex() == -1) {
            
 
            } else {
            	setSelection(list.getSelectedIndex());
            }
        }
	}
}
