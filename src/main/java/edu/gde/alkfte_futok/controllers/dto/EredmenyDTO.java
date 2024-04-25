package edu.gde.alkfte_futok.controllers.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.DecimalMin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EredmenyDTO implements Serializable {
    @Column(nullable = false, length = 50)
    private String nev;

    @DecimalMin(value = "0.0")
    private double ido;
}