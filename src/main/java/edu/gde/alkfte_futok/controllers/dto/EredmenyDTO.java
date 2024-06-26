package edu.gde.alkfte_futok.controllers.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

//getRaceRunners válaszhoz

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EredmenyDTO implements Serializable {
    @NotNull
    private String nev;

    @Positive
    private double ido;
}