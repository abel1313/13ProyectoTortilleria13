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
public class Direccion 
{
   private int id_Direccion;
    private String pais_Direccion;        
    private String estado_Direccion;
    private String municipio_Direccion;
    private String calle_Direccion;
    private String colonia_Direccion;
    private String codigoPostal_Direccion;
    private String numeroExterior_Direccion;
    private String numeroInterior_Direccion;

    public Direccion() 
    {
        this.id_Direccion = 0;
        this.pais_Direccion = "";
        this.estado_Direccion = "";
        this.municipio_Direccion = "";
        this.calle_Direccion = "";
        this.colonia_Direccion = "";
        this.codigoPostal_Direccion = "";
        this.numeroExterior_Direccion = "";
        this.numeroInterior_Direccion = "";
    }

    public int getId_Direccion() {
        return id_Direccion;
    }

    public void setId_Direccion(int id_Direccion) {
        this.id_Direccion = id_Direccion;
    }

    public String getPais_Direccion() {
        return pais_Direccion;
    }

    public void setPais_Direccion(String pais_Direccion) {
        this.pais_Direccion = pais_Direccion;
    }

    public String getEstado_Direccion() {
        return estado_Direccion;
    }

    public void setEstado_Direccion(String estado_Direccion) {
        this.estado_Direccion = estado_Direccion;
    }

    public String getMunicipio_Direccion() {
        return municipio_Direccion;
    }

    public void setMunicipio_Direccion(String municipio_Direccion) {
        this.municipio_Direccion = municipio_Direccion;
    }

    public String getCalle_Direccion() {
        return calle_Direccion;
    }

    public void setCalle_Direccion(String calle_Direccion) {
        this.calle_Direccion = calle_Direccion;
    }

    public String getColonia_Direccion() {
        return colonia_Direccion;
    }

    public void setColonia_Direccion(String colonia_Direccion) {
        this.colonia_Direccion = colonia_Direccion;
    }

    public String getCodigoPostal_Direccion() {
        return codigoPostal_Direccion;
    }

    public void setCodigoPostal_Direccion(String codigoPostal_Direccion) {
        this.codigoPostal_Direccion = codigoPostal_Direccion;
    }

    public String getNumeroExterior_Direccion() {
        return numeroExterior_Direccion;
    }

    public void setNumeroExterior_Direccion(String numeroExterior_Direccion) {
        this.numeroExterior_Direccion = numeroExterior_Direccion;
    }

    public String getNumeroInterior_Direccion() {
        return numeroInterior_Direccion;
    }

    public void setNumeroInterior_Direccion(String numeroInterior_Direccion) {
        this.numeroInterior_Direccion = numeroInterior_Direccion;
    }
    
}
