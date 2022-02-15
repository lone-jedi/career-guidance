package com.yarkin.careerguidance.web.home;

import com.yarkin.careerguidance.web.HomeController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DefaultHomeController implements HomeController {
    @RequestMapping("/")
    @Override
    public String getHomePage() {
        return "index";
    }
}
