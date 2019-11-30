package com.ccanto.zenklub;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @CrossOrigin
    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("appName", "Zenklub");
        return "index";
    }
}
