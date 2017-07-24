/*
 * Copyright 2017 Elliekat.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.petersoninventive.bluelight_client.GUIPackage;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import java.util.Scanner;
import java.util.UUID;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.petersoninventive.bluelight_client.Backend.Conversation;
import com.petersoninventive.bluelight_client.DataModels.Coord;
import com.petersoninventive.bluelight_client.DataModels.Location;
import com.petersoninventive.bluelight_client.DataModels.Request;

public class TestFrame extends JFrame implements ActionListener{
	
	private JTextField textBox;
	private JButton button;
	private String defaultText = "New Request or Message to send.";
	private String text;

	private static final String reqRegex = "^%[a-z][a-z][a-z][0-9][0-9][0-9]%[ a-zA-Z0-9]++%[1-3]?[0-9][0-9]:[1-6]?[0-9]:[1-6]?[0-9]\\.[0-9]++%[1-3]?[0-9][0-9]:[1-6]?[0-9]:[1-6]?[0-9]\\.[0-9]++%$";
	private static final String msgRegex = "^%[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}%[ a-zA-Z0-9]++%$";
	
	public TestFrame () {
		textBox = new JTextField();
		button = new JButton();
		
		GridBagLayout gridBag = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		
		this.getContentPane().setLayout(gridBag);
		
		this.setPreferredSize(new Dimension(300, 100));
		//textBox.setPreferredSize(new Dimension(200, 90));
		//button.setPreferredSize(new Dimension(40, 20));
		
		textBox.setText(defaultText);
		textBox.addFocusListener(new FocusListener() {
			private boolean focusedBefore;
			public void focusGained(FocusEvent e) {
				if (!focusedBefore)
					textBox.setText("");
			}
			
			public void focusLost(FocusEvent e) {
				focusedBefore = true;
			}
		});
		gbc.gridwidth = 4;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		//gbc.anchor = GridBagConstraints.LINE_START;
		this.add(textBox, gbc);
		
		button.setText("Send Test String");
		button.addActionListener(this);
		gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.gridx = 4;
		//gbc.anchor = GridBagConstraints.LINE_END;
		this.add(button, gbc);
		
		this.revalidate();
		this.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String text = textBox.getText();
		
		if (text != null && text != defaultText) {
			if (text.matches(msgRegex)) {
				sendNewMessage(text);
			} else if (text.matches(reqRegex)) {
				ReqListModel.getModel().addElement(sendNewRequest(text));
			} else {
				JOptionPane.showMessageDialog(null,
                        "Not a valid text request or message, please retry.");
			}
		}
	}
	
	public Request sendNewRequest(String req) {
		String temp;
		String stuID = "";
		Conversation<String> convo = new Conversation<String>();
		Coord x = new Coord();
		Coord y = new Coord();
		Location loc = new Location();
		
			temp = req;
			System.out.println("New req: " + req);
			Scanner parts = new Scanner(temp);
			parts.useDelimiter("%");
			stuID = parts.next();
			System.out.println("New stuID: " + stuID);
			
			convo.add(parts.next());
			System.out.println("New convo: " + convo);
			
			parts.useDelimiter(":");
			parts.skip("%");
			
			int d = parts.nextInt();
			System.out.println("New degrees: " + d);
			int m = parts.nextInt();
			System.out.println("New minutes: " + m);
			parts.useDelimiter("%");
			parts.skip(":");
			double s = parts.nextDouble();
			System.out.println("New seconds: " + s);
			x.setCoordinates(d, m, s);
			
			parts.useDelimiter(":");
			parts.skip("%");
			
			d = parts.nextInt();
			m = parts.nextInt();
			parts.useDelimiter("%");
			parts.skip(":");
			s = parts.nextDouble();
			y.setCoordinates(d, m, s);
			
			loc.setCoordinates(x, y);
			
			parts.close();
			return new Request(stuID, convo, loc);
	}
	
	public String sendNewMessage(String s) {
		String temp;
		UUID convo;
		String msg;
		
		
			temp = s;
			
			Scanner parts = new Scanner(temp);
			parts.useDelimiter("%");
			
			convo = UUID.fromString(parts.next());
			System.out.println("convoID: " + convo.toString());
			msg = parts.next();
			System.out.println("Message to add: " + msg);
			System.out.println("Request to add msg to: " + ReqListModel.getModel().getRequestByConvoID(convo));
			
			(ReqListModel.getModel().getRequestByConvoID(convo)).addMessage(msg);
			
			parts.close();
			return msg;
	}
}
