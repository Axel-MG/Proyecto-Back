package com.example.demo.exception;

public class ProductoSinStock extends RuntimeException{
	public ProductoSinStock(String nombreProducto) {
        super("No hay suficiente stock para el producto: " + nombreProducto);
    }
}
