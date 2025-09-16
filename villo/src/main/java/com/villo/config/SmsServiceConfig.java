package com.villo.config;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import org.springframework.stereotype.Service;
@Service
public class SmsServiceConfig {

    private final String ACCOUNT_SID = "your_twilio_account_sid";
    private final String AUTH_TOKEN = "your_twilio_auth_token";
    private final String FROM_NUMBER = "+9986550385"; // your Twilio number

    public SmsServiceConfig() {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    }

    public void sendSms(String to, String message) {
        Message.creator(
                new com.twilio.type.PhoneNumber(to),
                new com.twilio.type.PhoneNumber(FROM_NUMBER),
                message
        ).create();
    }
}
