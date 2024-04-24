package edu.gde.alkfte_futok.models;

import jakarta.persistence.*;
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


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
}
