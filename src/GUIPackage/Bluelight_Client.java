/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIPackage;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.*;

import Backend.*;

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
        String[] k = {"Request for Safe Ride"};
        String[] m = {"Need ride plz??!?"};
    	ReqListModel.getModel().addElement(new Request("pre345", new Conversation<String>(k), new Location() ));
        ReqListModel.getModel().addElement(new Request("pre234", new Conversation<String>(m), new Location() ));
        ReqListModel.getModel().addElement(new Request("pre345", new Conversation<String>(k), new Location() ));
        ArrayList<Request> a = ReqListModel.getModel().getRequestList();
        for (Iterator<Request> i = a.iterator(); i.hasNext(); i.next() ) {
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
                
                reqListFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                reqListFrame.pack();
                
                reqListFrame.setVisible(true);
                
            }
        });
        
        initSystemTray();
        
    }
    
    /**
     * Create an icon for the system tray to allow users to reopen window 
     */
    private static void initSystemTray() {
    	//Check the SystemTray is supported
        if (!SystemTray.isSupported()) {
            System.out.println("SystemTray is not supported");
            return;
        }
        final PopupMenu popup = new PopupMenu();
        final TrayIcon trayIcon =
                new TrayIcon(createImage("../Resources/bulb.gif", "tray icon"));
        final SystemTray tray = SystemTray.getSystemTray();
       
        // Create a pop-up menu components
        MenuItem aboutItem = new MenuItem("About");
        Menu displayMenu = new Menu("Display");
        MenuItem maximizeItem = new MenuItem("Maximize");
        MenuItem minimizeItem = new MenuItem("Minimize");
        MenuItem exitItem = new MenuItem("Exit");
       
        //Add components to pop-up menu
        popup.add(aboutItem);
        popup.addSeparator();
        popup.add(displayMenu);
        displayMenu.add(maximizeItem);
        displayMenu.add(minimizeItem);
        popup.add(exitItem);
       
        trayIcon.setPopupMenu(popup);
       
        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            System.out.println("TrayIcon could not be added.");
        }
        
        trayIcon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,
                        "This dialog box is run from System Tray");
            }
        });
         
        aboutItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,
                        "This dialog box is run from the About menu item");
            }
        });
        
        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MenuItem item = (MenuItem)e.getSource();
                //TrayIcon.MessageType type = null;
                System.out.println(item.getLabel());
                if ("Maximize".equals(item.getLabel())) {
                    //type = TrayIcon.MessageType.ERROR;
                	reqListFrame.setVisible(true);
                     
                } else if ("Minimize".equals(item.getLabel())) {
                    //type = TrayIcon.MessageType.WARNING;
                	reqListFrame.setVisible(false);
                     
                } 
            }
        };
        
        maximizeItem.addActionListener(listener);
        minimizeItem.addActionListener(listener);
        
        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tray.remove(trayIcon);
                System.exit(0);
            }
        });
		
	}

	//Obtain the image URL
    protected static Image createImage(String path, String description) {
        URL imageURL = Bluelight_Client.class.getResource(path);
         
        if (imageURL == null) {
            System.err.println("Resource not found: " + path);
            return null;
        } else {
            return (new ImageIcon(imageURL, description)).getImage();
        }
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
