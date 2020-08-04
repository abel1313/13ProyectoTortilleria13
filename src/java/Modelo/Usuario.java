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
public class Usuario 
{
    private int id_Usuario;
    private String userName;
    private String contra;
    
    private Rol rolUsuario;
    private Persona personaUsuario;
    private Estatus estatusUsuario;
    private Cliente clienteUsuario;
    public Usuario() 
    {
        this.id_Usuario = 0;
        this.userName = "";
        this.contra = "";
        
        this.rolUsuario = new Rol();
        this.personaUsuario = new Persona();
        this.estatusUsuario = new Estatus();
        this.clienteUsuario = new Cliente();
    }

    public Cliente getClienteUsuario() {
        return clienteUsuario;
    }

    public void setClienteUsuario(Cliente clienteUsuario) {
        this.clienteUsuario = clienteUsuario;
    }

    
    public int getId_Usuario() {
        return id_Usuario;
    }

    public void setId_Usuario(int id_Usuario) {
        this.id_Usuario = id_Usuario;
    }

    
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public Rol getRolUsuario() {
        return rolUsuario;
    }

    public void setRolUsuario(Rol rolUsuario) {
        this.rolUsuario = rolUsuario;
    }

    public Persona getPersonaUsuario() {
        return personaUsuario;
    }

    public void setPersonaUsuario(Persona personaUsuario) {
        this.personaUsuario = personaUsuario;
    }

    public Estatus getEstatusUsuario() {
        return estatusUsuario;
    }

    public void setEstatusUsuario(Estatus estatusUsuario) {
        this.estatusUsuario = estatusUsuario;
    }
    
    
    
}
