package com.stiven.miinventario.servicios;


import com.stiven.miinventario.entidades.DetallePedido;
import com.stiven.miinventario.repositorios.DetallePedidoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DetallePedidoServicioImplementacion implements DetallePedidoServicio {

    @Autowired
    private DetallePedidoRepositorio repositorio;


    @Override
    @Transactional(readOnly = true)
    public List<DetallePedido> findAll() {
        return (List<DetallePedido>) repositorio.findAll();

    }

    @Override
    @Transactional(readOnly = true)
    public Optional<DetallePedido> findById(int id) {
        return repositorio.findById(id);

    }

    @Override
    @Transactional
    public DetallePedido save(DetallePedido detalle) {
        Optional<DetallePedido> existente = repositorio.findById(detalle.getId());
        if (existente.isPresent()) {
            return existente.get();
        }
        return repositorio.save(detalle);
    }

    @Override
    @Transactional
    public DetallePedido update(int id, DetallePedido detalle) {
        Optional<DetallePedido> buscado = repositorio.findById(id);
        if (buscado.isPresent()) {
            DetallePedido actual = buscado.get();
            actual.setPedido(detalle.getPedido());
            actual.setProducto(detalle.getProducto());
            actual.setCantidad(detalle.getCantidad());
            return repositorio.save(actual);
        }
        return null;
    }

    @Override
    @Transactional
    public Optional<DetallePedido> delete(int id) {
        Optional<DetallePedido> buscado = repositorio.findById(id);
        if (buscado.isPresent()) {
            repositorio.delete(buscado.get());
        } else {
            System.out.println("Detalle de pedido no encontrado");
        }
        return buscado;
    }
}
