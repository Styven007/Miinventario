package com.stiven.miinventario.controladores;


import com.stiven.miinventario.entidades.DetallePedido;
import com.stiven.miinventario.servicios.DetallePedidoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/detallepedidos")
public class DetallePedidoControlador {

    @Autowired
    private DetallePedidoServicio servicio;

    @GetMapping("/Listar")
    public ResponseEntity<List<DetallePedido>> listarDetalles() {
        return ResponseEntity.ok(servicio.findAll());

    }


    @PostMapping("/Guardar")
    public ResponseEntity<DetallePedido> GuardarDetalle(@RequestBody DetallePedido detalle) {
        DetallePedido nuevoDetalle = servicio.save(detalle);
        return ResponseEntity.ok(nuevoDetalle);
    }


    @PutMapping("/Actualizar/{id}")
    public ResponseEntity<DetallePedido> ActualizarDetalle(@PathVariable int id, @RequestBody DetallePedido detalleActualizado) {
        Optional<DetallePedido> detalleExistente = servicio.findById(id);
        if (detalleExistente.isPresent()) {
            DetallePedido detalle = detalleExistente.get();
            detalle.setPedido(detalleActualizado.getPedido());
            detalle.setProducto(detalleActualizado.getProducto());
            detalle.setCantidad(detalleActualizado.getCantidad());
            return ResponseEntity.ok(servicio.save(detalle));
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/Eliminar/{id}")
    public ResponseEntity<Void> EliminarDetalle(@PathVariable int id) {
        Optional<DetallePedido> detalle = servicio.findById(id);
        if (detalle.isPresent()) {
            servicio.delete(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
