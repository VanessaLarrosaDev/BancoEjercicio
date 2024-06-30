/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BancoClases;

import java.util.Date;

/**
 *
 * @author vanessa
 */
public class Transaccion {

    private int id;
    private Date fecha;
    private double monto;
    private String descripcion;
    private CuentaBancaria cuentaBancaria;

    public Transaccion(int id, Date fecha, double monto, String descripcion, CuentaBancaria cuentaBancaria) {
        this.id = id;
        this.fecha = fecha;
        this.monto = monto;
        this.descripcion = descripcion;
        this.cuentaBancaria = cuentaBancaria;
    }


    // getters
    public int getId() {
        return id;
    }

    public Date getFecha() {
        return fecha;
    }

    public double getMonto() {
        return monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public CuentaBancaria getCuentaBancaria() {
        return cuentaBancaria;
    }

    // setters
    public void setId(int id) {
        this.id = id;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCuentaBancaria(CuentaBancaria cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }

    @Override
    public String toString() {
        return "Transaccion{"
                + "id=" + id
                + ", fecha=" + fecha
                + ", monto=" + monto
                + ", descripcion='" + descripcion + '\''
                + ", cuentaBancaria=" + cuentaBancaria
                + '}';
    }

    //Métodos 
    public String getTipoTransaccion() {
        return descripcion;
    }

    public double getMontoAbsoluto() {
        return Math.abs(monto);
    }
    
    

}
