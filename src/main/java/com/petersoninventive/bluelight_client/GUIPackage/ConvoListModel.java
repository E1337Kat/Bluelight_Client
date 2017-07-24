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
