/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author emanuelyepesmolina
 */

public class CContactoDAO {

    // Insertar contacto validando que no vayan vacíos
    public boolean insertarContacto(Connection con, CContacto c) {
        if (c.getNombres().isEmpty() || c.getApellidos().isEmpty() || c.getTelefono().isEmpty()
                || c.getDireccion().isEmpty() || c.getEmail().isEmpty()) {
            return false;
        }
        String sql = "INSERT INTO datos (nombres, apellidos, telefono, direccion, email) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, c.getNombres());
            ps.setString(2, c.getApellidos());
            ps.setString(3, c.getTelefono());
            ps.setString(4, c.getDireccion());
            ps.setString(5, c.getEmail());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Borrar contacto
    public boolean borrarContacto(Connection con, int id) {
        String sql = "DELETE FROM datos WHERE id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            return false;
        }
    }

    // Editar contacto
    public boolean editarContacto(Connection con, CContacto c) {
        String sql = "UPDATE datos SET nombres=?, apellidos=?, telefono=?, direccion=?, email=? WHERE id=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, c.getNombres());
            ps.setString(2, c.getApellidos());
            ps.setString(3, c.getTelefono());
            ps.setString(4, c.getDireccion());
            ps.setString(5, c.getEmail());
            ps.setInt(6, c.getId());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            return false;
        }
    }

    // Buscar por ID
    public CContacto buscarPorId(Connection con, int id) {
        String sql = "SELECT * FROM datos WHERE id=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new CContacto(
                        rs.getInt("id"),
                        rs.getString("nombres"),
                        rs.getString("apellidos"),
                        rs.getString("telefono"),
                        rs.getString("direccion"),
                        rs.getString("email")
                );
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    // Buscar por nombre
    public ArrayList<CContacto> buscarPorNombre(Connection con, String nombre) {
        String sql = "SELECT * FROM datos WHERE nombres LIKE ?";
        ArrayList<CContacto> lista = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new CContacto(
                        rs.getInt("id"),
                        rs.getString("nombres"),
                        rs.getString("apellidos"),
                        rs.getString("telefono"),
                        rs.getString("direccion"),
                        rs.getString("email")
                ));
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }

    // Buscar por apellido
    public ArrayList<CContacto> buscarPorApellido(Connection con, String apellido) {
        String sql = "SELECT * FROM datos WHERE apellidos LIKE ?";
        ArrayList<CContacto> lista = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, apellido + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new CContacto(
                        rs.getInt("id"),
                        rs.getString("nombres"),
                        rs.getString("apellidos"),
                        rs.getString("telefono"),
                        rs.getString("direccion"),
                        rs.getString("email")
                ));
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }

    // Listar todos los contactos
    public ArrayList<CContacto> listarTodos(Connection con) {
        String sql = "SELECT * FROM datos";
        ArrayList<CContacto> lista = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new CContacto(
                        rs.getInt("id"),
                        rs.getString("nombres"),
                        rs.getString("apellidos"),
                        rs.getString("telefono"),
                        rs.getString("direccion"),
                        rs.getString("email")
                ));
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }

    // Listar contactos que viven en calles
    public ArrayList<CContacto> listarCalles(Connection con) {
        String sql = "SELECT * FROM datos WHERE direccion LIKE '%Calle%'";
        ArrayList<CContacto> lista = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new CContacto(
                        rs.getInt("id"),
                        rs.getString("nombres"),
                        rs.getString("apellidos"),
                        rs.getString("telefono"),
                        rs.getString("direccion"),
                        rs.getString("email")
                ));
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }

    // Listar contactos que viven en carreras
    public ArrayList<CContacto> listarCarreras(Connection con) {
        String sql = "SELECT * FROM datos WHERE direccion LIKE '%Carrera%'";
        ArrayList<CContacto> lista = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new CContacto(
                        rs.getInt("id"),
                        rs.getString("nombres"),
                        rs.getString("apellidos"),
                        rs.getString("telefono"),
                        rs.getString("direccion"),
                        rs.getString("email")
                ));
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }

    // Filtrar por prefijo de teléfono
    public ArrayList<CContacto> filtrarPorPrefijo(Connection con, String prefijo) {
        String sql = "SELECT * FROM datos WHERE telefono LIKE ?";
        ArrayList<CContacto> lista = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, prefijo + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new CContacto(
                        rs.getInt("id"),
                        rs.getString("nombres"),
                        rs.getString("apellidos"),
                        rs.getString("telefono"),
                        rs.getString("direccion"),
                        rs.getString("email")
                ));
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }

    // Listar contactos alfabéticamente por nombre
    public ArrayList<CContacto> listarAlfabeticamente(Connection con) {
        String sql = "SELECT * FROM datos ORDER BY nombres ASC";
        ArrayList<CContacto> lista = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new CContacto(
                        rs.getInt("id"),
                        rs.getString("nombres"),
                        rs.getString("apellidos"),
                        rs.getString("telefono"),
                        rs.getString("direccion"),
                        rs.getString("email")
                ));
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }

    // Listar IDs pares
    public ArrayList<CContacto> listarIDPares(Connection con) {
        String sql = "SELECT * FROM datos WHERE MOD(id,2)=0";
        ArrayList<CContacto> lista = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new CContacto(
                        rs.getInt("id"),
                        rs.getString("nombres"),
                        rs.getString("apellidos"),
                        rs.getString("telefono"),
                        rs.getString("direccion"),
                        rs.getString("email")
                ));
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }

    // Listar IDs impares
    public ArrayList<CContacto> listarIDImpares(Connection con) {
        String sql = "SELECT * FROM datos WHERE MOD(id,2)=1";
        ArrayList<CContacto> lista = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new CContacto(
                        rs.getInt("id"),
                        rs.getString("nombres"),
                        rs.getString("apellidos"),
                        rs.getString("telefono"),
                        rs.getString("direccion"),
                        rs.getString("email")
                ));
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }

    // Listar un campo específico (columna)
    public ArrayList<String> listarCampoEspecifico(Connection con, String campo) {
        String sql = "SELECT " + campo + " FROM datos";
        ArrayList<String> lista = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(rs.getString(campo));
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }
}
