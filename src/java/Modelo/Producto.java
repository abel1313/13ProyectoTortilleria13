/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author trece
 */
public class Producto {
    private int id_Producto;
    private String nombre_Producto;
    private String descipcion_Producto;
    private double precio_Producto;
    private double existencias_Producto;

    public Producto() 
    {
        this.id_Producto = 0;
        this.nombre_Producto = "";
        this.descipcion_Producto = "";
        this.precio_Producto = 0;
        this.existencias_Producto = 0;
    }

    public int getId_Producto() {
        return id_Producto;
    }

    public void setId_Producto(int id_Producto) {
        this.id_Producto = id_Producto;
    }

    public String getNombre_Producto() {
        return nombre_Producto;
    }

    public void setNombre_Producto(String nombre_Producto) {
        this.nombre_Producto = nombre_Producto;
    }

    public String getDescipcion_Producto() {
        return descipcion_Producto;
    }

    public void setDescipcion_Producto(String descipcion_Producto) {
        this.descipcion_Producto = descipcion_Producto;
    }

    public double getPrecio_Producto() {
        return precio_Producto;
    }

    public void setPrecio_Producto(double precio_Producto) {
        this.precio_Producto = precio_Producto;
    }

    public double getExistencias_Producto() {
        return existencias_Producto;
    }

    public void setExistencias_Producto(double existencias_Producto) {
        this.existencias_Producto = existencias_Producto;
    }
    
    
    
}
