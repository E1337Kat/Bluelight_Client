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
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

/**
 *
 * @author Elliekat
 */
@javax.websocket.ClientEndpoint(encoders = MessageEncoder.class, decoders = MessageDecoder.class)
public class ClientEndpoint {
    Logger log = Logger.getLogger(ClientEndpoint.class.getName());
    private SimpleDateFormat sDF = new SimpleDateFormat();
    
    @OnMessage
    public void onMessage(Message message) {
        log.log(Level.INFO, String.format("[%s:%s] %s :VERIFY: %d", 
                sDF.format(message.getReceived()), 
                message.getSender(),
                message.getBody(),
                message.getVerification()));
    }
    
    @OnOpen
    public void onOpen(Session session) {
        log.log(Level.INFO, String.format("Connection established. session id: %s", session.getId()));
    }
}
