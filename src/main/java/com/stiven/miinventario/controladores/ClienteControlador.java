package com.stiven.miinventario.controladores;


import com.stiven.miinventario.entidades.Cliente;
import com.stiven.miinventario.servicios.ClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/clientes")
public class ClienteControlador {

    @Autowired
    private ClienteServicio servicio;

    ///Proceso de Listar
    @GetMapping("/Listar")
    public ResponseEntity<List<Cliente>> ListarCliente(){
        List<Cliente> x=servicio.findAll();
        return ResponseEntity.ok(x);

    }

}
