package repositorio.vista.proyecto;

import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Desktop;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import repositorio.modelo.Proyecto;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import repositorio.controlador.ActividadServicio;
import repositorio.controlador.ProyectoServicio;
import repositorio.modelo.PlanAmbiental;
import repositorio.vista.admin.InterfazAdminJFrame;
import static repositorio.vista.admin.InterfazAdminJFrame.codigoUsuario;
import repositorio.vista.trabajador.InterfazTrabajador1JFrame;

public class ActualizarProyecto extends javax.swing.JInternalFrame {

    Proyecto proyecto;
    PlanAmbiental actividad = new PlanAmbiental();
    public Calendar hoy = null;
    private static int filaseleccionadaActividad = -1;
    private DefaultTableModel dtm = null;

    public ActualizarProyecto() {
        initComponents();
        consultarDatos();
        llenarTablaActividades();
        restringirJcalendar();

    }

    public void restringirJcalendar() {
        hoy = Calendar.getInstance();
        Date restriccion = hoy.getTime();
        dcFechaFinalProyecto.setMinSelectableDate(restriccion);
        dcFechaInicioProyecto.setMinSelectableDate(restriccion);
        JTextFieldDateEditor editorfinal = (JTextFieldDateEditor) dcFechaFinalProyecto.getDateEditor();
        editorfinal.setEditable(false);
        JTextFieldDateEditor editorinicio = (JTextFieldDateEditor) dcFechaInicioProyecto.getDateEditor();
        editorinicio.setEditable(false);

    }

    public void llenarTablaActividades() {
        dtm = (DefaultTableModel) tbActividades.getModel();
        TableColumnModel columnModel = tbActividades.getColumnModel();
        TableColumn columna = columnModel.getColumn(0);
        columna.setMinWidth(0);
        columna.setMaxWidth(0);

        dtm.setRowCount(0);
        for (PlanAmbiental actividades : ActividadServicio.ListaActividades(obtenercodigointerfacez())) {
            String fechaafinal, evidencia, completado;
            if (actividades.getFechaRealizada() == null) {
                fechaafinal = "Indefinida";
            } else {
                fechaafinal = new SimpleDateFormat("dd/MM/yyyy").format(actividades.getFechaRealizada());
            }
            if (actividades.getCompletado()) {
                completado = "Completado";
            } else {
                completado = "En progreso";
            }

            if (actividades.getEvidencias() == null) {
                evidencia = "Por cargar";
            } else {
                evidencia = "Cargado";
            }

            dtm.addRow(new Object[]{actividades.getIdActividad(), actividades.getActividad(), completado, fechaafinal, evidencia});
        }
    }

    private String obtenercodigointerfacez() {
        String codigo = "";
        if (InterfazAdminJFrame.getCodigoProyecto() != "") {
            codigo = InterfazAdminJFrame.getCodigoProyecto();

        } else if (InterfazTrabajador1JFrame.getCodigoProyecto() != "") {
            codigo = InterfazTrabajador1JFrame.getCodigoProyecto();

        }
        return codigo;
    }

    private void agregarActividadTabla() {
        hoy = Calendar.getInstance();
        Date fecharealizacion = hoy.getTime();
        PlanAmbiental actividades = new PlanAmbiental();
        actividades.setEvidencias(null);
        actividades.setActividad(txtActividadAgregar.getText());
        actividades.setCompletado(false);
        actividades.setId(obtenercodigointerfacez());
        actividades.setFechaRealizada(fecharealizacion);
        ActividadServicio.InsertarActividades(actividades);

    }

    private boolean validarDatos() {
        if ((txtNombreProyecto.getText().length() > 0) && (txtDescripcionProyecto.getText().length() > 0) && (dcFechaInicioProyecto.getDate() != null) && (rdEnProgreso.isSelected() || dcFechaFinalProyecto != null)) {
            return true;
        } else {
            if (txtNombreProyecto.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "No puede dejar el Nombre vacío");
            }
            if (txtDescripcionProyecto.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "No puede dejar la descipción vacía");
            }
            if (dcFechaInicioProyecto.getDate() == null) {
                JOptionPane.showMessageDialog(null, "No puede dejar la fecha de inicio vacía");
            }
            if (!rdEnProgreso.isSelected() && dcFechaFinalProyecto == null) {
                JOptionPane.showMessageDialog(null, "Si aun no ha finalizado el proyecto, sleccione en progreso");
            }
            return false;
        }
    }

    private boolean validarDatosActividad() {
        if ((txtActividadActualizar.getText().length() > 0) && (rbtProgreso.isSelected() || rbtCompletada.isSelected()) && (filaseleccionadaActividad >= 0)) {

            return true;

        } else {
            if (txtActividadActualizar.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "No puede dejar la actividad vacia");
            }

            if (!rbtCompletada.isSelected() && !rbtProgreso.isSelected()) {
                JOptionPane.showMessageDialog(null, "No ha seleccionado");
            }
            if (filaseleccionadaActividad == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione el elemento a actualizar");

            }

            return false;
        }
    }

    private void abrirArchivoProyecto(byte[] archivo) {
        if (archivo != null) {
            try {
                Path tempPdf = Files.createTempFile("Archivo Guardado", ".pdf");
                Files.copy(new ByteArrayInputStream(archivo), tempPdf, StandardCopyOption.REPLACE_EXISTING);

                Desktop.getDesktop().open(tempPdf.toFile());
            } catch (IOException ex) {

            }
        } else {
            JOptionPane.showMessageDialog(null, "No se ha cargado el documento aún");
        }
    }

    private byte[] seleccionarArchivo() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleccione un archivo");

        int result = fileChooser.showOpenDialog(null);
        byte[] pdfBytes = null;

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            JOptionPane.showMessageDialog(null, "Archivo seleccionado: " + selectedFile.getAbsolutePath());

            try {
                pdfBytes = Files.readAllBytes(Paths.get(selectedFile.getAbsolutePath()));
            } catch (IOException ex) {
                Logger.getLogger(AgregarProyecto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return pdfBytes;
    }

    private void fecharealizada() {
        if (rdEnProgreso.getAction() != null) {
            actividad.setFechaRealizada(dcFechaFinalProyecto.getDate());

        } else {
            actividad.setFechaRealizada(null);
        }

    }

    private void opcionCompletado() {
        if (rbtCompletada.isSelected()) {
            actividad.setCompletado(true);
        } else if (rbtProgreso.isSelected()) {
            actividad.setCompletado(false);
        }

    }

    private void consultarDatos() {
        System.out.println("AquiProblemas");
        try {
            proyecto = ProyectoServicio.BuscarProyecto(obtenercodigointerfacez());
            txtCodigo.setText(proyecto.getIdProyecto());
            txtNombreProyecto.setText(proyecto.getNombreProyecto());
            dcFechaInicioProyecto.setDate(proyecto.getFechaInicio());
            lbPermisoAmbiental.setVisible(false);
            lbPermisoAgua.setVisible(false);
            lbAuditoria.setVisible(false);
            lbMonitoreo.setVisible(false);

            if (proyecto.getFechaFinal() != null) {
                dcFechaFinalProyecto.setDate(proyecto.getFechaFinal());
                rdEnProgreso.setSelected(false);
            } else {
                rdEnProgreso.setSelected(true);
                dcFechaFinalProyecto.setEnabled(false);
            }
            txtDescripcionProyecto.setText(proyecto.getDescripcionProyecto());
            String recordatorio;
            if (proyecto.getRecordatorioProyecto() != null) {
                recordatorio = proyecto.getRecordatorioProyecto();
            } else {
                recordatorio = "No existen recordatorios";
            }
            txtRecordatorio.setText(recordatorio);

            if (proyecto.getPermisoAmbiental() != null) {
                lbPermisoAmbiental.setVisible(true);
            }
            if (proyecto.getPermisoAgua() != null) {
                lbPermisoAgua.setVisible(true);
            }
            if (proyecto.getAuditoria() != null) {
                lbAuditoria.setVisible(true);
            }
            if (proyecto.getMonitoreo() != null) {
                lbMonitoreo.setVisible(true);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No se ha podido cargar la información del proyecto");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngCompletado = new javax.swing.ButtonGroup();
        PanelActualizarProyecto = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        btnRegresarPanelTabla = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtNombreProyecto = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        txtDescripcionProyecto = new javax.swing.JTextArea();
        jLabel35 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        txtRecordatorio = new javax.swing.JTextArea();
        dcFechaInicioProyecto = new com.toedter.calendar.JDateChooser();
        dcFechaFinalProyecto = new com.toedter.calendar.JDateChooser();
        rdEnProgreso = new javax.swing.JRadioButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        tbactualizarActividad = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        txtActividadActualizar = new javax.swing.JTextField();
        btActualizarActividad = new javax.swing.JButton();
        rbtCompletada = new javax.swing.JRadioButton();
        rbtProgreso = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        tbEliminarActividad = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtActividadEliminar = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        txtActividadAgregar = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jScrollPane14 = new javax.swing.JScrollPane();
        tbActividades = new javax.swing.JTable();
        btPermisoAmbiental = new javax.swing.JButton();
        btPermisoAgua = new javax.swing.JButton();
        btAuditorias = new javax.swing.JButton();
        btMonitoreo = new javax.swing.JButton();
        cambiarMonitoreo = new javax.swing.JButton();
        cambiarAmbiental = new javax.swing.JButton();
        cambiarAgua = new javax.swing.JButton();
        cambiarAuditoria = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        lbPermisoAmbiental = new javax.swing.JLabel();
        lbPermisoAgua = new javax.swing.JLabel();
        lbAuditoria = new javax.swing.JLabel();
        lbMonitoreo = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());

        PanelActualizarProyecto.setBackground(new java.awt.Color(255, 255, 204));
        PanelActualizarProyecto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Sitka Banner", 1, 40)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 204));
        jLabel8.setText("Actualizar Proyecto");
        PanelActualizarProyecto.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, -1, 37));

        btnRegresarPanelTabla.setText("Regresar");
        btnRegresarPanelTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarPanelTablaActionPerformed(evt);
            }
        });
        PanelActualizarProyecto.add(btnRegresarPanelTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 10, -1, -1));

        jLabel31.setFont(new java.awt.Font("Sitka Banner", 1, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(51, 0, 51));
        jLabel31.setText("Fecha de Finalización:");
        PanelActualizarProyecto.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 70, 136, -1));

        jLabel23.setFont(new java.awt.Font("Sitka Banner", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(51, 0, 51));
        jLabel23.setText("Nombre Del Proyecto:");
        PanelActualizarProyecto.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, 136, -1));
        PanelActualizarProyecto.add(txtNombreProyecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, 136, -1));

        jLabel32.setFont(new java.awt.Font("Sitka Banner", 1, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(51, 0, 51));
        jLabel32.setText("Fecha de Inicio:");
        PanelActualizarProyecto.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 70, 136, -1));

        txtCodigo.setEditable(false);
        txtCodigo.setBackground(new java.awt.Color(153, 153, 153));
        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });
        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoKeyTyped(evt);
            }
        });
        PanelActualizarProyecto.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 136, -1));

        jLabel33.setFont(new java.awt.Font("Sitka Banner", 1, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(51, 0, 51));
        jLabel33.setText("Código de Proyecto:");
        PanelActualizarProyecto.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jLabel34.setFont(new java.awt.Font("Sitka Banner", 1, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(51, 0, 51));
        jLabel34.setText("Descripción del proyecto:");
        PanelActualizarProyecto.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 156, -1));

        txtDescripcionProyecto.setColumns(20);
        txtDescripcionProyecto.setRows(5);
        jScrollPane8.setViewportView(txtDescripcionProyecto);

        PanelActualizarProyecto.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 277, 133));

        jLabel35.setFont(new java.awt.Font("Sitka Banner", 1, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(51, 0, 51));
        jLabel35.setText("Recordatorios:");
        PanelActualizarProyecto.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 160, 156, -1));

        txtRecordatorio.setColumns(20);
        txtRecordatorio.setRows(5);
        jScrollPane9.setViewportView(txtRecordatorio);

        PanelActualizarProyecto.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, 270, 130));
        PanelActualizarProyecto.add(dcFechaInicioProyecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 100, 136, -1));
        PanelActualizarProyecto.add(dcFechaFinalProyecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 100, 136, -1));

        rdEnProgreso.setForeground(new java.awt.Color(51, 0, 51));
        rdEnProgreso.setText("En progreso");
        rdEnProgreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdEnProgresoActionPerformed(evt);
            }
        });
        PanelActualizarProyecto.add(rdEnProgreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 100, -1, -1));

        tbactualizarActividad.setBackground(new java.awt.Color(204, 255, 204));

        jLabel38.setFont(new java.awt.Font("Sitka Banner", 1, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(51, 0, 51));
        jLabel38.setText("Actividad");

        btActualizarActividad.setText("Actualizar");
        btActualizarActividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btActualizarActividadActionPerformed(evt);
            }
        });

        btngCompletado.add(rbtCompletada);
        rbtCompletada.setText("Completada");
        rbtCompletada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtCompletadaActionPerformed(evt);
            }
        });

        btngCompletado.add(rbtProgreso);
        rbtProgreso.setText("En progreso");
        rbtProgreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtProgresoActionPerformed(evt);
            }
        });

        jButton1.setText("Evidencia");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(204, 204, 255));
        jButton3.setText("Cambiar archivo");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tbactualizarActividadLayout = new javax.swing.GroupLayout(tbactualizarActividad);
        tbactualizarActividad.setLayout(tbactualizarActividadLayout);
        tbactualizarActividadLayout.setHorizontalGroup(
            tbactualizarActividadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tbactualizarActividadLayout.createSequentialGroup()
                .addGroup(tbactualizarActividadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tbactualizarActividadLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(tbactualizarActividadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbtProgreso)
                            .addComponent(rbtCompletada)
                            .addComponent(txtActividadActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(tbactualizarActividadLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)))
                .addGap(0, 16, Short.MAX_VALUE))
            .addGroup(tbactualizarActividadLayout.createSequentialGroup()
                .addGroup(tbactualizarActividadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tbactualizarActividadLayout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tbactualizarActividadLayout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(btActualizarActividad)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tbactualizarActividadLayout.setVerticalGroup(
            tbactualizarActividadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tbactualizarActividadLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel38)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtActividadActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbtCompletada)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbtProgreso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(tbactualizarActividadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btActualizarActividad)
                .addGap(17, 17, 17))
        );

        jTabbedPane1.addTab("Actualizar actividad", tbactualizarActividad);

        tbEliminarActividad.setBackground(new java.awt.Color(255, 255, 204));

        jLabel4.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        jLabel4.setText("Actividad");

        txtActividadEliminar.setEditable(false);

        jButton2.setText("Eliminar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tbEliminarActividadLayout = new javax.swing.GroupLayout(tbEliminarActividad);
        tbEliminarActividad.setLayout(tbEliminarActividadLayout);
        tbEliminarActividadLayout.setHorizontalGroup(
            tbEliminarActividadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tbEliminarActividadLayout.createSequentialGroup()
                .addGroup(tbEliminarActividadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tbEliminarActividadLayout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jLabel4))
                    .addGroup(tbEliminarActividadLayout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(jButton2))
                    .addGroup(tbEliminarActividadLayout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(txtActividadEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        tbEliminarActividadLayout.setVerticalGroup(
            tbEliminarActividadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tbEliminarActividadLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtActividadEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(76, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Eliminar Actividad", tbEliminarActividad);

        jPanel3.setBackground(new java.awt.Color(204, 255, 255));

        jLabel40.setFont(new java.awt.Font("Sitka Banner", 1, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(51, 0, 51));
        jLabel40.setText("Actividad");

        jButton9.setText("Agregar");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(txtActividadAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(jButton9)))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel40)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtActividadAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton9)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Agregar actividad", jPanel3);

        PanelActualizarProyecto.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 370, 280, 240));

        jButton10.setFont(new java.awt.Font("Sitka Banner", 1, 14)); // NOI18N
        jButton10.setText("Actualizar");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        PanelActualizarProyecto.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 550, -1, 45));

        tbActividades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Actividades", "Completado", "Fecha realizada", "Evidencia"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbActividades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbActividadesMouseClicked(evt);
            }
        });
        jScrollPane14.setViewportView(tbActividades);

        PanelActualizarProyecto.add(jScrollPane14, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, 480, 230));

        btPermisoAmbiental.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/ecoicon01_122073.png"))); // NOI18N
        btPermisoAmbiental.setText("Permiso Ambiental");
        btPermisoAmbiental.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btPermisoAmbiental.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPermisoAmbientalActionPerformed(evt);
            }
        });
        PanelActualizarProyecto.add(btPermisoAmbiental, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 160, 170, -1));

        btPermisoAgua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/water_23838.png"))); // NOI18N
        btPermisoAgua.setText("Permiso de Agua");
        btPermisoAgua.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btPermisoAgua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPermisoAguaActionPerformed(evt);
            }
        });
        PanelActualizarProyecto.add(btPermisoAgua, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 210, 170, -1));

        btAuditorias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/audit_icon_155782.png"))); // NOI18N
        btAuditorias.setText("Auditoria");
        btAuditorias.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btAuditorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAuditoriasActionPerformed(evt);
            }
        });
        PanelActualizarProyecto.add(btAuditorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 260, 170, -1));

        btMonitoreo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/monitoring-icon_icon-icons.com_55736.png"))); // NOI18N
        btMonitoreo.setText("Monitoreo");
        btMonitoreo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btMonitoreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMonitoreoActionPerformed(evt);
            }
        });
        PanelActualizarProyecto.add(btMonitoreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 310, 170, -1));

        cambiarMonitoreo.setBackground(new java.awt.Color(204, 204, 255));
        cambiarMonitoreo.setText("Cambiar archivo");
        cambiarMonitoreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambiarMonitoreoActionPerformed(evt);
            }
        });
        PanelActualizarProyecto.add(cambiarMonitoreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 320, -1, -1));

        cambiarAmbiental.setBackground(new java.awt.Color(204, 204, 255));
        cambiarAmbiental.setText("Cambiar archivo");
        cambiarAmbiental.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambiarAmbientalActionPerformed(evt);
            }
        });
        PanelActualizarProyecto.add(cambiarAmbiental, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 170, -1, -1));

        cambiarAgua.setBackground(new java.awt.Color(204, 204, 255));
        cambiarAgua.setText("Cambiar archivo");
        cambiarAgua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambiarAguaActionPerformed(evt);
            }
        });
        PanelActualizarProyecto.add(cambiarAgua, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 220, -1, -1));

        cambiarAuditoria.setBackground(new java.awt.Color(204, 204, 255));
        cambiarAuditoria.setText("Cambiar archivo");
        cambiarAuditoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambiarAuditoriaActionPerformed(evt);
            }
        });
        PanelActualizarProyecto.add(cambiarAuditoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 270, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/LogoBiosigmaTransparente.png"))); // NOI18N
        PanelActualizarProyecto.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/jaguar_prueba_3_742563 (1).png"))); // NOI18N
        PanelActualizarProyecto.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 330, 261, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/FondoProyectos.png"))); // NOI18N
        PanelActualizarProyecto.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 0, 280, 50));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/FondoProyectos.png"))); // NOI18N
        PanelActualizarProyecto.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 50));
        PanelActualizarProyecto.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 50, 1080, -1));

        jLabel3.setBackground(new java.awt.Color(102, 102, 102));
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("(Si aun no finaliza el proyecto seleccione en progreso)");
        PanelActualizarProyecto.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 130, -1, -1));

        lbPermisoAmbiental.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/accept_icon-icons.com_74428 (1).png"))); // NOI18N
        PanelActualizarProyecto.add(lbPermisoAmbiental, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 160, -1, -1));

        lbPermisoAgua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/accept_icon-icons.com_74428 (1).png"))); // NOI18N
        PanelActualizarProyecto.add(lbPermisoAgua, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 210, -1, -1));

        lbAuditoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/accept_icon-icons.com_74428 (1).png"))); // NOI18N
        PanelActualizarProyecto.add(lbAuditoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 260, -1, -1));

        lbMonitoreo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/accept_icon-icons.com_74428 (1).png"))); // NOI18N
        PanelActualizarProyecto.add(lbMonitoreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 310, -1, -1));

        jLabel22.setFont(new java.awt.Font("Sitka Banner", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 0, 51));
        jLabel22.setText("Plan de Manejo Ambiental");
        PanelActualizarProyecto.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 340, -1, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/ImagenFondoActualizarProyecto.png"))); // NOI18N
        PanelActualizarProyecto.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelActualizarProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 1056, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelActualizarProyecto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarPanelTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarPanelTablaActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnRegresarPanelTablaActionPerformed

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void txtCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyTyped
        char validacionnombre = evt.getKeyChar();
        if (Character.isLetter(validacionnombre)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingresar solamente numeros");

        }
    }//GEN-LAST:event_txtCodigoKeyTyped

    private void rdEnProgresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdEnProgresoActionPerformed
        if (rdEnProgreso.isSelected()) {
            dcFechaFinalProyecto.setEnabled(false);
            dcFechaFinalProyecto.setDate(null);
        } else {
            dcFechaFinalProyecto.setEnabled(true);
        }
    }//GEN-LAST:event_rdEnProgresoActionPerformed

    private void btPermisoAmbientalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPermisoAmbientalActionPerformed
        abrirArchivoProyecto(proyecto.getPermisoAmbiental());
    }//GEN-LAST:event_btPermisoAmbientalActionPerformed

    private void btPermisoAguaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPermisoAguaActionPerformed
        abrirArchivoProyecto(proyecto.getPermisoAgua());
    }//GEN-LAST:event_btPermisoAguaActionPerformed

    private void btAuditoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAuditoriasActionPerformed
        abrirArchivoProyecto(proyecto.getAuditoria());
    }//GEN-LAST:event_btAuditoriasActionPerformed

    private void btMonitoreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMonitoreoActionPerformed
        abrirArchivoProyecto(proyecto.getMonitoreo());
    }//GEN-LAST:event_btMonitoreoActionPerformed

    private void rbtCompletadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtCompletadaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtCompletadaActionPerformed

    private void rbtProgresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtProgresoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtProgresoActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        if (validarDatos()) {

            int resultado = JOptionPane.showConfirmDialog(null, "¿Esta seguro de actualizar el proyecto?", "Confirmación", JOptionPane.YES_NO_OPTION);
            if (resultado == JOptionPane.YES_OPTION) {
                proyecto.setNombreProyecto(txtNombreProyecto.getText());
                proyecto.setDescripcionProyecto(txtDescripcionProyecto.getText());
                proyecto.setFechaInicio(dcFechaInicioProyecto.getDate());

                if (rdEnProgreso.isSelected()) {
                    proyecto.setFechaFinal(null);
                } else {
                    proyecto.setFechaFinal(dcFechaFinalProyecto.getDate());
                }
                ProyectoServicio.ActualizarProyecto(proyecto);
            }
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void cambiarAmbientalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambiarAmbientalActionPerformed
        byte[] pdfBytes = seleccionarArchivo();
        if (pdfBytes != null) {
            proyecto.setPermisoAmbiental(pdfBytes);
            lbPermisoAmbiental.setVisible(true);
        }
    }//GEN-LAST:event_cambiarAmbientalActionPerformed

    private void cambiarAguaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambiarAguaActionPerformed
        byte[] pdfBytes = seleccionarArchivo();
        if (pdfBytes != null) {
            proyecto.setPermisoAgua(pdfBytes);
            lbPermisoAgua.setVisible(true);
        }
    }//GEN-LAST:event_cambiarAguaActionPerformed

    private void cambiarAuditoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambiarAuditoriaActionPerformed
        byte[] pdfBytes = seleccionarArchivo();
        if (pdfBytes != null) {
            proyecto.setAuditoria(pdfBytes);
            lbAuditoria.setVisible(true);
        }
    }//GEN-LAST:event_cambiarAuditoriaActionPerformed

    private void cambiarMonitoreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambiarMonitoreoActionPerformed
        byte[] pdfBytes = seleccionarArchivo();
        if (pdfBytes != null) {
            proyecto.setMonitoreo(pdfBytes);
            lbMonitoreo.setVisible(true);
        }
    }//GEN-LAST:event_cambiarMonitoreoActionPerformed

    private void btActualizarActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btActualizarActividadActionPerformed
        if (validarDatosActividad()) {
            int resultado = JOptionPane.showConfirmDialog(null, "¿Esta seguro de actualizar", "Confirmación", JOptionPane.YES_NO_OPTION);
            if (resultado == JOptionPane.YES_OPTION) {
                if (filaseleccionadaActividad > -1) {
                    dtm = (DefaultTableModel) tbActividades.getModel();
                    Object idActividad = dtm.getValueAt(filaseleccionadaActividad, 0);

                    actividad.setActividad(txtActividadActualizar.getText());
                    actividad.setId(txtCodigo.getText());
                    actividad.setIdActividad(idActividad);
                    fecharealizada();
                    opcionCompletado();
                    ActividadServicio.ActualizarActividad(actividad);
                    llenarTablaActividades();
                }

            }
        }
    }//GEN-LAST:event_btActualizarActividadActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        int resultado = JOptionPane.showConfirmDialog(null, "¿Esta seguro de agregar esta actividad?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (resultado == JOptionPane.YES_OPTION) {
            agregarActividadTabla();
            txtActividadAgregar.setText("");
            llenarTablaActividades();
        }


    }//GEN-LAST:event_jButton9ActionPerformed

    private void tbActividadesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbActividadesMouseClicked
        filaseleccionadaActividad = tbActividades.getSelectedRow();
        
        if (filaseleccionadaActividad >= 0) {
            actividad = ActividadServicio.BuscarActividad(tbActividades.getValueAt(filaseleccionadaActividad, 0));
            txtActividadActualizar.setText(actividad.getActividad());
            txtActividadEliminar.setText(actividad.getActividad());
            if (actividad.getCompletado()) {
                rbtCompletada.setSelected(true);
                rbtProgreso.setSelected(false);
            } else {
                rbtProgreso.setSelected(true);
                rbtCompletada.setSelected(false);
            }
        }

    }//GEN-LAST:event_tbActividadesMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (filaseleccionadaActividad >= 0) {
            if (actividad.getEvidencias() != null) {
                abrirArchivoProyecto(actividad.getEvidencias());
            } else {
                JOptionPane.showMessageDialog(null, "No se han cargado evidencias");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una actividad para ver la evidencia");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (filaseleccionadaActividad >= 0) {
            byte[] pdfBytes = seleccionarArchivo();
            if (pdfBytes != null) {
                actividad.setEvidencias(pdfBytes);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una actividad para cambiar el archivo");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (filaseleccionadaActividad > -1) {
        int resultado = JOptionPane.showConfirmDialog(null, "¿Esta seguro de eliminar", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (resultado == JOptionPane.YES_OPTION) {
            
                dtm = (DefaultTableModel) tbActividades.getModel();
                Object idActividad = dtm.getValueAt(filaseleccionadaActividad, 0);

                ActividadServicio.EliminarActividad(idActividad);
                llenarTablaActividades();
                 txtActividadActualizar.setText("");
                txtActividadEliminar.setText("");
                rbtCompletada.setSelected(false);
                rbtProgreso.setSelected(false);
        }
        }else{
            JOptionPane.showMessageDialog(null, "Seleccione una actividad a eliminar");
        }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelActualizarProyecto;
    private javax.swing.JButton btActualizarActividad;
    private javax.swing.JButton btAuditorias;
    private javax.swing.JButton btMonitoreo;
    private javax.swing.JButton btPermisoAgua;
    private javax.swing.JButton btPermisoAmbiental;
    private javax.swing.JButton btnRegresarPanelTabla;
    private javax.swing.ButtonGroup btngCompletado;
    private javax.swing.JButton cambiarAgua;
    private javax.swing.JButton cambiarAmbiental;
    private javax.swing.JButton cambiarAuditoria;
    private javax.swing.JButton cambiarMonitoreo;
    private com.toedter.calendar.JDateChooser dcFechaFinalProyecto;
    private com.toedter.calendar.JDateChooser dcFechaInicioProyecto;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbAuditoria;
    private javax.swing.JLabel lbMonitoreo;
    private javax.swing.JLabel lbPermisoAgua;
    private javax.swing.JLabel lbPermisoAmbiental;
    private javax.swing.JRadioButton rbtCompletada;
    private javax.swing.JRadioButton rbtProgreso;
    private javax.swing.JRadioButton rdEnProgreso;
    private static javax.swing.JTable tbActividades;
    private javax.swing.JPanel tbEliminarActividad;
    private javax.swing.JPanel tbactualizarActividad;
    private javax.swing.JTextField txtActividadActualizar;
    private javax.swing.JTextField txtActividadAgregar;
    private javax.swing.JTextField txtActividadEliminar;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextArea txtDescripcionProyecto;
    private javax.swing.JTextField txtNombreProyecto;
    private javax.swing.JTextArea txtRecordatorio;
    // End of variables declaration//GEN-END:variables
}
