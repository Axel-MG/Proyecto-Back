package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.PedidoDTO;
import com.example.demo.service.PedidoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/pedido")
@RequiredArgsConstructor

public class PedidoController {
	@Autowired
    private  PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<PedidoDTO> crearPedido(@RequestBody @Valid PedidoDTO pedidoDTO) {
        PedidoDTO nuevoPedido = pedidoService.crearPedido(pedidoDTO);

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Pedido-Creado", "true");
        headers.set("X-Fecha-Registro", nuevoPedido.getFecha().toString());
        return  ResponseEntity 
        		.status(HttpStatus.CREATED)
        		.headers(headers)
        		.body(nuevoPedido);
    }
    
    @GetMapping("/pedidosCliente/{id}")
    public ResponseEntity<List<PedidoDTO>> obtenerPedidosPorCliente(@PathVariable("id") Long clienteId) {
        return ResponseEntity.ok(pedidoService.listarPedidosPorCliente(clienteId));
    }

    @GetMapping("/pedido/{id}")
    public ResponseEntity<PedidoDTO> obtenerPedidoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(pedidoService.obtenerPedidoPorId(id));
    }
}
