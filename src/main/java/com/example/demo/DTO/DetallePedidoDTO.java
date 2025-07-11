package com.example.demo.DTO;

import com.example.demo.model.Pedido;
import com.example.demo.model.Producto;

import lombok.*;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetallePedidoDTO {
    private Long productoId;
    private String productoNombre;
    private double productoPrecio;
    private int cantidad;
    private double subtotal;

    public Long getProductoId() {
        return productoId;
    }

    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }

    public String getProductoNombre() {
        return productoNombre;
    }

    public void setProductoNombre(String productoNombre) {
        this.productoNombre = productoNombre;
    }

    public double getProductoPrecio() {
        return productoPrecio;
    }

    public void setProductoPrecio(double productoPrecio) {
        this.productoPrecio = productoPrecio;
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

}
