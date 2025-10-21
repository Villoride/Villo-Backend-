package com.villo.web;

import com.villo.Entity.UserEntity;
import com.villo.model.LoginRequest;
import com.villo.model.OtpVerifyRequest;
import com.villo.repository.UserRepository;
import com.villo.service.OtpService;
import com.villo.service.SmsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/villo/auth")
public class AuthWeb {

    private final UserRepository userRepository;
    private final OtpService otpService;
    private final SmsService smsService;

    @PostMapping("/send-otp")
    public ResponseEntity<?> sendOtp(@RequestBody LoginRequest loginRequest) {
        var username = loginRequest.getUsername();
        UserEntity user;

        if (username.contains("@")) {
            user = userRepository.findByEmail(username).orElse(null);
        } else {
            user = userRepository.findByPhoneNumber(username).orElse(null);
        }

        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", "User not found"));
        }

        String otp = otpService.generateOtp(user.getUserId());  // returns OTP string

        // Format phone to E.164 (e.g., +91xxxxxxxxxx) before sending
        String to = SmsService.toE164India(user.getPhoneNumber());

        // Async send — we don't wait on this
        smsService.sendOtp(to, otp);

        return ResponseEntity.ok(Map.of("message", "OTP queued for sending", "userId", user.getUserId()));
    }

    @PostMapping("/verify-otp")
    public ResponseEntity<?> verifyOtp(@RequestBody OtpVerifyRequest request) {
        boolean isValid = otpService.validateOtp(request.getUserId(), request.getOtp());

        if (!isValid) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("message","Invalid/expired OTP"));
        }
        return ResponseEntity.ok(Map.of("message", "Login success", "userId", request.getUserId()));
    }
}
