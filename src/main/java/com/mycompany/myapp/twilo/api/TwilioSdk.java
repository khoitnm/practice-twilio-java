package com.mycompany.myapp.twilo.api;

import com.mycompany.myapp.ConversationCreatorApp;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.conversations.v1.Conversation;
import com.twilio.rest.conversations.v1.conversation.Message;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TwilioSdk {
    public static void createConversations() {
        //This example shows that we can handle different Twilio accounts in the same application.
        TwilioRestClient client1 = getClient("application-localqa.properties");
        TwilioRestClient client2 = getClient("application-localkevin.properties");

        Conversation conversation = Conversation.creator()
                .setFriendlyName("My Conversation in org 1")
                .create(client1);
        System.out.println("Conversation1 SID: " + conversation.getSid());

        Message message = Message.creator(conversation.getSid())
                .setBody("Hello, World!")
                .create(client1);
        System.out.println("message SID: " + message.getSid());

        Conversation conversation2 = Conversation.creator()
                .setFriendlyName("My Conversation in org 2")
                .create(client2);
        System.out.println("Conversation2 SID: " + conversation2.getSid());
    }


    private static TwilioConfig loadConfig(String filePath) {
        Properties properties = new Properties();
        try (InputStream inputStream = ConversationCreatorApp.class.getClassLoader().getResourceAsStream(filePath)) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        TwilioConfig config = new TwilioConfig();
        config.setAccountSid(properties.getProperty("twilio.account.sid"));
        config.setApiKey(properties.getProperty("twilio.api.key"));
        config.setApiSecret(properties.getProperty("twilio.api.secret"));
        return config;
    }

    private static TwilioRestClient getClient(TwilioConfig config) {
        TwilioRestClient client = new TwilioRestClient.Builder(config.getApiKey(), config.getApiSecret()).accountSid(config.getAccountSid()).build();
        return client;
    }

    private static TwilioRestClient getClient(String configFilePath) {
        TwilioConfig config = loadConfig(configFilePath);
        return getClient(config);
    }
}
