package com.stiven.miinventario.servicios;

import com.stiven.miinventario.entidades.DetallePedido;

import java.util.List;
import java.util.Optional;

public interface DetallePedidoServicio {
    List<DetallePedido> findAll();
    Optional<DetallePedido> findById(int id);
    DetallePedido save(DetallePedido detalle);
    DetallePedido update(int id, DetallePedido detalle);
    Optional<DetallePedido> delete(int id);
}
