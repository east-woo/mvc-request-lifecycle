package com.wavus.edu.mvcrequestlifecycle.controller;

import com.wavus.edu.mvcrequestlifecycle.dto.CurrentUser;
import com.wavus.edu.mvcrequestlifecycle.dto.User;
import com.wavus.edu.mvcrequestlifecycle.dto.UserProfile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/profile")
    public ResponseEntity<UserProfile> getProfile(@CurrentUser User user) {
        if (user == null) {
            return ResponseEntity.status(401).build(); // 인증 실패
        }
        return ResponseEntity.ok(user.getProfile());
    }
}