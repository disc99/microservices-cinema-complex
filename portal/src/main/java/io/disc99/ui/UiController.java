package io.disc99.ui;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@EnableOAuth2Sso
public class UiController {

    @RequestMapping("/")
    String home(Principal user, Model model) {
        model.addAttribute("name", user.getName());
        return "index";
    }

}
