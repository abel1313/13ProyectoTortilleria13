/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Consultas.ConsultaUsuario;
import Modelo.Cliente;
import Modelo.Direccion;
import Modelo.EncryptionPassword;
import Modelo.Persona;
import Modelo.Rol;
import Modelo.Usuario;

import ModeloDAO.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author trece
 */
@WebServlet(name = "ServletUsuario", urlPatterns = {"/DatosUsuario"})
public class ServletUsuario extends HttpServlet {
String accion="";
UsuarioDAO usrDAO = null;
Usuario usuarioDatos = null;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletUsuario</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletUsuario at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        accion = request.getParameter("accion");
        usrDAO = new ConsultaUsuario();
        usuarioDatos = new Usuario();
        System.out.println("accio "+ accion);
        if (accion != null) {
             

            if (accion.equals("accederSistema")) {
                String usuario = request.getParameter("userName");
                String contra = request.getParameter("contra");
                String correo = request.getParameter("correoElect");
               
                System.out.println("Ecceder "+correo);
                if ((!usuario.equals("") && !contra.equals("")) || (!correo.equals(""))) {
                    try {
                        EncryptionPassword encryption = new EncryptionPassword();
                        
                        final String secret = "Secret";
                        String passAcc = encryption.encriptar(contra, secret);
                        usuarioDatos = usrDAO.accederUsuario(usuario, passAcc, correo);
                        
                        if (usuarioDatos.getId_Usuario() != 0) {
                            
                            request.getSession().setAttribute("us", usuarioDatos);
                        } else {
                            request.getSession().setAttribute("Mensaje", "Usuario o Contrasena incorrecta");
                        }
                    } catch (UnsupportedEncodingException ex) {
                        Logger.getLogger(ServletUsuario.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (NoSuchAlgorithmException ex) {
                        Logger.getLogger(ServletUsuario.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InvalidKeyException ex) {
                        Logger.getLogger(ServletUsuario.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (NoSuchPaddingException ex) {
                        Logger.getLogger(ServletUsuario.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IllegalBlockSizeException ex) {
                        Logger.getLogger(ServletUsuario.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (BadPaddingException ex) {
                        Logger.getLogger(ServletUsuario.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

            if (accion.equals("AgregarUsuarioDts")) {
                

                

                usrDAO = new ConsultaUsuario();
                usuarioDatos = new Usuario();
                Direccion dir = new Direccion();
                Rol ro = new Rol();
                Persona per = new Persona();
                

                if (!request.getParameter("userName").equals("")
                        && !request.getParameter("pass").equals("")) {
                    try {
                        EncryptionPassword enc = new EncryptionPassword();
                        final String secret = "Secret";

                        String passSecr = enc.encriptar(request.getParameter("pass"), secret);
                        
                        usuarioDatos.setUserName(request.getParameter("userName"));
                        
                        usuarioDatos.setContra(passSecr);
                        
                        
                    } catch (UnsupportedEncodingException ex) {
                        Logger.getLogger(ServletUsuario.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (NoSuchAlgorithmException ex) {
                        Logger.getLogger(ServletUsuario.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InvalidKeyException ex) {
                        Logger.getLogger(ServletUsuario.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (NoSuchPaddingException ex) {
                        Logger.getLogger(ServletUsuario.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IllegalBlockSizeException ex) {
                        Logger.getLogger(ServletUsuario.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (BadPaddingException ex) {
                        Logger.getLogger(ServletUsuario.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                
                dir.setPais_Direccion(request.getParameter("Pais"));
                dir.setEstado_Direccion(request.getParameter("Estado"));
                dir.setMunicipio_Direccion(request.getParameter("Municipio"));
                dir.setCalle_Direccion(request.getParameter("Calle"));
                dir.setColonia_Direccion(request.getParameter("Colonia"));
                dir.setCodigoPostal_Direccion(request.getParameter("Postal"));
                dir.setNumeroExterior_Direccion(request.getParameter("Exterior"));
                dir.setNumeroInterior_Direccion(request.getParameter("Interior"));

                per.setNombre_Persona(request.getParameter("Nombre"));
                per.setPaterno_Persona(request.getParameter("Paterno"));
                per.setMaterno_Persona(request.getParameter("Materno"));
                per.setFechaNacimiento_Persona(request.getParameter("Nacimiento"));
                per.setSexo_Persona(request.getParameter("Sexo"));
                per.setTelefono_Persona(request.getParameter("Telefono"));
                per.setCorreo_Persona(request.getParameter("Correo"));

                ro.setId_RolUduario(2);
                if(request.getParameter("userName").equals("")
                        && request.getParameter("pass").equals(""))
                {
                usuarioDatos.setUserName(per.getNombre_Persona());
                }
                

                usuarioDatos.getPersonaUsuario().setDireccionPersona(dir);
                usuarioDatos.setPersonaUsuario(per);
                usuarioDatos.setRolUsuario(ro);
                
                usuarioDatos.getEstatusUsuario().setId_Estatus(1);
                if (usrDAO.agregarUsuario(usuarioDatos)) {
                }
            }
            if (accion.equals("validarCorreo")) {
                if (usrDAO.validarCorreo(request.getParameter("Correo"))) {
                    response.setContentType("text/plain");
                    response.getWriter().write("false");
                } else {
                    response.setContentType("text/plain");
                    response.getWriter().write("true");
                }
            }
            if (accion.equals("validarCorreoActualizar")) {
                Usuario dtsUsuario = (Usuario) request.getSession().getAttribute("usuarioListoActualizar");
                if (usrDAO.validarCorreoActualizar(request.getParameter("Correos"), dtsUsuario.getPersonaUsuario().getId_Persona())) {
                    response.setContentType("text/plain");
                    response.getWriter().write("false");
                } else {
                    response.setContentType("text/plain");
                    response.getWriter().write("true");
                }
            }
            if (accion.equals("buscarUsuario")) {
                usrDAO = new ConsultaUsuario();
                
                ArrayList usuariosEncontrados = usrDAO.buscarTodos(request.getParameter("busca"));
                request.getSession().setAttribute("usuariosEncontados", usuariosEncontrados);
            }
            
            
            if (accion.equals("ActualizarUsuarioDts")) {
               Usuario dtsUsuarioActualizar = (Usuario) request.getSession().getAttribute("usuarioListoActualizar");
               usrDAO = new ConsultaUsuario();
               Boolean cambiarPass = Boolean.parseBoolean(request.getParameter("cambiarPass"));
               Boolean cambiarPer = Boolean.parseBoolean(request.getParameter("DtsPersonales"));
               Boolean cambiarDir = Boolean.parseBoolean(request.getParameter("DtsDireccion"));
               
                

                   Persona pe = new Persona();
                   Direccion di = new Direccion();
                   Usuario u = new Usuario();
               
               if(!cambiarPass)
               {
                       u.setId_Usuario(dtsUsuarioActualizar.getId_Usuario());
                       u.setUserName(request.getParameter("UsrName"));
               }
               if(cambiarPass)
               {

                   EncryptionPassword enc = new EncryptionPassword();
                 final String secret = "Secret";
                   try {
                       
                       String passAcc = enc.encriptar(request.getParameter("NuevaContra"), secret);
                       u.setId_Usuario(dtsUsuarioActualizar.getId_Usuario());
                       u.setUserName(request.getParameter("UsrName"));
                       u.setContra(passAcc);
                      
                       
                       
                   } catch (UnsupportedEncodingException ex) {
                       System.err.println("1 "+ex.getMessage());
                       Logger.getLogger(ServletUsuario.class.getName()).log(Level.SEVERE, null, ex);
                   } catch (NoSuchAlgorithmException ex) {
                       System.err.println("2 "+ex.getMessage());
                       Logger.getLogger(ServletUsuario.class.getName()).log(Level.SEVERE, null, ex);
                   } catch (InvalidKeyException ex) {
                       System.err.println("3 "+ex.getMessage());
                       Logger.getLogger(ServletUsuario.class.getName()).log(Level.SEVERE, null, ex);
                   } catch (NoSuchPaddingException ex) {
                       System.err.println("4 "+ex.getMessage());
                       Logger.getLogger(ServletUsuario.class.getName()).log(Level.SEVERE, null, ex);
                   } catch (IllegalBlockSizeException ex) {
                       System.err.println("5 "+ex.getMessage());
                       Logger.getLogger(ServletUsuario.class.getName()).log(Level.SEVERE, null, ex);
                   } catch (BadPaddingException ex) {
                       System.err.println("6 "+ex.getMessage());
                       Logger.getLogger(ServletUsuario.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(cambiarPer)
               {
                   
                   pe.setId_Persona(dtsUsuarioActualizar.getPersonaUsuario().getId_Persona());
                   pe.setNombre_Persona(request.getParameter("Nombre"));
                   pe.setPaterno_Persona(request.getParameter("Paterno"));
                   pe.setMaterno_Persona(request.getParameter("Materno"));
                   pe.setFechaNacimiento_Persona(request.getParameter("Nacimiento"));
                   pe.setTelefono_Persona(request.getParameter("Telefono"));
                   pe.setSexo_Persona(request.getParameter("Sexo"));
                   pe.setCorreo_Persona(request.getParameter("Correos"));
                   u.setPersonaUsuario(pe);
               }
               if(cambiarDir)
               {
                   
                   di.setId_Direccion(dtsUsuarioActualizar.getPersonaUsuario().getDireccionPersona().getId_Direccion());
                   di.setPais_Direccion(request.getParameter("Pais"));
                   di.setEstado_Direccion(request.getParameter("Estado"));
                   di.setMunicipio_Direccion(request.getParameter("Municipio"));
                   di.setCalle_Direccion(request.getParameter("Calle"));
                   di.setColonia_Direccion(request.getParameter("Colonia"));
                   di.setCodigoPostal_Direccion(request.getParameter("Postal"));
                   di.setNumeroExterior_Direccion(request.getParameter("Exterior"));
                   di.setNumeroInterior_Direccion(request.getParameter("Interior"));
                   u.getPersonaUsuario().setDireccionPersona(di);
               }

                    
//                if (request.getParameter("DtsPersonales") == null) {
//                    System.out.println("malo");
//                }
              
//              if (request.getParameter("DtsDireccion") == null) {
//                    System.out.println("malo");
//                } else 
//               if(dtsDireccion.equals("actualizarDireccion"))
//               {
//                   System.out.println("Entro a cambiar password");
//                   
//                   di.setId_Direccion(dtsUsuarioActualizar.getPersonaUsuario().getDireccionPersona().getId_Direccion());
//                   di.setPais_Direccion(request.getParameter("Pais"));
//                   di.setEstado_Direccion(request.getParameter("Estado"));
//                   di.setMunicipio_Direccion(request.getParameter("Municipio"));
//                   di.setCalle_Direccion(request.getParameter("Calle"));
//                   di.setColonia_Direccion(request.getParameter("Colonia"));
//                   di.setCodigoPostal_Direccion(request.getParameter("Postal"));
//                   di.setNumeroExterior_Direccion(request.getParameter("Exterior"));
//                   di.setNumeroInterior_Direccion(request.getParameter("Interior"));
//                   u.getPersonaUsuario().setDireccionPersona(di);
//               }
               

                if(usrDAO.actualizar(u)){}
                
               
            }

            if (accion.equals("sairSistema")) {
                request.getSession().removeAttribute("us");
                request.getSession().invalidate();
            }

        }
        

    }
        public void persn(HttpServletRequest request,HttpServletResponse response){
        Boolean cambiarPass = Boolean.parseBoolean(request.getParameter("cambiarPass"));
            
    }


    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

