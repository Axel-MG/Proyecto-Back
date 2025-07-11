package com.example.demo.DTO;

import java.time.LocalDate;
import java.util.List;

import com.example.demo.model.Pedido;
import com.example.demo.model.Producto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class ClienteDTO {
	
    private Long id;
    @NotBlank
    @Size(min = 3)
    private String nombre;
    @Email
    @NotBlank
    private String correo;
    
    public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	 
}