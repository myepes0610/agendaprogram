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
public class CConsultas {
    
    //de la librería sql usamos como atributo un objeto de tipo conexión, que es necesario para ejecutar las consultas
    Connection con;
    String query;

    public CConsultas() {

    }

    //para ejecutar el método recibimos por parámetro una conexión activa
    public boolean ingresar(Connection con, String nombres, String apellidos, String telefono, String direccion, String email) {
        this.con = con;
        query = "INSERT INTO datos(id,nombres,apellidos,telefono,direccion,email) VALUES (null,'" + nombres + "','" + apellidos + "','" + telefono + "','" + direccion + "','" + email + "');";
        try {
            //preparo la consulta
            PreparedStatement preparar = con.prepareStatement(query);
            //ejecuto la consulta luego de prepararla
            preparar.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error en el sql");
            return false;
        }
    }

    //para ejecutar el método recibimos por parámetro una conexión activa
    public ArrayList<CContacto> consultar(Connection con) {
        this.con = con;
        query = "SELECT * FROM datos";
        ArrayList<CContacto> lista = new ArrayList<>();
        try {
            //preparo la consulta
            PreparedStatement preparar = con.prepareStatement(query);
            //ejecuto la consulta luego de prepararla
            ResultSet resultado = preparar.executeQuery();

                      while (resultado.next()) {
                CContacto c = new CContacto(
                        resultado.getInt("id"),
                        resultado.getString("nombres"),
                        resultado.getString("apellidos"),
                        resultado.getString("telefono"),
                        resultado.getString("direccion"),
                        resultado.getString("email")
                );
                lista.add(c);
            }
            System.out.println("Consulta correcta");
            return lista;

        } catch (SQLException ex) {
            System.out.println("Error en el sql");
            return null;
        }
    }
}

