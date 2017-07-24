package com.petersoninventive.bluelight_client.GUIPackage;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;


public class ConvoListModel<T> extends DefaultListModel<T> 
							implements ListModel<T> {

	
	private ArrayList<T> convo;
	
    public ConvoListModel( ) {
    	super();
    	convo = new ArrayList<T>();
    }
    
    public ConvoListModel(ArrayList<T> s) {
    	super();
    	convo = new ArrayList<T>();
    	for (T i : s) {
    		this.addElement(i);
    	}
    }
    
    @Override
	public void addElement(T t) {
    	convo.add(t);
    	super.addElement(t);
    	System.out.println("added obj");
    }
    
    @Override
    public T remove(int i){
    	return super.remove(i);
    }
    	
	@Override
	public T getElementAt(int arg0) {
		// TODO Auto-generated method stub
		return convo.get(arg0);
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return convo.size();
	}
	
	public ArrayList<T> getConvoList(){
        return convo;
    }

    public void setList(ArrayList<T> array){
        this.convo = array;
    }

}
