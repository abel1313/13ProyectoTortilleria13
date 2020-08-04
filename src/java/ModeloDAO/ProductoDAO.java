/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import MCRUD.CRUD;
import Modelo.Producto;

/**
 *
 * @author trece
 */
public interface ProductoDAO extends CRUD<Producto> {
    public boolean actualizarProductoSolo(Producto producto);
}
