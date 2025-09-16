package com.villo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class HttpSmsService {

  /*  @Value("${sms.provider.url}")           // e.g. https://api.fast2sms.com/f2s/v1/...
    private String providerUrl;

    @Value("${sms.provider.api-key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    public void sendOtpGeneric(String to, String otp) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("Authorization", apiKey); // provider-specific header

            // provider-specific body — example shape:
            var body = Map.of(
                    "sender_id", "VILLOL",
                    "message", "Your Villo OTP: " + otp,
                    "mobile", to,
                    "route", "4"
            );

            HttpEntity<Map<String, String>> request = new HttpEntity<>(body, headers);
            ResponseEntity<String> response = restTemplate.postForEntity(providerUrl, request, String.class);
            log.info("SMS sent: status={}, body={}", response.getStatusCode(), response.getBody());
        } catch (Exception ex) {
            log.error("SMS sending error: {}", ex.getMessage(), ex);
        }
    }*/
}

