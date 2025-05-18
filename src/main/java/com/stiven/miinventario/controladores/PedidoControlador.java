package com.stiven.miinventario.controladores;


import com.stiven.miinventario.entidades.Pedido;
import com.stiven.miinventario.servicios.PedidoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
