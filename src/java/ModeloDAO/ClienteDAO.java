/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import MCRUD.CRUD;
import Modelo.Cliente;
import Modelo.Direccion;

/**
 *
 * @author trece
 */
public interface ClienteDAO extends CRUD<Cliente>{
    public Direccion agregarDireccion (Direccion d);
    public boolean validarCorreoActualizar(String correo,int idUsu);
}
