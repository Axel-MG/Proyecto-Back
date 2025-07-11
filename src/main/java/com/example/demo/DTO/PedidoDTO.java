package com.example.demo.DTO;

import java.time.LocalDate;
import java.util.List;

import com.example.demo.model.Cliente;
import com.example.demo.model.DetallePedido;
import com.example.demo.model.Pedido;
import com.example.demo.model.Producto;

import lombok.*;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class PedidoDTO {            
	private Long clienteId;   
    private LocalDate fecha;        
    private double total;
    private List<DetallePedidoDTO> productos;
    public Long getclienteId() {
		return clienteId;
	}

	public void setClienteID(Long clienteID) {
		this.clienteId = clienteID;
	}


	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}


	public List<DetallePedidoDTO> getProductos() {
		return productos;
	}

	public void setProductos(List<DetallePedidoDTO> productos) {
		this.productos = productos;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	

	
}
