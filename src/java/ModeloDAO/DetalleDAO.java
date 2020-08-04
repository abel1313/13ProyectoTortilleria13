/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import MCRUD.CRUD;
import Modelo.DetalleVenta;
import Modelo.Venta;

/**
 *
 * @author trece
 */
public interface DetalleDAO extends CRUD<DetalleVenta> {
    public Venta agregarDetalle(Venta venta,DetalleVenta detalle);
}
