package edu.gde.alkfte_futok.controllers.dto;

import edu.gde.alkfte_futok.models.Eredmeny;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FutoDTO implements Serializable {
    @Column(nullable = false, length = 50)
    private String nev;

    @Column(nullable = false)
    @Min(value = 12)
    @Max(value = 99)
    private Integer kor;

    @Column(nullable = false)
    private boolean nem;
    //false = ferfi
    //true = no
}