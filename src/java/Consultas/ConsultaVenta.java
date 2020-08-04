/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consultas;

import Modelo.ConexionDB;
import Modelo.DetalleVenta;
import Modelo.Venta;
import ModeloDAO.VentaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author trece
 */
public class ConsultaVenta implements VentaDAO{
    PreparedStatement ps = null;
    ResultSet rs = null;
     ConexionDB conDB = null;
    Connection conexion = null; 
    @Override
    public ArrayList mostrarUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList buscar(int Producto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Venta mostrar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Venta agregar(Venta agregar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Venta> buscarTodos(String buscar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean agregarDatos(Venta t) {
        try {
            conDB = new ConexionDB();
            conexion = conDB.conexionDB();
            String sqlAgregarVenta = "INSERT INTO Venta(fecha_Venta,hora_Venta,total_Venta,id_UsuarioFK,id_ClienteFK,id_TipoPedidoFK )\n" +
                    "VALUES(CURDATE(),CURTIME(),?,?,?,?)";
            
            String sqlAsignarEmpleado = "INSERT INTO VentaEntregada(id_VentaFK,id_EmpleadoFK)VALUES(?,?)";
            
            String sqlAgregarDetalleVenta = "INSERT INTO DetalleVenta(cantidad_Producto,subTotal,id_VentaFK,"
                            + "id_ProductoFK)VALUES(?,?,?,?)";
            String sqlAgregarDetalleVentaDomicilio = "INSERT INTO DetalleEnvioDireccion(id_ProductoFK,"
                    + "id_VentaFK,cantidad_DetalleDomicilio,subtotal_DetalleDomicilio)VALUES(?,?,?,?)";
            
            System.out.println("id venta Clase "+ t.getClienteVenta().getId_Cliente());
            ps = conexion.prepareStatement(sqlAgregarVenta);
            ps.setDouble(1, t.getTotal_Venta());
            ps.setInt(2, t.getUsuarioVenta().getId_Usuario());
            ps.setInt(3, t.getClienteVenta().getId_Cliente());
            ps.setInt(4, t.getTipoPedidoVenta().getId_TipoPedido());
            ps.executeUpdate();
            
            ps = conexion.prepareStatement("select last_insert_id() as idVenta");
            rs = ps.executeQuery();
            if (rs != null && rs.next()) 
            {
                t.setId_Venta(Integer.parseInt(rs.getString("idVenta")));
            }
            
            
            if(t.getTipoPedidoVenta().getId_TipoPedido() == 1)
            {
                for(int i = 0 ; i < t.getDetalleVenta().size(); i++)
                {
                    DetalleVenta d = t.getDetalleVenta().get(i);
                    ps = conexion.prepareStatement(sqlAgregarDetalleVenta);
                    ps.setDouble(1, d.getCantidad_ProductoDetalle());
                    ps.setDouble(2, d.getSubtotalDetalle());
                    ps.setInt(3, t.getId_Venta());
                    ps.setInt(4, d.getProductoDetalle().getId_Producto());
                    ps.executeUpdate();
                    
                }
            }
            
            if(t.getTipoPedidoVenta().getId_TipoPedido() == 2)
            {
                for(int i = 0 ; i < t.getDetalleVenta().size(); i++)
                {
                    DetalleVenta d = t.getDetalleVenta().get(i);
                    ps = conexion.prepareStatement(sqlAgregarDetalleVentaDomicilio);
                    ps.setInt(1, d.getProductoDetalle().getId_Producto());
                    ps.setInt(2, t.getId_Venta());
                    ps.setDouble(3, d.getCantidad_ProductoDetalle());
                    ps.setDouble(4, d.getSubtotalDetalle());
                    ps.executeUpdate();
                    
                }
                
                ps= conexion.prepareStatement(sqlAsignarEmpleado);
                
                ps.setInt(1, t.getId_Venta());
                ps.setInt(2, 1);
                
                ps.executeUpdate();
            }
            
            return true;
            
            
            
        } catch (SQLException ex) {
            
            System.out.println("Error agregar Venta y Detalle COntrol Venta "+ ex.getMessage());
            
            Logger.getLogger(ConsultaVenta.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally
        {
            try {
                ps.close();
                rs.close();
                conexion.close();
            } catch (SQLException ex) {
                System.out.println("cerro la conexion a DB COnsultar Venta " + ex.getMessage());
                Logger.getLogger(ConsultaUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
      
    }
    
     @Override
    public boolean agregarDatos(Venta t,int idDireccion) {
        try {

            conDB = new ConexionDB();
            conexion = conDB.conexionDB();
            String sqlAgregarVenta = "INSERT INTO Venta(fecha_Venta,hora_Venta,total_Venta,id_UsuarioFK,id_ClienteFK,id_TipoPedidoFK )\n" +
                    "VALUES(CURDATE(),CURTIME(),?,?,?,?)";
            
            String sqlAsignarEmpleado = "INSERT INTO VentaEntregada(id_VentaFK,id_EmpleadoFK)VALUES(?,?)";

            String sqlAgregarDetalleVentaDomicilio = "INSERT INTO DetalleEnvioDireccion(id_ProductoFK,"
                    + "id_VentaFK,cantidad_DetalleDomicilio,subtotal_DetalleDomicilio)VALUES(?,?,?,?)";
            
            String sqlAgregarDireccionDiferente = "INSERT INTO DiferenteDireccionCliente"
                    + "(id_DireccionFK,id_VentaFK,id_EstatusEnvioDomicilioFK)VALUES(?,?,?)";
            
            ps = conexion.prepareStatement(sqlAgregarVenta);
            ps.setDouble(1, t.getTotal_Venta());
            ps.setInt(2, t.getUsuarioVenta().getId_Usuario());
            ps.setInt(3, t.getClienteVenta().getId_Cliente());
            ps.setInt(4, t.getTipoPedidoVenta().getId_TipoPedido());
            ps.executeUpdate();
            
            ps = conexion.prepareStatement("select last_insert_id() as idVenta");
            rs = ps.executeQuery();
            if (rs != null && rs.next()) 
            {
                t.setId_Venta(Integer.parseInt(rs.getString("idVenta")));
            }
            if(idDireccion != 0)
            {
                ps = conexion.prepareStatement(sqlAgregarDireccionDiferente);
                ps.setInt(1, idDireccion);
                ps.setInt(2, t.getId_Venta());
                ps.setInt(3, 3);
                ps.executeUpdate();

            }
            for (int i = 0; i < t.getDetalleVenta().size(); i++) {
                DetalleVenta d = t.getDetalleVenta().get(i);
                ps = conexion.prepareStatement(sqlAgregarDetalleVentaDomicilio);
                ps.setInt(1, d.getProductoDetalle().getId_Producto());
                ps.setInt(2, t.getId_Venta());
                ps.setDouble(3, d.getCantidad_ProductoDetalle());
                ps.setDouble(4, d.getSubtotalDetalle());
                ps.executeUpdate();

            }
            ps = conexion.prepareStatement(sqlAsignarEmpleado);

            ps.setInt(1, t.getId_Venta());
            ps.setInt(2, 1);
            ps.executeUpdate();

 
            
            
            return true;
            
            
            
        } catch (SQLException ex) {
            
            System.out.println("Error agregar Venta y Detalle COntrol Venta "+ ex.getMessage());
            
            Logger.getLogger(ConsultaVenta.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally
        {
            try {
                ps.close();
                rs.close();
                conexion.close();
            } catch (SQLException ex) {
                System.out.println("cerro la conexion a DB COnsultar Venta " + ex.getMessage());
                Logger.getLogger(ConsultaUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
      
    }
    
    @Override
    public boolean actualizar(Venta actualizar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean agregarPedidoTortilleria(Venta t) {
         try {

            conDB = new ConexionDB();
            conexion = conDB.conexionDB();
            String sqlAgregarVenta = "INSERT INTO Venta(fecha_Venta,hora_Venta,total_Venta,id_UsuarioFK,id_ClienteFK,id_TipoPedidoFK )\n" +
                    "VALUES(CURDATE(),CURTIME(),?,?,?,?)";
            
            String sqlAsignarEmpleado = "INSERT INTO VentaEntregada"
                    + "(id_VentaFK,id_EmpleadoFK,id_EstatusDomicilioFK)VALUES(?,?,?)";

            String sqlAgregarDetalleVentaDomicilio = "INSERT INTO DetalleEnvioDireccion(id_ProductoFK,"
                    + "id_VentaFK,cantidad_DetalleDomicilio,subtotal_DetalleDomicilio)VALUES(?,?,?,?)";
 
            ps = conexion.prepareStatement(sqlAgregarVenta);
            ps.setDouble(1, t.getTotal_Venta());
            ps.setInt(2, t.getUsuarioVenta().getId_Usuario());
            ps.setInt(3, t.getClienteVenta().getId_Cliente());
            ps.setInt(4, t.getTipoPedidoVenta().getId_TipoPedido());
            ps.executeUpdate();
            
            ps = conexion.prepareStatement("select last_insert_id() as idVenta");
            rs = ps.executeQuery();
            if (rs != null && rs.next()) 
            {
                t.setId_Venta(Integer.parseInt(rs.getString("idVenta")));
            }
 
            for (int i = 0; i < t.getDetalleVenta().size(); i++) {
                DetalleVenta d = t.getDetalleVenta().get(i);
                ps = conexion.prepareStatement(sqlAgregarDetalleVentaDomicilio);
                ps.setInt(1, d.getProductoDetalle().getId_Producto());
                ps.setInt(2, t.getId_Venta());
                ps.setDouble(3, d.getCantidad_ProductoDetalle());
                ps.setDouble(4, d.getSubtotalDetalle());
                ps.executeUpdate();

            }
            ps = conexion.prepareStatement(sqlAsignarEmpleado);

            ps.setInt(1, t.getId_Venta());
            ps.setInt(2, 1);
            ps.setInt(3, 3);
            ps.executeUpdate();

            return true;
            
            
            
        } catch (SQLException ex) {
            
            System.out.println("Error agregar Venta y Detalle COntrol Venta "+ ex.getMessage());
            
            Logger.getLogger(ConsultaVenta.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally
        {
            try {
                ps.close();
                rs.close();
                conexion.close();
            } catch (SQLException ex) {
                System.out.println("cerro la conexion a DB COnsultar Venta " + ex.getMessage());
                Logger.getLogger(ConsultaUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
}
