package com.stiven.miinventario.servicios;

import com.stiven.miinventario.entidades.Cliente;
import com.stiven.miinventario.repositorios.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServicioImplementacion implements ClienteServicio {


    @Autowired

    private ClienteRepositorio repositorio;

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> findAll() {
        return (List<Cliente>) repositorio.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Cliente> findById(int id) {
        return repositorio.findById(id);
    }

    @Override
    @Transactional
    public Cliente save(Cliente x) {
        Optional<Cliente> respuesta = repositorio.findById(x.getId());
        if(respuesta.isPresent()){
            return respuesta.get();
        }
        return repositorio.save(x);
    }

    @Override
    @Transactional
    public Cliente update(int id, Cliente x) {
        Optional<Cliente> elemento_buscado=repositorio.findById(id);
        Cliente respuesta;
        if(elemento_buscado.isPresent()){
            respuesta = elemento_buscado.get();
            respuesta.setNombre(x.getNombre());
            respuesta.setApellido(x.getApellido());
            respuesta.setTelefono(x.getTelefono());
            respuesta.setEmail(x.getEmail());
            respuesta.setNumIdentificacion(x.getNumIdentificacion());
            return repositorio.save(respuesta);

        }
        return null;

    }

    @Override
    public Optional<Cliente> delete(int id) {
        Optional<Cliente> buscado = findById(id);
        if (buscado.isPresent()){
            repositorio.delete(buscado.get());
        }
        else {
            System.out.println("Usuario no existe... ");
        }
        return buscado;

    }
}
