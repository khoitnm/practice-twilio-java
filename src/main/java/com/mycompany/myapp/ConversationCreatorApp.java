package com.mycompany.myapp;  
  
import com.twilio.Twilio;  
import com.twilio.rest.conversations.v1.Conversation;  
import com.twilio.rest.conversations.v1.service.ConversationCreator;  
  
import java.io.IOException;  
import java.io.InputStream;  
import java.util.Properties;  
  
public class ConversationCreatorApp {  
    public static void main(String[] args) {  
        Properties properties = new Properties();  
        try (InputStream inputStream = ConversationCreatorApp.class.getClassLoader().getResourceAsStream("application-local.properties")) {
            properties.load(inputStream);  
        } catch (IOException e) {  
            e.printStackTrace();  
            return;  
        }

        /**
         * The {@link Twilio#init(String, String)} and {@link Twilio#init(String, String, String)}  methods are quite confusing.
         * In those method, username and password could have different meanings:
         * - username & password could be accountSid and authToken.
         * - Or username & password could also be apiKey and apiSecret
         *
         * This is the document when we login into Twilio console: https://www.twilio.com/console/video/project/api-keys
         * "API Keys are revokable credentials for the Twilio API.
         * You can use API Keys to authenticate to the REST API using basic auth
         * , with user=KeySid and password=KeySecret.
         *
         * And, you can use API Keys to sign Access Tokens,
         * which are used by Twilio's Real-Time Communications SDKs.
         * Access Tokens are short-lived credentials that can be distributed safely to client-side applications."
         *
         * ---------------------------
         * Conclusion:
         * So, in our case, we decide to use {ApiKey, ApiSecret, and AccountSid} instead of {AccountSid and AuthToken}
         * The reason is that it's much safer with ApiKey & ApiSecret: https://www.twilio.com/blog/protect-phishing-auth-token-fraud
         */
        String accountSid = properties.getProperty("twilio.account.sid");
        String apiKey = properties.getProperty("twilio.api.key");
        String apiSecret = properties.getProperty("twilio.api.secret");

        Twilio.init(apiKey, apiSecret, accountSid);
  
        Conversation conversation = Conversation.creator()
                .setFriendlyName("My Conversation")  
                .setUniqueName("my-conversation")  
                .create();  
  
        System.out.println("Conversation SID: " + conversation.getSid());
    }  
}  
