package com.tianjian.app2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class App2Controller {

    @RequestMapping(value = "/")
    public String welcome() {
        return "This is App2 Cas Client";
    }
}
