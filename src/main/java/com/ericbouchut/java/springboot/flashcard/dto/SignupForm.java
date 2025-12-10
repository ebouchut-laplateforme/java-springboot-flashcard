package com.ericbouchut.java.springboot.flashcard.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The form Object (technically a Request DTO)
 * that holds the signup form fields.
 * <p>
 * Cannot use a Java record here because a SignupForm is mutable.
 */
@Data
@NoArgsConstructor
public class SignupForm {
    @NotBlank(message = "Email is required")
    @Email(message = "Please provide a valid email address")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password;
}
