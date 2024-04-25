package edu.gde.alkfte_futok.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import lombok.*;

@Entity
@Data
public class Eredmeny {
    @ManyToOne
    @JoinColumn(name = "versenyId")
    private Verseny verseny;

    @ManyToOne
    @JoinColumn(name = "futoId")
    private Futo futo;

    @DecimalMin(value = "0.0")
    private double ido;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
}
