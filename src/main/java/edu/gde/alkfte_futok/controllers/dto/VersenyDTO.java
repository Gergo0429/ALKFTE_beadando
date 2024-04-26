package edu.gde.alkfte_futok.controllers.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VersenyDTO implements Serializable {
    @Column(nullable = false, length = 50)
    private String nev;

    @Column(nullable = false)
    @DecimalMin("0.05")
    @Max(value = 42)
    private Double tav;
}