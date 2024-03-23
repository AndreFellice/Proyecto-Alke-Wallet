/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.alkewallet;

import java.util.Date;

/**
 *
 * @author andre
 */
public class Transaccion extends BilleteraDigital {

    private Date fecha;
    private String descripcion;

    public Transaccion(Date fecha, String descripcion) {
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

    // Getters y setters (si es necesario)
    public Date getFecha() {
        return fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
