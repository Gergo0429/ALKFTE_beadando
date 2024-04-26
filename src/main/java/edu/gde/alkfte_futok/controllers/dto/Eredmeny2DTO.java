package edu.gde.alkfte_futok.controllers.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

//addResult kéréshez

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Eredmeny2DTO implements Serializable {
    @NotNull
    private long futoID;

    @NotNull
    private long versenyID;

    @Positive
    private double ido;
}