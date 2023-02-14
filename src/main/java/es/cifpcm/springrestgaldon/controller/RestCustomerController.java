package es.cifpcm.springrestgaldon.controller;

import ch.qos.logback.core.net.server.Client;
import es.cifpcm.springrestgaldon.model.Customer;
import es.cifpcm.springrestgaldon.model.Producto;
import es.cifpcm.springrestgaldon.repository.clienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@org.springframework.web.bind.annotation.RestController
public class RestCustomerController {
    @Autowired
    clienteRepository clienteRepository;

    @GetMapping("/Customer")
    List<Customer> obtenerListaProducto(){
        return clienteRepository.findAll();
    }
    @GetMapping("/Customer/{id}")
    Customer obtenerProductoPorId(@PathVariable String id){
        return  clienteRepository.findById(Long.valueOf(id)).orElseThrow(()-> new CustomerNotFoundException(id));
    }

    @PostMapping("Customer/Crear")
    Customer crearProducto(@RequestBody Customer customer){
        return clienteRepository.save(customer);
    }
    @PutMapping("Customer/Editar/{id}")
    Customer actualizarProducto(@PathVariable String id,@RequestBody Customer customer){
        return clienteRepository.findById(Long.valueOf(id)).map(customerNuevo -> {
                    customerNuevo.setFirstName(customer.getFirstName());
                    customerNuevo.setEmail(customer.getEmail());
                    customerNuevo.setTelefono(customer.getEmail());
                    customerNuevo.setLastName(customer.getLastName());
                    customerNuevo.setFechaDeNacimiento(customer.getFechaDeNacimiento());
                    return clienteRepository.save(customerNuevo);
                })
                .orElseGet(() -> {
                    customer.setId(Integer.valueOf(id));
                    return clienteRepository.save(customer);
                });
    }
}
