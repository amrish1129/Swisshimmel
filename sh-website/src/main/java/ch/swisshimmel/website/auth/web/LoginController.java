package ch.swisshimmel.website.auth.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }
    
    @RequestMapping({ "/signup", "/about", "/policies" })
    public String unprotectedUris() {
        return "unprotected";
    }
    
    @RequestMapping({ "/secure/*" })
    public String securePage() {
        return "secure";
    }
    
    @RequestMapping({ "/secure/home" })
    public String homePage() {
        return "home";
    }
    
    @RequestMapping({ "/admin/*" })
    public String adminPage() {
        return "admin";
    }
    
}
