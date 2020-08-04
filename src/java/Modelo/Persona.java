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
public class Persona 
{
    private int id_Persona;
    private String nombre_Persona;
    private String paterno_Persona;
    private String materno_Persona;       
    private String fechaNacimiento_Persona;
    private String sexo_Persona;
    private String telefono_Persona;
    private String correo_Persona;
    Direccion direccionPersona;

    public Persona() 
    {
        this.id_Persona = 0;
        this.nombre_Persona = "";
        this.paterno_Persona = "";
        this.materno_Persona = "";
        this.fechaNacimiento_Persona = "";
        this.sexo_Persona = "";
        this.telefono_Persona = "";
        this.correo_Persona = "";
        this.direccionPersona = new Direccion();
    }

    public int getId_Persona() {
        return id_Persona;
    }

    public void setId_Persona(int id_Persona) {
        this.id_Persona = id_Persona;
    }

    public String getNombre_Persona() {
        return nombre_Persona;
    }

    public void setNombre_Persona(String nombre_Persona) {
        this.nombre_Persona = nombre_Persona;
    }

    public String getPaterno_Persona() {
        return paterno_Persona;
    }

    public void setPaterno_Persona(String paterno_Persona) {
        this.paterno_Persona = paterno_Persona;
    }

    public String getMaterno_Persona() {
        return materno_Persona;
    }

    public void setMaterno_Persona(String materno_Persona) {
        this.materno_Persona = materno_Persona;
    }

    public String getFechaNacimiento_Persona() {
        return fechaNacimiento_Persona;
    }

    public void setFechaNacimiento_Persona(String fechaNacimiento_Persona) {
        this.fechaNacimiento_Persona = fechaNacimiento_Persona;
    }

    public String getSexo_Persona() {
        return sexo_Persona;
    }

    public void setSexo_Persona(String sexo_Persona) {
        this.sexo_Persona = sexo_Persona;
    }

    public String getTelefono_Persona() {
        return telefono_Persona;
    }

    public void setTelefono_Persona(String telefono_Persona) {
        this.telefono_Persona = telefono_Persona;
    }

    public String getCorreo_Persona() {
        return correo_Persona;
    }

    public void setCorreo_Persona(String correo_Persona) {
        this.correo_Persona = correo_Persona;
    }

    public Direccion getDireccionPersona() {
        return direccionPersona;
    }

    public void setDireccionPersona(Direccion direccionPersona) {
        this.direccionPersona = direccionPersona;
    }
    
    
}
