package cz.vhasnr.ppf.challenge1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/test-api")
@Slf4j
public class TestController {

    @GetMapping
    public String test() {
        return "test";
    }

    @PostConstruct
    public void postConstruct() {
        log.info("TestController initialized");
    }
}
