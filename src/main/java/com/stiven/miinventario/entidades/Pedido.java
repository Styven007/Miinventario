package com.stiven.miinventario.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "pedidos")
public class Pedido {
    private int id;
    private Cliente cliente;
    private LocalDateTime fechaPedido;
    private String estado;

    public Pedido(){}

    public Pedido(int id, Cliente cliente, LocalDateTime fechaPedido, String estado) {
        this.id = id;
        this.cliente = cliente;
        this.fechaPedido = fechaPedido;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDateTime getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDateTime fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
