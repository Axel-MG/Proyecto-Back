package com.example.demo.service;

import java.util.List;

import com.example.demo.DTO.PedidoDTO;


public interface PedidoService {
    public PedidoDTO crearPedido(PedidoDTO pedidoDTO);
    public List<PedidoDTO> listarPedidosPorCliente(Long clienteId);
    public PedidoDTO obtenerPedidoPorId(Long id);
}
