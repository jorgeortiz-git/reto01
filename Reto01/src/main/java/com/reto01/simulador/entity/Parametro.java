package com.reto01.simulador.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Parametro")
public class Parametro {

    @Id
    private Long parametroId;
    @Column(name="nombre")
    private String nombre;
    @Column(name="valor")
    private String valor;
    @Column(name="is_active")
    private Boolean activo;

    public Parametro() {
    }

    public Parametro(Long parametroId, String nombre, String valor) {
        this.parametroId = parametroId;
        this.nombre = nombre;
        this.valor = valor;
    }

    public Long getParametroId() {
        return parametroId;
    }

    public void setParametroId(Long parametroId) {
        this.parametroId = parametroId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}
