package com.stiven.miinventario.servicios;

import com.stiven.miinventario.entidades.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoServicio {
    List<Producto> findAll();
    Optional<Producto> findById(int id);
    Producto save(Producto producto);
    Producto update(int id, Producto producto);
    Optional<Producto> delete(int id);
}
