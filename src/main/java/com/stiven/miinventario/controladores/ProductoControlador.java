package com.stiven.miinventario.controladores;


import com.stiven.miinventario.entidades.Producto;
import com.stiven.miinventario.servicios.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/productos")
public class ProductoControlador {


    @Autowired
    private ProductoServicio servicio;

    @GetMapping("/Listar")
    public ResponseEntity<List<Producto>> ListarProducto() {
        return ResponseEntity.ok(servicio.findAll());
    }


    @PostMapping("/guardar")
    public ResponseEntity<Producto> guardarProducto(@RequestBody Producto producto) {
        return ResponseEntity.ok(servicio.save(producto));
    }


    @PutMapping("/Actualizar/{id}")
    public ResponseEntity<Producto> ActualizarProducto(@PathVariable int id, @RequestBody Producto productoActualizado) {
        Optional<Producto> productoExistente = servicio.findById(id);
        if (productoExistente.isPresent()) {
            Producto producto = productoExistente.get();
            producto.setNombre(productoActualizado.getNombre());
            producto.setPrecio(productoActualizado.getPrecio());
            producto.setCategoria(productoActualizado.getCategoria());
            producto.setStock(productoActualizado.getStock());
            return ResponseEntity.ok(servicio.save(producto));
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/Eliminar/{id}")
    public ResponseEntity<Void> EliminarProducto(@PathVariable int id) {
        Optional<Producto> producto = servicio.findById(id);
        if (producto.isPresent()) {
            servicio.delete(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
