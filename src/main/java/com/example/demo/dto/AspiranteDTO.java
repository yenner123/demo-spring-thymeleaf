package com.example.demo.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AspiranteDTO {
    private Long id;
    @NotBlank
    private String tipoDocumento;
    @NotBlank
    private String documento;
    @NotBlank
    private String nombres;
    @NotBlank
    private String apellidos;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @NotNull
    private String fechaNacimiento;
    @NotBlank
    private String cargo;
    @NotNull
    private Long municipioId;
}
