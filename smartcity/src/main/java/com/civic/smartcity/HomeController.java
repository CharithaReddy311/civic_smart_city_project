package com.civic.smartcity;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HomeController {

    @GetMapping("/dashboard")
    public String dashboard() {
        return "Welcome to Secure Dashboard";
    }
}