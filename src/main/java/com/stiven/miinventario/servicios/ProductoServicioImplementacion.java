package com.stiven.miinventario.servicios;


import com.stiven.miinventario.entidades.Producto;
import com.stiven.miinventario.repositorios.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServicioImplementacion implements ProductoServicio {

    @Autowired

    private ProductoRepositorio repositorio;

    @Override
    @Transactional(readOnly = true)
    public List<Producto> findAll() {
        return (List<Producto>) repositorio.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Producto> findById(int id) {
        return repositorio.findById(id);
    }

    @Override
    @Transactional
    public Producto save(Producto producto) {
        Optional<Producto> existente = repositorio.findById(producto.getId());
        return existente.orElseGet(() -> repositorio.save(producto));
    }

    @Override
    @Transactional
    public Producto update(int id, Producto producto) {
        Optional<Producto> buscado = repositorio.findById(id);
        if (buscado.isPresent()){
            Producto actual = buscado.get();
            actual.setNombre(producto.getNombre());
            actual.setPrecio(producto.getPrecio());
            actual.setCategoria(producto.getCategoria());
            actual.setStock(producto.getStock());
            return repositorio.save(actual);

        }
        return null;

    }

    @Override
    @Transactional
    public Optional<Producto> delete(int id) {
        Optional<Producto> buscado = repositorio.findById(id);
        buscado.ifPresent(producto -> repositorio.delete(producto));
        return buscado;
    }
}