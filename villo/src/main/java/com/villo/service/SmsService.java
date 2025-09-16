package com.villo.service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SmsService {

    @Value("${twilio.account-sid}")
    private String accountSid;

    @Value("${twilio.auth-token}")
    private String authToken;

    @Value("${twilio.from-number}")
    private String fromNumber;

    @PostConstruct
    public void init() {
        Twilio.init(accountSid, authToken);
        log.info("✅ Twilio initialized successfully");
    }

    /**
     * Send OTP to a phone number
     */
    @Async
    public void sendOtp(String toPhoneE164, String otp) {
        try {
            String message = "Your Villo OTP is: " + otp + " (valid for 5 minutes)";

            Message.creator(
                    new PhoneNumber(toPhoneE164),   // Receiver
                    new PhoneNumber(fromNumber),    // Twilio number
                    message
            ).create();

            log.info("📲 OTP sent successfully to {}", toPhoneE164);
        } catch (Exception ex) {
            log.error("❌ Failed to send OTP to {}: {}", toPhoneE164, ex.getMessage(), ex);
        }
    }

    // helper: format Indian numbers into +91 format
    public static String toE164India(String phone) {
        if (phone == null) return null;
        var digits = phone.replaceAll("[^0-9]", "");
        if (digits.length() == 10) return "+91" + digits;
        if (digits.startsWith("91") && digits.length() == 12) return "+" + digits;
        if (phone.startsWith("+")) return phone;
        return phone;
    }
}
