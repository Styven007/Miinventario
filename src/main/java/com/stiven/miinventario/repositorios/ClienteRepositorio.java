package com.stiven.miinventario.repositorios;

import com.stiven.miinventario.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepositorio extends CrudRepository<Cliente, Integer>{

}

