package GUIPackage;

import Backend.*;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;

public class ReqListModel<T> extends DefaultListModel<T> 
							implements ListModel<T> {

	private static ReqListModel<Request> reqModel;
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
    public static <T> ReqListModel<Request> getModel() {
    	
    	if (reqModel == null){
    		reqs = new ArrayList<Request>();
    		reqModel = new ReqListModel<Request>();
    	}
	
    	return reqModel;
    }
    
    /**
     * Adds an Element to end of list
     * @param t		element to add
     */
    @Override
    public void addElement(T t) {
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
    public T remove(int i){
    	return super.remove(i);
    }
    	
    /**
     * 
     */
	@Override
	public T getElementAt(int arg0) {
		return (T) reqs.get(arg0);
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
