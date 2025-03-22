package com.wavus.edu.mvcrequestlifecycle.controller;

import com.wavus.edu.mvcrequestlifecycle.dto.MyCustomDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TestController {
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    // 예시 요청 URL: /hello
    @GetMapping("/hello")
    public String modelhelloPage(Model model) {
        logger.info("🔹 [Controller] /hello 요청 받음");
        model.addAttribute("message", "Hello, Spring MVC!");
        return "hello";
    }

    @PostMapping("/api/post")
    public ResponseEntity<String> testPostMethod(MyCustomDto dto) {
        logger.info("🔹 [Controller] 요청 처리 중...{}", dto);
        return ResponseEntity.ok("요청 처리 완료: " + dto);
    }
}