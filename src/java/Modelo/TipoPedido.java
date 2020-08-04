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
public class TipoPedido 
{
   private int id_TipoPedido;
   private String nombreTipoPedido;

    public TipoPedido() {
        this.id_TipoPedido = 0;
        this.nombreTipoPedido = "";
    }

    public int getId_TipoPedido() {
        return id_TipoPedido;
    }

    public void setId_TipoPedido(int id_TipoPedido) {
        this.id_TipoPedido = id_TipoPedido;
    }

    public String getNombreTipoPedido() {
        return nombreTipoPedido;
    }

    public void setNombreTipoPedido(String nombreTipoPedido) {
        this.nombreTipoPedido = nombreTipoPedido;
    }
   
   
   
}
