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

import java.io.IOException;
import javax.json.Json;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.websocket.DeploymentException;
import javax.websocket.Session;
import org.glassfish.tyrus.client.ClientManager;

/**
 *
 * @author Elliekat
 */
public class Client {

    public static final String SERVER = "ws://localhost:8025/ws/chat";

    public static void main(String[] args) throws DeploymentException, URISyntaxException {
        ClientManager client = ClientManager.createClient();

        // connect to server
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Tiny Chat!");
        System.out.println("What's your name?");
        String user = scanner.nextLine();
        Session session = client.connectToServer(ClientEndpoint.class, new URI(SERVER));
        System.out.println("You are logged in as: " + user);

        // repeatedly read a message and send it to the server (until quit)
        new Thread(() -> {
            while (true) {
                String message = scanner.nextLine();
                try {
                    session.getBasicRemote().sendText(formatMessage(message, user, 0));
                } catch (IOException ex) {
                    Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (message.equalsIgnoreCase("quit")) {
                    break;
                }
            }
        }).start();
        
    }

    private static String formatMessage(String body, String user, long verification) {
        return Json.createObjectBuilder()
                .add("body", body)
                .add("sender", user)
                .add("verification", verification)
                .add("received", "")
                .build().toString();
    }

}
