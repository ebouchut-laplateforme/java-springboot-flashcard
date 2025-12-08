package com.ericbouchut.java.springboot.flashcard.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table("link")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true) // Only consider the id attribute
@ToString
public class Link {
    @Id  // Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto increment
    @EqualsAndHashCode.Include
    private Integer id;

    @ManyToOne
    private User user1;

    @ManyToOne
    private User user2;
}
