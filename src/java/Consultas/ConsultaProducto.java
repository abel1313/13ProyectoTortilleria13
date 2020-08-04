/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consultas;

import Modelo.ConexionDB;
import Modelo.DetalleVenta;
import Modelo.Producto;
import Modelo.Venta;
import ModeloDAO.ProductoDAO;
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
public class ConsultaProducto implements ProductoDAO {

    PreparedStatement ps = null;
    ResultSet rs = null;
    ConexionDB conDB = null;
    Connection conexion = null;

    @Override
    public ArrayList<Producto> mostrarUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Producto> buscar(int producto) {
        conDB = new ConexionDB();
        conexion = conDB.conexionDB();
        ArrayList<Producto> guardarProducto = new ArrayList<>();
        try {

            String sqlBuscarUnProducto = "SELECT id_Producto,nombre_Producto,descripcion_Producto,precio_Producto,existencias_Producto "
                    + "FROM Producto WHERE id_Producto = ? LIMIT 1";
            String sqlBuscarProducto = "SELECT id_Producto,nombre_Producto,descripcion_Producto,precio_Producto,existencias_Producto "
                    + "FROM Producto ORDER BY nombre_Producto";

            if (producto == 0) {
                ps = conexion.prepareStatement(sqlBuscarProducto);

            } //Antes estaba el if(producto != 0)
            else {

                ps = conexion.prepareStatement(sqlBuscarUnProducto);
                ps.setInt(1, producto);
            }

            rs = ps.executeQuery();
            while (rs != null && rs.next()) {
                Producto p = new Producto();

                p.setId_Producto(rs.getInt("id_Producto"));
                p.setNombre_Producto(rs.getString(2));
                p.setDescipcion_Producto(rs.getString(3));
                p.setPrecio_Producto(rs.getDouble(4));
                p.setExistencias_Producto(rs.getDouble(5));
                guardarProducto.add(p);
            }

        } catch (SQLException ex) {
            System.out.println("Errr " + ex.getMessage());
            Logger.getLogger(ConsultaProducto.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
                rs.close();
                conexion.close();
            } catch (SQLException ex) {
                System.out.println("cerro la conexion a DB COnsultar Producto " + ex.getMessage());
                Logger.getLogger(ConsultaUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return guardarProducto;
    }

    @Override
    public Producto mostrar() {
        Producto p = new Producto();
        try {
            String sqlBuscarUnProducto = "SELECT id_Producto,nombre_Producto,descripcion_Producto,precio_Producto,existencias_Producto "
                    + "FROM Producto WHERE id_Producto = ? LIMIT 1";
            ps = conexion.prepareStatement(sqlBuscarUnProducto);
            ps.setInt(1, 1);
            rs = ps.executeQuery();
            if (rs != null && rs.next()) {

                p.setId_Producto(rs.getInt(1));
                p.setNombre_Producto(rs.getString(2));
                p.setDescipcion_Producto(rs.getString(3));
                p.setPrecio_Producto(rs.getDouble(4));
                p.setExistencias_Producto(rs.getDouble(5));

            }

        } catch (SQLException ex) {
            Logger.getLogger(ConsultaProducto.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
                rs.close();
                conexion.close();
            } catch (SQLException ex) {
                System.out.println("cerro la conexion a DB COnsultar Producto " + ex.getMessage());
                Logger.getLogger(ConsultaUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return p;
    }

    @Override
    public Producto agregar(Producto agregar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Producto> buscarTodos(String buscar) {
         conDB = new ConexionDB();
        conexion = conDB.conexionDB();
        ArrayList<Producto> guardarProducto = new ArrayList<>();
        try {

            String sqlBuscarUnProducto = "SELECT id_Producto,nombre_Producto,descripcion_Producto,precio_Producto,existencias_Producto "
                    + "FROM Producto WHERE nombre_Producto LIKE ? ORDER BY nombre_Producto";
            String sqlBuscarProducto = "SELECT id_Producto,nombre_Producto,descripcion_Producto,precio_Producto,existencias_Producto "
                    + "FROM Producto ORDER BY nombre_Producto";

            if (buscar.equals("")) {
                ps = conexion.prepareStatement(sqlBuscarProducto);

            } //Antes estaba el if(producto != 0)
            else {

                ps = conexion.prepareStatement(sqlBuscarUnProducto);
                ps.setString(1, "%"+buscar+"%");
            }

            rs = ps.executeQuery();
            while (rs != null && rs.next()) {
                Producto p = new Producto();

                p.setId_Producto(rs.getInt("id_Producto"));
                p.setNombre_Producto(rs.getString(2));
                p.setDescipcion_Producto(rs.getString(3));
                p.setPrecio_Producto(rs.getDouble(4));
                p.setExistencias_Producto(rs.getDouble(5));
                guardarProducto.add(p);
            }

        } catch (SQLException ex) {
            System.out.println("Errr " + ex.getMessage());
            Logger.getLogger(ConsultaProducto.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
                rs.close();
                conexion.close();
            } catch (SQLException ex) {
                System.out.println("cerro la conexion a DB COnsultar Producto " + ex.getMessage());
                Logger.getLogger(ConsultaUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return guardarProducto;
    }

    @Override
    public boolean agregarDatos(Producto p) {
        try {
            conDB = new ConexionDB();
            conexion = conDB.conexionDB();
            String sqlAgregarPropducto = "INSERT INTO Producto(nombre_Producto,descripcion_Producto,"
                    + "precio_Producto,existencias_Producto)VALUE(?,?,?,?)";

            ps = conexion.prepareStatement(sqlAgregarPropducto);
            ps.setString(1, p.getNombre_Producto());
            ps.setString(2, p.getDescipcion_Producto());
            ps.setDouble(3, p.getPrecio_Producto());
            ps.setDouble(4, p.getExistencias_Producto());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("error agregar Producto Consultar Producto " + ex.getMessage());
            Logger.getLogger(ConsultaProducto.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            try {
                ps.close();

                conexion.close();
            } catch (SQLException ex) {
                System.out.println("cerro la conexion a DB COnsultar Producto " + ex.getMessage());
                Logger.getLogger(ConsultaUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public boolean actualizar(Producto p) {
       try {
            conDB = new ConexionDB();
            conexion = conDB.conexionDB();
            String sqlAgregarPropducto = "UPDATE Producto SET nombre_Producto = ?,descripcion_Producto = ?,"
                    + "precio_Producto = ?,existencias_Producto = ? WHERE id_Producto = ? ";

            
           
            ps = conexion.prepareStatement(sqlAgregarPropducto);
            ps.setString(1, p.getNombre_Producto());
            ps.setString(2, p.getDescipcion_Producto());
            ps.setDouble(3, p.getPrecio_Producto());
            ps.setDouble(4, p.getExistencias_Producto());
            ps.setInt(5, p.getId_Producto());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("error actualizar Producto Consultar Producto " + ex.getMessage());
            Logger.getLogger(ConsultaProducto.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            try {
                ps.close();

                conexion.close();
            } catch (SQLException ex) {
                System.out.println("cerro la conexion a DB COnsultar Producto " + ex.getMessage());
                Logger.getLogger(ConsultaUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
//    public double verificarExistencias(Venta venta, int indice, double cantidad)
//    {                DetalleVenta det = venta.getDetalleVenta().get(indice);
//        if (cantidad <= det.getProductoDetalle().getExistencias_Producto()) {
//            venta.setTotal_Venta(venta.getTotal_Venta()- det.getSubtotalDetalle());
//            det.setCantidad_ProductoDetalle(cantidad);
//            det.setSubtotalDetalle((det.getProductoDetalle().getPrecio_Producto()* cantidad ));
//            venta.setTotal_Venta(venta.getTotal_Venta()+ det.getSubtotalDetalle());
//        } else {
//            return det.getProductoDetalle().getExistencias_Producto();
//        }
//        return 0;
//    }

    @Override
    public boolean actualizarProductoSolo(Producto p) {
         try {
             
            conDB = new ConexionDB();
            conexion = conDB.conexionDB();
            String sqlActPropducto = "UPDATE Producto SET existencias_Producto = ? WHERE id_Producto = ? ";
            
            String sqlVerificarExistencias = "SELECT existencias_Producto \n" +
                                            "FROM Producto WHERE id_Producto = ?";
           ps = conexion.prepareStatement(sqlVerificarExistencias);
           ps.setInt(1, 1);
           rs = ps.executeQuery();
           if(rs.next() && rs !=null)    
           {
               
            ps = conexion.prepareStatement(sqlActPropducto);
            ps.setDouble(1, (rs.getDouble(1)+p.getExistencias_Producto()));
            ps.setInt(2, 1);
            ps.executeUpdate();
               
           }
            return true;
        } catch (SQLException ex) {
            System.out.println("error actualizar Producto Consultar Producto " + ex.getMessage());
            Logger.getLogger(ConsultaProducto.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            try {
                ps.close();

                conexion.close();
            } catch (SQLException ex) {
                System.out.println("cerro la conexion a DB COnsultar Producto " + ex.getMessage());
                Logger.getLogger(ConsultaUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
