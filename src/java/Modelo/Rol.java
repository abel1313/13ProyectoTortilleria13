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
public class Rol 
{
   private int id_RolUduario;
   private String nombre_RolUsuario;
   private int activo_RolUsuario;
   private Estatus rolEstatus;
   private ArrayList<Integer> permisos;

    public Rol() {
        this.id_RolUduario = 0;
        this.nombre_RolUsuario = "";
        this.activo_RolUsuario = 0;
        this.rolEstatus = new Estatus();
        this.permisos = new ArrayList<>();
    }

    public Estatus getRolEstatus() {
        return rolEstatus;
    }

    public void setRolEstatus(Estatus rolEstatus) {
        this.rolEstatus = rolEstatus;
    }

    public int getId_RolUduario() {
        return id_RolUduario;
    }

    public void setId_RolUduario(int id_RolUduario) {
        this.id_RolUduario = id_RolUduario;
    }

    public String getNombre_RolUsuario() {
        return nombre_RolUsuario;
    }

    public void setNombre_RolUsuario(String nombre_RolUsuario) {
        this.nombre_RolUsuario = nombre_RolUsuario;
    }

    public int getActivo_RolUsuario() {
        return activo_RolUsuario;
    }

    public void setActivo_RolUsuario(int activo_RolUsuario) {
        this.activo_RolUsuario = activo_RolUsuario;
    }

    public ArrayList<Integer> getPermisos() {
        return permisos;
    }

    public void setPermisos(ArrayList<Integer> permisos) {
        this.permisos = permisos;
    }
   
   
}
