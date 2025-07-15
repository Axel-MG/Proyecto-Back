package com.example.demo.service;

import java.util.List;

import com.example.demo.DTO.ProductoDTO;

public interface ProductoService {
   public  List<ProductoDTO> listarProductos();
   public ProductoDTO guardarConValidacion(ProductoDTO dto);
   void eliminarProducto(Long id);
   ProductoDTO actualizarProducto(Long id, ProductoDTO dto);
   ProductoDTO obtenerProductoPorId(Long id);
}

 