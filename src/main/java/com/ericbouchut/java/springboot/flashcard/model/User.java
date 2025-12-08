package com.ericbouchut.java.springboot.flashcard.model;

import java.util.Set;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true) // Only consider the id attribute/field
@ToString
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ToString.Exclude
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @NotBlank
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    @NotBlank
    @Email
    private String email;

    @Column(name = "password", nullable = false)
    @NotBlank        // Required
    @Min(value = 6L) // Min length 6 characters
    @ToString.Exclude // toString() does NOT display the password
    private String password;

    @ManyToMany
    // TODO: Add annotations
    private Set<Link> links;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private UserAccount userAccount;
}

