package com.ericbouchut.java.springboot.flashcard.controller;

import com.ericbouchut.java.springboot.flashcard.dto.request.SignupForm;
import com.ericbouchut.java.springboot.flashcard.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * This controller is in charge of displaying and handling the submission of
 * the user signup (user registration) and sign-in (login) forms.
 */
@Controller
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //   Signup
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~

    /**
     * Display the user registration form.
     *
     * @return the signup template path
     */
    @GetMapping("/signup")
    public String showUserRegistrationForm(Model model) {
        model.addAttribute("signupForm", new SignupForm());
        return "signup";
    }

    /**
     * Process the user registration form submission
     * (aka. user registration).
     *
     * @param signupForm the submitted signup form
     * @return
     */
    @PostMapping("/signup")
    public String processUserRegistrationForm(
            @Valid @ModelAttribute("signupForm") SignupForm signupForm,
            BindingResult result,
            Model model
    ) {
        if (result.hasErrors()) {
            return "signup";  // Re-display signup form with errors
        }

        userService.processUserRegistrationForm(signupForm);

        // Redirect to the sign-in page after a successful registration (signup)
        return "redirect:signin";
    }

}
