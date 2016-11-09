package GUIPackage;

import Backend.*;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.AbstractListModel;

public class ReqListModel extends AbstractListModel {

	ArrayList<Request> reqs;

    public ReqListModel( ArrayList<Request> array){
        reqs = array;
    }
	
	@Override
	public Object getElementAt(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public ArrayList<Request> getRequestList(){
        return reqs;
    }

    public void setList(ArrayList<Request> array){
        this.reqs = array;
    }

    public void sort(){
        Collections.sort(reqs);
        fireContentsChanged(this, 0, reqs.size());
    }

}
