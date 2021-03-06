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
package com.petersoninventive.bluelight_client.DataModels;

import java.util.Date;

/**
 *
 * @author ellie
 */
public class Message {
    private String body;
    private String sender;
    private long convoID;
    private long userID;
    private long encrypted_verificator;
    private Date recieved;
    
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
    
    public long getUserID() {
        return this.userID;
    }
    
    public long getConvoID() {
        return this.convoID;
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
    
    public void setUserID(long id) {
        this.userID = id;
    }
    
    public void setConvoID(long id) {
        this.convoID = id;
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
