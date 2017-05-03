/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos.DAdministrarLibros;

import Datos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mauriballes
 */
public class Ejemplar {

    private int id_libro;
    private int nro_ejemplar;

    private Conexion m_Conexion;

    public Ejemplar() {
        m_Conexion = Conexion.getInstancia();
    }

    /**
     *
     * @param id_libro
     * @param nro_ejemplar
     */
    public void eliminarEjemplar(int id_libro, int nro_ejemplar) {

    }

    /**
     *
     * @param id_libro
     */
    public int eliminarEjemplares(int id_libro) {
        return 0;
    }

    /**
     *
     * @param id_libro
     */
    public int getCantEjemplares(int id_libro) {
        String sql = "SELECT count(*) AS `cantEjemplares`\n"
                + "FROM biblioteca.ejemplar\n"
                + "WHERE biblioteca.ejemplar.id_libro = ?";
        Connection con = m_Conexion.getConexion();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id_libro);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt("cantEjemplares");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Ejemplar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    /**
     *
     * @param id_libro
     */
    public DefaultTableModel getEjemplares(int id_libro) {
        return null;
    }

    public void insertarEjemplar() {

    }

    public void modificarEjemplar() {

    }

    /**
     *
     * @param id_libro
     * @param nro_ejemplar
     */
    public void setEjemplar(int id_libro, int nro_ejemplar) {

    }
}
