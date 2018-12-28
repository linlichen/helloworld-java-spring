package com.linlichen.spring.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public void greeting(@RequestParam(name="locationName", required=false, defaultValue="World") String locationName, Model model) {
        model.addAttribute("locationName", locationName);
    }
}