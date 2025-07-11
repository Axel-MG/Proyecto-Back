package com.example.demo.exception;

public class TotalMinimoNoAlcanzado extends RuntimeException{
	public TotalMinimoNoAlcanzado() {
        super("El total del pedido debe ser al menos $200.00");
    }
}
