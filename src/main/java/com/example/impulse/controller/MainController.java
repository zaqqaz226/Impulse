package com.example.impulse.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
public class MainController {

    @GetMapping("/unsecured")
    public String homePage() {
        return "what are you doing heere?";
    }

    @GetMapping("/authenticated")
    public String authenticatedPage() {

        return "authenticated page";
    }

    @GetMapping("/admin")
    public String adminPage(Principal principal) {

        return principal.getName();
    }

}
