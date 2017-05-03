/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos.DAdministrarPrestamos;

import Datos.Conexion;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mauriballes
 */
public class DetallePrestamo {

    private int id_libro;
    private int nro_ejemplar;
    private int id_prestamo;

    private Conexion m_Conexion;

    public DetallePrestamo() {
        m_Conexion = Conexion.getInstancia();
    }

    /**
     *
     * @param id_prestamo
     */
    public DefaultTableModel getDetallePrestamo(int id_prestamo) {
        return null;
    }

    public void insertarDetallePrestamo() {

    }

    /**
     *
     * @param id_prestamo
     * @param id_libro
     * @param nro_ejemplar
     */
    public void setDetallePrestamo(int id_prestamo, int id_libro, int nro_ejemplar) {

    }
}
