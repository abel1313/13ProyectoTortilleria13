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
public class Menu {
    private int id_Menu;
    private String nombre_Menu;
    private int activo_Menu; 

    public Menu() 
    {
        this.id_Menu = 0;
        this.nombre_Menu = "";
        this.activo_Menu = 0;
    }

    public int getId_Menu() {
        return id_Menu;
    }

    public void setId_Menu(int id_Menu) {
        this.id_Menu = id_Menu;
    }

    public String getNombre_Menu() {
        return nombre_Menu;
    }

    public void setNombre_Menu(String nombre_Menu) {
        this.nombre_Menu = nombre_Menu;
    }

    public int getActivo_Menu() {
        return activo_Menu;
    }

    public void setActivo_Menu(int activo_Menu) {
        this.activo_Menu = activo_Menu;
    }

}
