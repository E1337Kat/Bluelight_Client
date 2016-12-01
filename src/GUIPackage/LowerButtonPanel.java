package GUIPackage;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LowerButtonPanel extends JPanel {
	
	 // Variables declaration 
    private JButton otherButton;
    private JButton selectConvoButton;
    private int jListSelection;
    // End of variables declaration
    
    /**
     * Creates new form LowerButtonPanel
     */
    public LowerButtonPanel() {
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
    	otherButton = new JButton();
    	selectConvoButton = new JButton();
    	
        GridBagLayout gridBag = new GridBagLayout();
        GridBagConstraints gbc;
        
        //Set Layout
        this.setLayout(gridBag);
        
        //Row One
        selectConvoButton.setText("<html><u>S</u>elect</html>");
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
            gbc.gridx = 0;
            //gbc.gridy = 0;
            //gbc.ipady = 10;
            //gbc.insets = new Insets(10,10,5,5); //top, left, bottom, right
            gbc.anchor = GridBagConstraints.LINE_START; 
        this.add(selectConvoButton, gbc);
        
        otherButton.setText("<html><u>E</u>xit</html>");
        otherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });
        	//set new grid bag constraints
            gbc = new GridBagConstraints();
            gbc.gridheight = 1;
            gbc.gridwidth = 2;
            gbc.gridx = 2;
            //gbc.gridy = 0;
            //gbc.ipady = 10;
            //gbc.insets = new Insets(10,5,5,10); //top, left, bottom, right
            gbc.anchor = GridBagConstraints.LINE_END; 
        this.add(otherButton, gbc);
        
        
        //setOpaque(false);
    }    
    
    public JButton getSelectButton() {
    	return selectConvoButton;
    }
    
    /***ACTION LISTENERS***/
    
    /**
     * Action event for button press
     * @param evt idk lol
     */
    private void selectConvoButtonActionPerformed(ActionEvent evt) {
    	/* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                ConvoFrame convoFrame = new ConvoFrame(ReqListModel.getModel().getRequestList().get((int) getSelection()), getSelection());
                //ReqListFrame.setIconImage(img.getImage());
                convoFrame.setTitle("Request #" + ReqListModel.getModel().getRequestList().get((int) getSelection()).getConvoID().toString());
                convoFrame.setLocationByPlatform(true);
                convoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                convoFrame.pack();
                
                convoFrame.setVisible(true);
            }
        });
    }

    /**
     * Action event for button press
     * @param evt idk lol
     */
    private void exitButtonActionPerformed(ActionEvent evt) {
        JFrame parent = (JFrame) this.getTopLevelAncestor();
        parent.setVisible(false);
    }

	public void setSelection(int selectedIndex) {
		jListSelection = selectedIndex;	
		System.out.println(selectedIndex);
	}
	
	public int getSelection() {
		return jListSelection;
	}
}
