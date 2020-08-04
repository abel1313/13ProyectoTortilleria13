/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MCRUD;



import java.util.ArrayList;




/**
 *
 * @author trece
 */
public interface CRUD <T>
{

    
    public ArrayList<T>mostrarUsuario();
    public ArrayList<T>buscar(int buscar);
    public ArrayList<T>buscarTodos(String buscar);
    public boolean actualizar(T actualizar);
    public T mostrar();
    public T agregar(T agregar);
    public boolean agregarDatos(T t);
}
