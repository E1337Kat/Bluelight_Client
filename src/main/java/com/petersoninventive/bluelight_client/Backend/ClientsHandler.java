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
package com.petersoninventive.bluelight_client.Backend;

import com.petersoninventive.bluelight_client.DataModels.Message;
import com.petersoninventive.bluelight_client.DataModels.MessageDecoder;
import com.petersoninventive.bluelight_client.DataModels.MessageEncoder;
import static java.lang.String.format;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.websocket.DeploymentException;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

/**
 *
 * @author Elliekat
 */
@javax.websocket.server.ServerEndpoint(value = "/chat", encoders = MessageEncoder.class, decoders = MessageDecoder.class)
public class ClientsHandler {
    
    static Set<Session> peers = Collections.synchronizedSet(new HashSet<Session>());
    
    
    @OnOpen
    public void onOpen(Session session) {
        System.out.println(format("%s has a new request.", session.getId()));
        peers.add(session);
    } 
    
    @OnMessage
    public void receiveRequests(Message message, Session session) throws IOException, EncodeException {
        new Thread(() ->{
            try {
                Client.main(null);
            } catch (DeploymentException ex) {
                Logger.getLogger(ClientsHandler.class.getName()).log(Level.SEVERE, null, ex);
            } catch (URISyntaxException ex) {
                Logger.getLogger(ClientsHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }).start();
        
        String user = (String) session.getUserProperties().get("user");
        if (user == null) {
            session.getUserProperties().put("user", message.getSender());
        }
        if ("quit".equalsIgnoreCase(message.getBody())) {
            session.close();
        }

        System.out.println(format("[%s:%s] %s", session.getId(), message.getReceived(), message.getBody()));

        //broadcast the message
        for (Session peer : peers) {
            if (!session.getId().equals(peer.getId())) { // do not resend the message to its sender
                peer.getBasicRemote().sendObject(message);
            }
        }
    }
    
    
    public void addConversation() {}
    
    @OnClose
    public void onClose(Session session) throws IOException, EncodeException {
        System.out.println(format("%s left the chat room.", session.getId()));
        peers.remove(session);
        //notify peers about leaving the chat room
        for (Session peer : peers) {
            Message chatMessage = new Message();
            chatMessage.setSender("Server");
            chatMessage.setBody(format("%s left the chat room.", (String) session.getUserProperties().get("user")));
            chatMessage.setReceived(new Date());
            peer.getBasicRemote().sendObject(chatMessage);
        }
    }
    
}
