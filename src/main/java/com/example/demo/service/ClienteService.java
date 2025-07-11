package com.example.demo.service;

import java.util.List;

import com.example.demo.DTO.ClienteDTO;

public interface ClienteService {
    public ClienteDTO crearCliente(ClienteDTO clienteDTO);
    public List<ClienteDTO> listarClientes();
}
