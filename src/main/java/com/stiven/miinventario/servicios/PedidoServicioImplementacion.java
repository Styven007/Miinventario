package com.stiven.miinventario.servicios;


import com.stiven.miinventario.entidades.Pedido;
import com.stiven.miinventario.repositorios.PedidoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoServicioImplementacion implements PedidoServicio {

    @Autowired
    private PedidoRepositorio repositorio;

    @Override
    @Transactional(readOnly = true)
    public List<Pedido> findAll() {
        return (List<Pedido>) repositorio.findAll();

    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Pedido> findById(int id) {
        return repositorio.findById(id);

    }

    @Override
    @Transactional
    public Pedido save(Pedido pedido) {
        Optional<Pedido> existente = repositorio.findById(pedido.getId());
        if (existente.isPresent()) {
            return existente.get();
        }
        return repositorio.save(pedido);

    }

    @Override
    @Transactional
    public Pedido update(int id, Pedido pedido) {
        Optional<Pedido> buscado = repositorio.findById(id);
        if (buscado.isPresent()) {
            Pedido actual = buscado.get();
            actual.setCliente(pedido.getCliente());
            actual.setFechaPedido(pedido.getFechaPedido());
            actual.setEstado(pedido.getEstado());
            actual.setDetalles(pedido.getDetalles());
            return repositorio.save(actual);

        }
        return null;
    }

    @Override
    @Transactional
    public Optional<Pedido> delete(int id) {
        Optional<Pedido> buscado = repositorio.findById(id);
        if (buscado.isPresent()) {
            repositorio.delete(buscado.get());
        } else {
            System.out.println("Pedido no encontrado.");
        }
        return buscado;
    }
}
