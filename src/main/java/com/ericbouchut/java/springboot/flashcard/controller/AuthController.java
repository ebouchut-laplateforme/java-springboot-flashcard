package com.ericbouchut.java.springboot.flashcard.controller;

import com.ericbouchut.java.springboot.flashcard.dto.SignupForm;
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

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //   Signup (User registration)
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

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
     * Process the user registration form.
     *
     * @param signupForm the submitted signup form object
     * @param result TODO: learn and digest
     * @param model the object used to exchange information with the signup form back and forth
     * @return the sign-in form if the signup has been successful or the signup form otherwise (for example of the form is not valid).
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

        // Create the user
        userService.processUserRegistrationForm(signupForm);

        // Redirect to the sign-in page after a successful registration (signup)
        return "redirect:signin";
    }

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //   Sign-in (User login)
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~

    // TODO: Display the signin form: Create REST endpoint: GET /signin

    // TODO: Process the signin form: Create REST endpoint: POST /signin
}
