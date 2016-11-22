package GUIPackage;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class ConvoLowerButtonPanel extends JPanel {
	
	 // Variables declaration 
    private JComboBox comboSelection;
    private JButton otherButton;
    private JButton selectConvoButton;
    
    private String[] testResponses = {"Hello", "Officer on way", 
        "All units busy, plese hold"};
    // End of variables declaration
    
    /**
     * Creates new form LowerButtonPanel
     */
    public ConvoLowerButtonPanel() {
    }
    
    /**
     * Public method to initialize components
     * calls initComponents
     */
    public void initMe() {
        initComponents();
    }
    /**
     * Initializes and adds components to the panel.
     */
    private void initComponents() {
        
    	System.out.println("init JPanel");
    	//Initialize Buttons
        comboSelection = new JComboBox(testResponses);
    	otherButton = new JButton();
    	selectConvoButton = new JButton();
    	
        GridBagLayout gridBag = new GridBagLayout();
        GridBagConstraints gbc;
        
        //Set Layout
        this.setLayout(gridBag);
        
        //Row One
        //comboBox stuff
        gbc = new GridBagConstraints();
            gbc.gridheight = 1;
            gbc.gridwidth = 2;
            gbc.gridx = 0;
            gbc.insets = new Insets(10,10,5,5);
            gbc.anchor = gbc.LINE_START;
        this.add(comboSelection, gbc);
        
        
        selectConvoButton.setText("Send Message");
        selectConvoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                selectConvoButtonActionPerformed(evt);
            }
        });
        	//set new grid bag constraints
            gbc = new GridBagConstraints();
            gbc.gridheight = 1;
            gbc.gridwidth = 2;
            gbc.gridx = 2;
            //gbc.gridy = 0;
            //gbc.ipadx = 5;
            gbc.insets = new Insets(10,5,5,10); //top, left, bottom, right
            gbc.anchor = gbc.LINE_START; 
        this.add(selectConvoButton, gbc);
        
        otherButton.setText("other?");
        otherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                otherButtonActionPerformed(evt);
            }
        });
        	//set new grid bag constraints
            gbc = new GridBagConstraints();
            gbc.gridheight = 1;
            gbc.gridwidth = 2;
            gbc.gridx = 2;
            gbc.gridy = 2;
            //gbc.ipadx = 5;
            gbc.insets = new Insets(10,5,5,10); //top, left, bottom, right
            gbc.anchor = gbc.LINE_END; 
        this.add(otherButton, gbc);
        
        
        //setOpaque(false);
    }    
    
    /***ACTION LISTENERS***/
    
    /**
     * Action event for button press
     * @param evt idk lol
     */
    private void selectConvoButtonActionPerformed(ActionEvent evt) {
    	//TODO: select Conversation
    }

    /**
     * Action event for button press
     * @param evt idk lol
     */
    private void otherButtonActionPerformed(ActionEvent evt) {
        //TODO: confirmation dialog, if yes, delete, else do nothing
    }
}
