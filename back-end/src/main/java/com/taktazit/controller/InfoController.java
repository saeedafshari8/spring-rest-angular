package com.taktazit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InfoController {
    @RequestMapping("/")
    public String info() {
        return "redirect:swagger-ui.html";
    }
}
