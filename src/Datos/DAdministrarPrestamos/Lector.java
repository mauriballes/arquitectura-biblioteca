/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos.DAdministrarPrestamos;

import Datos.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mauriballes
 */
public class Lector {

    private int id;
    private int ci;
    private String apellidos;
    private String nombres;
    private String direccion;
    private Date fecha_nacimiento;
    private char sexo;
    private int telefono;
    private Date fecha_afiliacion;
    private int id_persona;

    private Conexion m_Conexion;

    public Lector() {
        m_Conexion = Conexion.getInstancia();
    }

    /**
     *
     * @param id
     */
    public void eliminarLector(int id) {
        Connection con = m_Conexion.getConexion();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT biblioteca.lector.id_persona FROM biblioteca.lector WHERE biblioteca.lector.id = ?");
            ps.setInt(1, id);
            int id_persona = 0;
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                id_persona = rs.getInt("id_persona");
            }
            PreparedStatement ps2 = con.prepareStatement("DELETE FROM biblioteca.lector WHERE biblioteca.lector.id = ?");
            ps2.setInt(1, id);
            int rows = ps2.executeUpdate();
            PreparedStatement ps3 = con.prepareStatement("DELETE FROM biblioteca.persona WHERE biblioteca.persona.id = ?");
            ps3.setInt(1, id_persona);
            rows = ps3.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Bibliotecario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public DefaultTableModel getLectores() {
        DefaultTableModel lectores = new DefaultTableModel();
        lectores.setColumnIdentifiers(new Object[]{"id", "ci", "apellidos", "nombres", "direccion", "fecha_nacimiento", "sexo", "telefono", "fecha_afiliacion", "id_persona"});
        Connection con = m_Conexion.getConexion();
        String sql = "SELECT \n"
                + "biblioteca.lector.id,\n"
                + "biblioteca.persona.ci,\n"
                + "biblioteca.persona.apellidos,\n"
                + "biblioteca.persona.nombres,\n"
                + "biblioteca.persona.direccion,\n"
                + "biblioteca.persona.fecha_nacimiento,\n"
                + "biblioteca.persona.sexo,\n"
                + "biblioteca.persona.telefono,\n"
                + "biblioteca.lector.fecha_afiliacion,\n"
                + "biblioteca.lector.id_persona\n"
                + "FROM biblioteca.lector, biblioteca.persona\n"
                + "WHERE biblioteca.lector.id_persona = biblioteca.persona.id";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lectores.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getInt("ci"),
                    rs.getString("apellidos"),
                    rs.getString("nombres"),
                    rs.getString("direccion"),
                    rs.getDate("fecha_nacimiento"),
                    rs.getString("sexo"),
                    rs.getInt("telefono"),
                    rs.getInt("fecha_afiliacion"),
                    rs.getInt("id_persona")
                });
            }
        } catch (SQLException ex) {
            Logger.getLogger(Lector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lectores;
    }

    public int insertarLector() {
        Connection con = m_Conexion.getConexion();
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO biblioteca.persona(ci,apellidos,nombres, fecha_nacimiento, direccion, sexo, telefono)\n"
                    + "VALUES (?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, ci);
            ps.setString(2, apellidos);
            ps.setString(3, nombres);
            ps.setDate(4, fecha_nacimiento);
            ps.setString(5, direccion);
            ps.setString(6, String.valueOf(sexo));
            ps.setInt(7, telefono);
            int rows = ps.executeUpdate();
            if (rows != 0) {
                ResultSet generateKeys = ps.getGeneratedKeys();
                if (generateKeys.next()) {
                    int idPersona = generateKeys.getInt(1);
                    PreparedStatement ps2 = con.prepareStatement("INSERT INTO biblioteca.lector(fecha_afiliacion,id_persona) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);
                    ps2.setDate(1, fecha_afiliacion);
                    ps2.setInt(2, idPersona);
                    rows = ps2.executeUpdate();
                    if (rows != 0) {
                        generateKeys = ps2.getGeneratedKeys();
                        if (generateKeys.next()) {
                            return generateKeys.getInt(1);
                        }
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Lector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public void modificarLector() {
        Connection con = m_Conexion.getConexion();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT biblioteca.lector.id_persona FROM biblioteca.lector WHERE biblioteca.lector.id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                this.id_persona = rs.getInt("id_persona");
            }
            String sql = "UPDATE biblioteca.persona \n"
                    + "SET biblioteca.persona.ci = ?,\n"
                    + "biblioteca.persona.apellidos = ?,\n"
                    + "biblioteca.persona.nombres = ?,\n"
                    + "biblioteca.persona.direccion = ?,\n"
                    + "biblioteca.persona.fecha_nacimiento = ?,\n"
                    + "biblioteca.persona.sexo = ?,\n"
                    + "biblioteca.persona.telefono = ?\n"
                    + "WHERE biblioteca.persona.id = ?";
            PreparedStatement ps2 = con.prepareStatement(sql);
            ps2.setInt(1, ci);
            ps2.setString(2, apellidos);
            ps2.setString(3, nombres);
            ps2.setString(4, direccion);
            ps2.setDate(5, fecha_nacimiento);
            ps2.setString(6, String.valueOf(sexo));
            ps2.setInt(7, telefono);
            ps2.setInt(8, id_persona);
            int rows = ps2.executeUpdate();
            sql = "UPDATE biblioteca.lector \n"
                    + "SET biblioteca.lector.fecha_afiliacion = ?\n"
                    + "WHERE biblioteca.lector.id = ?";
            PreparedStatement ps3 = con.prepareStatement(sql);
            ps3.setDate(1, fecha_afiliacion);
            ps3.setInt(2, id);
            rows = ps3.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Lector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param ci
     * @param apellidos
     * @param nombres
     * @param direccion
     * @param fecha_nacimiento
     * @param sexo
     * @param telefono
     * @param fecha_afiliacion
     */
    public void setLector(int ci, String apellidos, String nombres, String direccion, Date fecha_nacimiento, char sexo, int telefono, Date fecha_afiliacion) {
        this.ci = ci;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.direccion = direccion;
        this.fecha_nacimiento = fecha_nacimiento;
        this.sexo = sexo;
        this.telefono = telefono;
        this.fecha_afiliacion = fecha_afiliacion;
    }

    /**
     *
     * @param id
     * @param ci
     * @param apellidos
     * @param nombres
     * @param direccion
     * @param fecha_nacimiento
     * @param sexo
     * @param telefono
     * @param fecha_afiliacion
     * @param id_persona
     */
    public void setLector(int id, int ci, String apellidos, String nombres, String direccion, Date fecha_nacimiento, char sexo, int telefono, Date fecha_afiliacion, int id_persona) {
        this.id = id;
        this.ci = ci;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.direccion = direccion;
        this.fecha_nacimiento = fecha_nacimiento;
        this.sexo = sexo;
        this.telefono = telefono;
        this.fecha_afiliacion = fecha_afiliacion;
        this.id_persona = id_persona;
    }
}
