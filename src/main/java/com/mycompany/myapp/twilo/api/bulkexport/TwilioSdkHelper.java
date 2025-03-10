package com.mycompany.myapp.twilo.api.bulkexport;

import com.mycompany.myapp.twilo.api.config.TwilioConfig;
import com.mycompany.myapp.twilo.api.config.TwilioConfigLoader;
import org.apache.http.HttpMessage;

public class TwilioSdkHelper {
    private static final String configFileName = "application-localkevin.properties";
    private static final TwilioConfig twilioConfig = TwilioConfigLoader.loadConfig(configFileName);

    public static void setHttpAuthorizationHeaders(HttpMessage httpMessage) {
        httpMessage.setHeader("Authorization", "Basic " + java.util.Base64.getEncoder().encodeToString(
                (twilioConfig.getApiKey() + ":" + twilioConfig.getApiSecret()).getBytes()));
        httpMessage.setHeader("Content-Type", "application/x-www-form-urlencoded");
    }

}
