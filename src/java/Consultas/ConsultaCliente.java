/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consultas;

import MCRUD.CRUD;
import Modelo.Cliente;
import Modelo.ConexionDB;
import Modelo.Direccion;
import Modelo.Venta;
import ModeloDAO.ClienteDAO;
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
public class ConsultaCliente implements ClienteDAO {

    PreparedStatement ps = null;
    ResultSet rs = null;
    ConexionDB conDB = null;
    Connection conexion = null;

    @Override
    public ArrayList<Cliente> mostrarUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Cliente> buscar(int buscar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public Cliente mostrar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cliente agregar(Cliente t) {
        try {
            conDB = new ConexionDB();

            conexion = conDB.conexionDB();

            String sqlDireccion = "INSERT INTO Direccion"
                    + "(pais_Direccion,estado_Direccion,municipio_Direccion,calle_Direccion,colonia_Direccion,"
                    + "codigoPostal_Direccion,numeroExterior_Direccion,numeroInterior_Direccion)VALUES(?,?,?,?,?,?,?,?)";

            String sqlPersona = "INSERT INTO Persona"
                    + "(nombre_Persona,apellidoPaterno_Persona,apellidoMaterno_Persona,fechaNacimiento_Persona,sexo_Persona,"
                    + "telefono_Persona,correo_Persona,id_DireccionFK)VALUES(?,?,?,?,?,?,?,?)";

            String sqlCliente = "INSERT INTO Cliente(id_PersonaFK)VALUES(?)";

            ps = conexion.prepareStatement(sqlDireccion);
            ps.setString(1, t.getPersonaCliente().getDireccionPersona().getPais_Direccion());
            ps.setString(2, t.getPersonaCliente().getDireccionPersona().getEstado_Direccion());
            ps.setString(3, t.getPersonaCliente().getDireccionPersona().getMunicipio_Direccion());
            ps.setString(4, t.getPersonaCliente().getDireccionPersona().getCalle_Direccion());
            ps.setString(5, t.getPersonaCliente().getDireccionPersona().getColonia_Direccion());
            ps.setString(6, t.getPersonaCliente().getDireccionPersona().getCodigoPostal_Direccion());
            ps.setString(7, t.getPersonaCliente().getDireccionPersona().getNumeroExterior_Direccion());
            ps.setString(8, t.getPersonaCliente().getDireccionPersona().getNumeroInterior_Direccion());
            ps.executeUpdate();

            ps = conexion.prepareStatement("select last_insert_id() as ultimoDireccion");
            rs = ps.executeQuery();
            if (rs != null && rs.next()) {
                t.getPersonaCliente().getDireccionPersona().setId_Direccion(Integer.parseInt(rs.getString("ultimoDireccion")));
            }

            ps = conexion.prepareStatement(sqlPersona);
            ps.setString(1, t.getPersonaCliente().getNombre_Persona());
            ps.setString(2, t.getPersonaCliente().getPaterno_Persona());
            ps.setString(3, t.getPersonaCliente().getMaterno_Persona());
            ps.setString(4, t.getPersonaCliente().getFechaNacimiento_Persona());
            ps.setString(5, t.getPersonaCliente().getSexo_Persona());
            ps.setString(6, t.getPersonaCliente().getTelefono_Persona());
            ps.setString(7, t.getPersonaCliente().getCorreo_Persona());
            ps.setInt(8, t.getPersonaCliente().getDireccionPersona().getId_Direccion());
            ps.executeUpdate();

            ps = conexion.prepareStatement("select last_insert_id() as ultimaPerson");
            rs = ps.executeQuery();
            if (rs != null && rs.next()) {
                t.getPersonaCliente().setId_Persona(Integer.parseInt(rs.getString("ultimaPerson")));
            }
            ps = conexion.prepareStatement(sqlCliente);
            ps.setInt(1, t.getPersonaCliente().getId_Persona());
            ps.executeUpdate();

            ps = conexion.prepareStatement("select last_insert_id() as ultimoCliente");
            rs = ps.executeQuery();
            if (rs != null && rs.next()) {
                t.setId_Cliente(Integer.parseInt(rs.getString("ultimoCliente")));
            }
            return t;

        } catch (SQLException ex) {
            System.out.println("error ConsultaCliente " + ex.getMessage());
            Logger.getLogger(ConsultaCliente.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            try {
                ps.close();
                rs.close();
                conexion.close();
            } catch (SQLException ex) {
                System.out.println("error cerrar conexiones ConsultaCliente " + ex.getMessage());
                Logger.getLogger(ConsultaCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
//        public static void main(String[] args) {
//        CRUD ve=new ConsultaCliente();
//         Cliente s=new Cliente();
//                
//                s.getPersonaCliente().getDireccionPersona().setPais_Direccion("Maxico");
//
//        s.getPersonaCliente().getDireccionPersona().setEstado_Direccion("Gola");
//        s.getPersonaCliente().getDireccionPersona().setMunicipio_Direccion("Gola");
//        s.getPersonaCliente().getDireccionPersona().setCalle_Direccion("Gola");
//        s.getPersonaCliente().getDireccionPersona().setColonia_Direccion("Gola");
//        s.getPersonaCliente().getDireccionPersona().setCodigoPostal_Direccion("Gola");
//        s.getPersonaCliente().getDireccionPersona().setNumeroExterior_Direccion("Gola");
//        s.getPersonaCliente().getDireccionPersona().setNumeroInterior_Direccion("Gola");
//
//        s.getPersonaCliente().setNombre_Persona("Racka");
//        s.getPersonaCliente().setPaterno_Persona("Clienta");
//        s.getPersonaCliente().setMaterno_Persona("CLienta");
//        s.getPersonaCliente().setFechaNacimiento_Persona("2020-05-05");
//        s.getPersonaCliente().setSexo_Persona("SI");
//        s.getPersonaCliente().setTelefono_Persona("SI");
//        s.getPersonaCliente().setCorreo_Persona("SI");
// 
//       
//       
//      Cliente nuevo =(Cliente)ve.agregar(s);
//        if(nuevo.getId_Cliente() != 0)
//        {
//        System.out.println(nuevo.getPersonaCliente().getDireccionPersona().getId_Direccion());    
//        System.out.println(nuevo.getPersonaCliente().getDireccionPersona().getPais_Direccion());     
//        System.out.println(nuevo.getPersonaCliente().getDireccionPersona().getEstado_Direccion());
//        System.out.println(nuevo.getPersonaCliente().getDireccionPersona().getMunicipio_Direccion());
//        System.out.println(nuevo.getPersonaCliente().getDireccionPersona().getCalle_Direccion());
//        System.out.println(nuevo.getPersonaCliente().getDireccionPersona().getColonia_Direccion());
//        System.out.println(nuevo.getPersonaCliente().getDireccionPersona().getCodigoPostal_Direccion());
//        System.out.println(nuevo.getPersonaCliente().getDireccionPersona().getNumeroExterior_Direccion());
//        System.out.println(nuevo.getPersonaCliente().getDireccionPersona().getNumeroInterior_Direccion());
//
//        System.out.println(nuevo.getPersonaCliente().getNombre_Persona());
//        System.out.println(nuevo.getPersonaCliente().getPaterno_Persona());
//        System.out.println(nuevo.getPersonaCliente().getMaterno_Persona());
//        System.out.println(nuevo.getPersonaCliente().getFechaNacimiento_Persona());
//        System.out.println(nuevo.getPersonaCliente().getSexo_Persona());
//        System.out.println(nuevo.getPersonaCliente().getTelefono_Persona());
//        System.out.println(nuevo.getPersonaCliente().getCorreo_Persona());
//        System.out.println(nuevo.getPersonaCliente().getId_Persona());
//        
//        System.out.println(nuevo.getId_Cliente());
//        System.out.println(nuevo.getTipo_Cliente());
//
//        }else
//        {
//            System.out.println("Nada");
//        }
//    }

    @Override
    public ArrayList<Cliente> buscarTodos(String buscar) {
        ArrayList<Cliente> guardarCliente = new ArrayList<>();
        try {
            conDB = new ConexionDB();
            conexion = conDB.conexionDB();
            String sqlClientes = "SELECT p.nombre_Persona,p.apellidoPaterno_Persona,p.apellidoMaterno_Persona,p.telefono_Persona ,\n"
                    + "d.pais_Direccion,cl.id_Cliente \n"
                    + "FROM Cliente cl\n"
                    + "INNER JOIN Persona p \n"
                    + "ON p.id_Persona = cl.id_PersonaFK \n"
                    + "INNER JOIN Direccion d \n"
                    + "ON d.id_Direccion = p.id_DireccionFK ORDER BY p.apellidoPaterno_Persona";

            String sqlCliente = "SELECT p.nombre_Persona,p.apellidoPaterno_Persona,p.apellidoMaterno_Persona,p.telefono_Persona ,\n"
                    + "d.pais_Direccion,cl.id_Cliente \n"
                    + "FROM Cliente cl\n"
                    + "INNER JOIN Persona p \n"
                    + "ON p.id_Persona = cl.id_PersonaFK \n"
                    + "INNER JOIN Direccion d \n"
                    + "ON d.id_Direccion = p.id_DireccionFK WHERE p.apellidoPaterno_Persona LIKE ? \n"
                    + "ORDER BY p.apellidoPaterno_Persona";

            if (buscar.equals("")) {

                ps = conexion.prepareStatement(sqlClientes);

            } else {

                ps = conexion.prepareStatement(sqlCliente);
                ps.setString(1, "%" + buscar + "%");
            }
            rs = ps.executeQuery();

            while (rs != null && rs.next()) {
                Cliente cli = new Cliente();

                cli.getPersonaCliente().setNombre_Persona(rs.getString(1));
                cli.getPersonaCliente().setPaterno_Persona(rs.getString(2));
                cli.getPersonaCliente().setMaterno_Persona(rs.getString(3));
                cli.getPersonaCliente().setTelefono_Persona(rs.getString(4));
                cli.getPersonaCliente().getDireccionPersona().setPais_Direccion(rs.getString(5));

                cli.setId_Cliente(rs.getInt(6));
                guardarCliente.add(cli);
            }

        } catch (SQLException ex) {
            System.out.println("Error Array CLiente Consulta Cliente " + ex.getMessage());
            Logger.getLogger(ConsultaCliente.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
                rs.close();
                conexion.close();
            } catch (SQLException ex) {
                System.out.println("error cerrar conexiones ConsultaCliente " + ex.getMessage());
                Logger.getLogger(ConsultaCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return guardarCliente;

    }

    @Override
    public boolean agregarDatos(Cliente t) {
         try {
            conDB = new ConexionDB();

            conexion = conDB.conexionDB();

            String sqlDireccion = "INSERT INTO Direccion"
                    + "(pais_Direccion,estado_Direccion,municipio_Direccion,calle_Direccion,colonia_Direccion,"
                    + "codigoPostal_Direccion,numeroExterior_Direccion,numeroInterior_Direccion)VALUES(?,?,?,?,?,?,?,?)";

            String sqlPersona = "INSERT INTO Persona"
                    + "(nombre_Persona,apellidoPaterno_Persona,apellidoMaterno_Persona,fechaNacimiento_Persona,sexo_Persona,"
                    + "telefono_Persona,correo_Persona,id_DireccionFK)VALUES(?,?,?,?,?,?,?,?)";

            String sqlCliente = "INSERT INTO Cliente(id_PersonaFK)VALUES(?)";

            ps = conexion.prepareStatement(sqlDireccion);
            ps.setString(1, t.getPersonaCliente().getDireccionPersona().getPais_Direccion());
            ps.setString(2, t.getPersonaCliente().getDireccionPersona().getEstado_Direccion());
            ps.setString(3, t.getPersonaCliente().getDireccionPersona().getMunicipio_Direccion());
            ps.setString(4, t.getPersonaCliente().getDireccionPersona().getCalle_Direccion());
            ps.setString(5, t.getPersonaCliente().getDireccionPersona().getColonia_Direccion());
            ps.setString(6, t.getPersonaCliente().getDireccionPersona().getCodigoPostal_Direccion());
            ps.setString(7, t.getPersonaCliente().getDireccionPersona().getNumeroExterior_Direccion());
            ps.setString(8, t.getPersonaCliente().getDireccionPersona().getNumeroInterior_Direccion());
            ps.executeUpdate();

            ps = conexion.prepareStatement("select last_insert_id() as ultimoDireccion");
            rs = ps.executeQuery();
            if (rs != null && rs.next()) {
                t.getPersonaCliente().getDireccionPersona().setId_Direccion(Integer.parseInt(rs.getString("ultimoDireccion")));
            }

            ps = conexion.prepareStatement(sqlPersona);
            ps.setString(1, t.getPersonaCliente().getNombre_Persona());
            ps.setString(2, t.getPersonaCliente().getPaterno_Persona());
            ps.setString(3, t.getPersonaCliente().getMaterno_Persona());
            ps.setString(4, t.getPersonaCliente().getFechaNacimiento_Persona());
            ps.setString(5, t.getPersonaCliente().getSexo_Persona());
            ps.setString(6, t.getPersonaCliente().getTelefono_Persona());
            ps.setString(7, t.getPersonaCliente().getCorreo_Persona());
            ps.setInt(8, t.getPersonaCliente().getDireccionPersona().getId_Direccion());
            ps.executeUpdate();

            ps = conexion.prepareStatement("select last_insert_id() as ultimaPerson");
            rs = ps.executeQuery();
            if (rs != null && rs.next()) {
                t.getPersonaCliente().setId_Persona(Integer.parseInt(rs.getString("ultimaPerson")));
            }
            ps = conexion.prepareStatement(sqlCliente);
            ps.setInt(1, t.getPersonaCliente().getId_Persona());
            ps.executeUpdate();

            
            return true;
            

        } catch (SQLException ex) {
            System.out.println("error ConsultaCliente " + ex.getMessage());
            Logger.getLogger(ConsultaCliente.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            try {
                ps.close();
                rs.close();
                conexion.close();
            } catch (SQLException ex) {
                System.out.println("error cerrar conexiones ConsultaCliente " + ex.getMessage());
                Logger.getLogger(ConsultaCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    public boolean actualizar(Cliente actualizar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Direccion agregarDireccion(Direccion d) {
        try {
            conDB = new ConexionDB();

            conexion = conDB.conexionDB();

            String sqlDireccion = "INSERT INTO Direccion"
                    + "(pais_Direccion,estado_Direccion,municipio_Direccion,calle_Direccion,colonia_Direccion,"
                    + "codigoPostal_Direccion,numeroExterior_Direccion,numeroInterior_Direccion)VALUES(?,?,?,?,?,?,?,?)";

            ps = conexion.prepareStatement(sqlDireccion);
            ps.setString(1, d.getPais_Direccion());
            ps.setString(2, d.getEstado_Direccion());
            ps.setString(3, d.getMunicipio_Direccion());
            ps.setString(4, d.getCalle_Direccion());
            ps.setString(5, d.getColonia_Direccion());
            ps.setString(6, d.getCodigoPostal_Direccion());
            ps.setString(7, d.getNumeroExterior_Direccion());
            ps.setString(8, d.getNumeroInterior_Direccion());
            ps.executeUpdate();

            ps = conexion.prepareStatement("select last_insert_id() as ultimoDireccion");
            rs = ps.executeQuery();
            if (rs != null && rs.next()) {
                d.setId_Direccion(Integer.parseInt(rs.getString("ultimoDireccion")));
            }

            return d;

        } catch (SQLException ex) {
            System.out.println("error Agregar Direccion " + ex.getMessage());
            Logger.getLogger(ConsultaCliente.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            try {
                ps.close();
                rs.close();
                conexion.close();
            } catch (SQLException ex) {
                System.out.println("error cerrar conexiones ConsultaCliente " + ex.getMessage());
                Logger.getLogger(ConsultaCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public boolean validarCorreo(String correo) {
                try {
            conDB = new ConexionDB();
            conexion = conDB.conexionDB();
            String sqlCorreoUsuario = "SELECT p.id_Persona \n" +
"                    FROM Persona p \n" +
"                    WHERE p.correo_Persona = ?";

            ps = conexion.prepareStatement(sqlCorreoUsuario);
            ps.setString(1, correo);
            rs = ps.executeQuery();
            if (rs != null && rs.next()) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException ex) {
            System.err.println("Error Agregar Usuario Consulta Usuario " + ex.getMessage());
            Logger.getLogger(ConsultaUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            try {
                ps.close();
                rs.close();
                conexion.close();
            } catch (SQLException ex) {
                System.out.println("error cerrar conexiones ConsultaCliente " + ex.getMessage());
                Logger.getLogger(ConsultaCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
