/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;
import java.util.ArrayList;

/**
 *
 * @author GoodF
 */
public interface CRUD <T> {
    public boolean insertar(T p);
    public boolean eliminar(String dato);
    public T listarUno(String dato);
    public boolean actualizar(T p);
    public ArrayList<T> listarTodos();
}
