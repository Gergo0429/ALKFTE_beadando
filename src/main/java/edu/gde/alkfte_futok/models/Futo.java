package edu.gde.alkfte_futok.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.Set;

@Data
@Entity
public class Futo {
    @Column(nullable = false, length = 50)
    private String nev;

    @Column(nullable = false)
    @Min(value = 12)
    @Max(value = 99)
    private Integer kor;

    @Column(nullable = false)
    private boolean nem;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long futoId;

    @OneToMany(mappedBy = "futo")
    private Set<Eredmeny> eredmenyek;
}