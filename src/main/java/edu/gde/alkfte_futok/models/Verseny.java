package edu.gde.alkfte_futok.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.Set;

@Data
@Entity
public class Verseny {
    @Column(nullable = false, length = 50)
    private String nev;

    @Column(nullable = false)
    @DecimalMin("0.05")
    @Max(value = 42)
    private Double tav;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long versenyId;
}
