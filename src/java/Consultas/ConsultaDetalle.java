/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consultas;

import Modelo.DetalleVenta;
import Modelo.Venta;
import ModeloDAO.DetalleDAO;
import java.util.ArrayList;

/**
 *
 * @author trece
 */
public class ConsultaDetalle implements DetalleDAO{

    @Override
    public ArrayList<DetalleVenta> mostrarUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<DetalleVenta> buscar(int Producto) {
throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DetalleVenta mostrar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DetalleVenta agregar(DetalleVenta agregar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<DetalleVenta> buscarTodos(String buscar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public double agregarDetalleExistencias(Venta venta, DetalleVenta detalle){
            int existe = 0;
        int siHay =0;
        
        for (int i = 0; i < venta.getDetalleVenta().size(); i++) {
            DetalleVenta det = venta.getDetalleVenta().get(i);
            System.out.println("Venta "+ det.getCantidad_ProductoDetalle());
            
            
            
            if (detalle.getProductoDetalle().getId_Producto()== det.getProductoDetalle().getId_Producto()) {
                System.out.println("cueta "+ (det.getCantidad_ProductoDetalle()+detalle.getCantidad_ProductoDetalle()) );
                if((det.getCantidad_ProductoDetalle()+detalle.getCantidad_ProductoDetalle()) <= det.getProductoDetalle().getExistencias_Producto() ){
                if(det.getCantidad_ProductoDetalle() < det.getProductoDetalle().getExistencias_Producto()){
                    
                det.setCantidad_ProductoDetalle(det.getCantidad_ProductoDetalle()+ detalle.getCantidad_ProductoDetalle());
                det.setSubtotalDetalle(det.getSubtotalDetalle()+ (det.getProductoDetalle().getPrecio_Producto()*detalle.getCantidad_ProductoDetalle() ));
                i = venta.getDetalleVenta().size();
                existe = 1;
                }else{
                    siHay = 1;
                    return det.getProductoDetalle().getExistencias_Producto();
                }
                }else{
                        siHay = 1;
                    return det.getProductoDetalle().getExistencias_Producto();
             
                }
                
            }
        }
        if (existe == 0) {
            
            if(detalle.getCantidad_ProductoDetalle() > detalle.getProductoDetalle().getExistencias_Producto()){
                
                return detalle.getProductoDetalle().getExistencias_Producto();
            }else{
            
            venta.getDetalleVenta().add(detalle);
                
            }
            }
        if(siHay == 0)
        {
        venta.setTotal_Venta(venta.getTotal_Venta()+ detalle.getSubtotalDetalle());
        }
        
        return 0;
    }
    @Override
    public Venta agregarDetalle(Venta venta, DetalleVenta detalle) {
        int existe = 0;
        for (int i = 0; i < venta.getDetalleVenta().size(); i++) {
            DetalleVenta det = venta.getDetalleVenta().get(i);
            
            if (detalle.getProductoDetalle().getId_Producto()== det.getProductoDetalle().getId_Producto()) {

                det.setCantidad_ProductoDetalle(det.getCantidad_ProductoDetalle()+ detalle.getCantidad_ProductoDetalle());
                det.setSubtotalDetalle(det.getSubtotalDetalle()+ (det.getProductoDetalle().getPrecio_Producto()*detalle.getCantidad_ProductoDetalle() ));
                i = venta.getDetalleVenta().size();
                existe = 1;
            }
        }
        if (existe == 0) {
            venta.getDetalleVenta().add(detalle);
        }
        venta.setTotal_Venta(venta.getTotal_Venta()+ detalle.getSubtotalDetalle());
        return venta;
    }

    @Override
    public boolean agregarDatos(DetalleVenta t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizar(DetalleVenta actualizar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean validarCorreo(String correo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
