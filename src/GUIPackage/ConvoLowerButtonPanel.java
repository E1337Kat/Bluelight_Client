package GUIPackage;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Backend.Request;

public class ConvoLowerButtonPanel extends JPanel {
	
	 // Variables declaration 
    private JComboBox comboSelection;
    private JButton sendMsgButton;
    
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
    	sendMsgButton = new JButton();
    	
        GridBagLayout gridBag = new GridBagLayout();
        GridBagConstraints gbc;
        
        //Set Layout
        this.setLayout(gridBag);
        
        //Row One
        //comboBox stuff
        comboSelection.setSelectedIndex(-1);
        comboSelection.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent evt) {
        		comboSelectionActionPerformed(evt);
        	}
        });
        gbc = new GridBagConstraints();
            gbc.gridheight = 1;
            gbc.gridwidth = 2;
            gbc.gridx = 0;
            //gbc.insets = new Insets(10,10,5,5);
            gbc.anchor = gbc.LINE_START;
        this.add(comboSelection, gbc);
        
        
        sendMsgButton.setText("Send Message");
        sendMsgButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                sendMsgButtonActionPerformed(evt);
            }
        });
        	//set new grid bag constraints
            gbc = new GridBagConstraints();
            gbc.gridheight = 1;
            gbc.gridwidth = 2;
            gbc.gridx = 2;
            //gbc.gridy = 0;
            //gbc.ipadx = 5;
            //gbc.insets = new Insets(10,5,5,10); //top, left, bottom, right
            gbc.anchor = gbc.LINE_END; 
        this.add(sendMsgButton, gbc);
        
        
       
        	
        
        
        //setOpaque(false);
    }    
    
    /***ACTION LISTENERS***/
    
    protected void comboSelectionActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		
	}

	/**
     * Action event for button press
     * @param evt idk lol
     */
    private void sendMsgButtonActionPerformed(ActionEvent evt) {
    	if (comboSelection.getSelectedIndex() == -1) {
    		JOptionPane.showMessageDialog(null,
                    "Please choose a response from the left!");
    	} else {
    		ConvoFrame parent = (ConvoFrame) this.getTopLevelAncestor();
    		( (Request) ReqListModel.getModel().getRequestList().get(parent.getSelection())).getConvoListModel().addElement(comboSelection.getSelectedItem().toString());
    		parent.revalidate();
    		parent.repaint();
    	}
    }

    
}
