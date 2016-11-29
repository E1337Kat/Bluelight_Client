/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIPackage;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.*;

/**
 *
 * @author ellie
 */
public class Bluelight_Client {
    
	private static ReqListFrame reqListFrame;
    public static final String LOOKANDFEEL = "System";
    protected static final String UNI_NAME = "University of Tennessee at Chattanooga";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    	ReqListModel.getModel().addElement("Request for Safe Ride at Library - UTCID=pre345 - NAME=Kellie Peace");
        ReqListModel.getModel().addElement("Request for Safe Ride at Library - UTCID=pre234 - NAME=Ellie Prean");
        ReqListModel.getModel().addElement("Request for Safe Ride at Library - UTCID=pra457 - NAME=Kel Kyl");
        ArrayList a = ReqListModel.getModel().getRequestList();
        for (Iterator<ArrayList> i = a.iterator(); i.hasNext(); i.next() ) {
        	System.out.println(i.toString());
        }
        /* Set Look and Feel of program to system look and feel if possible*/
        initLookAndFeel();
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                reqListFrame = new ReqListFrame();
                //ReqListFrame.setIconImage(img.getImage());
                reqListFrame.setTitle(UNI_NAME);
                
                reqListFrame.setDefaultCloseOperation(reqListFrame.EXIT_ON_CLOSE);
                reqListFrame.pack();
                
                reqListFrame.setVisible(true);
                
            }
        });
        // TODO code application logic here
        ReqListModel.getModel().addElement("Request for Safe Ride at Library - UTCID=pre345 - NAME=Kellie Peace");
        ReqListModel.getModel().addElement("Request for Safe Ride at Library - UTCID=pre234 - NAME=Ellie Prean");
        ReqListModel.getModel().addElement("Request for Safe Ride at Library - UTCID=pra457 - NAME=Kel Kyl");
       
    }
    
    /*
    * Requests system look and feel, and if unavailable, sets to metal(System independent)
    */
    private static void initLookAndFeel() {
        String lookAndFeel = null;
        
        if (LOOKANDFEEL != null) {
            if (LOOKANDFEEL.equals("System")) {
                lookAndFeel = UIManager.getSystemLookAndFeelClassName(); 
            } else { //default to java LaF
                System.err.println("Unexpected value of LOOKANDFEEL specified: "
                        + LOOKANDFEEL );
                lookAndFeel = UIManager.getCrossPlatformLookAndFeelClassName();
            }
            try {
                
                UIManager.setLookAndFeel(lookAndFeel);
                
            } catch (ClassNotFoundException e) {
                System.err.println("Couldn't find class for specified look and feel:"
                                   + lookAndFeel);
                System.err.println("Did you include the L&F library in the class path?");
                System.err.println("Using the default look and feel.");
            } 
            
            catch (UnsupportedLookAndFeelException e) {
                System.err.println("Can't use the specified look and feel ("
                                   + lookAndFeel
                                   + ") on this platform.");
                System.err.println("Using the default look and feel.");
            } 
            
            catch (Exception e) {
                System.err.println("Couldn't get specified look and feel ("
                                   + lookAndFeel
                                   + "), for some reason.");
                System.err.println("Using the default look and feel.");
                e.printStackTrace();
            }
        }
    }
}
