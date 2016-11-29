package GUIPackage;

import Backend.*;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;

public class ReqListModel extends DefaultListModel 
							implements ListModel {

	private static ReqListModel reqModel;
	private static ArrayList<Object> reqs;

	/**
	 * Private constructor for lazy singleton
	 */
    private ReqListModel( ) {
    	super();
    }
	
    public static ReqListModel getModel() {
    	if (reqModel == null){
    		reqs = new ArrayList<Object>();
    		reqModel = new ReqListModel();
    	}
    	return reqModel;
    }
    
    public void addElement(Object o) {
    	reqs.add(o);
    	super.addElement(o);
    	System.out.println("added obj");
    }
    
    public Object remove(int i){
    	return super.remove(i);
    }
    	
	@Override
	public Object getElementAt(int arg0) {
		// TODO Auto-generated method stub
		return reqs.get(arg0);
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return reqs.size();
	}
	
	public ArrayList<Object> getRequestList(){
        return reqs;
    }

    public void setList(ArrayList<Object> array){
        this.reqs = array;
    }

}
