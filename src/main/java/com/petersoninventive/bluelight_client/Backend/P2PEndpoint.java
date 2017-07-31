/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.petersoninventive.bluelight_client.Backend;

import com.petersoninventive.bluelight_client.DataModels.Message;
import com.petersoninventive.bluelight_client.DataModels.MessageEncoder;
import com.petersoninventive.bluelight_client.DataModels.MessageDecoder;
import com.petersoninventive.bluelight_client.GUIPackage.ReqListModel;

import java.io.IOException;
import static java.lang.String.format;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import static java.lang.String.format;
import static java.lang.String.format;
import static java.lang.String.format;

/**
 *
 * @author ellie
 */
@javax.websocket.server.ServerEndpoint(value = "/P2P/chat/{user}", encoders = MessageEncoder.class, decoders = MessageDecoder.class)
public class P2PEndpoint {
    static Set<Session> peers = Collections.synchronizedSet(new HashSet<Session>());
    

    @OnOpen
    public void onOpen(Session session) {
        System.out.println(format("%s joined the chat room.", session.getId()));
        peers.add(session);
        
        
    }

    @OnMessage
    public void onMessage(Message message, Session session) throws IOException, EncodeException {
        /*
        * @TODO: Add message to proper session conversation
        *
        */
        
        //(ReqListModel.getModel().getRequestByConvoID(session)).addMessage(decrypt(message.getBody()));
    }

    @OnClose
    public void onClose(Session session) throws IOException, EncodeException {
        System.out.println(format("%s left the chat room.", session.getId()));
        peers.remove(session);
        //notify peers about leaving the chat room
        for (Session peer : peers) {
            Message message = new Message();
            message.setSender("Server");
            message.setBody(format("%s left the chat room", (String) session.getUserProperties().get("user")));
            message.setReceived(new Date());
            peer.getBasicRemote().sendObject(message);
        }
    }
    
    private String decrypt(String message) {
        
        
        return "heck";
    }
}
