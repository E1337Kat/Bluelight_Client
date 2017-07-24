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

import com.petersoninventive.bluelight_client.DataModels.Request;

import java.util.ArrayList;
import java.util.UUID;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;

public class ReqListModel extends DefaultListModel 
							implements ListModel {

	private static ReqListModel reqModel;
	private static ArrayList<Request> reqs;

	/**
	 * Private constructor for lazy singleton
	 */
    private ReqListModel( ) {
    	super();
    }
	
    /**
     * Lazy Singleton instantiation of ReqListModel
     * @return a single ReqListModel
     */
    public static <T> ReqListModel getModel() {
    	
    	if (reqModel == null){
    		reqs = new ArrayList<Request>();
    		reqModel = new ReqListModel();
    	}
	
    	return reqModel;
    }
    
    /**
     * Adds an Element to end of list
     * @param t		element to add
     */
    public void addElement(Request t) {
    	reqs.add((Request)t);
    	super.addElement(t);
    	System.out.println("added obj");
    }
    
    /**
     * removes the element at the specified location
     * @param i	The index of the element to be removed
     * @return returns the element that was removed
     */
    @Override
    public Request remove(int i){
    	System.out.println("removed element." );
    	return (Request) super.remove(i);
    }
    	
    /**
     * 
     */
	@Override
	public Request getElementAt(int arg0) {
		return (Request) reqs.get(arg0);
	}
	
	/**
	 * 
	 * @param convoID
	 * @return
	 */
	public Request getRequestByConvoID(UUID convoID) {
		for (Request r : reqs) {
			if (r.getConvoID().equals(convoID)) {
				return r;
			} 
		}
		return null;
	}

	/**
	 * 
	 */
	@Override
	public int getSize() {
		return reqs.size();
	}
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<Request> getRequestList(){
        return reqs;
    }

	/**
	 * 
	 * @param array
	 */
    public static void setList(ArrayList<Request> array){
        reqs = array;
    }

}
