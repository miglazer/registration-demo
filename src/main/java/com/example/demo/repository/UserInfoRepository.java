package com.example.demo.repository;

import com.example.demo.entity.UserInfo;
import com.example.demo.entity.UserInfoExistsResponse;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserInfoRepository {
    public UserInfo saveOrUpdate(UserInfo userInfo) {
        //TODO:
        return userInfo;
    }

    public UserInfo findUserInfo(String email){
        //TODO:
        return UserInfo.builder()
                .email(email)
                .build();
    }

    public UserInfoExistsResponse existsByEmail(String email){
        return new UserInfoExistsResponse(true);
    }
}
