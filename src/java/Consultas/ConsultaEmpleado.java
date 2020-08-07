/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consultas;

/**
 *
 * @author elver
 */
import Modelo.ConexionDB;
import Modelo.Direccion;
import Modelo.Persona;
import Modelo.Empleado;
import ModeloDAO.EmpleadoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsultaEmpleado implements EmpleadoDAO {
   
    PreparedStatement ps = null;
    ResultSet rs = null;
    ConexionDB conDB = null;
    Connection conexion = null;
    
    @Override
    public ArrayList<Empleado> buscarTodos(String buscar){
      ArrayList<Empleado> EmpleadosList=new ArrayList<>();  
      try{
       conDB = new ConexionDB();
       conexion = conDB.conexionDB();
//       String sqlBuscarEmpleados="SELECT persona.id_Persona,persona.nombre_Persona,persona.apellidoPaterno_Persona,persona.apellidoMaterno_Persona,\n" +
//                                "empleado.id_Empleado,empleado.puesto_Empleado,empleado.sueldoDia_Empleado\n" +
//                                "FROM empleado\n" +
//                                "INNER JOIN persona ON empleado.id_PersonaFK=persona.id_Persona";
//       String sqlBuscarEmpleado="SELECT persona.id_Persona,persona.nombre_Persona,persona.apellidoPaterno_Persona,persona.apellidoMaterno_Persona,\n" +
//                                "empleado.id_Empleado,empleado.puesto_Empleado,empleado.sueldoDia_Empleado\n" +
//                                "FROM empleado\n" +
//                                "INNER JOIN persona ON empleado.id_PersonaFK=persona.id_Persona \n"+
//                                  "WHERE persona.nombre_Persona LIKE ?";
        String sqlBuscarEmpleados="SELECT Direccion.id_Direccion,Direccion.pais_Direccion,Direccion.estado_Direccion,Direccion.municipio_Direccion,Direccion.calle_Direccion,Direccion.colonia_Direccion,Direccion.codigoPostal_Direccion,Direccion.numeroExterior_Direccion,Direccion.numeroInterior_Direccion,\n" +
                                    "Persona.id_Persona,Persona.nombre_Persona,Persona.apellidoPaterno_Persona,Persona.apellidoMaterno_Persona,Persona.fechaNacimiento_Persona,Persona.sexo_Persona,Persona.telefono_Persona,Persona.correo_Persona,Persona.id_DireccionFK,\n" +
                                    "Empleado.id_Empleado,Empleado.sueldoDia_Empleado,Empleado.puesto_Empleado,Empleado.id_PersonaFK\n" +
                                    "FROM Empleado\n" +
                                    "INNER JOIN Persona ON Empleado.id_PersonaFK=Persona.id_Persona\n" +
                                    "INNER JOIN Direccion ON Persona.id_DireccionFK=Direccion.id_Direccion";
        
        String sqlBuscarEmpleado="SELECT Direccion.id_Direccion,Direccion.pais_Direccion,Direccion.estado_Direccion,Direccion.municipio_Direccion,Direccion.calle_Direccion,Direccion.colonia_Direccion,Direccion.codigoPostal_Direccion,Direccion.numeroExterior_Direccion,Direccion.numeroInterior_Direccion,\n" +
                                    "Persona.id_Persona,Persona.nombre_Persona,Persona.apellidoPaterno_Persona,Persona.apellidoMaterno_Persona,Persona.fechaNacimiento_Persona,Persona.sexo_Persona,Persona.telefono_Persona,Persona.correo_Persona,Persona.id_DireccionFK,\n" +
                                    "Empleado.id_Empleado,Empleado.sueldoDia_Empleado,Empleado.puesto_Empleado,Empleado.id_PersonaFK\n" +
                                    "FROM Empleado\n" +
                                    "INNER JOIN Persona ON Empleado.id_PersonaFK=Persona.id_Persona\n" +
                                    "INNER JOIN Direccion ON Persona.id_DireccionFK=Direccion.id_Direccion\n"+
                                    "WHERE Persona.nombre_Persona LIKE ?";
       
       if (buscar.equals("")) {

                ps = conexion.prepareStatement(sqlBuscarEmpleados);
            } else {

                ps = conexion.prepareStatement(sqlBuscarEmpleado);
                ps.setString(1, "%" + buscar + "%");

            }
            rs = ps.executeQuery();
            
            while(rs!=null && rs.next()){
              Persona p=new Persona();
              Empleado e=new Empleado();
              Direccion d=new Direccion();
              d.setId_Direccion(rs.getInt(1));
              d.setPais_Direccion(rs.getString(2));
              d.setEstado_Direccion(rs.getString(3));
              d.setMunicipio_Direccion(rs.getString(4));
              d.setCalle_Direccion(rs.getString(5));
              d.setColonia_Direccion(rs.getString(6));
              d.setCodigoPostal_Direccion(rs.getString(7));
              d.setNumeroExterior_Direccion(rs.getString(8));
              d.setNumeroInterior_Direccion(rs.getString(9));
              p.setId_Persona(rs.getInt(10));
              p.setNombre_Persona(rs.getString(11));
              p.setPaterno_Persona(rs.getString(12));
              p.setMaterno_Persona(rs.getString(13));
              p.setFechaNacimiento_Persona(rs.getString(14));
              p.setSexo_Persona(rs.getString(15));
              p.setTelefono_Persona(rs.getString(16));
              p.setCorreo_Persona(rs.getString(17));
              e.setId_Empleado(rs.getInt(19));
              e.setSueldoDia_Empleado(rs.getDouble(20));
              e.setPuesto_Empleado(rs.getString(21));
              
              e.setPersonaCliente(p);
              e.getPersonaCliente().setDireccionPersona(d);
              EmpleadosList.add(e);
            }
       
      }catch (SQLException ex) {
            System.err.println("Error cargar Empleado Consulta Empleado " + ex.getMessage());
            Logger.getLogger(ConsultaEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
                rs.close();
                conexion.close();
            } catch (SQLException ex) {
                System.out.println("error cerrar conexiones Consulta Empleado cerrar Conexion " + ex.getMessage());
                Logger.getLogger(ConsultaCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return EmpleadosList;
    }

    @Override
    public boolean agregarEmpleado(Empleado e){
       try{
        conDB = new ConexionDB();
        conexion = conDB.conexionDB(); 
            String sqlDireccion = "INSERT INTO Direccion"
                        + "(pais_Direccion,estado_Direccion,municipio_Direccion,calle_Direccion,colonia_Direccion,"
                        + "codigoPostal_Direccion,numeroExterior_Direccion,numeroInterior_Direccion)VALUES(?,?,?,?,?,?,?,?)";

            String sqlPersona = "INSERT INTO Persona"
                    + "(nombre_Persona,apellidoPaterno_Persona,apellidoMaterno_Persona,fechaNacimiento_Persona,sexo_Persona,"
                    + "telefono_Persona,correo_Persona,id_DireccionFK)VALUES(?,?,?,?,?,?,?,?)";
            
            String sqlEmpleado="INSERT INTO Empleado (sueldoDia_Empleado,puesto_Empleado,id_PersonaFK)VALUES(?,?,?)";
            
            ps=conexion.prepareStatement(sqlDireccion);
            ps.setString(1, e.getPersonaCliente().getDireccionPersona().getPais_Direccion());
            ps.setString(2, e.getPersonaCliente().getDireccionPersona().getEstado_Direccion());
            ps.setString(3, e.getPersonaCliente().getDireccionPersona().getMunicipio_Direccion());
            ps.setString(4, e.getPersonaCliente().getDireccionPersona().getCalle_Direccion());
            ps.setString(5, e.getPersonaCliente().getDireccionPersona().getColonia_Direccion());
            ps.setString(6, e.getPersonaCliente().getDireccionPersona().getCodigoPostal_Direccion());
            ps.setString(7, e.getPersonaCliente().getDireccionPersona().getNumeroExterior_Direccion());
            ps.setString(8, e.getPersonaCliente().getDireccionPersona().getNumeroInterior_Direccion());
            ps.executeUpdate();
            
            System.out.println("en Conslta Pais :"+e.getPersonaCliente().getDireccionPersona().getPais_Direccion());
            
            ps = conexion.prepareStatement("select last_insert_id() as ultimoDireccion");
            rs = ps.executeQuery();
            if (rs != null && rs.next()) {
               e.getPersonaCliente().getDireccionPersona().setId_Direccion(Integer.parseInt(rs.getString("ultimoDireccion")));
            }
            
            ps = conexion.prepareStatement(sqlPersona);
            ps.setString(1, e.getPersonaCliente().getNombre_Persona());
            ps.setString(2, e.getPersonaCliente().getPaterno_Persona());
            ps.setString(3, e.getPersonaCliente().getMaterno_Persona());
            ps.setString(4, e.getPersonaCliente().getFechaNacimiento_Persona());
            ps.setString(5, e.getPersonaCliente().getSexo_Persona());
            ps.setString(6, e.getPersonaCliente().getTelefono_Persona());
            ps.setString(7, e.getPersonaCliente().getCorreo_Persona());
            ps.setInt(8, e.getPersonaCliente().getDireccionPersona().getId_Direccion());
            ps.executeUpdate();
            
            ps = conexion.prepareStatement("select last_insert_id() as ultimaPerson");
            rs = ps.executeQuery();
            if (rs != null && rs.next()) {
                e.getPersonaCliente().setId_Persona(Integer.parseInt(rs.getString("ultimaPerson")));
            }
            
            ps = conexion.prepareStatement(sqlEmpleado);
            ps.setDouble(1, e.getSueldoDia_Empleado());
            ps.setString(2, e.getPuesto_Empleado());
            ps.setInt(3, e.getPersonaCliente().getId_Persona());
            ps.executeUpdate();
            return true;
            
       }catch (SQLException ex) {
            System.err.println("Error Agregar Empleado Consulta Empleado " + ex.getMessage());
            Logger.getLogger(ConsultaUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            try {
                ps.close();
                rs.close();
                conexion.close();
            } catch (SQLException ex) {
                System.out.println("error cerrar conexiones ConsultaEmpleado " + ex.getMessage());
                Logger.getLogger(ConsultaCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }
    
    @Override
    public boolean actualizar(Empleado e){
        try{
            conDB = new ConexionDB();
            conexion = conDB.conexionDB(); 
            String sqlActualizarDireccion = "UPDATE Direccion SET pais_Direccion = ?, estado_Direccion = ?, municipio_Direccion = ?,\n"
                    + "calle_Direccion = ?,colonia_Direccion = ?, codigoPostal_Direccion = ?, numeroExterior_Direccion = ?,\n"
                    + "numeroInterior_Direccion = ? WHERE id_Direccion = ?";
            String sqlActualizarPersona = "UPDATE Persona SET nombre_Persona = ?, apellidoPaterno_Persona = ?, "
                    + "apellidoMaterno_Persona = ?, fechaNacimiento_Persona = ?,"
                    + "sexo_Persona = ?, telefono_Persona = ?, correo_Persona = ? WHERE id_Persona =?";
            String sqlActualizarEmpleado="UPDATE Empleado SET sueldoDia_Empleado = ?, puesto_Empleado=? \n"
                    +"WHERE id_Empleado = ?";
            
            
           // if(e.getPersonaCliente().getId_Persona() !=0){
                ps = conexion.prepareStatement(sqlActualizarPersona);
                ps.setString(1, e.getPersonaCliente().getNombre_Persona());
                ps.setString(2, e.getPersonaCliente().getPaterno_Persona());
                ps.setString(3, e.getPersonaCliente().getMaterno_Persona());
                ps.setString(4, e.getPersonaCliente().getFechaNacimiento_Persona());
                ps.setString(5, e.getPersonaCliente().getSexo_Persona());
                ps.setString(6, e.getPersonaCliente().getTelefono_Persona());
                ps.setString(7, e.getPersonaCliente().getCorreo_Persona());
                ps.setInt(8, e.getPersonaCliente().getId_Persona());
                ps.executeUpdate();
            //}else{
            System.out.println("Id Persona que llega a consulta "+e.getPersonaCliente().getId_Persona());              
            //}
            
            //if (e.getPersonaCliente().getDireccionPersona().getId_Direccion() != 0) {

                ps = conexion.prepareStatement(sqlActualizarDireccion);
                ps.setString(1, e.getPersonaCliente().getDireccionPersona().getPais_Direccion());
                ps.setString(2, e.getPersonaCliente().getDireccionPersona().getEstado_Direccion());
                ps.setString(3, e.getPersonaCliente().getDireccionPersona().getMunicipio_Direccion());
                ps.setString(4, e.getPersonaCliente().getDireccionPersona().getCalle_Direccion());
                ps.setString(5, e.getPersonaCliente().getDireccionPersona().getColonia_Direccion());
                ps.setString(6, e.getPersonaCliente().getDireccionPersona().getCodigoPostal_Direccion());
                ps.setString(7, e.getPersonaCliente().getDireccionPersona().getNumeroExterior_Direccion());
                ps.setString(8, e.getPersonaCliente().getDireccionPersona().getNumeroInterior_Direccion());
                ps.setInt(9, e.getPersonaCliente().getDireccionPersona().getId_Direccion());
                ps.executeUpdate();
            //}else{
            System.out.println("Id Direccion que llega a consulta "+e.getPersonaCliente().getDireccionPersona().getId_Direccion());
            System.out.println("pais que llega a consulta "+e.getPersonaCliente().getDireccionPersona().getPais_Direccion());
            System.out.println("municipio que llega a consulta "+e.getPersonaCliente().getDireccionPersona().getMunicipio_Direccion());
            System.out.println("calle que llega a consulta "+e.getPersonaCliente().getDireccionPersona().getCalle_Direccion());
            //}
            
            //if(e.getId_Empleado() !=0){
                ps = conexion.prepareStatement(sqlActualizarEmpleado);
                ps.setDouble(1, e.getSueldoDia_Empleado());
                ps.setString(2, e.getPuesto_Empleado());
                ps.setInt(3, e.getId_Empleado());
                ps.executeUpdate();
           // }else{
            System.out.println("Id Empleado que llega a consulta "+e.getId_Empleado());                             
            //}
            
            return true;
            
            
        }catch (SQLException ex) {
            System.err.println("error Consulta Empleado Actualizar Empleado " + ex.getMessage());
            Logger.getLogger(ConsultaUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            try {
                ps.close();
                conexion.close();
            } catch (SQLException ex) {
                System.err.println("error cerrar conexiones Consulta Usuario cerrar Conexion " + ex.getMessage());
                Logger.getLogger(ConsultaCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @Override
    public ArrayList<Empleado> mostrarUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Empleado> buscar(int buscar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Empleado mostrar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Empleado agregar(Empleado agregar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean agregarDatos(Empleado t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean validarCorreo(String correo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
