package com.reto01.simulador.entity;

import com.reto01.simulador.constants.Constants;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Entity
@Table(name="Simulacion")
public class Simulacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long simulacionId;
    @Column(name="dni")
    private String dni;
    @Column(name="tipo_tarjeta")
    private String tipoTarjeta;
    @Column(name="moneda")
    private String moneda;
    @Column(name="monto")
    private double monto;
    @Column(name="cantidad_cuotas")
    private Integer cantidadCuotas;
    @Column(name="tea")
    private double tea;
    @Column(name="dia_pago")
    private Integer diaPago;

    @Column(name="fecha_creacion")
    private LocalDateTime fechaCreacion;
    @Column(name="estado")
    private String estado;
    @Column(name="monto_cuota")
    private double montoCuota;

    @Column(name="fecha_primera_cuota")
    private LocalDateTime fechaPrimeraCuota;

//    @Column(name="usuario_id")
//    private Long usuarioId;
//    @Column(name="tipo_tarjeta_id")
//    private Long tipoTarjetaId;

    @Column(name="observaciones")
    private String observaciones;

    @Column(name="is_active")
    private Boolean activo;


    public Simulacion() {
    }

    public Simulacion(String dni, String tipoTarjeta, String moneda, double monto, Integer cantidadCuotas, double tea, Integer diaPago) {
        this.dni = dni;
        this.tipoTarjeta = tipoTarjeta;
        this.moneda = moneda;
        this.monto = monto;
        this.cantidadCuotas = cantidadCuotas;
        this.tea = tea;
        this.diaPago = diaPago;
    }

    public Long getSimulacionId() {
        return simulacionId;
    }

    public void setSimulacionId(Long simulacionId) {
        this.simulacionId = simulacionId;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(String tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Integer getCantidadCuotas() {
        return cantidadCuotas;
    }

    public void setCantidadCuotas(Integer cantidadCuotas) {
        this.cantidadCuotas = cantidadCuotas;
    }

    public double getTea() {
        return tea;
    }

    public void setTea(double tea) {
        this.tea = tea;
    }

    public Integer getDiaPago() {
        return diaPago;
    }

    public void setDiaPago(Integer diaPago) {
        this.diaPago = diaPago;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getMontoCuota() {
        return montoCuota;
    }

    public void setMontoCuota(double montoCuota) {
        this.montoCuota = montoCuota;
    }

    public LocalDateTime getFechaPrimeraCuota() {
        return fechaPrimeraCuota;
    }

    public void setFechaPrimeraCuota(LocalDateTime fechaPrimeraCuota) {
        this.fechaPrimeraCuota = fechaPrimeraCuota;
    }

//    public Long getUsuarioId() {
//        return usuarioId;
//    }
//
//    public void setUsuarioId(Long usuarioId) {
//        this.usuarioId = usuarioId;
//    }
//
//    public Long getTipoTarjetaId() {
//        return tipoTarjetaId;
//    }
//
//    public void setTipoTarjetaId(Long tipoTarjetaId) {
//        this.tipoTarjetaId = tipoTarjetaId;
//    }

    public String getObservaciones() { return observaciones; }

    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public void calcularCuota() {
//        Calculo de Tasa Efectiva Mensual (TEM)
        double tem = Math.pow(1 + this.tea/100, (double) 30/360) - 1;
//        Calculo del Factor de Recuperacion de Capital (FRC)
        double frc = (tem * Math.pow(1 + tem, this.cantidadCuotas)) / (Math.pow(1 + tem, this.cantidadCuotas) - 1);
//        Calculo de la cuota
        this.montoCuota = this.monto * frc;
    }

    public void calcularFechaPrimeraCuota() {
        LocalDateTime fechaActual = LocalDateTime.now();
        StringBuilder str = new StringBuilder(fechaActual.toString());

        str.setCharAt(10, ' ');
        if (diaPago < 10) {
            str.setCharAt(8, '0');
            str.setCharAt(9, diaPago.toString().charAt(0));
        }
        else {
            str.setCharAt(8, diaPago.toString().charAt(0));
            str.setCharAt(9, diaPago.toString().charAt(1));
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime fechaCuota = LocalDateTime.parse(str.delete(19, 26).toString(), formatter);

        this.fechaPrimeraCuota = fechaCuota;

        if (fechaActual.getDayOfMonth() >= this.diaPago)
            this.fechaPrimeraCuota = fechaCuota.plusMonths(1);

    }
}
