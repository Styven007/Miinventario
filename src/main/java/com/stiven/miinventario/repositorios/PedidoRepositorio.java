package com.stiven.miinventario.repositorios;

import com.stiven.miinventario.entidades.Pedido;
import org.springframework.data.repository.CrudRepository;

public interface PedidoRepositorio extends CrudRepository<Pedido, Integer> {
}
