/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;



import MCRUD.CRUD;
import Modelo.Usuario;



/**
 *
 * @author trece
 */
public interface UsuarioDAO extends CRUD <Usuario>{
    
    public Usuario accederUsuario(String user, String contra,String correo);
    public boolean agregarUsuario(Usuario usr);
    public boolean validarUsuario(String usr);
    public boolean validarUserName(String usr,int id);
    public boolean validarCorreoActualizar(String correo,int idUsu);
    
}
