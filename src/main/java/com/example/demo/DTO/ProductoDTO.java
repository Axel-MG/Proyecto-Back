package com.example.demo.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ProductoDTO {
    private Long id;

    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    private String imagen;

    @Min(value = 1)
    private double precio;

    @Min(value = 0)
    private int stock;

    // Constructor adicional manual (si usas new ProductoDTO(...))
    public ProductoDTO(Long id, String nombre, double precio, int stock, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.imagen = imagen;
    }
}
