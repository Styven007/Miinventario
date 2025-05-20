package com.stiven.miinventario.controladores;


import com.stiven.miinventario.entidades.Cliente;
import com.stiven.miinventario.servicios.ClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/clientes")
public class ClienteControlador {

    //En algunos archivos de la linea Cliente se usa una variable intermedia "x", en los demas elegí no hacerlo.


    @Autowired
    private ClienteServicio servicio;

    /// Proceso de Listar
    @GetMapping("/Listar")
    public ResponseEntity<List<Cliente>> ListarCliente() {
        List<Cliente> x = servicio.findAll();
        return ResponseEntity.ok(x);

    }

    /// Proceso de Guardar
    @PostMapping("/Guardar")
    public ResponseEntity<Cliente> guardarCliente(@RequestBody Cliente cliente) {
        Cliente nuevoCliente = servicio.save(cliente);
        return ResponseEntity.ok(nuevoCliente);
    }

    /// Proceso de Actualizar
    @PutMapping("/Actualizar/{id}")
    public ResponseEntity<Cliente> ActualizarCliente(@PathVariable int id, @RequestBody Cliente clienteActualizado) {
        Optional<Cliente> clienteExistente = servicio.findById(id);
        if (clienteExistente.isPresent()) {
            Cliente cliente = clienteExistente.get();
            cliente.setNombre(clienteActualizado.getNombre());
            cliente.setApellido(clienteActualizado.getApellido());
            cliente.setTelefono(clienteActualizado.getTelefono());
            cliente.setEmail(clienteActualizado.getEmail());
            cliente.setNumIdentificacion(clienteActualizado.getNumIdentificacion());
            return ResponseEntity.ok(servicio.save(cliente));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /// Proceso de Eliminar
    @DeleteMapping("/Eliminar/{id}")
    public ResponseEntity<Void> EliminarCliente(@PathVariable int id) {
        Optional<Cliente> cliente = servicio.findById(id);
        if (cliente.isPresent()) {
            servicio.delete(id);
            return ResponseEntity.noContent().build(); // es 204
        } else {
            return ResponseEntity.notFound().build(); // es 404
        }

    }
}

