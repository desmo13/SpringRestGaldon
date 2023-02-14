package es.cifpcm.springrestgaldon.controller;


import es.cifpcm.springrestgaldon.model.Producto;
import es.cifpcm.springrestgaldon.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
    ProductRepository productRepository;

    @GetMapping("/Producto")
    List<Producto> obtenerListaProducto(){
        return productRepository.findAll();
    }
    @GetMapping("/Producto/{id}")
   Producto obtenerProductoPorId(@PathVariable String id){
        return  productRepository.findById(Long.valueOf(id)).orElseThrow(()-> new ProductNotFoundException(id));
    }

    @PostMapping("/Crear")
    Producto crearProducto(@RequestBody Producto producto){
        return productRepository.save(producto);
    }
    @PutMapping("/Editar/{id}")
    Producto actualizarProducto(@PathVariable String id,@RequestBody Producto producto){
        return productRepository.findById(Long.valueOf(id)).map(productoNuevo -> {
            productoNuevo.setProductName(producto.getProductName());
            productoNuevo.setIdMunicipio(producto.getIdMunicipio());
            productoNuevo.setProductPicture(producto.getProductPicture());
            productoNuevo.setProductPrice(producto.getProductPrice());
            return productRepository.save(productoNuevo);
        })
                .orElseGet(() -> {
                    producto.setId(Integer.valueOf(id));
                    return productRepository.save(producto);
                });
    }

}
