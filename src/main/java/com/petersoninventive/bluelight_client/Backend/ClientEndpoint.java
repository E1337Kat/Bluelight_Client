/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.petersoninventive.bluelight_client.Backend;

import java.text.SimpleDateFormat;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

/**
 *
 * @author Elliekat
 */
@javax.websocket.ClientEndpoint(encoders = MessageEncoder.class, decoders = MessageDecoder.class)
public class ClientEndpoint {
    private SimpleDateFormat sDF = new SimpleDateFormat();
    
    @OnMessage
    public void onMessage(Message message) {
        System.out.println(String.format("[%s:%s] %s", sDF.format(message.getReceived()), message.getSender(), message.getVerification(), message.getBody()));
    }
    
    @OnOpen
    public void onOpen(Session session) {
        System.out.println(String.format("Connection established. session id: %s", session.getId()));
    }
}
