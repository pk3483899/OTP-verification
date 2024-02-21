package com.OTO.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class OtpServiceImpl {

    @Autowired
    private JavaMailSender javaMailSender;


    //It will generate a random OTP
    public String generateOtp() {
//        It generates random 6-digit number by using Random()..
        return String.format("%06d", new java.util.Random().nextInt(100000));
    }

    public Map<String, String> sendOtpEmail(String email) {
        //it will call the method genereate otp and return 6 digit random number
        String otp = generateOtp();
        sendEmail(email, "OTP for email varification", "Your OTP is : "+otp);
        Map<String, String> response=new HashMap<>();
        response.put("status", "Success");
        response.put("message", "OTP sent Successfully");
        return response;
    }

    public void sendEmail(String to, String subject, String text){
        SimpleMailMessage message=new SimpleMailMessage();
        message.setFrom("abc@gmail.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        javaMailSender.send(message);
    }
}

