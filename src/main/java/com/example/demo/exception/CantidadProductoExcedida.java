package com.example.demo.exception;

public class CantidadProductoExcedida extends RuntimeException{
	public CantidadProductoExcedida(String nombreProducto) {
        super("No se puede pedir más de 5 unidades del producto: " + nombreProducto);
    }
}
