/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;



/**
 *
 * @author trece
 */
public class Venta 
{
 private int id_Venta;
    private double total_Venta;
    private Usuario usuarioVenta;
    private Cliente clienteVenta;
    private TipoPedido tipoPedidoVenta;
    private ArrayList<DetalleVenta>detalleVenta;
    public Venta() 
    {
        this.id_Venta = 0;
        this.total_Venta = 0;
        this.usuarioVenta = new Usuario();
        this.clienteVenta = new Cliente();
        this.tipoPedidoVenta = new TipoPedido();
        this.detalleVenta = new ArrayList<>();
    }

    public Usuario getUsuarioVenta() {
        return usuarioVenta;
    }

    public void setUsuarioVenta(Usuario usuarioVenta) {
        this.usuarioVenta = usuarioVenta;
    }
    
    public ArrayList<DetalleVenta> getDetalleVenta() {
        return detalleVenta;
    }

    public void setDetalleVenta(ArrayList<DetalleVenta> detalleVenta) {
        this.detalleVenta = detalleVenta;
    }

    public int getId_Venta() {
        return id_Venta;
    }

    public void setId_Venta(int id_Venta) {
        this.id_Venta = id_Venta;
    }

    public double getTotal_Venta() {
        return total_Venta;
    }

    public void setTotal_Venta(double total_Venta) {
        this.total_Venta = total_Venta;
    }

    public Cliente getClienteVenta() {
        return clienteVenta;
    }

    public void setClienteVenta(Cliente clienteVenta) {
        this.clienteVenta = clienteVenta;
    }

    public TipoPedido getTipoPedidoVenta() {
        return tipoPedidoVenta;
    }

    public void setTipoPedidoVenta(TipoPedido tipoPedidoVenta) {
        this.tipoPedidoVenta = tipoPedidoVenta;
    }
}
