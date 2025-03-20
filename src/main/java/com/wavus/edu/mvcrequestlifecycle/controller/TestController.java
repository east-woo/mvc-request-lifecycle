package com.wavus.edu.mvcrequestlifecycle.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @GetMapping("/test")
    public ResponseEntity<String> testMethod(@RequestParam String myParam) {
        logger.info("🔹 [Controller] 요청 처리 중...");
        return ResponseEntity.ok("요청 처리 완료: " + myParam);
    }
}