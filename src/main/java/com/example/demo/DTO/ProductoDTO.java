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

    @Min(value = 1)
    private double precio;
    @Min(value = 0)
    private int stock;
    
    public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	

}