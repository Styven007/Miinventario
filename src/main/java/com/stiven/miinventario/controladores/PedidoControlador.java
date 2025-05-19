package com.stiven.miinventario.controladores;


import com.stiven.miinventario.entidades.Pedido;
import com.stiven.miinventario.servicios.PedidoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    /// Proceso de guardar
    @PostMapping("/Guardar")
    public ResponseEntity<Pedido> GuardarPedido(@RequestBody Pedido pedido) {
        Pedido nuevoPedido = servicio.save(pedido);
        return ResponseEntity.ok(nuevoPedido);
    }
}
