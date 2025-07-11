package com.example.demo.DTO;

import com.example.demo.model.Pedido;
import com.example.demo.model.Producto;

import lombok.*;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetallePedidoDTO {
    private Long productoId;    // Entrada
    private Producto producto;    // Salida
    private int cantidad;
    private double subtotal;
    private Pedido pedido;
    
    public Long getProductoId() {
        return productoId;
    }

    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }
    
    public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public void setProductoNombre(String nombre) {
		this.producto = new Producto();
		this.producto.setNombre(nombre);
	}
}
