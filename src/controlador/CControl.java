/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import vista.*;
import modelo.*;
import java.sql.Connection;
import java.util.ArrayList;
import modelo.CContactoDAO;
import modelo.CConexion;
import modelo.CContacto;

/**
 *
 * @author emanuelyepesmolina
 */

public class CControl {

    private CConexion conexion;
    private CContactoDAO dao;

    public CControl() {
        conexion = new CConexion();
        dao = new CContactoDAO();
    }

    // Insertar contacto
    public boolean insertar(CContacto c) {
        Connection con = conexion.conectar();
        return dao.insertarContacto(con, c);
    }

    // Borrar contacto
    public boolean borrar(int id) {
        Connection con = conexion.conectar();
        return dao.borrarContacto(con, id);
    }

    // Editar contacto
    public boolean editar(CContacto c) {
        Connection con = conexion.conectar();
        return dao.editarContacto(con, c);
    }

    // Buscar por ID
    public CContacto buscarPorId(int id) {
        Connection con = conexion.conectar();
        return dao.buscarPorId(con, id);
    }

    // Buscar por nombre
    public ArrayList<CContacto> buscarPorNombre(String nombre) {
        Connection con = conexion.conectar();
        return dao.buscarPorNombre(con, nombre);
    }

    // Buscar por apellido
    public ArrayList<CContacto> buscarPorApellido(String apellido) {
        Connection con = conexion.conectar();
        return dao.buscarPorApellido(con, apellido);
    }

    // Listar todos los contactos
    public ArrayList<CContacto> listarTodos() {
        Connection con = conexion.conectar();
        return dao.listarTodos(con);
    }

    // Listar por calles
    public ArrayList<CContacto> listarCalles() {
        Connection con = conexion.conectar();
        return dao.listarCalles(con);
    }

    // Listar por carreras
    public ArrayList<CContacto> listarCarreras() {
        Connection con = conexion.conectar();
        return dao.listarCarreras(con);
    }

    // Filtrar por prefijo de teléfono
    public ArrayList<CContacto> filtrarPorPrefijo(String prefijo) {
        Connection con = conexion.conectar();
        return dao.filtrarPorPrefijo(con, prefijo);
    }

    // Listar alfabéticamente por nombre
    public ArrayList<CContacto> listarAlfabeticamente() {
        Connection con = conexion.conectar();
        return dao.listarAlfabeticamente(con);
    }

    // Listar IDs pares
    public ArrayList<CContacto> listarIDPares() {
        Connection con = conexion.conectar();
        return dao.listarIDPares(con);
    }

    // Listar IDs impares
    public ArrayList<CContacto> listarIDImpares() {
        Connection con = conexion.conectar();
        return dao.listarIDImpares(con);
    }

    // Listar un campo específico
    public ArrayList<String> listarCampoEspecifico(String campo) {
        Connection con = conexion.conectar();
        return dao.listarCampoEspecifico(con, campo);
    }
}


