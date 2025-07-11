package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.ClienteDTO;
import com.example.demo.service.ClienteService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/cliente")

public class ClienteController {

	@Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<ClienteDTO> crearCliente(@RequestBody @Valid ClienteDTO clienteDTO) {
        ClienteDTO nuevoCliente = clienteService.crearCliente(clienteDTO);
        return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(nuevoCliente);
    }

    @GetMapping("/listarClientes")
    public ResponseEntity<List<ClienteDTO>> listarClientes() {
    	List<ClienteDTO> listaClientes = clienteService.listarClientes();
    	if(listaClientes.isEmpty()) {
    		return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(listaClientes);
    }
}
