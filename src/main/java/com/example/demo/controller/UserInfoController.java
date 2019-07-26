package com.example.demo.controller;

import com.example.demo.entity.UserInfo;
import com.example.demo.entity.UserInfoExistsResponse;
import com.example.demo.repository.UserInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/user-info")
@Slf4j
public class UserInfoController {

    private final UserInfoRepository userInfoRepository;

    public UserInfoController(@Autowired UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }

    @PostMapping
    public ResponseEntity<UserInfo> save(@RequestBody @Valid UserInfo userInfo) {
        log.debug("POST /user-info UserInfo: {}", userInfo);
        //TODO: generate uid
        UserInfo result = userInfoRepository.saveOrUpdate(userInfo);
        return ResponseEntity.ok(result);
    }

    @PutMapping
    public ResponseEntity<UserInfo> update(@RequestBody @Valid UserInfo userInfo) {
        log.debug("PATCH /user-info UserInfo: {}", userInfo);
        UserInfo result = userInfoRepository.saveOrUpdate(userInfo);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{uid}")
    public ResponseEntity<UserInfo> getUserInfo(@PathVariable String uid){
        //TODO: fing userInfo by uid
        return ResponseEntity.ok(new UserInfo("123", "qwe@er.com", "Bill", "Bill"));
    }

    @RequestMapping(value = "/{email}", method = RequestMethod.HEAD) //step number 1
    public ResponseEntity exists(@PathVariable  String email) {
        log.debug("GET /user-info/{}", email);
        UserInfoExistsResponse result = userInfoRepository.existsByEmail(email);
        if(result.getUserInfoExists()){
            return ResponseEntity.ok(result);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

}
