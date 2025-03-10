package com.mycompany.myapp.twilo.api.config;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TwilioConfig {
    private String accountSid;
    private String apiKey;
    private String apiSecret;
}
