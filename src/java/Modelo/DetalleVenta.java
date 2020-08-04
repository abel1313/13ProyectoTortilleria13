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
public class DetalleVenta 
{
   private int id_DetalleVenta;
   private double cantidad_ProductoDetalle;
   private double subtotalDetalle;
   private Producto productoDetalle; 

    public DetalleVenta() 
    {
        this.id_DetalleVenta = 0;
        this.cantidad_ProductoDetalle = 0;
        this.subtotalDetalle = 0;
        this.productoDetalle = new Producto();
    }

    public int getId_DetalleVenta() {
        return id_DetalleVenta;
    }

    public void setId_DetalleVenta(int id_DetalleVenta) {
        this.id_DetalleVenta = id_DetalleVenta;
    }

    public double getCantidad_ProductoDetalle() {
        return cantidad_ProductoDetalle;
    }

    public void setCantidad_ProductoDetalle(double cantidad_ProductoDetalle) {
        this.cantidad_ProductoDetalle = cantidad_ProductoDetalle;
    }

    public double getSubtotalDetalle() {
        return subtotalDetalle;
    }

    public void setSubtotalDetalle(double subtotalDetalle) {
        this.subtotalDetalle = subtotalDetalle;
    }

    public Producto getProductoDetalle() {
        return productoDetalle;
    }

    public void setProductoDetalle(Producto productoDetalle) {
        this.productoDetalle = productoDetalle;
    }
   
   
}
