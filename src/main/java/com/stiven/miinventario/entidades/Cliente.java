package com.stiven.miinventario.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idclientes")
    private int id;

    @Column(name = "nombre_cliente")
    private String Nombre;

    @Column(name = "apellido_cliente")
    private String Apellido;

    @Column(name = "telefono_cliente")
    private String Telefono;


    @Column(name = "email_cliente")
    private String Email;

    @Column(name = "num_identificacion")
    private Long NumIdentificacion;

    public Cliente(){}


    public Cliente(int id, String nombre, String apellido, String telefono, String email, Long numIdentificacion) {
        this.id = id;
        Nombre = nombre;
        Apellido = apellido;
        Telefono = telefono;
        Email = email;
        NumIdentificacion = numIdentificacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Long getNumIdentificacion() {
        return NumIdentificacion;
    }

    public void setNumIdentificacion(Long numIdentificacion) {
        NumIdentificacion = numIdentificacion;
    }
}
