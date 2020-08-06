/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import MCRUD.CRUD;
import Modelo.Empleado;
/**
 *
 * @author elver
 */
public interface EmpleadoDAO extends CRUD <Empleado> {
    public boolean agregarEmpleado(Empleado e);
    
}
