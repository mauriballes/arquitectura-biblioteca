/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos.DAdministrarLibros;

import Datos.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mauriballes
 */
public class Libro {

    private int id;
    private String titulo;
    private String isbn;
    private String descripcion;
    private int paginas;
    private Date fecha_lanzamiento;
    private String idioma;
    private int edicion;
    private int nro_ejemplares;
    private int id_categoria;
    private int id_editorial;
    private LinkedList<Integer> ids_autores;

    private Conexion m_Conexion;

    public Libro() {
        m_Conexion = Conexion.getInstancia();
    }

    /**
     *
     * @param id
     */
    public void eliminarLibro(int id) {

    }

    public DefaultTableModel getLibros() {
        DefaultTableModel libros = new DefaultTableModel();
        libros.setColumnIdentifiers(new Object[]{"id", "titulo", "isbn", "descripcion", "paginas", "fecha_lanzamiento", "idioma", "edicion", "nro_ejemplares", "id_categoria", "id_editorial", "ids_autores"});
        Connection con = m_Conexion.getConexion();
        String sql = "SELECT \n"
                + "biblioteca.libro.id,\n"
                + "biblioteca.libro.titulo,\n"
                + "biblioteca.libro.isbn,\n"
                + "biblioteca.libro.descripcion,\n"
                + "biblioteca.libro.paginas,\n"
                + "biblioteca.libro.fecha_lanzamiento,\n"
                + "biblioteca.libro.idioma,\n"
                + "biblioteca.libro.edicion,\n"
                + "biblioteca.libro.id_categoria,\n"
                + "biblioteca.libro.id_editorial\n"
                + "FROM biblioteca.libro";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                libros.addRow(new Object[]{
                    id,
                    rs.getString("titulo"),
                    rs.getString("isbn"),
                    rs.getString("descripcion"),
                    rs.getInt("paginas"),
                    rs.getDate("fecha_lanzamiento"),
                    rs.getString("idioma"),
                    rs.getInt("edicion"),
                    0,
                    rs.getInt("id_categoria"),
                    rs.getInt("id_editorial"),
                    null
                });
                sql = "SELECT biblioteca.autoria.id_autor\n"
                        + "FROM biblioteca.autoria\n"
                        + "WHERE biblioteca.autoria.id_libro = ?";
                PreparedStatement ps2 = con.prepareStatement(sql);
                ps2.setInt(1, id);
                ResultSet rs2 = ps2.executeQuery();
                LinkedList<Integer> id_autores = new LinkedList<>();
                while (rs2.next()) {
                    id_autores.add(rs2.getInt("id_autor"));
                }
                libros.setValueAt(id_autores, libros.getRowCount() - 1, libros.getColumnCount() - 1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Libro.class.getName()).log(Level.SEVERE, null, ex);
        }
        return libros;
    }

    public int insertarLibro() {
        return 0;
    }

    public void modificarLibro() {

    }

    /**
     *
     * @param titulo
     * @param isbn
     * @param descripcion
     * @param paginas
     * @param edicion
     * @param fecha_lanzamiento
     * @param idioma
     * @param nro_ejemplares
     * @param id_categoria
     * @param id_editorial
     * @param ids_autores
     */
    public void setLibro(String titulo, String isbn, String descripcion, int paginas, int edicion, Date fecha_lanzamiento, String idioma, int nro_ejemplares, int id_categoria, int id_editorial, LinkedList<Integer> ids_autores) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.descripcion = descripcion;
        this.paginas = paginas;
        this.edicion = edicion;
        this.fecha_lanzamiento = fecha_lanzamiento;
        this.idioma = idioma;
        this.nro_ejemplares = nro_ejemplares;
        this.id_categoria = id_categoria;
        this.id_editorial = id_editorial;
        this.ids_autores = ids_autores;
    }

    /**
     *
     * @param id
     * @param titulo
     * @param isbn
     * @param descripcion
     * @param paginas
     * @param edicion
     * @param fecha_lanzamiento
     * @param idioma
     * @param nro_ejemplares
     * @param id_categoria
     * @param id_editorial
     * @param ids_autores
     */
    public void setLibro(int id, String titulo, String isbn, String descripcion, int paginas, int edicion, Date fecha_lanzamiento, String idioma, int nro_ejemplares, int id_categoria, int id_editorial, LinkedList<Integer> ids_autores) {
        this.id = id;
        this.titulo = titulo;
        this.isbn = isbn;
        this.descripcion = descripcion;
        this.paginas = paginas;
        this.edicion = edicion;
        this.fecha_lanzamiento = fecha_lanzamiento;
        this.idioma = idioma;
        this.nro_ejemplares = nro_ejemplares;
        this.id_categoria = id_categoria;
        this.id_editorial = id_editorial;
        this.ids_autores = ids_autores;
    }
}
