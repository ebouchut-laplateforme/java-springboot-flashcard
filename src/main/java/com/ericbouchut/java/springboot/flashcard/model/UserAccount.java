package com.ericbouchut.java.springboot.flashcard.model;

import jakarta.persistence.*;
import lombok.*;

/**
 * An entity with additional account information associated to a user.
 */
@Entity
@Table(name = "user_account")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true) // Only consider the id attribute/field
@ToString
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;



}
