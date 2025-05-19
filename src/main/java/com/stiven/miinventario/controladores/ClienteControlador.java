package com.stiven.miinventario.controladores;


import com.stiven.miinventario.entidades.Cliente;
import com.stiven.miinventario.servicios.ClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/clientes")
public class ClienteControlador {

    //En algunos archivos de la linea Cliente se usa una variable intermedia "x", en los demas elegí no hacerlo.


    @Autowired
    private ClienteServicio servicio;

    ///Proceso de Listar
    @GetMapping("/Listar")
    public ResponseEntity<List<Cliente>> ListarCliente(){
        List<Cliente> x=servicio.findAll();
        return ResponseEntity.ok(x);

    }
    /// Proceso de Guardar
    @PostMapping("/Guardar")
    public ResponseEntity<Cliente> guardarCliente(@RequestBody Cliente cliente) {
        Cliente nuevoCliente = servicio.save(cliente);
        return ResponseEntity.ok(nuevoCliente);
    }

}
