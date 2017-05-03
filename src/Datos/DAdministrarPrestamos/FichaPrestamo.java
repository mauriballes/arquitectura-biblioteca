/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos.DAdministrarPrestamos;

import Datos.Conexion;
import java.sql.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mauriballes
 */
public class FichaPrestamo {

    private Date fechaDevolucion;
    private Date fechaPrestamo;
    private boolean devuelto;
    private int idBibliotecario;
    private int idLector;

    private Conexion m_Conexion;

    public FichaPrestamo() {
        m_Conexion = Conexion.getInstancia();
    }

    /**
     *
     * @param idPrestamo
     */
    public void concretarDevolucion(int idPrestamo) {

    }

    public DefaultTableModel getPrestamos() {
        return null;
    }

    public int registrarPrestamo() {
        return 0;
    }

    /**
     *
     * @param fechaPrestamo
     * @param fechaDevolucion
     * @param idLector
     * @param idBibliotecario
     */
    public void setPrestamo(Date fechaPrestamo, Date fechaDevolucion, int idLector, int idBibliotecario) {

    }
}
