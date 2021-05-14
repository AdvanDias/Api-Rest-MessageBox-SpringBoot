package com.SpringBoot.Api.MessageBox;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @Value("${app.message}")
    private String appMenssagem;

    @GetMapping("/")
    public String getAppMenssagem(){
        return appMenssagem;
    }
}
