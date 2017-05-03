/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.PAdministrarLibros;

import Negocio.NAdministrarLibros.AutorNegocio;
import Negocio.NAdministrarLibros.CategoriaNegocio;
import Negocio.NAdministrarLibros.EditorialNegocio;
import Negocio.NAdministrarLibros.LibroNegocio;
import java.sql.Date;
import java.util.LinkedList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mauriballes
 */
public class LibroFrm extends javax.swing.JFrame {

    /**
     * Creates new form LibroFrm
     */
    private LibroNegocio m_LibroNegocio;
    private EditorialNegocio m_EditorialNegocio;
    private CategoriaNegocio m_CategoriaNegocio;
    private AutorNegocio m_AutorNegocio;

    public LibroFrm() {
        initComponents();
        this.setTitle("Gestionar Libro");
        this.setLocationRelativeTo(null);
        m_LibroNegocio = new LibroNegocio();
        m_AutorNegocio = new AutorNegocio();
        m_CategoriaNegocio = new CategoriaNegocio();
        m_EditorialNegocio = new EditorialNegocio();
        inicializar();
    }

    public void cargarTablaAutores() {
        DefaultTableModel autores = m_AutorNegocio.obtenerAutores();
        tableAutores.setModel(autores);
    }

    public void cargarTablaCategoria() {
        DefaultTableModel categorias = m_CategoriaNegocio.obtenerCategorias();
        tableCategoria.setModel(categorias);
        tableCategoria.removeColumn(tableCategoria.getColumn("descripcion"));
    }

    public void cargarTablaEditorial() {
        DefaultTableModel editoriales = m_EditorialNegocio.obtenerEditoriales();
        tableEditorial.setModel(editoriales);
        tableEditorial.removeColumn(tableEditorial.getColumn("telefono"));
        tableEditorial.removeColumn(tableEditorial.getColumn("direccion"));
    }

    public void eliminarLibro() {

    }

    public void inicializar() {
        cargarTablaEditorial();
        cargarTablaAutores();
        cargarTablaCategoria();
        obtenerLibros();
    }

    public void modificarLibro() {

    }

    public void obtenerLibros() {
        DefaultTableModel libros = m_LibroNegocio.obtenerLibros();
        tableLibros.setModel(libros);
        tableLibros.removeColumn(tableLibros.getColumn("isbn"));
        tableLibros.removeColumn(tableLibros.getColumn("paginas"));
        tableLibros.removeColumn(tableLibros.getColumn("fecha_lanzamiento"));
        tableLibros.removeColumn(tableLibros.getColumn("idioma"));
        tableLibros.removeColumn(tableLibros.getColumn("edicion"));
        tableLibros.removeColumn(tableLibros.getColumn("nro_ejemplares"));
        tableLibros.removeColumn(tableLibros.getColumn("id_categoria"));
        tableLibros.removeColumn(tableLibros.getColumn("id_editorial"));
        tableLibros.removeColumn(tableLibros.getColumn("ids_autores"));
    }

    public void registrarLibro() {
        String[] dateString = textFechaLanzamiento.getText().split("-");
        Date date = Date.valueOf(dateString[0] +"-"+ dateString[1] +"-"+ dateString[2]);
        LinkedList<Integer> autores = new LinkedList<>();
        int[] autoresSelected = tableAutores.getSelectedRows();
        for (int i = 0; i < autoresSelected.length; i++) {
            autores.add((Integer) tableAutores.getValueAt(autoresSelected[i], 0));
        }
        int id = m_LibroNegocio.registrarLibro(
                textTitulo.getText(),
                textIsbn.getText(),
                textDescripcion.getText(),
                Integer.parseInt(textPaginas.getText()),
                Integer.parseInt(textEdicion.getText()),
                date,
                textIdioma.getText(),
                Integer.parseInt((String) spinnerEjemplares.getValue()),
                Integer.parseInt((String) tableCategoria.getValueAt(tableCategoria.getSelectedRow(), 0)),
                Integer.parseInt((String) tableEditorial.getValueAt(tableEditorial.getSelectedRow(), 0)),
                autores);
//        DefaultTableModel bibliotecariosUpdated = (DefaultTableModel) tableBibliotecarios.getModel();
//        bibliotecariosUpdated.addRow(new Object[]{
//            id,
//            Integer.parseInt(textCi.getText()),
//            textApellidos.getText(),
//            textNombres.getText(),
//            textDireccion.getText(),
//            date,
//            String.valueOf(comboSexo.getSelectedItem()).charAt(0),
//            Integer.parseInt(textTelefono.getText()),
//            Integer.parseInt(textAnoContratacion.getText()),
//            0
//        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelTitulo = new javax.swing.JLabel();
        textTitulo = new javax.swing.JTextField();
        labelIsbn = new javax.swing.JLabel();
        textIsbn = new javax.swing.JTextField();
        labelPaginas = new javax.swing.JLabel();
        textPaginas = new javax.swing.JTextField();
        labelEdicion = new javax.swing.JLabel();
        textEdicion = new javax.swing.JTextField();
        labelIdioma = new javax.swing.JLabel();
        textIdioma = new javax.swing.JTextField();
        labelFechaLanzamiento = new javax.swing.JLabel();
        textFechaLanzamiento = new javax.swing.JTextField();
        labelEjemplares = new javax.swing.JLabel();
        spinnerEjemplares = new javax.swing.JSpinner();
        labelDescripcion = new javax.swing.JLabel();
        textDescripcion = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableLibros = new javax.swing.JTable();
        buttonRegistrar = new javax.swing.JButton();
        buttonModificar = new javax.swing.JButton();
        buttonEliminar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableEditorial = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableCategoria = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableAutores = new javax.swing.JTable();
        labelEditorial = new javax.swing.JLabel();
        labelCategoria = new javax.swing.JLabel();
        labelAutores = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        labelTitulo.setText("Titulo");

        labelIsbn.setText("ISBN");

        labelPaginas.setText("Paginas");

        labelEdicion.setText("Edicion");

        labelIdioma.setText("Idioma");

        labelFechaLanzamiento.setText("Fecha Lanzamiento");

        labelEjemplares.setText("Ejemplares");

        labelDescripcion.setText("Descripcion");

        tableLibros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Titulo", "Descripcion"
            }
        ));
        jScrollPane1.setViewportView(tableLibros);

        buttonRegistrar.setText("Registrar");
        buttonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRegistrarActionPerformed(evt);
            }
        });

        buttonModificar.setText("Modificar");

        buttonEliminar.setText("Eliminar");

        tableEditorial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Id", "Nombre"
            }
        ));
        jScrollPane2.setViewportView(tableEditorial);

        tableCategoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Id", "Nombre"
            }
        ));
        jScrollPane3.setViewportView(tableCategoria);

        tableAutores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Nombre", "Pais Origen"
            }
        ));
        tableAutores.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jScrollPane4.setViewportView(tableAutores);

        labelEditorial.setText("Editorial");

        labelCategoria.setText("Categoria");

        labelAutores.setText("Autores");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelFechaLanzamiento)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(textFechaLanzamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelTitulo)
                                    .addComponent(labelIsbn)
                                    .addComponent(labelPaginas)
                                    .addComponent(labelEdicion)
                                    .addComponent(labelIdioma))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textIdioma)
                                    .addComponent(textEdicion)
                                    .addComponent(textPaginas)
                                    .addComponent(textIsbn)
                                    .addComponent(textTitulo)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelEjemplares)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spinnerEjemplares)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addComponent(labelEditorial)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelCategoria)
                                .addGap(71, 71, 71))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelAutores)
                                .addGap(174, 174, 174))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelDescripcion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textDescripcion))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(144, 144, 144)
                        .addComponent(buttonModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(149, 149, 149)
                        .addComponent(buttonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelTitulo)
                            .addComponent(textTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelIsbn)
                            .addComponent(textIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelPaginas)
                            .addComponent(textPaginas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelEdicion)
                            .addComponent(textEdicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelEditorial)
                            .addComponent(labelCategoria))
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelAutores)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelIdioma)
                            .addComponent(textIdioma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelFechaLanzamiento)
                            .addComponent(textFechaLanzamiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(spinnerEjemplares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelEjemplares)))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDescripcion)
                    .addComponent(textDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonRegistrar)
                    .addComponent(buttonModificar)
                    .addComponent(buttonEliminar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRegistrarActionPerformed
        registrarLibro();
    }//GEN-LAST:event_buttonRegistrarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LibroFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LibroFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LibroFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LibroFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LibroFrm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonEliminar;
    private javax.swing.JButton buttonModificar;
    private javax.swing.JButton buttonRegistrar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel labelAutores;
    private javax.swing.JLabel labelCategoria;
    private javax.swing.JLabel labelDescripcion;
    private javax.swing.JLabel labelEdicion;
    private javax.swing.JLabel labelEditorial;
    private javax.swing.JLabel labelEjemplares;
    private javax.swing.JLabel labelFechaLanzamiento;
    private javax.swing.JLabel labelIdioma;
    private javax.swing.JLabel labelIsbn;
    private javax.swing.JLabel labelPaginas;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JSpinner spinnerEjemplares;
    private javax.swing.JTable tableAutores;
    private javax.swing.JTable tableCategoria;
    private javax.swing.JTable tableEditorial;
    private javax.swing.JTable tableLibros;
    private javax.swing.JTextField textDescripcion;
    private javax.swing.JTextField textEdicion;
    private javax.swing.JTextField textFechaLanzamiento;
    private javax.swing.JTextField textIdioma;
    private javax.swing.JTextField textIsbn;
    private javax.swing.JTextField textPaginas;
    private javax.swing.JTextField textTitulo;
    // End of variables declaration//GEN-END:variables
}
