/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio.NAdministrarPrestamos;

import Datos.DAdministrarPrestamos.FichaPrestamo;
import java.sql.Date;
import java.util.LinkedList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mauriballes
 */
public class FichaPrestamoNegocio {

    private DetallePrestamoNegocio m_DetallePrestamoNegocio;
    private FichaPrestamo m_FichaPrestamo;

    public FichaPrestamoNegocio() {
        m_DetallePrestamoNegocio = new DetallePrestamoNegocio();
        m_FichaPrestamo = new FichaPrestamo();
    }

    /**
     *
     * @param id
     */
    public void concretarPrestamo(int id) {

    }

    /**
     *
     * @param id
     */
    public DefaultTableModel obtenerDetallePrestamo(int id) {
        return null;
    }

    public DefaultTableModel obtenerPrestamos() {
        return null;
    }

    /**
     *
     * @param fecha_prestamo
     * @param fecha_devolucion
     * @param id_lector
     * @param id_bibliotecario
     * @param ids_libros
     * @param nros_ejemplares
     */
    public int registrarPrestamo(Date fecha_prestamo, Date fecha_devolucion, int id_lector, int id_bibliotecario, LinkedList<Integer> ids_libros, LinkedList<Integer> nros_ejemplares) {
        return 0;
    }
}
