/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.petersoninventive.bluelight_client.Backend;

import java.util.Date;

/**
 *
 * @author ellie
 */
public class Message {
    private String body;
    private String sender;
    private long encrypted_verificator;
    private Date recieved;
    
    public Message(String b, String s, long v, Date r) {
        this.body = b;
        this.sender = s;
        this.encrypted_verificator = v;
        this.recieved = r;
    }
    
    public Message() {
        // Default Constructor
    }
    /*****Getters*****/
    
    public String getBody() {
        return this.body;
    }
    
    public String getSender() {
        return this.sender;
    }
    
    public long getVerification() {
        return this.encrypted_verificator;
    }
    
    public Date getReceived() {
        return this.recieved;
    }
    
    /*****Setters******/
    public void setBody(String b) {
        this.body = b;
    }
    
    public void setSender(String s) {
        this.sender = s;
    }
    
    public void setVerification(long v) {
        this.encrypted_verificator = v;
    }
    
    public void setReceived(Date r) {
        this.recieved = r;
    }
    
    /*****Utility*****/
    
    public boolean isValid() {
        return true;
    }
    
    public void printMessage() {
        System.out.print("Message Recieved:: " + 
                         "\nfrom: " + this.sender + 
                         "\nat: " + this.recieved.toString());
    }
}
