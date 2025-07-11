package com.example.demo.exception;


import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {
	@ExceptionHandler(ProductoSinStock.class)
	public ResponseEntity<Map<String, String>> handleProductoSinStock(ProductoSinStock ex) {
        return buildErrorResponse(ex.getMessage());
    }

    @ExceptionHandler(TotalMinimoNoAlcanzado.class)
    public ResponseEntity<Map<String, String>> handleTotalMinimo(TotalMinimoNoAlcanzado ex) {
        return buildErrorResponse(ex.getMessage());
    }

    @ExceptionHandler(CantidadProductoExcedida.class)
    public ResponseEntity<Map<String, String>> handleCantidadExcedida(CantidadProductoExcedida ex) {
        return buildErrorResponse(ex.getMessage());
    }

    private ResponseEntity<Map<String, String>> buildErrorResponse(String mensaje) {
        Map<String, String> errorBody = new HashMap<>();
        errorBody.put("error", mensaje);

        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Pedido-Creado", "false");
        headers.add("X-Fecha-Registro", LocalDate.now().toString());

        return new ResponseEntity<>(errorBody, headers, HttpStatus.BAD_REQUEST);
    }
}
