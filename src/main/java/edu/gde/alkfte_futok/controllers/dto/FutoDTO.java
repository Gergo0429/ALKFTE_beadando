package edu.gde.alkfte_futok.controllers.dto;

import edu.gde.alkfte_futok.models.Eredmeny;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FutoDTO implements Serializable {
    @NotNull
    private String nev;

    @NotNull
    @Min(value = 12)
    @Max(value = 99)
    private Integer kor;

    private boolean nem;
    //false = ferfi
    //true = no
}