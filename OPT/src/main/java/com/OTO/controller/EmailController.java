package com.OTO.controller;

import com.OTO.service.OtpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("otp")
public class EmailController {

    @Autowired
    private OtpServiceImpl OtpServiceImpl;


    @PostMapping("/{email}")
    public Map<String, String> sendOtp(@PathVariable String email){
        return OtpServiceImpl.sendOtpEmail(email);
    }
}
