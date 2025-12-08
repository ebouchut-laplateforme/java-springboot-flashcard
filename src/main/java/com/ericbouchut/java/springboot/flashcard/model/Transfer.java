package com.ericbouchut.java.springboot.flashcard.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "transfer")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true) // Only consider the id attribute/field
@ToString
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    private Instant date;

    @ManyToOne
    private User from;

    @ManyToOne
    private User to;

    // TODO: Validate the amounts: @Positive
    private Double amountBeforeFee;

    private Double amountAfterFee;
}
