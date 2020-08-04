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
public class Estatus 
{
    private int id_Estatus;
    private String nombre_Estatus;

    public Estatus() 
    {
        this.id_Estatus = 0;
        this.nombre_Estatus = "";
    }

    
    
    public int getId_Estatus() {
        return id_Estatus;
    }

    public void setId_Estatus(int id_Estatus) {
        this.id_Estatus = id_Estatus;
    }

    public String getNombre_Estatus() {
        return nombre_Estatus;
    }

    public void setNombre_Estatus(String nombre_Estatus) {
        this.nombre_Estatus = nombre_Estatus;
    }
    
    
}
