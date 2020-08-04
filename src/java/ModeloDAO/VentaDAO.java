/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import MCRUD.CRUD;
import Modelo.Venta;

/**
 *
 * @author trece
 */
public interface VentaDAO extends CRUD<Venta>{
    public boolean agregarDatos(Venta t,int id);
    public boolean agregarPedidoTortilleria(Venta v);
}
