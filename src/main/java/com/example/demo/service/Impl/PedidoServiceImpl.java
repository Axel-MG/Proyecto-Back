package com.example.demo.service.Impl;

import com.example.demo.DTO.DetallePedidoDTO;
import com.example.demo.DTO.PedidoDTO;
import com.example.demo.exception.CantidadProductoExcedida;
import com.example.demo.exception.GlobalException;
import com.example.demo.exception.ProductoSinStock;
import com.example.demo.exception.TotalMinimoNoAlcanzado;
import com.example.demo.model.Cliente;
import com.example.demo.model.DetallePedido;
import com.example.demo.model.Pedido;
import com.example.demo.model.Producto;
import com.example.demo.*;
import com.example.demo.repository.*;
import com.example.demo.service.PedidoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class PedidoServiceImpl implements PedidoService {

	@Autowired
	private ClienteRepository clienteRepo;

	@Autowired
	private ProductoRepository productoRepo;

	@Autowired
	private PedidoRepository pedidoRepo;

	@Override
	public PedidoDTO crearPedido(PedidoDTO dto) {
		Cliente cliente = clienteRepo.findById(dto.getclienteId())
				.orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

		Pedido pedido = new Pedido();
		pedido.setCliente(cliente);
		pedido.setFecha(LocalDate.now());

		List<DetallePedido> detalles = new ArrayList<>();
		double total = 0;

		for (DetallePedidoDTO d : dto.getProductos()) {
			Producto producto = productoRepo.findById(d.getProductoId())
					.orElseThrow(() -> new RuntimeException("Producto no encontrado"));

			if (d.getCantidad() > 5)
				throw new CantidadProductoExcedida(producto.getNombre());			

			if (producto.getStock() < d.getCantidad())
				throw new ProductoSinStock(producto.getNombre());

			double subtotal = producto.getPrecio() * d.getCantidad();
			total += subtotal;

			DetallePedido detalle = new DetallePedido();
			detalle.setProducto(producto);
			detalle.setCantidad(d.getCantidad());
			detalle.setSubtotal(subtotal);
			detalle.setPedido(pedido);
			detalles.add(detalle);

			producto.setStock(producto.getStock() - d.getCantidad());
		}

		if (total < 200)
			throw new TotalMinimoNoAlcanzado(); 

		pedido.setTotal(total);
		pedido.setProductos(detalles);

		Pedido guardado = pedidoRepo.save(pedido);

		return convertirAPedidoDTO(guardado);
	}

	@Override
	public List<PedidoDTO> listarPedidosPorCliente(Long clienteId) {
		List<Pedido> pedidos = pedidoRepo.findByClienteId(clienteId);
		List<PedidoDTO> resultado = new ArrayList<>();
		for (Pedido p : pedidos) {
			resultado.add(convertirAPedidoDTO(p));
		}
		return resultado;
	}

	@Override
	public PedidoDTO obtenerPedidoPorId(Long id) {
		Pedido pedido = pedidoRepo.findById(id).orElseThrow(() -> new RuntimeException("Pedido no encontrado"));
		return convertirAPedidoDTO(pedido);
	}

	private PedidoDTO convertirAPedidoDTO(Pedido pedido) {
	    PedidoDTO dto = new PedidoDTO();
	    dto.setId(pedido.getId());
	    dto.setClienteID(pedido.getCliente().getId());
	    dto.setFecha(pedido.getFecha());
	    dto.setTotal(pedido.getTotal());

	    List<DetallePedidoDTO> detalleDTOs = new ArrayList<>();
	    for (DetallePedido dp : pedido.getProductos()) {
	        DetallePedidoDTO d = new DetallePedidoDTO();
	        d.setProductoId(dp.getProducto().getId());
	        d.setProductoNombre(dp.getProducto().getNombre());
	        d.setProductoPrecio(dp.getProducto().getPrecio());
	        d.setCantidad(dp.getCantidad());
	        d.setSubtotal(dp.getSubtotal());
	        detalleDTOs.add(d);
	    }
	    dto.setProductos(detalleDTOs);
	    return dto;
	}

}

