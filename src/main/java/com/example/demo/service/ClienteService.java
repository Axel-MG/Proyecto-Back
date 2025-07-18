package com.example.demo.service;

import java.util.List;

import com.example.demo.DTO.ClienteDTO;
import com.example.demo.DTO.ProductoDTO;

public interface ClienteService {
    public ClienteDTO crearCliente(ClienteDTO clienteDTO);
    public List<ClienteDTO> listarClientes();
    public ClienteDTO actualizarCliente(Long id, ClienteDTO dto);
    public void eliminarCliente(Long id);
    public ClienteDTO obtenerClientePorId(Long id);
    }


