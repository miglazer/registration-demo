package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email-natification")
public class EmailNotificationController {

    @PostMapping("/notify-user")
    public ResponseEntity notifyUserByEmail(String email){
        //TODO: find userInfo and send email with link like http://some/register/123qweasdzcx
        return ResponseEntity.ok().build();
        //return ResponseEntity.noContent().build();

    }
}
