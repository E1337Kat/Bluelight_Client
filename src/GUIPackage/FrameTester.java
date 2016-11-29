/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIPackage;

import javax.swing.*;

/**
 *
 * @author ellie
 */
public class FrameTester {
    
    public static final String LOOKANDFEEL = "System";
    protected static final String UNI_NAME = "University of Tennessee at Chattanooga";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /* Set Look and Feel of program to system look and feel if possible*/
        initLookAndFeel();
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                ConvoFrame reqConvoFrame = new ConvoFrame();
                //ReqListFrame.setIconImage(img.getImage());
                reqConvoFrame.setTitle(UNI_NAME);
                
                reqConvoFrame.setDefaultCloseOperation(reqConvoFrame.EXIT_ON_CLOSE);
                reqConvoFrame.pack();
                
                reqConvoFrame.setVisible(true);
            }
        });
        // TODO code application logic here
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
