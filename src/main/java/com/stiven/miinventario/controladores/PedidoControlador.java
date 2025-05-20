package com.stiven.miinventario.controladores;


import com.stiven.miinventario.entidades.Pedido;
import com.stiven.miinventario.servicios.PedidoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/pedidos")
public class PedidoControlador {

    @Autowired
    private PedidoServicio servicio;

    @GetMapping("/Listar")
    public ResponseEntity<List<Pedido>> ListarPedidos() {
        return ResponseEntity.ok(servicio.findAll());

    }

    @PostMapping("/Guardar")
    public ResponseEntity<Pedido> GuardarPedido(@RequestBody Pedido pedido) {
        Pedido nuevoPedido = servicio.save(pedido);
        return ResponseEntity.ok(nuevoPedido);
    }


    @PutMapping("/Actualizar/{id}")
    public ResponseEntity<Pedido> ActualizarPedido(@PathVariable int id, @RequestBody Pedido pedidoActualizado) {
        Optional<Pedido> pedidoExistente = servicio.findById(id);
        if (pedidoExistente.isPresent()) {
            Pedido pedido = pedidoExistente.get();
            pedido.setCliente(pedidoActualizado.getCliente());
            pedido.setFechaPedido(pedidoActualizado.getFechaPedido());
            pedido.setEstado(pedidoActualizado.getEstado());
            pedido.setDetalles(pedidoActualizado.getDetalles());
            return ResponseEntity.ok(servicio.save(pedido));
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/Eliminar/{id}")
    public ResponseEntity<Void> EliminarPedido(@PathVariable int id) {
        Optional<Pedido> pedido = servicio.findById(id);
        if (pedido.isPresent()) {
            servicio.delete(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
