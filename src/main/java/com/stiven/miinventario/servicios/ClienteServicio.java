package com.stiven.miinventario.servicios;

import com.stiven.miinventario.entidades.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteServicio {
    List<Cliente> findAll();
    Optional<Cliente> findById(int id);
    Cliente save(Cliente x);
    Cliente update(int id, Cliente x);
    Optional<Cliente> delete(int id);


}
