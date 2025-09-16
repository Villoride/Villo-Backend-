package com.villo.service;

import com.villo.Entity.OtpEntity;
import com.villo.repository.OtpRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class OtpService {

    private final OtpRepository otpRepository;

    // Generate OTP
    @Transactional
    public String generateOtp(Long userId) {
        // Delete old OTPs for this user
        otpRepository.deleteByUserId(userId);

        // Random 4-digit OTP
        String otpCode = String.format("%04d", new Random().nextInt(10000));

        LocalDateTime now = LocalDateTime.now();

        OtpEntity otp = new OtpEntity();
        otp.setUserId(userId);
        otp.setOtpCode(otpCode);
        otp.setCreatedAt(now);
        otp.setExpiresAt(now.plusMinutes(5)); // valid for 5 minutes

        otpRepository.save(otp);

        return otpCode;
    }

    // Validate OTP
    public boolean validateOtp(Long userId, String otpCode) {
        return otpRepository.findByUserIdAndOtpCode(userId, otpCode)
                .filter(otp -> otp.getExpiresAt().isAfter(LocalDateTime.now()))
                .isPresent();
    }
}
