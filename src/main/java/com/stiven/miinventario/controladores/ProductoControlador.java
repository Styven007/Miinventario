package com.stiven.miinventario.controladores;


import com.stiven.miinventario.entidades.Producto;
import com.stiven.miinventario.servicios.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    // Proceso de Guardar
    @PostMapping("/guardar")
    public ResponseEntity<Producto> guardarProducto(@RequestBody Producto producto) {
        return ResponseEntity.ok(servicio.save(producto));
    }
}
