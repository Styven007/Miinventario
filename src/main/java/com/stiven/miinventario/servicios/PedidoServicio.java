package com.stiven.miinventario.servicios;

import com.stiven.miinventario.entidades.Pedido;

import java.util.List;
import java.util.Optional;

public interface PedidoServicio {
    List<Pedido> findAll();
    Optional<Pedido> findById(int id);
    Pedido save(Pedido pedido);
    Pedido update(int id, Pedido pedido);
    Optional<Pedido> delete(int id);
}
