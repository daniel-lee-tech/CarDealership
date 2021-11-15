package org.danlee.cardealership.controllers;

import org.danlee.cardealership.datatransfers.UserRegistrationDTO;
import org.danlee.cardealership.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;
import java.util.Set;

@Controller
public class AuthController {

    @GetMapping("/signup")
    public String signupPage(Model model) {
        model.addAttribute("user", new UserRegistrationDTO());
        return "signup.html";
    }

    @PostMapping("/signup")
    public String handleSignup(
            @ModelAttribute("user") @Valid UserRegistrationDTO userRegistrationDTO,
            BindingResult bindingResult
    ) {

        if (bindingResult.hasErrors()) return "/signup.html";

        try {
            User newUser = User
        }


        return "redirect:/home";
    }
}
