package com.stiven.miinventario.entidades;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpedidos")
    private int id;

    @ManyToOne
    @JoinColumn(name = "clientes_id")
    private Cliente cliente;

    @Column(name = "fecha_pedido")
    private LocalDateTime fechaPedido;

    @Column(name = "estado")
    @Enumerated(EnumType.STRING)
    private EstadoPedido estado;

    @OneToMany(mappedBy = "pedido")
    private List<DetallePedido> detalles;

    public enum EstadoPedido {
        Pendiente, Enviado, Entregado, Cancelado
    }

    public Pedido(){}

    public Pedido(int id, Cliente cliente, LocalDateTime fechaPedido, EstadoPedido estado, List<DetallePedido> detalles) {
        this.id = id;
        this.cliente = cliente;
        this.fechaPedido = fechaPedido;
        this.estado = estado;
        this.detalles = detalles;
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

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public List<DetallePedido> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetallePedido> detalles) {
        this.detalles = detalles;
    }
}

