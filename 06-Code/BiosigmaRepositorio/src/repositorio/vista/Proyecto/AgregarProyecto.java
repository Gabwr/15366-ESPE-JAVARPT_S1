package repositorio.vista.proyecto;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import repositorio.controlador.ActividadServicio;
import repositorio.controlador.ProyectoServicio;
import repositorio.modelo.PlanAmbiental;
import repositorio.modelo.Proyecto;
import repositorio.vista.admin.InterfazAdminJFrame;

public class AgregarProyecto extends javax.swing.JInternalFrame {
    private Proyecto proyecto = new Proyecto();
    
    private static DefaultTableModel dtm = null;
    List<PlanAmbiental> listaActividades = new ArrayList<>();
    private Calendar hoy= null;
    public AgregarProyecto() {
        initComponents();
        UIManager.put("TextComponent.arc", 999);
        restringirJcalendar();
        limpiarCampos();
    }
    
        public void restringirJcalendar(){
        hoy = Calendar.getInstance();
        Date restriccion =hoy.getTime();
        dcFechaFinalProyecto.setMinSelectableDate(restriccion);
    }
    
    private boolean validarDatosactividad() {
        PlanAmbiental actividades = new PlanAmbiental();

        DefaultTableModel dtm = (DefaultTableModel) tbActividades.getModel();
        if ((txtCodigoProyecto.getText().length() > 0) && (txtNombreProyecto.getText().length() > 0) && (txtDescripcionProyecto.getText().length() > 0) && (dcFechaInicioProyecto.getDate() != null) && (rdEnProgreso.isSelected() || dcFechaFinalProyecto != null)) {
            if (ProyectoServicio.VerificarCodigoRepetido(txtCodigoProyecto.getText())) {
                JOptionPane.showMessageDialog(null, "El códgio ingresado ya esta registrado");
                return false;
            }
            actividades.setEvidencias(null);
            actividades.setActividad(txtActividad.getText());
            
            String completado, fechaFinal, permisoAgua, auditoria, monitoreo;
            
            if(dcFechaFinalProyecto.getDate()==null){
              actividades.setFechaRealizada(dcFechaFinalProyecto.getDate());
              completado="Por completar";
              fechaFinal="En progreso";
            }else{
            completado="Completado";
            fechaFinal = new SimpleDateFormat("dd/MM/yyyy").format(dcFechaFinalProyecto.getDate());
            actividades.setFechaRealizada(dcFechaFinalProyecto.getDate());
            
            }
            dtm.addRow(new Object[]{actividades.getActividad(), completado, fechaFinal, actividades.getEvidencias()});

            listaActividades.add(actividades);
            return true;
        } else {
            return false;
        }

    }
    private void cagarDatosActividades() {
        for (PlanAmbiental actividad : listaActividades) {
            System.out.println(actividad.getActividad());
            actividad.setId(txtCodigoProyecto.getText());

            ActividadServicio.InsertarActividades(actividad);

        }
    }
    private boolean validarDatos() {
        DefaultTableModel dtm = (DefaultTableModel) tbActividades.getModel();
        if ((txtCodigoProyecto.getText().length() > 0) && (txtNombreProyecto.getText().length() > 0) && (txtDescripcionProyecto.getText().length() > 0) && (dcFechaInicioProyecto.getDate() != null) && (rdEnProgreso.isSelected() || dcFechaFinalProyecto != null) && (rdActividades.isSelected() || (dtm.getRowCount() != 0))) {
            if (ProyectoServicio.VerificarCodigoRepetido(txtCodigoProyecto.getText())) {
                JOptionPane.showMessageDialog(null, "El códgio ingresado ya esta registrado");
                return false;
            }

            proyecto.setIdProyecto(txtCodigoProyecto.getText());
            proyecto.setNombreProyecto(txtNombreProyecto.getText());
            proyecto.setDescripcionProyecto(txtDescripcionProyecto.getText());
            proyecto.setFechaInicio(dcFechaInicioProyecto.getDate());
            if (!rdEnProgreso.isSelected()) {
                proyecto.setFechaFinal(dcFechaFinalProyecto.getDate());
            }
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

    private void limpiarCampos() {
        txtCodigoProyecto.setText("");
        txtNombreProyecto.setText("");
        txtDescripcionProyecto.setText("");
        dcFechaInicioProyecto.setDate(null);
        dcFechaFinalProyecto.setDate(null);
        rdEnProgreso.setSelected(false);
        rdActividades.setSelected(false);
        lbAvisoCodigo.setVisible(true);
        lbAvisoNombre.setVisible(true);
        lbAvisoFechaInicio.setVisible(true);
        lbAvisoFechaFinal.setVisible(true);
        lbAvisoDescripcion.setVisible(true);
        lbPermisoAmbiental.setVisible(false);
        lbPermisoAgua.setVisible(false);
        lbAuditoria.setVisible(false);
        lbMonitoreo.setVisible(false);
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelAgregarProyecto = new javax.swing.JPanel();
        btAuditorias = new javax.swing.JButton();
        btPermisoAmbiental = new javax.swing.JButton();
        rdEnProgreso = new javax.swing.JRadioButton();
        dcFechaFinalProyecto = new com.toedter.calendar.JDateChooser();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        dcFechaInicioProyecto = new com.toedter.calendar.JDateChooser();
        txtNombreProyecto = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        txtDescripcionProyecto = new javax.swing.JTextArea();
        jLabel46 = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        tbActividades = new javax.swing.JTable();
        panelActividades = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        txtActividad = new javax.swing.JTextField();
        btActividad = new javax.swing.JButton();
        btAgregarProyecto = new javax.swing.JButton();
        btnRegresarPanelTabla1 = new javax.swing.JButton();
        jLabel45 = new javax.swing.JLabel();
        txtCodigoProyecto = new javax.swing.JTextField();
        lbAvisoCodigo = new javax.swing.JLabel();
        lbAvisoNombre = new javax.swing.JLabel();
        lbAvisoFechaInicio = new javax.swing.JLabel();
        lbAvisoFechaFinal = new javax.swing.JLabel();
        lbAvisoDescripcion = new javax.swing.JLabel();
        btPermisoAgua = new javax.swing.JButton();
        btMonitoreo = new javax.swing.JButton();
        lbAvisoActividades = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        rdActividades = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        lbMonitoreo = new javax.swing.JLabel();
        lbPermisoAmbiental = new javax.swing.JLabel();
        lbPermisoAgua = new javax.swing.JLabel();
        lbAuditoria = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setForeground(new java.awt.Color(255, 204, 204));
        setTitle("Agregar Proyecto");
        setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);

        panelAgregarProyecto.setBackground(new java.awt.Color(172, 217, 229));
        panelAgregarProyecto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btAuditorias.setText("Agregar Auditoria");
        btAuditorias.setToolTipText("Subir un archivo pdf");
        btAuditorias.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btAuditorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAuditoriasActionPerformed(evt);
            }
        });
        panelAgregarProyecto.add(btAuditorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 320, 180, -1));

        btPermisoAmbiental.setText("Agregar Permiso Ambiental");
        btPermisoAmbiental.setToolTipText("Subir un archivo pdf");
        btPermisoAmbiental.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btPermisoAmbiental.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPermisoAmbientalActionPerformed(evt);
            }
        });
        panelAgregarProyecto.add(btPermisoAmbiental, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 240, 180, -1));

        rdEnProgreso.setForeground(new java.awt.Color(51, 0, 51));
        rdEnProgreso.setText("En progreso");
        rdEnProgreso.setToolTipText("");
        rdEnProgreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdEnProgresoActionPerformed(evt);
            }
        });
        panelAgregarProyecto.add(rdEnProgreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 140, -1, -1));

        dcFechaFinalProyecto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        dcFechaFinalProyecto.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dcFechaFinalProyectoPropertyChange(evt);
            }
        });
        panelAgregarProyecto.add(dcFechaFinalProyecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 110, 136, -1));

        jLabel41.setFont(new java.awt.Font("Sitka Banner", 1, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(51, 0, 51));
        jLabel41.setText("Fecha de Finalización:");
        panelAgregarProyecto.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 80, 136, -1));

        jLabel42.setFont(new java.awt.Font("Sitka Banner", 1, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(51, 0, 51));
        jLabel42.setText("Fecha de Inicio:");
        panelAgregarProyecto.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 80, 136, -1));

        dcFechaInicioProyecto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        dcFechaInicioProyecto.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dcFechaInicioProyectoPropertyChange(evt);
            }
        });
        panelAgregarProyecto.add(dcFechaInicioProyecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 110, 136, -1));

        txtNombreProyecto.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtNombreProyecto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreProyectoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreProyectoKeyTyped(evt);
            }
        });
        panelAgregarProyecto.add(txtNombreProyecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, 136, -1));

        jLabel43.setFont(new java.awt.Font("Sitka Banner", 1, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(51, 0, 51));
        jLabel43.setText("Nombre Del Proyecto:");
        panelAgregarProyecto.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 136, -1));

        jLabel44.setFont(new java.awt.Font("Sitka Banner", 1, 14)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(51, 0, 51));
        jLabel44.setText("Descripción del proyecto:");
        panelAgregarProyecto.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 156, -1));

        txtDescripcionProyecto.setColumns(20);
        txtDescripcionProyecto.setRows(5);
        txtDescripcionProyecto.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtDescripcionProyecto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDescripcionProyectoKeyReleased(evt);
            }
        });
        jScrollPane12.setViewportView(txtDescripcionProyecto);

        panelAgregarProyecto.add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 310, 130));

        jLabel46.setFont(new java.awt.Font("Sitka Banner", 1, 18)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(51, 0, 51));
        jLabel46.setText("Plan de Manejo Ambiental");
        panelAgregarProyecto.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 440, -1, -1));

        tbActividades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Actividades", "Completado", "Fecha realizada"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane14.setViewportView(tbActividades);

        panelAgregarProyecto.add(jScrollPane14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 480, 110));

        panelActividades.setBackground(new java.awt.Color(204, 255, 204));

        jLabel47.setFont(new java.awt.Font("Sitka Banner", 1, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(51, 0, 51));
        jLabel47.setText("Actividad");

        txtActividad.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtActividad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtActividadKeyTyped(evt);
            }
        });

        btActividad.setText("Agregar Actividad");
        btActividad.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btActividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btActividadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelActividadesLayout = new javax.swing.GroupLayout(panelActividades);
        panelActividades.setLayout(panelActividadesLayout);
        panelActividadesLayout.setHorizontalGroup(
            panelActividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelActividadesLayout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelActividadesLayout.createSequentialGroup()
                .addGap(0, 27, Short.MAX_VALUE)
                .addComponent(txtActividad, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelActividadesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btActividad)
                .addGap(41, 41, 41))
        );
        panelActividadesLayout.setVerticalGroup(
            panelActividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelActividadesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel47)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtActividad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btActividad)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        panelAgregarProyecto.add(panelActividades, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 480, 210, 110));

        btAgregarProyecto.setFont(new java.awt.Font("Sitka Banner", 1, 18)); // NOI18N
        btAgregarProyecto.setText("Agregar Proyecto");
        btAgregarProyecto.setToolTipText("");
        btAgregarProyecto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btAgregarProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgregarProyectoActionPerformed(evt);
            }
        });
        panelAgregarProyecto.add(btAgregarProyecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 530, -1, 49));

        btnRegresarPanelTabla1.setText("Regresar");
        btnRegresarPanelTabla1.setToolTipText("salir al menú");
        btnRegresarPanelTabla1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresarPanelTabla1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarPanelTabla1ActionPerformed(evt);
            }
        });
        panelAgregarProyecto.add(btnRegresarPanelTabla1, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 20, -1, 20));

        jLabel45.setFont(new java.awt.Font("Sitka Banner", 1, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(51, 0, 51));
        jLabel45.setText("Código de Proyecto:");
        panelAgregarProyecto.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        txtCodigoProyecto.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtCodigoProyecto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodigoProyectoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoProyectoKeyTyped(evt);
            }
        });
        panelAgregarProyecto.add(txtCodigoProyecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 136, -1));

        lbAvisoCodigo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbAvisoCodigo.setForeground(new java.awt.Color(255, 0, 0));
        lbAvisoCodigo.setText("*");
        panelAgregarProyecto.add(lbAvisoCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, -1, 20));

        lbAvisoNombre.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbAvisoNombre.setForeground(new java.awt.Color(255, 0, 0));
        lbAvisoNombre.setText("*");
        panelAgregarProyecto.add(lbAvisoNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, -1, 20));

        lbAvisoFechaInicio.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbAvisoFechaInicio.setForeground(new java.awt.Color(255, 0, 0));
        lbAvisoFechaInicio.setText("*");
        panelAgregarProyecto.add(lbAvisoFechaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 110, -1, 20));

        lbAvisoFechaFinal.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbAvisoFechaFinal.setForeground(new java.awt.Color(255, 0, 0));
        lbAvisoFechaFinal.setText("*");
        panelAgregarProyecto.add(lbAvisoFechaFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 110, -1, 20));

        lbAvisoDescripcion.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbAvisoDescripcion.setForeground(new java.awt.Color(255, 0, 0));
        lbAvisoDescripcion.setText("*");
        panelAgregarProyecto.add(lbAvisoDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 200, -1, 20));

        btPermisoAgua.setText("Agregar Permiso de Agua");
        btPermisoAgua.setToolTipText("Subir un archivo pdf");
        btPermisoAgua.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btPermisoAgua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPermisoAguaActionPerformed(evt);
            }
        });
        panelAgregarProyecto.add(btPermisoAgua, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 280, 180, -1));

        btMonitoreo.setText("Agregar Monitoreo");
        btMonitoreo.setToolTipText("Subir un archivo pdf");
        btMonitoreo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btMonitoreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMonitoreoActionPerformed(evt);
            }
        });
        panelAgregarProyecto.add(btMonitoreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 360, 180, -1));

        lbAvisoActividades.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbAvisoActividades.setForeground(new java.awt.Color(255, 0, 0));
        lbAvisoActividades.setText("*");
        panelAgregarProyecto.add(lbAvisoActividades, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 450, -1, 20));

        jLabel2.setBackground(new java.awt.Color(102, 102, 102));
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("(Seleccione si no desea agregar por el momento)");
        panelAgregarProyecto.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 430, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/cloudup_icon-icons.com_54402.png"))); // NOI18N
        panelAgregarProyecto.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 290, -1, -1));

        jTextArea2.setEditable(false);
        jTextArea2.setBackground(new java.awt.Color(204, 204, 255));
        jTextArea2.setColumns(20);
        jTextArea2.setForeground(new java.awt.Color(102, 102, 102));
        jTextArea2.setLineWrap(true);
        jTextArea2.setRows(3);
        jTextArea2.setText("Si no posee el pdf  puede cargar desde Actualizar Proyecto");
        jScrollPane2.setViewportView(jTextArea2);

        panelAgregarProyecto.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 390, 120, 60));

        rdActividades.setText("No agregar actividades por ahora");
        rdActividades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdActividadesActionPerformed(evt);
            }
        });
        panelAgregarProyecto.add(rdActividades, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 450, -1, -1));

        jLabel8.setBackground(new java.awt.Color(204, 255, 204));
        jLabel8.setFont(new java.awt.Font("Sitka Banner", 1, 40)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 255, 204));
        jLabel8.setText("Agregar Proyecto");
        panelAgregarProyecto.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, -1, -1));

        jLabel3.setBackground(new java.awt.Color(102, 102, 102));
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("(Si aun no finaliza el proyecto seleccione en progreso)");
        panelAgregarProyecto.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 170, -1, -1));

        jTextArea3.setEditable(false);
        jTextArea3.setBackground(new java.awt.Color(204, 204, 255));
        jTextArea3.setColumns(20);
        jTextArea3.setForeground(new java.awt.Color(102, 102, 102));
        jTextArea3.setLineWrap(true);
        jTextArea3.setRows(3);
        jTextArea3.setText("Puede agregar más\nactividades desde \nActualizar Proyecto");
        jScrollPane3.setViewportView(jTextArea3);

        panelAgregarProyecto.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 360, 120, 60));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/LogoBiosigmaTransparente.png"))); // NOI18N
        panelAgregarProyecto.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        lbMonitoreo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/accept_icon-icons.com_74428 (1).png"))); // NOI18N
        lbMonitoreo.setToolTipText("Archivo cargado");
        panelAgregarProyecto.add(lbMonitoreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 350, -1, -1));

        lbPermisoAmbiental.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/accept_icon-icons.com_74428 (1).png"))); // NOI18N
        lbPermisoAmbiental.setToolTipText("Archivo cargado");
        lbPermisoAmbiental.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbPermisoAmbientalMouseClicked(evt);
            }
        });
        panelAgregarProyecto.add(lbPermisoAmbiental, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 230, -1, -1));

        lbPermisoAgua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/accept_icon-icons.com_74428 (1).png"))); // NOI18N
        lbPermisoAgua.setToolTipText("Archivo cargado");
        panelAgregarProyecto.add(lbPermisoAgua, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 270, -1, -1));

        lbAuditoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/accept_icon-icons.com_74428 (1).png"))); // NOI18N
        lbAuditoria.setToolTipText("Archivo cargado");
        panelAgregarProyecto.add(lbAuditoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 310, -1, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/view_search_find_9565 (1).png"))); // NOI18N
        panelAgregarProyecto.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 230, -1, -1));
        panelAgregarProyecto.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1040, 10));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/FondoProyectos.png"))); // NOI18N
        panelAgregarProyecto.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 0, 250, 60));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/FondoProyectos.png"))); // NOI18N
        panelAgregarProyecto.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 60));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/Tiburon-martillo (1).png"))); // NOI18N
        panelAgregarProyecto.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 210, 280, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/ImagenFondoAgregarProyecto.png"))); // NOI18N
        jLabel9.setText("jLabel9");
        panelAgregarProyecto.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1040, 550));

        jLabel10.setText("jLabel10");
        panelAgregarProyecto.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 350, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelAgregarProyecto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelAgregarProyecto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigoProyectoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoProyectoKeyTyped
        char validacionnombre = evt.getKeyChar();
        if (Character.isLetter(validacionnombre)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingresar solamente numeros");
        }
    }//GEN-LAST:event_txtCodigoProyectoKeyTyped

    private void btnRegresarPanelTabla1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarPanelTabla1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnRegresarPanelTabla1ActionPerformed

    private void txtNombreProyectoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreProyectoKeyTyped
        char validacionnombre = evt.getKeyChar();
        if (Character.isDigit(validacionnombre)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingresar solamente letras");

        }
    }//GEN-LAST:event_txtNombreProyectoKeyTyped

    private void rdEnProgresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdEnProgresoActionPerformed
        if (rdEnProgreso.isSelected()) {
            dcFechaFinalProyecto.setEnabled(false);
            lbAvisoFechaFinal.setVisible(false);
        } else {
            dcFechaFinalProyecto.setEnabled(true);
            lbAvisoFechaFinal.setVisible(true);
        }
    }//GEN-LAST:event_rdEnProgresoActionPerformed

    private void btPermisoAmbientalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPermisoAmbientalActionPerformed
        byte[] pdfBytes = seleccionarArchivo();
        if (pdfBytes != null) {
            proyecto.setPermisoAmbiental(pdfBytes);
            lbPermisoAmbiental.setVisible(true);
        }

    }//GEN-LAST:event_btPermisoAmbientalActionPerformed

    private void btPermisoAguaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPermisoAguaActionPerformed
        byte[] pdfBytes = seleccionarArchivo();
        if (pdfBytes != null) {
            proyecto.setPermisoAgua(pdfBytes);
            lbPermisoAgua.setVisible(true);
        }
    }//GEN-LAST:event_btPermisoAguaActionPerformed

    private void btAuditoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAuditoriasActionPerformed
        
        byte[] pdfBytes = seleccionarArchivo();
        if (pdfBytes != null) {
            proyecto.setAuditoria(pdfBytes);
        }
    }//GEN-LAST:event_btAuditoriasActionPerformed

    private void btMonitoreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMonitoreoActionPerformed

        byte[] pdfBytes = seleccionarArchivo();
        if (pdfBytes != null) {
            proyecto.setMonitoreo(pdfBytes);
        }
    }//GEN-LAST:event_btMonitoreoActionPerformed

    private void btAgregarProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregarProyectoActionPerformed
        if (validarDatos()) {
            ProyectoServicio.InsertarProyecto(proyecto);
            cagarDatosActividades();
            InterfazAdminJFrame.llenarTablaProyectos();
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese los datos correctamente");
        }
    }//GEN-LAST:event_btAgregarProyectoActionPerformed

    private void txtActividadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtActividadKeyTyped
        char validacion = evt.getKeyChar();
        if (Character.isDigit(validacion)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingresar solamente Letras");
        }
    }//GEN-LAST:event_txtActividadKeyTyped

    private void rdActividadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdActividadesActionPerformed
        if (rdActividades.isSelected()) {
            panelActividades.setVisible(false);
            lbAvisoActividades.setVisible(false);
        } else {
            panelActividades.setVisible(true);
            lbAvisoActividades.setVisible(true);
        }
    }//GEN-LAST:event_rdActividadesActionPerformed

    private void txtCodigoProyectoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoProyectoKeyReleased
        if (txtCodigoProyecto.getText().length() == 0) {
            lbAvisoCodigo.setVisible(true);
        } else {
            lbAvisoCodigo.setVisible(false);
        }
    }//GEN-LAST:event_txtCodigoProyectoKeyReleased

    private void txtNombreProyectoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreProyectoKeyReleased
        if (txtNombreProyecto.getText().length() == 0) {
            lbAvisoNombre.setVisible(true);
        } else {
            lbAvisoNombre.setVisible(false);
        }
    }//GEN-LAST:event_txtNombreProyectoKeyReleased

    private void dcFechaInicioProyectoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dcFechaInicioProyectoPropertyChange
        if (dcFechaInicioProyecto.getDate() == null) {
            lbAvisoFechaInicio.setVisible(true);
        } else {
            lbAvisoFechaInicio.setVisible(false);
        }
    }//GEN-LAST:event_dcFechaInicioProyectoPropertyChange

    private void dcFechaFinalProyectoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dcFechaFinalProyectoPropertyChange
        if (dcFechaFinalProyecto.getDate() == null) {
            lbAvisoFechaFinal.setVisible(true);
        } else {
            lbAvisoFechaFinal.setVisible(false);
        }
    }//GEN-LAST:event_dcFechaFinalProyectoPropertyChange

    private void txtDescripcionProyectoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionProyectoKeyReleased
        if (txtDescripcionProyecto.getText().length() == 0) {
            lbAvisoDescripcion.setVisible(true);
        } else {
            lbAvisoDescripcion.setVisible(false);
        }
    }//GEN-LAST:event_txtDescripcionProyectoKeyReleased

    private void lbPermisoAmbientalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbPermisoAmbientalMouseClicked

    }//GEN-LAST:event_lbPermisoAmbientalMouseClicked

    private void btActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btActividadActionPerformed
                if (validarDatosactividad()) {

            DefaultTableModel dtm = (DefaultTableModel) tbActividades.getModel();

        } else {
            JOptionPane.showMessageDialog(null, "Ingrese los datos correctamente");
        }


    }//GEN-LAST:event_btActividadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btActividad;
    private javax.swing.JButton btAgregarProyecto;
    private javax.swing.JButton btAuditorias;
    private javax.swing.JButton btMonitoreo;
    private javax.swing.JButton btPermisoAgua;
    private javax.swing.JButton btPermisoAmbiental;
    private javax.swing.JButton btnRegresarPanelTabla1;
    private com.toedter.calendar.JDateChooser dcFechaFinalProyecto;
    private com.toedter.calendar.JDateChooser dcFechaInicioProyecto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JLabel lbAuditoria;
    private javax.swing.JLabel lbAvisoActividades;
    private javax.swing.JLabel lbAvisoCodigo;
    private javax.swing.JLabel lbAvisoDescripcion;
    private javax.swing.JLabel lbAvisoFechaFinal;
    private javax.swing.JLabel lbAvisoFechaInicio;
    private javax.swing.JLabel lbAvisoNombre;
    private javax.swing.JLabel lbMonitoreo;
    private javax.swing.JLabel lbPermisoAgua;
    private javax.swing.JLabel lbPermisoAmbiental;
    private javax.swing.JPanel panelActividades;
    private javax.swing.JPanel panelAgregarProyecto;
    private javax.swing.JRadioButton rdActividades;
    private javax.swing.JRadioButton rdEnProgreso;
    private javax.swing.JTable tbActividades;
    private javax.swing.JTextField txtActividad;
    private javax.swing.JTextField txtCodigoProyecto;
    private javax.swing.JTextArea txtDescripcionProyecto;
    private javax.swing.JTextField txtNombreProyecto;
    // End of variables declaration//GEN-END:variables
}
