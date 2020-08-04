/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consultas;

import Modelo.Cliente;
import Modelo.ConexionDB;
import Modelo.Direccion;
import Modelo.Persona;
import Modelo.Rol;
import Modelo.Usuario;
import ModeloDAO.UsuarioDAO;
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
public class ConsultaUsuario implements UsuarioDAO {

    PreparedStatement ps = null;
    ResultSet rs = null;
    ConexionDB conDB = null;
    Connection conexion = null;
    //Veamos si conexion funciona con las demas conexiones

    @Override
    public Usuario accederUsuario(String user, String contra, String correo) {
        conDB = new ConexionDB();
        conexion = conDB.conexionDB();

        Usuario usr = new Usuario();
        Cliente cl = new Cliente();
        try {
            String sqlAcceso = "SELECT u.id_Usuario,u.userName_User,u.password_User,e2.id_Estatus,e2.nombre_Estatus,\n"
                    + "            ru.id_TipoUser,ru.nombre_TipoUser,e.id_Estatus,e.nombre_Estatus,\n"
                    + "            p.id_Persona ,p.nombre_Persona,p.apellidoPaterno_Persona ,p.apellidoMaterno_Persona,p.fechaNacimiento_Persona,\n"
                    + "            p.sexo_Persona,p.telefono_Persona,p.correo_Persona,\n"
                    + "            d.id_Direccion,d.pais_Direccion,d.estado_Direccion,d.municipio_Direccion,d.calle_Direccion,\n"
                    + "            d.colonia_Direccion,d.codigoPostal_Direccion,d.numeroInterior_Direccion,d.numeroExterior_Direccion \n"
                    + "           \n"
                    + "            FROM Usuario u\n"
                    + "            INNER JOIN Estatus e2 \n"
                    + "            ON e2.id_Estatus = u.id_EstatusFK \n"
                    + "            INNER JOIN RolUsuario ru \n"
                    + "            ON ru.id_TipoUser = u.id_TipoUserFK \n"
                    + "            INNER JOIN Estatus e \n"
                    + "            ON e.id_Estatus = ru.id_EstatusFK \n"
                    + "            INNER JOIN Persona p\n"
                    + "            ON p.id_Persona = u.id_PersonaFK\n"
                    + "            INNER JOIN Direccion d\n"
                    + "            ON d.id_Direccion = p.id_DireccionFK \n"
                    + "            WHERE (u.userName_User = ? AND u.password_User = ?) || (p.correo_Persona = ?)";
            String sqlCliente = "SELECT id_Cliente\n"
                    + "FROM Cliente cl\n"
                    + "INNER JOIN Persona p\n"
                    + "ON p.id_Persona = cl.id_PersonaFK\n"
                    + "INNER JOIN Direccion d\n"
                    + "ON d.id_Direccion = p.id_DireccionFK \n"
                    + "WHERE p.correo_Persona = ? LIMIT 1";

            ps = conexion.prepareStatement(sqlAcceso);
            ps.setString(1, user);
            ps.setString(2, contra);
            ps.setString(3, correo);
            
            rs = ps.executeQuery();
            
            if (rs != null && rs.next()) {
                usr.setId_Usuario(rs.getInt("id_Usuario"));
                usr.setUserName(rs.getString("userName_User"));
                usr.setContra(rs.getString("password_User"));

                usr.getEstatusUsuario().setId_Estatus(rs.getInt(4));
                usr.getEstatusUsuario().setNombre_Estatus(rs.getString(5));

                usr.getRolUsuario().setId_RolUduario(rs.getInt(6));
                usr.getRolUsuario().setNombre_RolUsuario(rs.getString(7));

                usr.getRolUsuario().getRolEstatus().setId_Estatus(rs.getInt(8));
                usr.getRolUsuario().getRolEstatus().setNombre_Estatus(rs.getString(9));

                usr.getPersonaUsuario().setId_Persona(rs.getInt("id_Persona"));
                usr.getPersonaUsuario().setNombre_Persona(rs.getString("nombre_Persona"));
                usr.getPersonaUsuario().setPaterno_Persona(rs.getString("apellidoPaterno_Persona"));
                usr.getPersonaUsuario().setMaterno_Persona(rs.getString("apellidoMaterno_Persona"));
                usr.getPersonaUsuario().setFechaNacimiento_Persona(rs.getString("fechaNacimiento_Persona"));
                usr.getPersonaUsuario().setSexo_Persona(rs.getString("sexo_Persona"));
                usr.getPersonaUsuario().setTelefono_Persona(rs.getString("telefono_Persona"));
                usr.getPersonaUsuario().setCorreo_Persona(rs.getString("correo_Persona"));

                usr.getPersonaUsuario().getDireccionPersona().setId_Direccion(rs.getInt("id_Direccion"));
                usr.getPersonaUsuario().getDireccionPersona().setPais_Direccion(rs.getString("pais_Direccion"));
                usr.getPersonaUsuario().getDireccionPersona().setEstado_Direccion(rs.getString("estado_Direccion"));
                usr.getPersonaUsuario().getDireccionPersona().setMunicipio_Direccion(rs.getString("municipio_Direccion"));
                usr.getPersonaUsuario().getDireccionPersona().setCalle_Direccion(rs.getString("calle_Direccion"));
                usr.getPersonaUsuario().getDireccionPersona().setColonia_Direccion(rs.getString("colonia_Direccion"));
                usr.getPersonaUsuario().getDireccionPersona().setCodigoPostal_Direccion(rs.getString("codigoPostal_Direccion"));
                usr.getPersonaUsuario().getDireccionPersona().setNumeroInterior_Direccion(rs.getString("numeroInterior_Direccion"));
                usr.getPersonaUsuario().getDireccionPersona().setNumeroExterior_Direccion(rs.getString("numeroExterior_Direccion"));
                String sqlPermisos = "SELECT id_Menu FROM permisoMenu WHERE id_TipoUser = ?";
                ps = conexion.prepareStatement(sqlPermisos);
                ps.setInt(1, usr.getRolUsuario().getId_RolUduario());
                rs = ps.executeQuery();

                while (rs != null && rs.next()) {
                    usr.getRolUsuario().getPermisos().add(rs.getInt(1));
                }
            }

            String sqlCountPermisos = "SELECT COUNT(pm.id_permisoMenu) AS cont "
                    + "FROM permisoMenu pm WHERE id_TipoUser = ?";
            ps = conexion.prepareStatement(sqlCountPermisos);
            ps.setInt(1, usr.getRolUsuario().getId_RolUduario());
            rs = ps.executeQuery();
            if (rs.next()) {
                int conteo = rs.getInt("cont");
                if (conteo != 15) {
                    ps = conexion.prepareStatement(sqlCliente);
                    ps.setString(1, usr.getPersonaUsuario().getCorreo_Persona());
                    rs = ps.executeQuery();
                    if (rs != null && rs.next()) {

                        usr.getClienteUsuario().setId_Cliente(rs.getInt(1));
                        usr.getClienteUsuario().getPersonaCliente().setNombre_Persona(usr.getPersonaUsuario().getNombre_Persona());
                        usr.getClienteUsuario().getPersonaCliente().setTelefono_Persona(usr.getPersonaUsuario().getTelefono_Persona());
                    }
                }
                 if (conteo == 15) {
                     System.out.println("ENtro aqui");
                     String sqlSinDatos = "SELECT c.id_Cliente, \n"
                             + "p.nombre_Persona,p.apellidoPaterno_Persona,p.apellidoMaterno_Persona,p.telefono_Persona \n"
                             + "FROM Cliente c \n"
                             + "INNER JOIN Persona p \n"
                             + "ON p.id_Persona = c.id_PersonaFK \n"
                             + "WHERE p.nombre_Persona = ? && p.apellidoPaterno_Persona = ?";
                    ps = conexion.prepareStatement(sqlSinDatos);
                    ps.setString(1, "null");
                    ps.setString(2, "null");
                    rs = ps.executeQuery();
                    if (rs != null && rs.next()) {
                        System.out.println("Llego  aqui "+rs.getInt(1)+ " "+rs.getString(2)+" "+rs.getString(3));
                        usr.getClienteUsuario().setId_Cliente(rs.getInt(1));
                        usr.getClienteUsuario().getPersonaCliente().setNombre_Persona(rs.getString(2));
                        usr.getClienteUsuario().getPersonaCliente().setTelefono_Persona(rs.getString(5));
                    }
                }
            }

        } catch (SQLException ex) {
            System.out.println("err Acceder Usuario " + ex.getMessage());
            Logger.getLogger(ConsultaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
                rs.close();
                conexion.close();
            } catch (SQLException ex) {
                System.out.println("cerro la conexion a DB COnsultar usuario " + ex.getMessage());
                Logger.getLogger(ConsultaUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return usr;

    }

//    public static void main(String[] args) {
//        
//        Usuario usu = new ConsultaUsuario().accederUsuario("", "", "abel@gmail.com");
//       
//        System.out.println("User Name "+ usu.getId_Usuario());
//        
//        if(usu.getId_Usuario() != 0)
//        {
//            for(int i=0; i< usu.getRolUsuario().getPermisos().size();i++ )
//            {
//                System.out.println("Aqui va "+ usu.getRolUsuario().getPermisos().get(i));
//            }
//        }
//        
//        
//        
//    }
    @Override
    public boolean agregarUsuario(Usuario t) {
        try {
            conDB = new ConexionDB();
            conexion = conDB.conexionDB();
            String sqlDireccion = "INSERT INTO Direccion"
                    + "(pais_Direccion,estado_Direccion,municipio_Direccion,calle_Direccion,colonia_Direccion,"
                    + "codigoPostal_Direccion,numeroExterior_Direccion,numeroInterior_Direccion)VALUES(?,?,?,?,?,?,?,?)";

            String sqlPersona = "INSERT INTO Persona"
                    + "(nombre_Persona,apellidoPaterno_Persona,apellidoMaterno_Persona,fechaNacimiento_Persona,sexo_Persona,"
                    + "telefono_Persona,correo_Persona,id_DireccionFK)VALUES(?,?,?,?,?,?,?,?)";

            String sqlUsuario = "INSERT INTO Usuario(userName_User,password_User,id_TipoUserFK,id_PersonaFK,id_EstatusFK)VALUES(?,?,?,?,?)";

            String sqlCliente = "INSERT INTO Cliente(id_PersonaFK)VALUES(?)";

            ps = conexion.prepareStatement(sqlDireccion);
            ps.setString(1, t.getPersonaUsuario().getDireccionPersona().getPais_Direccion());
            ps.setString(2, t.getPersonaUsuario().getDireccionPersona().getEstado_Direccion());
            ps.setString(3, t.getPersonaUsuario().getDireccionPersona().getMunicipio_Direccion());
            ps.setString(4, t.getPersonaUsuario().getDireccionPersona().getCalle_Direccion());
            ps.setString(5, t.getPersonaUsuario().getDireccionPersona().getColonia_Direccion());
            ps.setString(6, t.getPersonaUsuario().getDireccionPersona().getCodigoPostal_Direccion());
            ps.setString(7, t.getPersonaUsuario().getDireccionPersona().getNumeroExterior_Direccion());
            ps.setString(8, t.getPersonaUsuario().getDireccionPersona().getNumeroInterior_Direccion());
            ps.executeUpdate();

            ps = conexion.prepareStatement("select last_insert_id() as ultimoDireccion");
            rs = ps.executeQuery();
            if (rs != null && rs.next()) {
                t.getPersonaUsuario().getDireccionPersona().setId_Direccion(Integer.parseInt(rs.getString("ultimoDireccion")));
            }

            ps = conexion.prepareStatement(sqlPersona);
            ps.setString(1, t.getPersonaUsuario().getNombre_Persona());
            ps.setString(2, t.getPersonaUsuario().getPaterno_Persona());
            ps.setString(3, t.getPersonaUsuario().getMaterno_Persona());
            ps.setString(4, t.getPersonaUsuario().getFechaNacimiento_Persona());
            ps.setString(5, t.getPersonaUsuario().getSexo_Persona());
            ps.setString(6, t.getPersonaUsuario().getTelefono_Persona());
            ps.setString(7, t.getPersonaUsuario().getCorreo_Persona());
            ps.setInt(8, t.getPersonaUsuario().getDireccionPersona().getId_Direccion());
            ps.executeUpdate();

            ps = conexion.prepareStatement("select last_insert_id() as ultimaPerson");
            rs = ps.executeQuery();
            if (rs != null && rs.next()) {
                t.getPersonaUsuario().setId_Persona(Integer.parseInt(rs.getString("ultimaPerson")));
            }
            ps = conexion.prepareStatement(sqlUsuario);
            if (!t.getUserName().equals("") && !t.getContra().equals("")) {

                ps.setString(1, t.getUserName());
                ps.setString(2, t.getContra());
            } else {
                ps.setString(1, t.getUserName());
                ps.setString(2, null);
            }

            ps.setInt(3, t.getRolUsuario().getId_RolUduario());
            ps.setInt(4, t.getPersonaUsuario().getId_Persona());
            ps.setInt(5, t.getEstatusUsuario().getId_Estatus());

            ps.executeUpdate();

            ps = conexion.prepareStatement(sqlCliente);
            ps.setInt(1, t.getPersonaUsuario().getId_Persona());
            ps.executeUpdate();

            return true;

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

    @Override
    public boolean validarCorreo(String correo) {
        try {
            conDB = new ConexionDB();
            conexion = conDB.conexionDB();
            String sqlCorreoUsuario = "SELECT u2.id_Usuario\n"
                    + "FROM Usuario u2 \n"
                    + "INNER JOIN Persona p \n"
                    + "ON p.id_Persona = u2.id_PersonaFK WHERE p.correo_Persona = ?";

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

    @Override
    public boolean validarCorreoActualizar(String correo, int idUsuario) {
        try {
            conDB = new ConexionDB();
            conexion = conDB.conexionDB();
            String sqlCorreoUsuario = "SELECT p.id_Persona \n"
                    + "                   FROM Usuario u2 \n"
                    + "                   INNER JOIN Persona p \n"
                    + "                   ON p.id_Persona = u2.id_PersonaFK WHERE p.correo_Persona = ? AND p.id_Persona <> ?";

            ps = conexion.prepareStatement(sqlCorreoUsuario);
            ps.setString(1, correo);
            ps.setInt(2, idUsuario);
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

    @Override
    public ArrayList<Usuario> mostrarUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Usuario> buscar(int buscar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Usuario> buscarTodos(String buscar) {
        ArrayList<Usuario> guardarUsuario = new ArrayList<>();
        try {
            conDB = new ConexionDB();
            conexion = conDB.conexionDB();
            String sqlBuscarUsuarios = "SELECT u2.id_Usuario ,u2.userName_User,ru.id_TipoUser,ru.nombre_TipoUser,\n"
                    + "p2.id_Persona,p2.nombre_Persona,p2.apellidoPaterno_Persona,p2.apellidoMaterno_Persona,\n"
                    + "p2.fechaNacimiento_Persona,p2.sexo_Persona,p2.telefono_Persona,p2.correo_Persona,\n"
                    + "d.id_Direccion,d.pais_Direccion,d.estado_Direccion,d.municipio_Direccion,d.calle_Direccion,\n"
                    + "d.colonia_Direccion,d.codigoPostal_Direccion,d.numeroExterior_Direccion,d.numeroInterior_Direccion\n"
                    + "FROM Usuario u2 \n"
                    + "INNER JOIN Persona p2\n"
                    + "ON p2.id_Persona = u2.id_Usuario\n"
                    + "INNER JOIN Direccion d\n"
                    + "ON d.id_Direccion = p2.id_Persona\n"
                    + "INNER JOIN RolUsuario ru \n"
                    + "ON ru.id_TipoUser = u2.id_TipoUserFK ORDER BY p2.apellidoPaterno_Persona";
            String sqlBuscarUsuario = "SELECT u2.id_Usuario ,u2.userName_User,ru.id_TipoUser,ru.nombre_TipoUser,\n"
                    + "p2.id_Persona,p2.nombre_Persona,p2.apellidoPaterno_Persona,p2.apellidoMaterno_Persona,\n"
                    + "p2.fechaNacimiento_Persona,p2.sexo_Persona,p2.telefono_Persona,p2.correo_Persona,\n"
                    + "d.id_Direccion,d.pais_Direccion,d.estado_Direccion,d.municipio_Direccion,d.calle_Direccion,\n"
                    + "d.colonia_Direccion,d.codigoPostal_Direccion,d.numeroExterior_Direccion,d.numeroInterior_Direccion\n"
                    + "FROM Usuario u2 \n"
                    + "INNER JOIN Persona p2\n"
                    + "ON p2.id_Persona = u2.id_Usuario\n"
                    + "INNER JOIN Direccion d\n"
                    + "ON d.id_Direccion = p2.id_Persona\n"
                    + "INNER JOIN RolUsuario ru \n"
                    + "ON ru.id_TipoUser = u2.id_TipoUserFK WHERE p2.apellidoPaterno_Persona LIKE ?\n"
                    + "ORDER BY p2.apellidoPaterno_Persona";

            if (buscar.equals("")) {

                ps = conexion.prepareStatement(sqlBuscarUsuarios);
            } else {

                ps = conexion.prepareStatement(sqlBuscarUsuario);
                ps.setString(1, "%" + buscar + "%");

            }
            rs = ps.executeQuery();

            while (rs != null && rs.next()) {
                Persona p = new Persona();
                Direccion d = new Direccion();
                Rol r = new Rol();
                Usuario u = new Usuario();
                u.setId_Usuario(rs.getInt(1));
                u.setUserName(rs.getString(2));
                r.setId_RolUduario(rs.getInt(3));
                r.setNombre_RolUsuario(rs.getString(4));
                p.setId_Persona(rs.getInt(5));
                p.setNombre_Persona(rs.getString(6));
                p.setPaterno_Persona(rs.getString(7));
                p.setMaterno_Persona(rs.getString(8));
                p.setFechaNacimiento_Persona(rs.getString(9));
                p.setSexo_Persona(rs.getString(10));
                p.setTelefono_Persona(rs.getString(11));
                p.setCorreo_Persona(rs.getString(12));
                d.setId_Direccion(rs.getInt(13));
                d.setPais_Direccion(rs.getString(14));
                d.setEstado_Direccion(rs.getString(15));
                d.setMunicipio_Direccion(rs.getString(16));
                d.setCalle_Direccion(rs.getString(17));
                d.setColonia_Direccion(rs.getString(18));
                d.setCodigoPostal_Direccion(rs.getString(19));
                d.setNumeroExterior_Direccion(rs.getString(20));
                d.setNumeroInterior_Direccion(rs.getString(21));
                u.setPersonaUsuario(p);
                u.getPersonaUsuario().setDireccionPersona(d);
                u.setRolUsuario(r);
                guardarUsuario.add(u);
            }

        } catch (SQLException ex) {
            System.err.println("Error guardar Usuario Consulta Usuario " + ex.getMessage());
            Logger.getLogger(ConsultaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
                rs.close();
                conexion.close();
            } catch (SQLException ex) {
                System.out.println("error cerrar conexiones Consulta Usuario cerrar Conexion " + ex.getMessage());
                Logger.getLogger(ConsultaCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return guardarUsuario;

    }

    @Override
    public Usuario mostrar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario agregar(Usuario agregar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean agregarDatos(Usuario t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizar(Usuario actualizar) {
        try {
            conDB = new ConexionDB();
            conexion = conDB.conexionDB();
            String sqlActUsuario = "UPDATE Usuario SET userName_User = ? where id_Usuario = ?";
            String sqlActUsuarioCOntra = "UPDATE Usuario SET userName_User = ?, password_User = ? where id_Usuario = ?";
            String sqlActualizarDireccion = "UPDATE Direccion SET pais_Direccion = ?, estado_Direccion = ?, municipio_Direccion = ?,\n"
                    + "calle_Direccion = ?,colonia_Direccion = ?, codigoPostal_Direccion = ?, numeroExterior_Direccion = ?,\n"
                    + "numeroInterior_Direccion = ? WHERE id_Direccion = ?";
            String sqlActualizarPersona = "UPDATE Persona SET nombre_Persona = ?, apellidoPaterno_Persona = ?, "
                    + "apellidoMaterno_Persona = ?, fechaNacimiento_Persona = ?,"
                    + "sexo_Persona = ?, telefono_Persona = ?, correo_Persona = ? WHERE id_Persona =?";

            if (actualizar.getId_Usuario() != 0 && actualizar.getContra().equals("")) {
                ps = conexion.prepareStatement(sqlActUsuario);
                ps.setString(1, actualizar.getUserName());
                ps.setInt(2, actualizar.getId_Usuario());

                ps.executeUpdate();
            }
            if (actualizar.getId_Usuario() != 0 && !actualizar.getContra().equals("")) {

                ps = conexion.prepareStatement(sqlActUsuarioCOntra);
                ps.setString(1, actualizar.getUserName());
                ps.setString(2, actualizar.getContra());
                ps.setInt(3, actualizar.getId_Usuario());
                ps.executeUpdate();

            }
            if (actualizar.getPersonaUsuario().getId_Persona() != 0) {

                ps = conexion.prepareStatement(sqlActualizarPersona);
                ps.setString(1, actualizar.getPersonaUsuario().getNombre_Persona());
                ps.setString(2, actualizar.getPersonaUsuario().getPaterno_Persona());
                ps.setString(3, actualizar.getPersonaUsuario().getMaterno_Persona());
                ps.setString(4, actualizar.getPersonaUsuario().getFechaNacimiento_Persona());
                ps.setString(5, actualizar.getPersonaUsuario().getSexo_Persona());
                ps.setString(6, actualizar.getPersonaUsuario().getTelefono_Persona());
                ps.setString(7, actualizar.getPersonaUsuario().getCorreo_Persona());
                ps.setInt(8, actualizar.getPersonaUsuario().getId_Persona());
                ps.executeUpdate();
            }

            if (actualizar.getPersonaUsuario().getDireccionPersona().getId_Direccion() != 0) {

                ps = conexion.prepareStatement(sqlActualizarDireccion);
                ps.setString(1, actualizar.getPersonaUsuario().getDireccionPersona().getPais_Direccion());
                ps.setString(2, actualizar.getPersonaUsuario().getDireccionPersona().getEstado_Direccion());
                ps.setString(3, actualizar.getPersonaUsuario().getDireccionPersona().getMunicipio_Direccion());
                ps.setString(4, actualizar.getPersonaUsuario().getDireccionPersona().getCalle_Direccion());
                ps.setString(5, actualizar.getPersonaUsuario().getDireccionPersona().getColonia_Direccion());
                ps.setString(6, actualizar.getPersonaUsuario().getDireccionPersona().getCodigoPostal_Direccion());
                ps.setString(7, actualizar.getPersonaUsuario().getDireccionPersona().getNumeroExterior_Direccion());
                ps.setString(8, actualizar.getPersonaUsuario().getDireccionPersona().getNumeroInterior_Direccion());
                ps.setInt(9, actualizar.getPersonaUsuario().getDireccionPersona().getId_Direccion());
                ps.executeUpdate();
            }

            return true;
        } catch (SQLException ex) {
            System.err.println("error Consulta Usuario cerrar Conexion " + ex.getMessage());
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

}
