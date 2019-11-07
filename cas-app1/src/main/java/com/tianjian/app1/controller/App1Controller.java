package com.tianjian.app1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class App1Controller {

    @RequestMapping(value = "/")
    public String welcome() {
        return "This is App1 Cas Client";
    }
}
