package com.stiven.miinventario.controladores;


import com.stiven.miinventario.entidades.DetallePedido;
import com.stiven.miinventario.servicios.DetallePedidoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
