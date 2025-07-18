package com.example.demo.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.ClienteDTO;
import com.example.demo.DTO.ProductoDTO;
import com.example.demo.model.Cliente;
import com.example.demo.model.Producto;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.service.ClienteService;
@Service
public class ClienteServiceImpl implements ClienteService{
	@Autowired
	private ClienteRepository clienteRepository;
	@Override
	public ClienteDTO crearCliente(ClienteDTO clienteDTO) {
		// TODO Auto-generated method stub
		Cliente cliente = new Cliente();
        cliente.setNombre(clienteDTO.getNombre());
        cliente.setCorreo(clienteDTO.getCorreo());
        Cliente guardado = clienteRepository.save(cliente);

		return new ClienteDTO(
	            guardado.getId(),
	            guardado.getNombre(),
	            guardado.getCorreo()
	            
	        );
	}

	@Override
	public List<ClienteDTO> listarClientes() {
		// TODO Auto-generated method stub
		return clienteRepository.findAll()
                .stream()
                .map(c -> new ClienteDTO(
                    c.getId(),
                    c.getNombre(),
                    c.getCorreo()
                ))
                .collect(Collectors.toList());
	}

	
	@Override
	public ClienteDTO actualizarCliente(Long id, ClienteDTO dto) {
		// TODO Auto-generated method stub
		Cliente cliente = clienteRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
		cliente.setNombre(dto.getNombre());
		cliente.setCorreo(dto.getCorreo());
		
		Cliente clienteNuevo = clienteRepository.save(cliente);
		
		return new ClienteDTO(
				clienteNuevo.getId(),
				clienteNuevo.getNombre(),
				clienteNuevo.getCorreo()
				);
	}

	@Override
	public void eliminarCliente(Long id) {
		// TODO Auto-generated method stub
		clienteRepository.deleteById(id);
	}

	@Override
	public ClienteDTO obtenerClientePorId(Long id) {
		// TODO Auto-generated method stub
		 Cliente cliente = clienteRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

	        return new ClienteDTO(
	                cliente.getId(),
	                cliente.getNombre(),
	                cliente.getCorreo()
	        );	}

}
