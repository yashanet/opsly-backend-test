package com.opsly.demo.controllers;

import com.opsly.demo.models.ResponseDTO;
import com.opsly.demo.service.SocialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Autowired
    private SocialService socialService;

    @RequestMapping("/")
    public ResponseDTO index() {
        return socialService.getNews();
    }
}
