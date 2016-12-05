package GUIPackage;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Backend.NetCode;
import Backend.Request;

public class ConvoLowerButtonPanel extends JPanel {
	
	 // Variables declaration 
	private JLabel otherLabel;
	private JTextField textField;
    private JComboBox<String> comboSelection;
    private JButton sendMsgButton;
    private JButton purgeButton;
    
    private String[] defaultResponses = {"Officer on their way, please stay where you are.", 
        "All units busy, please stay where you are.", "All officers busy, can you wait 5 minutes?", "other"};
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
    	otherLabel = new JLabel("other");
    	textField = new JTextField("");
        comboSelection = new JComboBox<String>(defaultResponses);
    	sendMsgButton = new JButton();
    	purgeButton = new JButton();
    	
        GridBagLayout gridBag = new GridBagLayout();
        GridBagConstraints gbc;
        
        //Set Layout
        this.setLayout(gridBag);
        
        //Row One
        //comboBox stuff
        
        //Row One
        /*  JLabel:             ComboBox^  SendMessage
         * 	+----------------+
         *  |    TextField   |  
         *  |    TextField   |
         *  |    TextField   |
         *  +----------------+             CompleteRequest
         */
        //otherLabel
        	gbc = new GridBagConstraints();
        	gbc.gridheight = 1;
        	gbc.gridwidth = 4;
        	gbc.gridx = 0;
        	gbc.anchor = GridBagConstraints.LINE_START;
        this.add(otherLabel);
        
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
            gbc.gridx = 4;
            //gbc.insets = new Insets(10,10,5,5);
            gbc.anchor = GridBagConstraints.LINE_START;
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
            gbc.gridx = 6;
            //gbc.gridy = 0;
            //gbc.ipadx = 5;
            //gbc.insets = new Insets(10,5,5,10); //top, left, bottom, right
            gbc.anchor = GridBagConstraints.LINE_END; 
        this.add(sendMsgButton, gbc);
        
        
        //Row Two
        //JTextField
        textField.setPreferredSize(new Dimension(200, 100));
        	gbc = new GridBagConstraints();
        	gbc.gridheight = 3;
        	gbc.gridwidth = 4;
        	gbc.gridy = 1;
        	gbc.anchor = GridBagConstraints.CENTER;
        	gbc.fill = GridBagConstraints.BOTH;
        this.add(textField, gbc);
        
        purgeButton.setText("Mark as Done");
        purgeButton.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent evt) {
                purgeButtonActionPerformed(evt);
            }
        });
        	gbc = new GridBagConstraints();
        	gbc.gridheight = 1;
        	gbc.gridwidth = 2;
        	gbc.gridx = 6;
        	gbc.gridy = 3;
        	gbc.anchor = GridBagConstraints.LINE_END;
        this.add(purgeButton, gbc);
        
        this.revalidate();
        this.repaint();
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
    		if (comboSelection.getSelectedItem().toString() == "other") {
    			( (Request) ReqListModel.getModel().getRequestList().get(parent.getSelection())).getConvoListModel().addElement(textField.getText());
    		} else {
	    		( (Request) ReqListModel.getModel().getRequestList().get(parent.getSelection())).getConvoListModel().addElement(comboSelection.getSelectedItem().toString());
	    		
    		}
    		
    		parent.revalidate();
	    	parent.repaint();
    		
    	}
    }

    private void purgeButtonActionPerformed(ActionEvent evt) {
		ConvoFrame parent = (ConvoFrame) this.getTopLevelAncestor();
		parent.setVisible(false);
		Request temp = ( (Request) ReqListModel.getModel().getRequestList().get(parent.getSelection()));
		
		//if not testing, send through netcode
		if ( ( (Bluelight_Client.getArgs().length >= 1 && Bluelight_Client.getArgs()[0] == "-t") || 
				(Bluelight_Client.getArgs().length >= 2 && Bluelight_Client.getArgs()[1] == "-t") ) ) {
			NetCode.getNetCodeInstance().sendTelemetry(new Date().getTime(), temp.getLocation());
		} 
		( (Request) ReqListModel.getModel().getRequestList().get(parent.getSelection())).getConvoListModel().removeAllElements();
		ReqListModel.getModel().remove(parent.getSelection());
		parent.dispose();
	}
}
