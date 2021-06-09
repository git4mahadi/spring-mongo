package com.edu.javatechbd.springmongo.controller;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class TwilioTest {

//    public static final String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID");
    public static final String ACCOUNT_SID = "ACda97675589a541a5394941821d0cd75b";
//    public static final String AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN");
    public static final String AUTH_TOKEN = "b99337d6dc46742b47cc48b08a9ebe69";

    // Install the Java helper library from twilio.com/docs/java/install



    @GetMapping("/twilio/sms")
    public ResponseEntity<?> sendSms() {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("+88 01797548848"),
                new com.twilio.type.PhoneNumber("+15005550006"),
                "Where's Wallace?")
                .create();

        System.out.println(message.getSid());
        return ResponseEntity.status(HttpStatus.OK)
                .body(message);
    }


}
