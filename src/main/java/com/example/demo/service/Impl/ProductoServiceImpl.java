package com.example.demo.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.ProductoDTO;
import com.example.demo.model.Producto;
import com.example.demo.repository.ProductoRepository;
import com.example.demo.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<ProductoDTO> listarProductos() {
        return productoRepository.findAll()
                .stream()
                .map(producto -> new ProductoDTO(
                        producto.getId(),
                        producto.getNombre(),
                        producto.getPrecio(),
                        producto.getStock(),
                        producto.getImagen() 
                ))
                .collect(Collectors.toList());
    }

    @Override
    public ProductoDTO guardarConValidacion(ProductoDTO dto) {
        if (dto.getNombre().toLowerCase().contains("gratis")) {
            throw new RuntimeException("No se puede guardar un producto con el nombre 'gratis'");
        }

        Producto producto = new Producto();
        producto.setNombre(dto.getNombre());
        producto.setPrecio(dto.getPrecio());
        producto.setStock(dto.getStock());
        producto.setImagen(dto.getImagen()); // ✅ imagen asignada

        Producto guardado = productoRepository.save(producto);

        return new ProductoDTO(
                guardado.getId(),
                guardado.getNombre(),
                guardado.getPrecio(),
                guardado.getStock(),
                guardado.getImagen() // ✅ imagen devuelta
        );
    }
    @Override
    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }

    @Override
    public ProductoDTO actualizarProducto(Long id, ProductoDTO dto) {
        Producto producto = productoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        producto.setNombre(dto.getNombre());
        producto.setPrecio(dto.getPrecio());
        producto.setStock(dto.getStock());
        producto.setImagen(dto.getImagen());

        Producto actualizado = productoRepository.save(producto);

        return new ProductoDTO(
            actualizado.getId(),
            actualizado.getNombre(),
            actualizado.getPrecio(),
            actualizado.getStock(),
            actualizado.getImagen()
        );
    }

    @Override
    public ProductoDTO obtenerProductoPorId(Long id) {
        Producto producto = productoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        return new ProductoDTO(
            producto.getId(),
            producto.getNombre(),
            producto.getPrecio(),
            producto.getStock(),
            producto.getImagen()
        );
    }

}
