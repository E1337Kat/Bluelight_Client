package GUIPackage;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;


public class ConvoListModel<T> extends DefaultListModel<T> 
							implements ListModel<T> {

	
	private ArrayList<String> convo;
	
    public ConvoListModel( ) {
    	super();
    	convo = new ArrayList<String>();
    }
    
    public ConvoListModel(ArrayList<String> s) {
    	super();
    	convo = new ArrayList<String>();
    	for (String i : s) {
    		this.addElement((T)i);
    	}
    }
    
    @Override
	public void addElement(T t) {
    	convo.add((String)t);
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
		return (T)convo.get(arg0);
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return convo.size();
	}
	
	public ArrayList<String> getConvoList(){
        return convo;
    }

    public void setList(ArrayList<String> array){
        this.convo = array;
    }

}
